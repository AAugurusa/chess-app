package game.common.promotion

import chessgame.game.state.GameState

/**
 * @author Agustin Augurusa
 */
interface PromotionStrategy {
    fun promote(gameState: GameState): GameState
}