package validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class ArchbishopMovementValidator : MovementValidator{
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val knightMv = KnightMovementValidator()
        val bishopMv = BishopMovementValidator()

        val bishopResult = bishopMv.validate(movement, gameState) is SuccessfulMovementResult
        val knightResult = knightMv.validate(movement, gameState) is SuccessfulMovementResult

        if(bishopResult || knightResult){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}