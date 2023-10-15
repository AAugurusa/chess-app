package chessgame.movement

import chessgame.GameState
import chessgame.game.board.Board

/**
 * @author Agustin Augurusa
 */
class PieceMover {
    fun movePiece(movement: Movement, gameState: GameState): GameState{
        return gameState.getPiece(movement.from)!!.mb.move(gameState, movement)
    }
}