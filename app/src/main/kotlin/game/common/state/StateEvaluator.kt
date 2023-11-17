package game.common.state

import adt.StateEvaluatorResult
import game.common.GameState

/**
 * @author Agustin Augurusa
 */
interface StateEvaluator {
    fun validate(gameState: GameState): StateEvaluatorResult
}