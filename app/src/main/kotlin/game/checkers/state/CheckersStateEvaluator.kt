package game.checkers.state

import adt.*
import chessgame.movement.Movement
import chessgame.movement.Position
import chessgame.piece.Piece
import game.checkers.validator.basic.BasicCheckersValidator
import game.common.GameState
import game.common.colour.Colour
import game.common.state.StateEvaluator

/**
 * @author Agustin Augurusa
 */
class CheckersStateEvaluator : StateEvaluator {
    override fun validate(gameState: GameState): StateEvaluatorResult {
        if (canAPieceMove(gameState)) {
            if (colourHasNoMorePieces(gameState, Colour.WHITE)) {
                return WinStateResult(Colour.BLACK)
            }
            if (colourHasNoMorePieces(gameState, Colour.BLACK)) {
                return WinStateResult(Colour.WHITE)
            }
            return InProgressStateResult()
        } else {
            return TieStateResult("Stalemate")
        }
    }

    private fun colourHasNoMorePieces(gameState: GameState, colour: Colour): Boolean {
        return gameState.getPieceMap().entries.none { it.value.colour === colour }
    }

    private fun canAPieceMove(gameState: GameState): Boolean {
        val pieceList = gameState.getPieceMap().entries.filter { it.value.colour === gameState.getCurrentColour() }
        for (piece in pieceList) {
            if (gameState.checkersPieceHasAnyValidMovement(piece.value)) {
                return true
            }
        }
        return false
    }

}