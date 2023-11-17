package game.common.history

import chessgame.movement.Position
import game.common.board.Board

/**
 * @author Agustin Augurusa
 */
data class History(val boardHistory: List<Board>) {

    fun getPosById(id: String): List<Position> {
        val positions = mutableListOf<Position>()

        for (board in boardHistory) {
            for ((position, piece) in board.pieceMap) {
                if (piece.id == id) {
                    positions.add(position)
                }
            }
        }
        return positions.toList()
    }
}