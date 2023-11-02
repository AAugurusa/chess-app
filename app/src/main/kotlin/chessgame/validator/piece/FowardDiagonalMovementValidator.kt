package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import enums.Colour
import validator.MovementValidator
import kotlin.math.abs

/**
 * @author Agustin Augurusa
 */
class FowardDiagonalMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        when (gameState.getCurrentColour()) {
            Colour.WHITE -> {
                if (movement.to.row > movement.from.row) {
                    val auxX = (movement.to.column - movement.from.column)
                    val auxY = (movement.to.row - movement.from.row)
                    if(abs(auxX) == abs(auxY)){
                        return SuccessfulMovementResult()
                    }
                    return InvalidMovementResult("Piece is not moving correctly")
                }
                return InvalidMovementResult("Piece is not moving correctly")
            }

            Colour.BLACK -> {
                if (movement.to.row < movement.from.row) {
                    val auxX = (movement.to.column - movement.from.column)
                    val auxY = (movement.to.row - movement.from.row)
                    if(abs(auxX) == abs(auxY)){
                        return SuccessfulMovementResult()
                    }
                    return InvalidMovementResult("Piece is not moving correctly")
                }
                return InvalidMovementResult("Piece is not moving correctly")
            }
        }
    }
}