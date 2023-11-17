package game.chess.validator

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import chessgame.movement.Movement
import game.common.validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class JumpMovementValidator(
    private val x: Int,
    private val y: Int,
) : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val auxX = abs(movement.to.column - movement.from.column)
        val auxY = abs(movement.to.row - movement.from.row)
        if ((auxX == x && auxY == y) || (auxX == y && auxY == x)) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}