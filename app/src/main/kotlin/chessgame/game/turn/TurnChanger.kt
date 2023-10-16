package chessgame.turn

import chessgame.game.state.GameState
import enums.Colour

/**
 * @author Agustin Augurusa
 */
class TurnChanger {
    fun changeTurn(gameState: GameState): GameState {
        when(gameState.currColour){
            Colour.WHITE -> return GameState(gameState.board, Colour.BLACK, gameState.history)
            Colour.BLACK -> return GameState(gameState.board, Colour.WHITE, gameState.history)
        }
    }
}