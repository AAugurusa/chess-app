package chessgame.validator.basic

import adt.ResultMovement
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.validator.piece.NotInCheckMovementValidator
import game.common.validator.logic.AndMovementValidator
import game.common.validator.MovementValidator
import game.common.validator.basic.NotSamePositionMovementValidator
import game.common.validator.basic.InBoardValidator
import game.common.validator.basic.NotAPieceMovementValidator

/**
 * @author Agustin Augurusa
 */
class BasicMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val basicMv = AndMovementValidator(listOf(
            NotAPieceMovementValidator(),
                EmptyOrEnemyMovementValidator(), InBoardValidator(),
                NotSamePositionMovementValidator(), ColourMovementValidator(), NotInCheckMovementValidator()))

        return basicMv.validate(movement, gameState)
    }
}