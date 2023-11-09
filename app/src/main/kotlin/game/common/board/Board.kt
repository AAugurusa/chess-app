package game.common.board

import chessgame.movement.Position
import chessgame.piece.Piece

/**
 * @author Agustin Augurusa
 */
data class Board(val pieceMap: Map<Position, Piece>, val numRow: Int, val numCol: Int) {
    fun getPositionByPiece(piece: Piece): Position {
        return pieceMap.entries.find { it.value == piece }!!.key
    }

}
