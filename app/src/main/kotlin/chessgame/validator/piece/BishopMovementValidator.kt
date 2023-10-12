package validator.piece

import adt.ResultMovement
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator
import validator.standar.DiagonalMovementValidator

/**
 * @author Agustin Augurusa
 */
class BishopMovementValidator : MovementValidator {
    val diagonalMv = DiagonalMovementValidator()
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        return diagonalMv.validate(movement, gameState)
    }
}