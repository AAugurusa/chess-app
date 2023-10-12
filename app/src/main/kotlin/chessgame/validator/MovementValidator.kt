package validator

import adt.ResultMovement
import chessgame.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementValidator {
    fun validate(movement: Movement, gameState: GameState): ResultMovement
}