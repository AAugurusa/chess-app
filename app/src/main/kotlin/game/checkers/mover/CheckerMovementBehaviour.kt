package game.checkers.mover

import adt.InvalidMovementResult
import adt.SuccessfulMovementResult
import chessgame.movement.Movement
import chessgame.movement.Position
import game.checkers.validator.basic.InBetweenEnemyValidator
import game.chess.mover.NormalMovementBehaviour
import game.chess.validator.LimitMovementValidator
import game.common.GameState
import game.common.movement.MovementBehaviour
import game.common.validator.basic.FowardDiagonalMovementValidator
import game.common.validator.basic.ToPositionClearValidator
import game.common.validator.logic.AndMovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class CheckerMovementBehaviour : MovementBehaviour {

    private val normalDiagonalMv = AndMovementValidator(
        listOf(
            LimitMovementValidator(1),
            ToPositionClearValidator(),
            FowardDiagonalMovementValidator()
        )
    )

    override fun move(gameState: GameState, movement: Movement): GameState {
        if (isAnNormalMovement(movement, gameState)) {
            return NormalMovementBehaviour().move(gameState, movement)
        }
        return applyEatMovement(movement, gameState)
    }

    private fun isAnNormalMovement(movement: Movement, gameState: GameState): Boolean {
        return (normalDiagonalMv.validate(movement, gameState) is SuccessfulMovementResult)
    }

    private fun applyEatMovement(movement: Movement, gameState: GameState): GameState {
        val newGameState = NormalMovementBehaviour().move(gameState, movement)
        val auxX = (movement.to.column - movement.from.column)
        val auxY = (movement.to.row - movement.from.row)

        val stepX = if (auxX > 0) 1 else -1
        val stepY = if (auxY > 0) 1 else -1

        val intermediatePosition = Position(
            movement.from.column + 1 * stepX,
            movement.from.row + 1 * stepY
        )

        var newPieceMap = newGameState.getPieceMap().toMutableMap()
        newPieceMap.remove(intermediatePosition)

        return newGameState.copy(board = newGameState.board.copy(pieceMap = newPieceMap.toMap()))
    }

}