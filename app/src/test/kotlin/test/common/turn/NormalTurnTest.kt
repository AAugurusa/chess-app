package test.common.turn

import game.common.colour.Colour
import game.common.turn.CommonTurnStrategy
import org.junit.Test

/**
 * @author Agustin Augurusa
 */
class NormalTurnTest {

    @Test
    fun `should change turn from white to black`() {
        val turnStrategy = CommonTurnStrategy(Colour.WHITE)
        val newTurnStrategy = turnStrategy.advanceTurn()
        assert(newTurnStrategy.getCurrentColour() == Colour.BLACK)
    }

    @Test
    fun `should change turn from black to white`() {
        val turnStrategy = CommonTurnStrategy(Colour.BLACK)
        val newTurnStrategy = turnStrategy.advanceTurn()
        assert(newTurnStrategy.getCurrentColour() == Colour.WHITE)
    }

}