package factory

import enums.Colour
import enums.PieceType
import chessgame.piece.Piece
import validator.piece.*

/**
 * @author Agustin Augurusa
 */
class PieceFactory {

    fun rookFactory(id: Int, colour: Colour): Piece{
        return Piece(id, PieceType.ROOK, RookMovementValidator(), colour)
    }

    fun pawnFactory(id: Int, colour: Colour): Piece{
        TODO()
    }

    fun kingFactory(id: Int, colour: Colour): Piece{
        TODO()
    }

    fun bishopFactory(id: Int, colour: Colour): Piece{
        return Piece(id, PieceType.BISHOP, BishopMovementValidator(), colour)
    }

    fun queenFactory(id: Int, colour: Colour): Piece{
        return Piece(id, PieceType.QUEEN, QueenMovementValidator(), colour)
    }

    fun knightFactory(id: Int, colour: Colour): Piece{
        return Piece(id, PieceType.KNIGHT, KnightMovementValidator(), colour)
    }

    //EXTRA PIECES:
    fun archbishopFactory(id: Int, colour: Colour): Piece{
        return Piece(id, PieceType.ARCHBISHOP, ArchbishopMovementValidator(), colour)
    }

    fun chancellorFactory(id: Int, colour: Colour): Piece{
        return Piece(id, PieceType.CHANCELLOR, ChancellorMovementValidator(), colour)
    }

}