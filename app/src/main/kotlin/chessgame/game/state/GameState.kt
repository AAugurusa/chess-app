package chessgame.game.state

import adt.StateEvaluatorResult
import chessgame.game.board.Board
import chessgame.movement.Position
import chessgame.piece.Piece
import enums.Colour

/**
 * @author Agustin Augurusa
 */
data class GameState(val board: Board, val currColour: Colour, val history: History, val state: StateEvaluatorResult) {

    fun getPieceMap(): Map<Position, Piece> {
        return board.pieceMap
    }

    fun getPiece(position: Position): Piece {
        return getPieceMap().get(position)!!
    }

    fun getPositionByPieceID(id: String): Position {
        return board.pieceMap.entries.find { it.value.id == id }!!.key
    }

}
