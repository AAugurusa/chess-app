package chessgame.factory

import adt.InProgressStateResult
import chessgame.game.state.GameState
import chessgame.game.state.History
import enums.Colour
import factory.BoardFactory

/**
 * @author Agustin Augurusa
 */
class GameStateFactory {
    val boardFactory = BoardFactory()
    fun initialiceGameState(): GameState{
        return GameState(boardFactory.initialiceNormalBoard(), Colour.WHITE, History(listOf()), InProgressStateResult())
    }
}