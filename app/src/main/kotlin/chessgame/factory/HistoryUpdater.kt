package chessgame.factory

import chessgame.game.state.GameState
import chessgame.game.state.History

/**
 * @author Agustin Augurusa
 */
class HistoryUpdater() {

    fun update(gameState: GameState): GameState {
        val auxBoard = gameState.board
        val newHistory = gameState.history.copy(boardHistory = gameState.history.boardHistory + auxBoard)
        return gameState.copy(history = newHistory)
    }

}