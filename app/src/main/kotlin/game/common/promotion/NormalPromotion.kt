package game.common.promotion

import chessgame.factory.PieceFactory
import chessgame.game.state.GameState
import chessgame.movement.Position
import game.common.colour.Colour

/**
 * @author Agustin Augurusa
 */
class NormalPromotion : PromotionStrategy{
    override fun promote(gameState: GameState): GameState {
        val pawns = gameState.getPieceMap().filter { it.value.colour == gameState.getCurrentColour() && it.value.type == "PAWN" }
        val toRow = if(gameState.getCurrentColour() == Colour.WHITE) gameState.board.numRow else 1
        for ((position, piece) in pawns){
            val pawnPosition = position
            if (comparePositionsToRow(pawnPosition, toRow)){
                val auxPieceFactory = PieceFactory()
                val newQueen = auxPieceFactory.queenFactory(piece.id, gameState.getCurrentColour())
                var newMutableMap = gameState.getPieceMap().toMutableMap()
                newMutableMap.replace(pawnPosition, newQueen)
                return gameState.copy(board = gameState.board.copy(pieceMap = newMutableMap))
            }
        }
        return gameState
    }


    private fun comparePositionsToRow(position: Position, row: Int): Boolean{
        return position.row == row
    }

}