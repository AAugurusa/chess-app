package test.chess.piece
import adt.InvalidMovementResult
import adt.SuccessfulMovementResult
import game.common.colour.Colour
import game.common.factory.PieceFactory
import game.common.movement.Movement
import game.common.movement.Position
import test.common.TestPieceGenerator
import kotlin.test.Test
import kotlin.test.assertTrue
/**
 * @author Agustin Augurusa
 */
class BishopTest {

    val gameGenerator = TestPieceGenerator()

    @Test
    fun `test diagonal forward-right successful bishop movement with no obstacles`() {
        val bishop = PieceFactory().bishopFactory("B1", Colour.WHITE)
        val gameState = gameGenerator.generateCenter(bishop)
        val movement = Movement(Position(7, 7), Position(4, 4))
        assertTrue(bishop.mv.validate(movement, gameState) is SuccessfulMovementResult)
    }

    @Test
    fun `test diagonal forward-left successful bishop movement with no obstacles`() {
        val bishop = PieceFactory().bishopFactory("B1", Colour.WHITE)
        val gameState = gameGenerator.generateCenter(bishop)
        val movement = Movement(Position(1, 7), Position(4, 4))
        assertTrue(bishop.mv.validate(movement, gameState) is SuccessfulMovementResult)
    }

    @Test
    fun `test diagonal backward-right successful bishop movement with no obstacles`() {
        val bishop = PieceFactory().bishopFactory("B1", Colour.WHITE)
        val gameState = gameGenerator.generateCenter(bishop)
        val movement = Movement(Position(7, 1), Position(4, 4))
        assertTrue(bishop.mv.validate(movement, gameState) is SuccessfulMovementResult)
    }

    @Test
    fun `test diagonal backward-left successful bishop movement with no obstacles`() {
        val bishop = PieceFactory().bishopFactory("B1", Colour.WHITE)
        val gameState = gameGenerator.generateCenter(bishop)
        val movement = Movement(Position(1, 1), Position(4, 4))
        assertTrue(bishop.mv.validate(movement, gameState) is SuccessfulMovementResult)
    }

    @Test
    fun `test bishop movement with obstacles`() {
        val bishop = PieceFactory().bishopFactory("B1", Colour.WHITE)
        val gameState = gameGenerator.generateWithAlly(bishop)
        val movement = Movement(Position(7, 7), Position(4, 4))
        assertTrue(bishop.mv.validate(movement, gameState) is InvalidMovementResult)
    }
}
