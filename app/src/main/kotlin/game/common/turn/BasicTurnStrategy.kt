package game.common.turn

import game.common.colour.Colour
import game.common.colour.Colour.*

/**
 * @author Agustin Augurusa
 */
class BasicTurnStrategy(val colour: Colour) : TurnStrategy {
    override fun advanceTurn(): TurnStrategy {
        when(colour){
            WHITE -> return BasicTurnStrategy(BLACK)
            BLACK -> return BasicTurnStrategy(WHITE)
        }
    }

    override fun getCurrentColour(): Colour {
        return colour
    }

}