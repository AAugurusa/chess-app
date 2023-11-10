package chessgame.factory

import chessgame.mover.NormalMovementBehaviour
import game.common.colour.Colour
import chessgame.piece.Piece
import chessgame.validator.basic.BasicMovementValidator
import game.common.validator.logic.AndMovementValidator
import chessgame.validator.piece.*
import game.common.validator.basic.InBoardValidator
import game.common.validator.basic.ToPositionClearValidator
import game.common.validator.logic.OrMovementValidator

/**
 * @author Agustin Augurusa
 */
class PieceFactory {

    fun rookFactory(id: String, colour: Colour): Piece {
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator()))
        val mv = OrMovementValidator(listOf(verticalMv, horizontalMv))
        return Piece(id, "ROOK", mv, colour, NormalMovementBehaviour())
    }

    fun pawnFactory(id: String, colour: Colour): Piece {
        val normalMv = AndMovementValidator(listOf(FowardMovementValidator(), LimitMovementValidator(1), ToPositionClearValidator()))
        val firstMoveMv = AndMovementValidator(
            listOf(
                FowardMovementValidator(),
                LimitMovementValidator(2),
                MaxMovementCount(1, id),
                PathClearValidator(),
                ToPositionClearValidator()
            )
        )
        val eatFowardMv = AndMovementValidator(
            listOf(
                FowardDiagonalMovementValidator(),
                OtherColourMovementValidator(),
                LimitMovementValidator(1)
            )
        )
        val mv = OrMovementValidator(listOf(normalMv, firstMoveMv, eatFowardMv))
        return Piece(id, "PAWN", mv, colour, NormalMovementBehaviour())
    }

    fun kingFactory(id: String, colour: Colour): Piece {
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator(), LimitMovementValidator(1)))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator(), LimitMovementValidator(1)))
        val diagonalMv = AndMovementValidator(listOf(DiagonalMovementValidator(), PathClearValidator(),LimitMovementValidator(1)))
        val mv = OrMovementValidator(listOf(verticalMv, horizontalMv, diagonalMv))
        return Piece(id, "KING", mv, colour, NormalMovementBehaviour())
    }

    fun bishopFactory(id: String, colour: Colour): Piece {
        val mv = AndMovementValidator(listOf(DiagonalMovementValidator(), PathClearValidator()))
        return Piece(id, "BISHOP", mv, colour, NormalMovementBehaviour())
    }

    fun queenFactory(id: String, colour: Colour): Piece {
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator()))
        val diagonalMv = AndMovementValidator(listOf(DiagonalMovementValidator(), PathClearValidator()))

        val mv = OrMovementValidator(listOf(verticalMv, horizontalMv, diagonalMv))
        return Piece(id, "QUEEN", mv, colour, NormalMovementBehaviour())
    }

    fun knightFactory(id: String, colour: Colour): Piece {
        return Piece(id, "KNIGHT", LMovementValidator(1, 2), colour, NormalMovementBehaviour())
    }

    //EXTRA PIECES:
    fun archbishopFactory(id: String, colour: Colour): Piece {
        val mv = OrMovementValidator(
            listOf(
                AndMovementValidator(
                    listOf(HorizontalMovementValidator(), PathClearValidator(), LMovementValidator(1, 2))
                )
            )
        )
        return Piece(id, "ARCHBISHOP", mv, colour, NormalMovementBehaviour())
    }

    fun chancellorFactory(id: String, colour: Colour): Piece {
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator()))
        val mv = OrMovementValidator(
            listOf(verticalMv, horizontalMv, LMovementValidator(1, 2))
        )
        return Piece(id, "CHANCELLOR", mv, colour, NormalMovementBehaviour())
    }


    fun checkerPiece(id: String, colour: Colour): Piece {
        TODO()
    }

    fun checkerKing(id: String, colour: Colour): Piece {
        TODO()
    }

}