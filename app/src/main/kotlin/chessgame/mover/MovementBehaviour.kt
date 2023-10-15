package chessgame.mover

import chessgame.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementBehaviour {
    fun move(gameState: GameState, movement: Movement): GameState
}