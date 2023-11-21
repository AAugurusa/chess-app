package game.common.mover

import game.common.GameState
import game.common.movement.Movement
import game.common.factory.BoardFactory
import game.common.mover.MovementBehaviour

/**
 * @author Agustin Augurusa
 */
class NormalMovementBehaviour() : MovementBehaviour {
    override fun move(gameState: GameState, movement: Movement): GameState {
        val boardFactory = BoardFactory()
        return gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement))
    }

}