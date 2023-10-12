package validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator
import validator.standar.DiagonalMovementValidator
import validator.standar.HorizontalMovementValidator
import validator.standar.VerticalMovementValidator

/**
 * @author Agustin Augurusa
 */
class QueenMovementValidator : MovementValidator {
    private val horizontalMv = HorizontalMovementValidator()
    private val verticalMv = VerticalMovementValidator()
    private val diagonalMv = DiagonalMovementValidator()

    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val isHorizontalMoveValid = horizontalMv.validate(movement, gameState) is SuccessfulMovementResult
        val isVerticalMoveValid = verticalMv.validate(movement, gameState) is SuccessfulMovementResult
        val isDiagonalMoveValid = diagonalMv.validate(movement, gameState) is SuccessfulMovementResult

        if (isHorizontalMoveValid || isVerticalMoveValid || isDiagonalMoveValid) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}