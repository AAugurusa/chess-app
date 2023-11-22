package game.common.mover

import game.common.GameState
import game.common.movement.Movement

/**
 * @author Agustin Augurusa
 */
class PieceMover {
    fun movePiece(movement: Movement, gameState: GameState): GameState {
        return gameState.getPiece(movement.from)!!.mb.move(gameState, movement)
    }
}