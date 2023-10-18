package chessgame.game.state

import adt.StateEvaluatorResult
import adt.TieStateResult
import enums.Colour

/**
 * @author Agustin Augurusa
 */
class StateEvaluator {
    fun stateEvaluator(gameState: GameState): StateEvaluatorResult{
        if(isThereAWayOfMate(gameState)){

        }
        return TieStateResult("Insuficient material")
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

    private fun canAPieceMove(){
        TODO()
    }

}