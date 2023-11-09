package chessgame.movement

import chessgame.game.state.GameState

/**
 * @author Agustin Augurusa
 */
class PieceMover {
    fun movePiece(movement: Movement, gameState: GameState): GameState {
        return gameState.getPiece(movement.from)!!.mb.move(gameState, movement)
    }
}