package chessgame.piece

import chessgame.mover.MovementBehaviour
import enums.Colour
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
data class Piece(val id: String, val type: String, val mv: MovementValidator, val colour: Colour, val mb: MovementBehaviour)
