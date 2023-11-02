package chessgame.game.state

import adt.*
import chessgame.movement.Movement
import chessgame.movement.Position
import enums.Colour
import factory.BoardFactory

/**
 * @author Agustin Augurusa
 */
class StateEvaluator {//QUEDA ESPECIFICO DEL CLASIC SUBILO UN POCO MAS PARA DAMAS ---> PASARLE CONDICIONES
    fun stateEvaluator(gameState: GameState): StateEvaluatorResult{
        if(isThereAWayOfMate(gameState)){//SI NINGUNA SE CUMPLE SIGUE
            if(canAPieceMove(gameState)){
                if(isCheckMate(gameState)){
                    when(gameState.getCurrentColour()){
                        Colour.WHITE -> return WinStateResult(Colour.BLACK)
                        Colour.BLACK -> return WinStateResult(Colour.WHITE)
                    }
                }
            }
            return TieStateResult("Stalemate")
        }

        return InProgressStateResult()
    }

    private fun isTherePieceType(gameState: GameState, pieceType: String): Boolean{
        return (gameState.getPieceMap().entries.filter { it.value.type === pieceType}.isNotEmpty())
    }

    private fun numberOfPieceTypeInColour(gameState: GameState, pieceType: String, colour: Colour): Int{
        return gameState.getPieceMap().entries.filter {(it.value.type === pieceType) && (it.value.colour === colour)}.size
    }

    private fun isThereAWayOfMate(gameState: GameState): Boolean {
        val hasRook = isTherePieceType(gameState, "ROOK")
        val hasPawn = isTherePieceType(gameState, "PAWN")
        val hasQueen = isTherePieceType(gameState, "QUEEN")

        val whiteBishops = numberOfPieceTypeInColour(gameState, "BISHOP", Colour.WHITE)
        val blackBishops = numberOfPieceTypeInColour(gameState, "BISHOP", Colour.BLACK)
        val whiteKnights = numberOfPieceTypeInColour(gameState, "KNIGHT", Colour.WHITE)
        val blackKnights = numberOfPieceTypeInColour(gameState, "KNIGHT", Colour.BLACK)

        if (!(hasRook || hasPawn || hasQueen)) {
            return true
        }

        if (whiteBishops >= 2 || blackBishops >= 2) {
            return false
        }

        if ((whiteBishops >= 1 && whiteKnights >= 1) || (blackBishops >= 1 && blackKnights >= 1)) {
            return false
        }

        return true
    }

    private fun canAPieceMove(gameState: GameState): Boolean{
        val pieceList = gameState.getPieceMap().entries.filter { it.value.colour === gameState.getCurrentColour()}
        for (piece in pieceList){
            if (gameState.pieceHasAnyValidMovement(piece.value)){
                return true
            }
        }
        return false
    }

    private fun isCheckMate(gameState: GameState) : Boolean {
        val positionsOfThreats = gameState.positionsThatThreatenKing(gameState.getCurrentColour())
        if(positionsOfThreats.isNotEmpty()){
            val currColourPieces = gameState.getPieceMap().entries.filter { it.value.colour === gameState.getCurrentColour()}
            for (piece in currColourPieces){
                for (i in 1..gameState.board.numCol){
                    for (j in 1..gameState.board.numRow){
                        val toPosition = Position(i,j)
                        val fromPosition = piece.key
                        val auxMovement = Movement(toPosition, fromPosition)
                        if (piece.value.mv.validate(auxMovement, gameState = gameState) is SuccessfulMovementResult){
                            val auxBoardFactory = BoardFactory()
                            val auxGameState = GameState(auxBoardFactory.boardFromReference(gameState.board, auxMovement), gameState.currColour, gameState.history, gameState.state)
                            if(auxGameState.positionsThatThreatenKing(gameState.getCurrentColour()).isEmpty()){
                                return false
                            }
                        }
                    }
                }
            }
        }
        return true
    }

}