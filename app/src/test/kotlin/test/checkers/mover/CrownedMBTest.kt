package test.checkers.mover

import game.common.factory.GameStateFactory
import adt.InvalidMovementResult
import adt.SuccessfulMovementResult
import game.common.colour.Colour
import game.common.factory.PieceFactory
import game.common.movement.Movement
import game.common.movement.Position
import test.common.TestPieceGenerator
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * @author Agustin Augurusa
 */
class CrownedMBTest {
    val gameStateFactory = GameStateFactory()

    @Test
    fun `test crowned movement behaviour`() {
        val pieceToMove = PieceFactory().crownedFactory("C1", Colour.WHITE)
        val initialGs = TestPieceGenerator().generateCenter(pieceToMove)
        val movement = Movement(Position(5, 5), Position(4, 4))
        val finalGs = pieceToMove.mb.move(initialGs, movement)

        val expectedBoard = initialGs.getPieceMap().toMutableMap()
        expectedBoard.remove(Position(4, 4))
        expectedBoard[Position(5, 5)] = pieceToMove

        val expectedGs = initialGs.copy(
            board = initialGs.board.copy(pieceMap = expectedBoard.toMap())
        )

        assertEquals(expectedGs, finalGs)
    }

    @Test
    fun `test crowned backwards movement behaviour`() {
        val pieceToMove = PieceFactory().crownedFactory("C1", Colour.WHITE)
        val initialGs = TestPieceGenerator().generateCenter(pieceToMove)
        val movement = Movement(Position(3, 3), Position(4, 4))
        val finalGs = pieceToMove.mb.move(initialGs, movement)

        val expectedBoard = initialGs.getPieceMap().toMutableMap()
        expectedBoard.remove(Position(4, 4))
        expectedBoard[Position(3, 3)] = pieceToMove

        val expectedGs = initialGs.copy(
            board = initialGs.board.copy(pieceMap = expectedBoard.toMap())
        )

        assertEquals(expectedGs, finalGs)
    }

    @Test
    fun `test crowned eat movement behaviour`() {
        val pieceToMove = PieceFactory().crownedFactory("C1", Colour.WHITE)
        val initialGs = TestPieceGenerator().generateWithEnemyChecker(pieceToMove)
        val movement = Movement(Position(6, 6), Position(4, 4))
        val finalGs = pieceToMove.mb.move(initialGs, movement)

        val expectedBoard = initialGs.getPieceMap().toMutableMap()
        expectedBoard.remove(Position(4, 4))
        expectedBoard.remove(Position(5, 5))
        expectedBoard[Position(6, 6)] = pieceToMove

        val expectedGs = initialGs.copy(
            board = initialGs.board.copy(pieceMap = expectedBoard.toMap())
        )

        assertEquals(expectedGs, finalGs)
    }
}