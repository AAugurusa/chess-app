package chessgame.game.turn

import enums.Colour

/**
 * @author Agustin Augurusa
 */
interface TurnStrategy {

    fun advanceTurn() : TurnStrategy
    fun getCurrentColour(): Colour

}