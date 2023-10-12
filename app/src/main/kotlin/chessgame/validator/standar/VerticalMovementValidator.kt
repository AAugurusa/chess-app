package validator.standar

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class VerticalMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
    if((movement.from.row != movement.to.row) && (movement.from.column === movement.to.column)){
            val aux = abs(movement.from.row - movement.to.row)
            for (i in 1 until aux) {
                val intermediatePosition = Position(
                    movement.from.column,
                    movement.from.row + i,
                )
                if (gameState.board.getPieceMap().contains(intermediatePosition)) {
                    return InvalidMovementResult("A intermediate position is blocked")
                }
            }
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}