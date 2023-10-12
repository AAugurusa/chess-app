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
class ChancellorMovementValidator : MovementValidator{
    private val knightMv = KnightMovementValidator()
    private val rookMv = RookMovementValidator()
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val rookResult = rookMv.validate(movement, gameState) is SuccessfulMovementResult
        val knightResult = knightMv.validate(movement, gameState) is SuccessfulMovementResult

        if(rookResult || knightResult){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}