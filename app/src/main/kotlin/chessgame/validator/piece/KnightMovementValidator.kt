package validator.piece

import adt.ResultMovement
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator
import validator.standar.LMovementValidator

/**
 * @author Agustin Augurusa
 */
class KnightMovementValidator : MovementValidator{
    private val lMV = LMovementValidator(1,2)
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        return lMV.validate(movement, gameState)
    }
}