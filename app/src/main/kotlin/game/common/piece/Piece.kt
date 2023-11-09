package chessgame.piece

import game.common.movement.MovementBehaviour
import game.common.colour.Colour
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
data class Piece(val id: String, val type: String, val mv: MovementValidator, val colour: Colour, val mb: MovementBehaviour)
