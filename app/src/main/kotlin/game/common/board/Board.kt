package game.common.board

import game.common.movement.Position
import game.common.piece.Piece

/**
 * @author Agustin Augurusa
 */
data class Board(val pieceMap: Map<Position, Piece>, val numRow: Int, val numCol: Int) {
    fun getPositionByPiece(piece: Piece): Position {
        return pieceMap.entries.find { it.value == piece }!!.key
    }

}
