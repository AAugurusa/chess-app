package game.common.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import game.common.movement.Movement
import game.common.validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class LimitMovementValidator(
    val limit: Int
) : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val difCol = abs(movement.to.column - movement.from.column)
        val difRow = abs(movement.to.row - movement.from.row)
        if(difCol <= limit &&  difRow <= limit){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("The movement exceeds its limit")
    }
}