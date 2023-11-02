package chessgame.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class NotAPieceMovementValidator: MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if(gameState.getPieceMap().contains(movement.from)){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("No piece in from position")
    }
}