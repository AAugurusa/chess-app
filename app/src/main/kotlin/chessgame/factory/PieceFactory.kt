package chessgame.factory

import chessgame.mover.NormalMovementBehaviour
import enums.Colour
import chessgame.piece.Piece
import chessgame.validator.logic.AndMovementValidator
import chessgame.validator.piece.*
import validator.mati.OrMovementValidator

/**
 * @author Agustin Augurusa
 */
class PieceFactory {

    fun rookFactory(id: String, colour: Colour): Piece{
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator()))
        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(),OrMovementValidator(
            listOf(verticalMv, horizontalMv)
        )))
        return Piece(id, "ROOK", mv, colour, NormalMovementBehaviour())
    }

    fun pawnFactory(id: String, colour: Colour): Piece{
        val normalMv = AndMovementValidator(listOf(FowardMovementValidator(), LimitMovementValidator(1)))
        val firstMoveMv = AndMovementValidator(listOf(FowardMovementValidator(), LimitMovementValidator(2), MaxMovementCount(1, id), PathClearValidator()))
        val eatFowardMv = AndMovementValidator(listOf(FowardDiagonalMovementValidator(), OtherColourMovementValidator(), LimitMovementValidator(1)))
        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(), OrMovementValidator(
            listOf(normalMv, firstMoveMv, eatFowardMv))))
        return Piece(id, "PAWN", mv, colour, NormalMovementBehaviour())
    }

    fun kingFactory(id: String, colour: Colour): Piece{
        TODO()
    }

    fun bishopFactory(id: String, colour: Colour): Piece{
        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(),AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))))
        return Piece(id, "BISHOP", mv, colour, NormalMovementBehaviour())
    }

    fun queenFactory(id: String, colour: Colour): Piece{
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator()))
        val diagonalMv = AndMovementValidator(listOf(DiagonalMovementValidator(), PathClearValidator()))

        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(),OrMovementValidator(
            listOf(verticalMv, horizontalMv, diagonalMv)
        )))
        return Piece(id, "QUEEN", mv, colour, NormalMovementBehaviour())
    }

    fun knightFactory(id: String, colour: Colour): Piece{
        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(), LMovementValidator(1,2)))
        return Piece(id, "KNIGHT", mv, colour, NormalMovementBehaviour())
    }

    //EXTRA PIECES:
    fun archbishopFactory(id: String, colour: Colour): Piece{
        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(),OrMovementValidator(
            listOf(AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator(), LMovementValidator(1,2))
        )))))
        return Piece(id, "ARCHBISHOP", mv, colour, NormalMovementBehaviour())
    }

    fun chancellorFactory(id: String, colour: Colour): Piece{
        val horizontalMv = AndMovementValidator(listOf(HorizontalMovementValidator(), PathClearValidator()))
        val verticalMv = AndMovementValidator(listOf(VerticalMovementValidator(), PathClearValidator()))
        val mv = AndMovementValidator(listOf(NotInCheckMovementValidator(),OrMovementValidator(
            listOf(verticalMv, horizontalMv, LMovementValidator(1,2))
        )))
        return Piece(id, "CHANCELLOR", mv, colour, NormalMovementBehaviour())
    }

}