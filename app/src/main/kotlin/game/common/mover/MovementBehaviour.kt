package game.common.mover

import game.common.GameState
import game.common.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementBehaviour {
    fun move(gameState: GameState, movement: Movement): GameState
}