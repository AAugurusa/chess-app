package chessgame.validator.basic

import adt.ResultMovement
import chessgame.game.state.GameState
import chessgame.movement.Movement
import game.common.validator.logic.AndMovementValidator
import game.common.validator.MovementValidator
import validator.basic.InBoardValidator

/**
 * @author Agustin Augurusa
 */
class BasicMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val basicMv = AndMovementValidator(listOf(NotAPieceMovementValidator(),
                EmptyOrEnemyMovementValidator(), InBoardValidator(),
                NotSamePositionMovementValidator(), ColourMovementValidator()))

        return basicMv.validate(movement, gameState)
    }
}