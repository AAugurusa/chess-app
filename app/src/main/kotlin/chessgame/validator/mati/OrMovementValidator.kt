package validator.mati

import adt.ResultMovement
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class OrMovementValidator(
    val mvList: List<MovementValidator>
):MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        TODO()
    }
}
