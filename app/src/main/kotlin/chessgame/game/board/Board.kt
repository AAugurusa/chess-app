package chessgame.board

import chessgame.movement.Position
import chessgame.piece.Piece

/**
 * @author Agustin Augurusa
 */
interface Board {
    fun getPieceMap(): HashMap<Position, Piece>
    fun getPositionList(): List<Position>
    fun getNumRows(): Int
    fun getNumColums(): Int
}