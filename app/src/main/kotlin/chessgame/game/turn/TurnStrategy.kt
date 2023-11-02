package chessgame.game.turn

import game.common.colour.Colour

/**
 * @author Agustin Augurusa
 */
interface TurnStrategy {

    fun advanceTurn() : TurnStrategy
    fun getCurrentColour(): Colour

}