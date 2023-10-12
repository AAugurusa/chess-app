package chessgame.piece

import enums.Colour
import enums.PieceType
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
data class Piece(val id: Int, val type: PieceType, val mv: MovementValidator, val colour: Colour)
