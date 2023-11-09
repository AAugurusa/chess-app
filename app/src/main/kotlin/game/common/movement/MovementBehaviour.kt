package game.common.movement

import chessgame.game.state.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
interface MovementBehaviour {
    fun move(gameState: GameState, movement: Movement): GameState
}