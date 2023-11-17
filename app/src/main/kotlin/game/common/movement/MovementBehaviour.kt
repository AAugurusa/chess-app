package game.common.movement

import game.common.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementBehaviour {
    fun move(gameState: GameState, movement: Movement): GameState
}