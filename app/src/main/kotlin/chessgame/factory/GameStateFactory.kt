package chessgame.factory

import adt.InProgressStateResult
import chessgame.game.state.GameState
import game.common.board.History
import chessgame.game.turn.RegularTurnStrategy
import game.common.colour.Colour
import factory.BoardFactory

/**
 * @author Agustin Augurusa
 */
class GameStateFactory {
    fun normalGameStateBuilder(): GameState{
        return GameState(BoardFactory().initialiceNormalBoard(), RegularTurnStrategy(Colour.WHITE), History(listOf()), InProgressStateResult())
    }

}