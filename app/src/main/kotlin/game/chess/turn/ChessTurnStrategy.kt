package game.chess.turn

import game.common.colour.Colour
import game.common.colour.Colour.*
import game.common.turn.TurnStrategy

/**
 * @author Agustin Augurusa
 */
class ChessTurnStrategy(val colour: Colour) : TurnStrategy {
    override fun advanceTurn(): TurnStrategy {
        when(colour){
            WHITE -> return ChessTurnStrategy(BLACK)
            BLACK -> return ChessTurnStrategy(WHITE)
        }
    }

    override fun getCurrentColour(): Colour {
        return colour
    }

}