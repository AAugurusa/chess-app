package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import game.common.colour.Colour
import game.common.colour.Colour.*
import factory.BoardFactory
import game.common.validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class NotInCheckMovementValidator : MovementValidator {

    val boardFactory = BoardFactory()

    override fun validate(movement: Movement, gameState: GameState): ResultMovement {

        when(gameState.getCurrentColour()){
            WHITE -> {
                val designatedPosition = gameState.getPositionByPieceID("KW")!!
                val auxNewGameState = gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement), gameState.changeColourTurn())
                if(!isPieceColourTargetingPosition(designatedPosition, auxNewGameState, BLACK)){
                    return SuccessfulMovementResult()
                }
                return InvalidMovementResult("King is left in check")
            }
            BLACK -> {
                val designatedPosition = gameState.getPositionByPieceID("KB")!!
                val auxNewGameState = gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement), gameState.changeColourTurn()   )
                if(!isPieceColourTargetingPosition(designatedPosition, gameState, WHITE)){
                    return SuccessfulMovementResult()
                }
                return InvalidMovementResult("King is left in check")
            }
        }
    }

    private fun isPieceColourTargetingPosition(targetPosition: Position, gameState: GameState, colour: Colour): Boolean{
        val pieceFilter = gameState.getPieceMap().values.filter { it.colour == colour && it.id != "KW" && it.id != "KB" }
        for(piece in pieceFilter){
            val originPostion = gameState.getPositionByPieceID(piece.id)!!
            if(piece.mv.validate(Movement(targetPosition, originPostion), gameState) is SuccessfulMovementResult){
                return true;
            }
        }
        return false;
    }

}