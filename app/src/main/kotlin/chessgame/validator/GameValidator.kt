package validator

import adt.ResultMovement
import chessgame.game.state.GameState
import chessgame.movement.Movement

/**
 * @author Agustin Augurusa
 */
class GameValidator: MovementValidator{
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        TODO("Not yet implemented")
    }
}