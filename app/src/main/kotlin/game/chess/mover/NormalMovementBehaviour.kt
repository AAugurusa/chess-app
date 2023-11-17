package game.chess.mover

import game.common.GameState
import chessgame.movement.Movement
import game.common.factory.BoardFactory
import game.common.movement.MovementBehaviour

/**
 * @author Agustin Augurusa
 */
class NormalMovementBehaviour() : MovementBehaviour {
    override fun move(gameState: GameState, movement: Movement): GameState {
        val boardFactory = BoardFactory()
        return gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement))
    }

}