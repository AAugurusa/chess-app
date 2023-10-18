package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class PathClearValidator() : MovementValidator {
    val diagonalMovementValidator = DiagonalMovementValidator()
    val verticalMovementValidator = VerticalMovementValidator()
    val horizontalMovementValidator = HorizontalMovementValidator()
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if (diagonalMovementValidator.validate(movement, gameState) is SuccessfulMovementResult) {
            return diagonalPathMovementValidator(movement, gameState)
        }

        if (horizontalMovementValidator.validate(movement, gameState) is SuccessfulMovementResult) {
            return horizontalPathMovementValidator(movement, gameState)
        }

        if (verticalMovementValidator.validate(movement, gameState) is SuccessfulMovementResult) {
            return verticalPathMovementValidator(movement, gameState)
        }
        return InvalidMovementResult("Move is not valid")
    }

    private fun diagonalPathMovementValidator(movement: Movement, gameState: GameState): ResultMovement {
        val auxX = (movement.to.column - movement.from.column)
        val auxY = (movement.to.row - movement.from.row)

        val stepX = if (auxX > 0) 1 else -1
        val stepY = if (auxY > 0) 1 else -1

        for (i in 1 until abs(auxX)) {
            val intermediatePosition = Position(
                movement.from.column + i * stepX,
                movement.from.row + i * stepY
            )

            if (gameState.getPieceMap().containsKey(intermediatePosition)) {
                return InvalidMovementResult("A intermediate position is blocked")
            }
        }

        return SuccessfulMovementResult()
    }

    private fun horizontalPathMovementValidator(movement: Movement, gameState: GameState): ResultMovement {
        val aux = abs(movement.from.column - movement.to.column)
        for (i in 1 until aux) {
            val intermediatePosition = Position(
                movement.from.column + i,
                movement.from.row,
            )
            if (gameState.getPieceMap().contains(intermediatePosition)) {
                return InvalidMovementResult("A intermediate position is blocked")
            }
        }
        return SuccessfulMovementResult()
    }

    private fun verticalPathMovementValidator(movement: Movement, gameState: GameState): ResultMovement {
        val aux = abs(movement.from.row - movement.to.row)
        for (i in 1 until aux) {
            val intermediatePosition = Position(
                movement.from.column,
                movement.from.row + i,
            )
            if (gameState.getPieceMap().contains(intermediatePosition)) {
                return InvalidMovementResult("A intermediate position is blocked")
            }
        }
        return SuccessfulMovementResult()
    }


}