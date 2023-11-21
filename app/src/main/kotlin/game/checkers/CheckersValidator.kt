package game.checkers

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import game.common.movement.Movement
import game.checkers.validator.BasicCheckersValidator
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class CheckersValidator: MovementValidator {//Agarra los validadores de la pieza y valida el movimiento
    val basicMv = BasicCheckersValidator()
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val basicResult = basicMv.validate(movement, gameState)
        when(basicResult){
            is InvalidMovementResult -> return basicResult
            is SuccessfulMovementResult -> {
                return gameState.getPiece(movement.from).mv.validate(movement, gameState)
            }
        }
    }
}