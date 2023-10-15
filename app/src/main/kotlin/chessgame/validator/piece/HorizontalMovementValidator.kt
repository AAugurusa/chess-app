package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class HorizontalMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if ((movement.from.column != movement.to.column) && (movement.from.row == movement.to.row)) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }

}