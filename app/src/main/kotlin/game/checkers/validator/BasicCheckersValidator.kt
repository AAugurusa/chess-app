package game.checkers.validator

import adt.ResultMovement
import game.common.movement.Movement
import game.common.GameState
import game.common.validator.MovementValidator
import game.common.validator.basic.*
import game.common.validator.logic.AndMovementValidator

/**
 * @author Agustin Augurusa
 */
class BasicCheckersValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val basicMv = AndMovementValidator(listOf(
            NotAPieceMovementValidator(),
            EmptyOrEnemyMovementValidator(), InBoardValidator(),
            NotSamePositionMovementValidator(), ColourMovementValidator()
        ))

        return basicMv.validate(movement, gameState)
    }
}