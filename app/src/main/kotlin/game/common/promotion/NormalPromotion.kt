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
        when(gameState.getCurrentColour()){
            Colour.WHITE -> {
                val pawns = gameState.getPieceMap().filter { it.value.colour == gameState.getCurrentColour() && it.value.type == "PAWN" }
                val toRow = gameState.board.numRow
                for ((position, piece) in pawns){
                    val pawnPosition = position
                    if (comparePositionsToRow(pawnPosition, toRow)){
                        val auxPieceFactory = PieceFactory()
                        val newQueen = auxPieceFactory.queenFactory(piece.id, Colour.WHITE)
                        var newMutableMap = gameState.getPieceMap().toMutableMap()
                        newMutableMap.replace(pawnPosition, newQueen)
                        return gameState.copy(board = gameState.board.copy(pieceMap = newMutableMap))
                    }
                }
            }
            Colour.BLACK -> {
                val pawns = gameState.getPieceMap().filter { it.value.colour == gameState.getCurrentColour() && it.value.type == "PAWN" }
                val toRow = 1
                for ((position, piece) in pawns){
                    val pawnPosition = position
                    if (comparePositionsToRow(pawnPosition, toRow)){
                        val auxPieceFactory = PieceFactory()
                        val newQueen = auxPieceFactory.queenFactory(piece.id, Colour.BLACK)
                        var newMutableMap = gameState.getPieceMap().toMutableMap()
                        newMutableMap.remove(pawnPosition)
                        newMutableMap[pawnPosition] = newQueen
                        return gameState.copy(board = gameState.board.copy(pieceMap = newMutableMap))
                    }
                }
            }
        }
        return gameState
    }


    private fun comparePositionsToRow(position: Position, row: Int): Boolean{
        return position.row == row
    }

}