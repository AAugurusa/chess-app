package chessgame.validator.piece

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.board.Board
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import enums.Colour
import enums.Colour.*
import factory.BoardFactory
import validator.MovementValidator

/**
 * @author Agustin Augurusa
 */
class NotInCheckMovementValidator : MovementValidator{

    val boardFactory = BoardFactory()

    override fun validate(movement: Movement, gameState: GameState): ResultMovement {

        when(gameState.currColour){
            WHITE -> {
                val designatedPosition = gameState.getPositionByPieceID("KW")!!
                val auxNewGameState = gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement), currColour = BLACK)
                if(isPieceColourTargetingPosition(designatedPosition, auxNewGameState, BLACK)){
                    return SuccessfulMovementResult()
                }
                return InvalidMovementResult("King is left in check")
            }
            BLACK -> {
                val designatedPosition = gameState.getPositionByPieceID("KB")!!
                val auxNewGameState = gameState.copy(board = boardFactory.boardFromReference(gameState.board, movement), currColour = WHITE)
                if(isPieceColourTargetingPosition(designatedPosition, gameState, WHITE)){
                    return SuccessfulMovementResult()
                }
                return InvalidMovementResult("King is left in check")
            }
        }
    }

    private fun isPieceColourTargetingPosition(targetPosition: Position, gameState: GameState, colour: Colour): Boolean{
        val pieceFilter = gameState.getPieceMap().values.filter { it.colour == colour }
        for(piece in pieceFilter){
            val originPostion = gameState.getPositionByPieceID(piece.id)!!
            if(piece.mv.validate(Movement(targetPosition, originPostion), gameState) is SuccessfulMovementResult){
                return true;
            }
        }
        return false;
    }

}