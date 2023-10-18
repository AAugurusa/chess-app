package chessgame.mover

import chessgame.game.state.GameState
import chessgame.movement.Movement
import factory.BoardFactory

/**
 * @author Agustin Augurusa
 */
class NormalMovementBehaviour() : MovementBehaviour {
    override fun move(gameState: GameState, movement: Movement): GameState {
        val boardFactory = BoardFactory()
        return gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement))
    }

}