package validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.standar.HorizontalMovementValidator
import validator.MovementValidator
import validator.standar.VerticalMovementValidator

/**
 * @author Agustin Augurusa
 */
class RookMovementValidator() : MovementValidator {
    val horizontalMV = HorizontalMovementValidator()
    val verticalMV = VerticalMovementValidator()
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {

        if ((horizontalMV.validate(movement, gameState) is SuccessfulMovementResult) ||
            (verticalMV.validate(movement, gameState) is SuccessfulMovementResult)
        ) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}