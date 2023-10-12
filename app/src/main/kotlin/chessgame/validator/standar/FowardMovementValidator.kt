package validator.standar

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import enums.Colour
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class FowardMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if (movement.from.column === movement.to.column && movement.from.row != movement.to.row) {
            val aux = if ((movement.to.row - movement.from.row) > 0) 1 else -1
            val pieceColour = gameState.board.getPieceMap().get(movement.from)?.colour

            if (aux === 1 && (pieceColour === Colour.WHITE)) {
                return SuccessfulMovementResult()
            }

            if (aux === -1 && (pieceColour === Colour.BLACK)) {
                return SuccessfulMovementResult()
            }
        }
        return InvalidMovementResult("Piece is not moving correctly")
    }
}