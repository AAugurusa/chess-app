package validator

import adt.ResultMovement
import chessgame.game.state.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementValidator {
    fun validate(movement: Movement, gameState: GameState): ResultMovement
}