package game.chess.validator

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import chessgame.movement.Movement
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class OtherColourMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if (gameState.getPieceMap().containsKey(movement.to)) {
            if (gameState.getPieceMap().get(movement.to)!!.colour != gameState.getCurrentColour()) {
                return SuccessfulMovementResult()
            }
        }
        return InvalidMovementResult("The to position is not occupied by a piece of another colour")
    }
}