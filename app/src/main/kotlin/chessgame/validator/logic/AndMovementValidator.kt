package chessgame.validator.logic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class AndMovementValidator(
    val mvList: List<MovementValidator>
) : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        for (mv in mvList) {
            val auxResult = mv.validate(movement, gameState)
            if (auxResult is InvalidMovementResult) {
                return auxResult
            }
        }
        return SuccessfulMovementResult()
    }
}