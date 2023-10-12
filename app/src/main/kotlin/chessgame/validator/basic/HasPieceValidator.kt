package validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class HasPieceValidator: MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if(gameState.board.getPieceMap().contains(movement.from)){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("There is no piece to move")
    }
}