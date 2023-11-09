package game.common.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class NotSamePositionMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if ((movement.to.row === movement.from.row) && (movement.to.column === movement.from.column)) {
            return InvalidMovementResult("From and to are the same")
        }
        return SuccessfulMovementResult()
    }
}