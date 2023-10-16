package adt

import chessgame.game.state.GameState

/**
 * @author Agustin Augurusa
 */
data class InProgressStateResult(val currGameState: GameState): StateEvaluatorResult