package validator.mati

import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class OrMovementValidator(
    val mvList: List<MovementValidator>
) : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        for (mv in mvList) {
            val auxResult = mv.validate(movement, gameState)
            if (auxResult is SuccessfulMovementResult) {
                return auxResult
            }
        }
        return mvList.get(0).validate(movement, gameState)
    }
}
