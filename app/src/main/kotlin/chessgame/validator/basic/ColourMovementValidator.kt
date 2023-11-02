package chessgame.validator.basic

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class ColourMovementValidator : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        if(gameState.board.pieceMap.get(movement.from)!!.colour === gameState.getCurrentColour()){
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("The piece is not from actual turn colour")
    }
}