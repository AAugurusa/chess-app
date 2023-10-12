package factory

import enums.Colour
import chessgame.board.Board
import chessgame.board.NormalBoard
import chessgame.movement.Position

/**
 * @author Agustin Augurusa
 */
class NormalBoardFactory : BoardFactory {
    override fun factory(): Board {
        val id = 0
        val pieceFactory = PieceFactory()
        val positionList = listOf(
            (Position(1, 1)),
            (Position(2, 1)),
            (Position(3, 1)),
            (Position(4, 1)),
            (Position(5, 1)),
            (Position(6, 1)),
            (Position(7, 1)),
            (Position(8, 1)),
            (Position(1, 2)),
            (Position(2, 2)),
            (Position(3, 2)),
            (Position(4, 2)),
            (Position(5, 2)),
            (Position(6, 2)),
            (Position(7, 2)),
            (Position(8, 2)),
            (Position(1, 3)),
            (Position(2, 3)),
            (Position(3, 3)),
            (Position(4, 3)),
            (Position(5, 3)),
            (Position(6, 3)),
            (Position(7, 3)),
            (Position(8, 3)),
            (Position(1, 4)),
            (Position(2, 4)),
            (Position(3, 4)),
            (Position(4, 4)),
            (Position(5, 4)),
            (Position(6, 4)),
            (Position(7, 4)),
            (Position(8, 4)),
            (Position(1, 5)),
            (Position(2, 5)),
            (Position(3, 5)),
            (Position(4, 5)),
            (Position(5, 5)),
            (Position(6, 5)),
            (Position(7, 5)),
            (Position(8, 5)),
            (Position(1, 6)),
            (Position(2, 6)),
            (Position(3, 6)),
            (Position(4, 6)),
            (Position(5, 6)),
            (Position(6, 6)),
            (Position(7, 6)),
            (Position(8, 6)),
            (Position(1, 7)),
            (Position(2, 7)),
            (Position(3, 7)),
            (Position(4, 7)),
            (Position(5, 7)),
            (Position(6, 7)),
            (Position(7, 7)),
            (Position(8, 7)),
            (Position(1, 8)),
            (Position(2, 8)),
            (Position(3, 8)),
            (Position(4, 8)),
            (Position(5, 8)),
            (Position(6, 8)),
            (Position(7, 8)),
            (Position(8, 8))
        )

        val pieceMap = hashMapOf(
            (Position(1, 1) to pieceFactory.rookFactory(1, Colour.WHITE)),
            (Position(2, 1) to pieceFactory.knightFactory(2, Colour.WHITE)),
            (Position(3, 1) to pieceFactory.bishopFactory(3, Colour.WHITE)),
            (Position(4, 1) to pieceFactory.queenFactory(4, Colour.WHITE)),
            (Position(5, 1) to pieceFactory.kingFactory(5, Colour.WHITE)),
            (Position(6, 1) to pieceFactory.bishopFactory(6, Colour.WHITE)),
            (Position(7, 1) to pieceFactory.knightFactory(7, Colour.WHITE)),
            (Position(8, 1) to pieceFactory.rookFactory(8, Colour.WHITE)),

            (Position(1, 2) to pieceFactory.pawnFactory(9, Colour.WHITE)),
            (Position(2, 2) to pieceFactory.pawnFactory(10, Colour.WHITE)),
            (Position(3, 2) to pieceFactory.pawnFactory(11, Colour.WHITE)),
            (Position(4, 2) to pieceFactory.pawnFactory(12, Colour.WHITE)),
            (Position(5, 2) to pieceFactory.pawnFactory(13, Colour.WHITE)),
            (Position(6, 2) to pieceFactory.pawnFactory(14, Colour.WHITE)),
            (Position(7, 2) to pieceFactory.pawnFactory(15, Colour.WHITE)),
            (Position(8, 2) to pieceFactory.pawnFactory(16, Colour.WHITE)),

            (Position(1, 7) to pieceFactory.pawnFactory(17, Colour.BLACK)),
            (Position(2, 7) to pieceFactory.pawnFactory(18, Colour.BLACK)),
            (Position(3, 7) to pieceFactory.pawnFactory(19, Colour.BLACK)),
            (Position(4, 7) to pieceFactory.pawnFactory(20, Colour.BLACK)),
            (Position(5, 7) to pieceFactory.pawnFactory(21, Colour.BLACK)),
            (Position(6, 7) to pieceFactory.pawnFactory(22, Colour.BLACK)),
            (Position(7, 7) to pieceFactory.pawnFactory(23, Colour.BLACK)),
            (Position(8, 7) to pieceFactory.pawnFactory(24, Colour.BLACK)),

            (Position(1, 8) to pieceFactory.rookFactory(25, Colour.BLACK)),
            (Position(2, 8) to pieceFactory.knightFactory(26, Colour.BLACK)),
            (Position(3, 8) to pieceFactory.bishopFactory(27, Colour.BLACK)),
            (Position(4, 8) to pieceFactory.kingFactory(28, Colour.BLACK)),
            (Position(5, 8) to pieceFactory.queenFactory(29, Colour.BLACK)),
            (Position(6, 8) to pieceFactory.bishopFactory(30, Colour.BLACK)),
            (Position(7, 8) to pieceFactory.knightFactory(31, Colour.BLACK)),
            (Position(8, 8) to pieceFactory.rookFactory(32, Colour.BLACK))
        )
        return NormalBoard(pieceMap, positionList)
    }
}