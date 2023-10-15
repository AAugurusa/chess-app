package chessgame

import chessgame.game.History
import chessgame.game.board.Board
import chessgame.movement.Position
import chessgame.piece.Piece
import enums.Colour

/**
 * @author Agustin Augurusa
 */
data class GameState(val board: Board, val currColour: Colour, val history: History){

    fun getPieceMap() : Map<Position, Piece>{
        return board.pieceMap
    }

    fun getPiece(position: Position): Piece{
        return getPieceMap().get(position)!!
    }


    
}
