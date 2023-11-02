package chessgame.game.state

import adt.StateEvaluatorResult

/**
 * @author Agustin Augurusa
 */
interface StateEvaluator {
    fun validate(gameState: GameState): StateEvaluatorResult
}