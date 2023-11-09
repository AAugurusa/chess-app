package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class MaxMovementCount(
    val max: Int,
    val pieceId: String
) : MovementValidator {
    override fun validate(movement: Movement, gameState: GameState): ResultMovement {
        val filteredList = filterDifferent(gameState.history.getPosById(pieceId))
        if (filteredList.size-1 < max) {
            return SuccessfulMovementResult()
        }
        return InvalidMovementResult("Piece reached max movement amount")
    }

    private fun filterDifferent(posList: List<Position>): List<Position> {
        val distinctPositions = posList.distinct()
        return distinctPositions
    }
}