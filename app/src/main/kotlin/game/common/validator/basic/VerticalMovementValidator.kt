package game.common.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import game.common.movement.Movement
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class VerticalMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if (isVertical(movement)) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }

    private fun isVertical(movement: Movement): Boolean {
        return (movement.from.row != movement.to.row) && (movement.from.column == movement.to.column)
    }

}