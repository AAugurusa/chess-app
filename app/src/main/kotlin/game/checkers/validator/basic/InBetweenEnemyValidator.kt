package game.checkers.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.movement.Movement
import chessgame.movement.Position
import game.common.GameState
import game.common.validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class InBetweenEnemyValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val auxX = (movement.to.column - movement.from.column)
        val auxY = (movement.to.row - movement.from.row)

        val stepX = if (auxX > 0) 1 else -1
        val stepY = if (auxY > 0) 1 else -1

        for (i in 1 until abs(auxX)) {
            val intermediatePosition = Position(
                movement.from.column + i * stepX,
                movement.from.row + i * stepY
            )

            if (gameState.getPieceMap().containsKey(intermediatePosition)) {
                return SuccessfulMovementResult()
            }
        }

        return InvalidMovementResult("Piece is not moving correctly")
    }
}