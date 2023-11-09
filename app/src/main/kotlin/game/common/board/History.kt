package game.common.board

import chessgame.movement.Position

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