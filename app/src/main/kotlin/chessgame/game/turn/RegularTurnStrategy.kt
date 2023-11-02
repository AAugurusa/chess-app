package chessgame.game.turn

import game.common.colour.Colour
import game.common.colour.Colour.*

/**
 * @author Agustin Augurusa
 */
class RegularTurnStrategy(val colour: Colour) : TurnStrategy{
    override fun advanceTurn(): TurnStrategy {
        when(colour){
            WHITE -> return RegularTurnStrategy(BLACK)
            BLACK -> return RegularTurnStrategy(WHITE)
        }
    }

    override fun getCurrentColour(): Colour {
        return colour
    }

}