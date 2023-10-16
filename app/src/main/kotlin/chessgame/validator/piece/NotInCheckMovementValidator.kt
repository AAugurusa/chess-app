package chessgame.validator.piece

import adt.ResultMovement
import chessgame.game.state.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class NotInCheckMovementValidator : MovementValidator{
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        TODO("Not yet implemented")
    }

}