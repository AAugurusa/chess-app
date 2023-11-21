package game.common.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import game.common.movement.Movement
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class InBoardValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if ((movement.from.column <= gameState.board.numCol) && (movement.from.row <= gameState.board.numRow) && (movement.to.column <= gameState.board.numCol) && (movement.to.row <= gameState.board.numRow)) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Movement out of bounds")
    }
}
