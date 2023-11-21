package game.common.movement

import game.common.GameState

/**
 * @author Agustin Augurusa
 */
class PieceMover {
    fun movePiece(movement: Movement, gameState: GameState): GameState {
        return gameState.getPiece(movement.from)!!.mb.move(gameState, movement)
    }
}