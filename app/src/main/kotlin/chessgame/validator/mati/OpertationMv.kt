package validator.mati

import adt.ResultMovement
import chessgame.GameState
import chessgame.movement.Movement
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class OpertationMv(

) : MovementValidator{
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        TODO("Not yet implemented")

        true.and()
    }
}