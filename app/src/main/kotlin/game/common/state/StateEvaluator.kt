package game.common.state

import adt.StateEvaluatorResult
import chessgame.game.state.GameState

/**
 * @author Agustin Augurusa
 */
interface StateEvaluator {
    fun validate(gameState: GameState): StateEvaluatorResult
}