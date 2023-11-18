package game.common

import chessgame.movement.Movement
import edu.austral.dissis.chess.gui.*

/**
 * @author Agustin Augurusa
 */
class MyEngine(rules: Rules) : GameEngine {
    val game = rules

    companion object{
        fun chessEngine() : MyEngine{
            return MyEngine(ChessRules())
        }

        fun checkersEngine() : MyEngine{
            return MyEngine(CheckersRules())
        }
    }

    override fun applyMove(move: Move): MoveResult {
        val movement : Movement = game.getAdapter().translateMoveToMovement(move)
        return game.makeAMove(movement)
    }

    override fun init(): InitialState {
        return game.getAdapter().adaptGameStateToInitialState(game.init())
    }
}