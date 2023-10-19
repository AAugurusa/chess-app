package chessgame.adapter

import chessgame.factory.GameStateFactory
import chessgame.piece.Piece
import edu.austral.dissis.chess.gui.*

/**
 * @author Agustin Augurusa
 */
class MyEngine() : GameEngine {
    val gameStateFactory = GameStateFactory()
    override fun applyMove(move: Move): MoveResult {
        return InvalidMove("TEST")
    }

    override fun init(): InitialState {
        val newGameState = gameStateFactory.initialiceGameState()
        return InitialState(
            BoardSize(newGameState.board.numCol, newGameState.board.numRow),
            createPiecesList(newGameState.getPieceMap()),
            PlayerColor.WHITE
        )
    }


    private fun createPiecesList(pieceMap: Map<chessgame.movement.Position, Piece>): List<ChessPiece> {
        val list = mutableListOf<ChessPiece>()
        for (position in pieceMap.keys) {
            val auxPiece = pieceMap[position]
            list.add(
                ChessPiece(
                    auxPiece!!.id, PlayerColor.valueOf(auxPiece!!.colour.toString().uppercase()),
                    Position(position.row, position.column), auxPiece!!.type.toString().lowercase()
                )
            )
        }
        return list
    }
}