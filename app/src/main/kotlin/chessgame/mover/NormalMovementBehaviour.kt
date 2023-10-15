package chessgame.mover

import chessgame.GameState
import chessgame.game.board.Board
import chessgame.movement.Movement
import factory.BoardFactory

/**
 * @author Agustin Augurusa
 */
class NormalMovementBehaviour(
    val boardFactory: BoardFactory
) : MovementBehaviour {
    override fun move(gameState: GameState, movement: Movement): GameState {
        return gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement))
    }

}