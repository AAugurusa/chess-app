package validator

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.validator.basic.BasicMovementValidator
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class GameValidator: MovementValidator {//Agarra los validadores de la pieza y valida el movimiento
    val basicMv = BasicMovementValidator()
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