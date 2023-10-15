package factory

import chessgame.factory.PieceFactory
import chessgame.game.board.Board
import chessgame.movement.Movement
import enums.Colour
import chessgame.movement.Position

/**
 * @author Agustin Augurusa
 */
class BoardFactory {

    fun boardFromReference(board: Board, movement: Movement): Board{
        val pieceToMove = board.pieceMap[movement.from]!!

        val updatedPieceMap = board.pieceMap
            .filterKeys { it != movement.from }
            .plus(movement.to to pieceToMove)

       return board.copy(pieceMap = updatedPieceMap)
    }

    fun initialiceNormalBoard(): Board {
        val pieceFactory = PieceFactory()
        val pieceMap = mapOf(
            (Position(1, 1) to pieceFactory.rookFactory("RW1", Colour.WHITE)),
            (Position(2, 1) to pieceFactory.knightFactory("KW1", Colour.WHITE)),
            (Position(3, 1) to pieceFactory.bishopFactory("BW1", Colour.WHITE)),
            (Position(4, 1) to pieceFactory.queenFactory("QW", Colour.WHITE)),
            (Position(5, 1) to pieceFactory.kingFactory("KW", Colour.WHITE)),
            (Position(6, 1) to pieceFactory.bishopFactory("BW2", Colour.WHITE)),
            (Position(7, 1) to pieceFactory.knightFactory("KW2", Colour.WHITE)),
            (Position(8, 1) to pieceFactory.rookFactory("RW2", Colour.WHITE)),

            (Position(1, 2) to pieceFactory.pawnFactory("PW1", Colour.WHITE)),
            (Position(2, 2) to pieceFactory.pawnFactory("PW2", Colour.WHITE)),
            (Position(3, 2) to pieceFactory.pawnFactory("PW3", Colour.WHITE)),
            (Position(4, 2) to pieceFactory.pawnFactory("PW4", Colour.WHITE)),
            (Position(5, 2) to pieceFactory.pawnFactory("PW5", Colour.WHITE)),
            (Position(6, 2) to pieceFactory.pawnFactory("PW6", Colour.WHITE)),
            (Position(7, 2) to pieceFactory.pawnFactory("PW7", Colour.WHITE)),
            (Position(8, 2) to pieceFactory.pawnFactory("PW8", Colour.WHITE)),

            (Position(1, 7) to pieceFactory.pawnFactory("PB1", Colour.BLACK)),
            (Position(2, 7) to pieceFactory.pawnFactory("PB2", Colour.BLACK)),
            (Position(3, 7) to pieceFactory.pawnFactory("PB3", Colour.BLACK)),
            (Position(4, 7) to pieceFactory.pawnFactory("PB4", Colour.BLACK)),
            (Position(5, 7) to pieceFactory.pawnFactory("PB5", Colour.BLACK)),
            (Position(6, 7) to pieceFactory.pawnFactory("PB6", Colour.BLACK)),
            (Position(7, 7) to pieceFactory.pawnFactory("PB7", Colour.BLACK)),
            (Position(8, 7) to pieceFactory.pawnFactory("PB8", Colour.BLACK)),

            (Position(1, 8) to pieceFactory.rookFactory("RB1", Colour.BLACK)),
            (Position(2, 8) to pieceFactory.knightFactory("KB1", Colour.BLACK)),
            (Position(3, 8) to pieceFactory.bishopFactory("BB1", Colour.BLACK)),
            (Position(4, 8) to pieceFactory.kingFactory("KB", Colour.BLACK)),
            (Position(5, 8) to pieceFactory.queenFactory("QB", Colour.BLACK)),
            (Position(6, 8) to pieceFactory.bishopFactory("BB2", Colour.BLACK)),
            (Position(7, 8) to pieceFactory.knightFactory("KB2", Colour.BLACK)),
            (Position(8, 8) to pieceFactory.rookFactory("RB2", Colour.BLACK))
        )
        return Board(pieceMap, 8, 8)
    }
}