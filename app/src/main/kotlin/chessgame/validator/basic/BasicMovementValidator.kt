package chessgame.validator.basic

import adt.ResultMovement
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.validator.logic.AndMovementValidator
import validator.MovementValidator
import validator.basic.InBoardValidator

/**
 * @author Agustin Augurusa
 */
class BasicMovementValidator : MovementValidator{
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val basicMv = AndMovementValidator(listOf(ColourMovementValidator(),
                EmptyOrEnemyMovementValidator(), InBoardValidator(),
                NotAPieceMovementValidator(), NotSamePositionMovementValidator()))

        return basicMv.validate(movement, gameState)
    }
}