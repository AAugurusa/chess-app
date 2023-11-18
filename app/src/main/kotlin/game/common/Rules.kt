package game.common

import chessgame.movement.Movement
import edu.austral.dissis.chess.gui.MoveResult

/**
 * @author Agustin Augurusa
 */
interface Rules {

    fun init(): GameState
    fun makeAMove(move: Movement): MoveResult
    fun getAdapter(): Adapter
}