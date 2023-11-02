package chessgame.factory

import adt.InProgressStateResult
import chessgame.game.state.GameState
import chessgame.game.state.History
import chessgame.game.turn.RegularTurnStrategy
import enums.Colour
import factory.BoardFactory

/**
 * @author Agustin Augurusa
 */
class GameStateFactory {
    val boardFactory = BoardFactory()
    fun normalGameStateBuilder(): GameState{
        return GameState(boardFactory.initialiceNormalBoard(), RegularTurnStrategy(Colour.WHITE), History(listOf()), InProgressStateResult())
    }

}