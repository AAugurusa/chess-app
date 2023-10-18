package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import enums.Colour
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class FowardMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if(movement.to.column === movement.from.column){
            when(gameState.currColour){
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