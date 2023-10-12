package validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class ColourValidator: MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val pieceColour = gameState.board.getPieceMap().getValue(movement.from).colour
        if(pieceColour == gameState.currColourTurn){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece if from another colour")
    }
}