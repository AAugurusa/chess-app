package validator.basic

import adt.OutOfBoundMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class InBoardValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if ((movement.from.column >= gameState.board.getNumColums()) && (movement.from.row >= gameState.board.getNumRows()) && (movement.to.column >= gameState.board.getNumColums()) && (movement.to.row >= gameState.board.getNumRows())) {
            return SuccessfulMovementResult()
        }
        return OutOfBoundMovementResult()
    }
}
