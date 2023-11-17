package game.common.promotion

import game.common.GameState

/**
 * @author Agustin Augurusa
 */
interface PromotionStrategy {
    fun promote(gameState: GameState): GameState
}