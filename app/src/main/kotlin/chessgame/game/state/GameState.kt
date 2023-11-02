package chessgame.game.state

import adt.StateEvaluatorResult
import adt.SuccessfulMovementResult
import chessgame.game.board.Board
import chessgame.game.turn.TurnStrategy
import chessgame.movement.Movement
import chessgame.movement.Position
import chessgame.piece.Piece
import enums.Colour

/**
 * @author Agustin Augurusa
 */
data class GameState(val board: Board, val currColour: TurnStrategy, val history: History, val state: StateEvaluatorResult) {

    fun getPieceMap(): Map<Position, Piece> {
        return board.pieceMap
    }

    fun getPiece(position: Position): Piece {
        return getPieceMap().get(position)!!
    }

    fun getPositionByPieceID(id: String): Position {
        return board.pieceMap.entries.find { it.value.id == id }!!.key
    }


    fun pieceHasAnyValidMovement(piece: Piece): Boolean{
        val fromPosition = board.pieceMap.filterKeys { it == getPositionByPieceID(piece.id) }.keys.first()
        for (i in 1.. board.numCol){
            for (j in 1.. board.numRow){
                val toPosition = Position(i,j)
                val auxMovement = Movement(fromPosition, toPosition)
                if (piece.mv.validate(auxMovement, gameState = this) is SuccessfulMovementResult){
                    return true
                }
            }
        }
        return false
    }

    fun positionsThatThreatenKing(colour: Colour): List<Position> {
        var listOfPosition = mutableListOf<Position>()
        val kingPosition = board.pieceMap.entries.find { it.value.type == "KING" && it.value.colour == colour }!!.key
        val enemyPieces = board.pieceMap.entries.filter { it.value.colour !== colour }
        for (enemyPiece in enemyPieces){
            val enemyPiecePosition = enemyPiece.key
            val enemyPieceMovement = Movement(kingPosition, enemyPiecePosition)
            if (enemyPiece.value.mv.validate(enemyPieceMovement, gameState = this) is SuccessfulMovementResult){
                listOfPosition.add(enemyPiecePosition)
            }
        }
        val immutableList = listOfPosition.toList()
        return immutableList
    }


    fun getBoardsHistory(): List<Board> {
        return history.boardHistory
    }

    fun getCurrentColour(): Colour{
        return currColour.getCurrentColour()
    }

}
