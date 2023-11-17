package game.common.validator

import adt.ResultMovement
import game.common.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementValidator {
    fun validate(movement: Movement, gameState: GameState): ResultMovement
}