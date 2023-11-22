package game.common.turn

import game.common.colour.Colour
import game.common.colour.Colour.*

/**
 * @author Agustin Augurusa
 */
class CommonTurnStrategy(val colour: Colour) : TurnStrategy {
    override fun advanceTurn(): TurnStrategy {
        when(colour){
            WHITE -> return CommonTurnStrategy(BLACK)
            BLACK -> return CommonTurnStrategy(WHITE)
        }
    }

    override fun getCurrentColour(): Colour {
        return colour
    }

}