package game.common.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import game.common.GameState
import game.common.movement.Movement
import game.common.colour.Colour
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class FowardMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if(movement.to.column === movement.from.column){
            when(gameState.getCurrentColour()){
                Colour.WHITE -> {
                    if(movement.to.row > movement.from.row){
                        return SuccessfulMovementResult()
                    }
                    return InvalidMovementResult("Piece is not moving correctly")
                }
                Colour.BLACK -> {
                    if(movement.to.row < movement.from.row){
                        return SuccessfulMovementResult()
                    }
                    return InvalidMovementResult("Piece is not moving correctly")
                }
            }
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}