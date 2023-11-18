package game.common.factory

import adt.InProgressStateResult
import game.common.GameState
import game.common.history.History
import game.chess.turn.ChessTurnStrategy
import game.common.colour.Colour

/**
 * @author Agustin Augurusa
 */
class GameStateFactory {
    fun normalGameStateBuilder(): GameState {
        return GameState(BoardFactory().initialiceNormalBoard(), ChessTurnStrategy(Colour.WHITE), History(listOf()), InProgressStateResult())
    }

    fun checkersStateBuilder(): GameState {
        return GameState(BoardFactory().initialiceCheckersBoard(), ChessTurnStrategy(Colour.WHITE), History(listOf()), InProgressStateResult())
    }

}