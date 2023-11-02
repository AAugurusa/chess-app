package chessgame.adapter

import adt.InvalidMovementResult
import adt.ResultMovement
import adt.SuccessfulMovementResult
import chessgame.game.board.Board
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import chessgame.piece.Piece
import edu.austral.dissis.chess.gui.*
import enums.Colour

/**
 * @author Agustin Augurusa
 */
class Adapter {

    fun adaptMyPositionToPosition(position: Position): edu.austral.dissis.chess.gui.Position {
        return edu.austral.dissis.chess.gui.Position(position.row, position.column)
    }

    fun adaptPieceColorToPlayerColor(colour: Colour): PlayerColor {
        return when (colour) {
            Colour.WHITE -> PlayerColor.WHITE
            Colour.BLACK -> PlayerColor.BLACK
        }
    }

    fun adaptPieceToChessPiece(board: Board, piece: Piece) : ChessPiece{
        val position : edu.austral.dissis.chess.gui.Position = adaptMyPositionToPosition(board.getPositionByPiece(piece))
        val playerColor: PlayerColor = adaptPieceColorToPlayerColor(piece.colour)
        val pieceNumber : String = piece.id.toString()
        val pieceName : String = piece.type.toString().lowercase()
        return ChessPiece(pieceNumber, playerColor, position, pieceName)
    }

    fun adaptPiecesToChessPieces(board: Board) : List<ChessPiece>{
        val pieces : List<Piece> = board.pieceMap.values.toList()
        val chessPieces: MutableList<ChessPiece> = mutableListOf()
        for (piece in pieces) {
            chessPieces.add(adaptPieceToChessPiece(board, piece))
        }
        return chessPieces.toList()
    }

    fun adaptBoardSize(row: Int, column: Int) : BoardSize {
        return BoardSize(column, row)
    }


    fun adaptGameStateToInitialState(gameState: GameState) : InitialState {
        val board : Board = gameState.board
        val boardSize = adaptBoardSize(board.numCol, board.numCol)
        val chessPieces = adaptPiecesToChessPieces(board)
        val playerColor = adaptPieceColorToPlayerColor(gameState.getCurrentColour())
        return InitialState(boardSize, chessPieces, playerColor)
    }

    fun adaptGameState(gameState: GameState) : NewGameState{
        val pieces = adaptPiecesToChessPieces(gameState.board)
        val playerColor = adaptPieceColorToPlayerColor(gameState.getCurrentColour())
        return NewGameState(pieces, playerColor)
    }

    fun translateMoveToMovement(move: Move) : Movement {
        return Movement(Position(move.to.column, move.to.row), Position(move.from.column, move.from.row))
    }

}