package validator.standar

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class LMovementValidator(
    private val fstJump: Int,
    private val sndJump: Int,
) : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val auxX = abs(movement.to.column - movement.from.column)
        val auxY = abs(movement.to.row - movement.from.row)
        if ((auxX == fstJump && auxY == sndJump) || (auxX == sndJump && auxY == fstJump)) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}