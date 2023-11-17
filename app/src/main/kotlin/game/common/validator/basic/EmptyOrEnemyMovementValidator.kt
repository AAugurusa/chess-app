package game.common.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import chessgame.movement.Movement
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class EmptyOrEnemyMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if(!gameState.getPieceMap().containsKey(movement.to)){
            return SuccessfulMovementResult()
        }else{
            if(gameState.getPieceMap().get(movement.to)!!.colour != gameState.getCurrentColour()){
                return SuccessfulMovementResult()
            }else{
                return InvalidMovementResult("To Position is occupied by a piece of the same colour")
            }
        }
    }

}