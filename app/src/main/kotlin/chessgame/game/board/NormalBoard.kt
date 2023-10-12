package chessgame.board

import chessgame.movement.Position
import chessgame.piece.Piece

/**
 * @author Agustin Augurusa
 */
class NormalBoard(
    private val pieceMap: HashMap<Position, Piece>,
    private val positionList: List<Position>
) : Board {
    override fun getPieceMap(): HashMap<Position, Piece> {
        return pieceMap
    }

    override fun getPositionList(): List<Position> {
        return positionList
    }

    override fun getNumRows(): Int {
        return 8;
    }

    override fun getNumColums(): Int {
        return 8;
    }
}