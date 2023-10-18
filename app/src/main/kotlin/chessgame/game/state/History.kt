package chessgame.game.state

import chessgame.game.board.Board
import chessgame.movement.Position
import chessgame.piece.Piece

/**
 * @author Agustin Augurusa
 */
class History(val boardHistory: List<Board>) {

    fun getPosById(id: String): List<Position> {
        val positions = boardHistory.flatMap { board ->
            board.pieceMap.filterValues { it.id == id }.keys.toList()
        }
        return positions
    }
}