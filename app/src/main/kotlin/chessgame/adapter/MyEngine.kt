package chessgame.adapter

import chessgame.factory.GameStateFactory
import chessgame.movement.Movement
import chessgame.piece.Piece
import edu.austral.dissis.chess.gui.*

/**
 * @author Agustin Augurusa
 */
class MyEngine() : GameEngine {
    val game = ChessEngine()

    override fun applyMove(move: Move): MoveResult {
        val movement : Movement = game.getAdapter().translateMoveToMovement(move)
        return game.makeAMove(movement)
    }

    override fun init(): InitialState {
        return game.getAdapter().adaptGameStateToInitialState(game.init())
    }
}