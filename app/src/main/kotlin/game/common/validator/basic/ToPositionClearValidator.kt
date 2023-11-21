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
class ToPositionClearValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if (gameState.getPieceMap().containsKey(movement.to)) {
            return InvalidMovementResult("The to position is occupied by a piece")
        }
        return SuccessfulMovementResult()
    }
}