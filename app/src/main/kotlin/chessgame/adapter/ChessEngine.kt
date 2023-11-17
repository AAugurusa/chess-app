package chessgame.adapter

import adt.*
import chessgame.factory.GameStateFactory
import game.common.board.HistoryUpdater
import chessgame.game.state.GameState
import chessgame.game.state.NormalStateEvaluator
import chessgame.movement.Movement
import chessgame.movement.PieceMover
import edu.austral.dissis.chess.gui.GameOver
import edu.austral.dissis.chess.gui.InvalidMove
import edu.austral.dissis.chess.gui.MoveResult
import game.common.colour.Colour
import game.chess.promotion.NormalPromotion
import game.common.promotion.PromotionStrategy
import validator.GameValidator

/**
 * @author Agustin Augurusa
 */
class ChessEngine {

    private val gameValidator : GameValidator = GameValidator()
    private val gameStateFactory : GameStateFactory = GameStateFactory()
    private val historyUpdater : HistoryUpdater = HistoryUpdater()
    private val pieceMover : PieceMover = PieceMover()
    private val normalStateEvaluator : NormalStateEvaluator = NormalStateEvaluator()
    private val promoter : PromotionStrategy = NormalPromotion()
    private val adapter = Adapter()
    private var gameState : GameState = init()

    fun init() : GameState{
        return gameStateFactory.normalGameStateBuilder()
    }

    fun makeAMove(move: Movement): MoveResult {
        if(isMovementSuccessful(move)){
            val afterMoveGs = historyUpdater.update(pieceMover.movePiece(move, gameState))
            val newGameState = promoter.promote(afterMoveGs)
            when(stateEvaluatorResult(newGameState)){
                is InProgressStateResult -> {
                    gameState = newGameState.copy(currColour = newGameState.currColour.advanceTurn())
                    return adapter.adaptGameState(gameState)
                }
                is TieStateResult -> return GameOver(adapter.adaptPieceColorToPlayerColor(Colour.WHITE))//EN VERDAD VER COMO PASARLE EL TIE
                is WinStateResult -> return GameOver(adapter.adaptPieceColorToPlayerColor((stateEvaluatorResult(newGameState) as WinStateResult).wonColour))
            }
        }
        return InvalidMove(invalidMovementDescription(move))
    }

    private fun isMovementSuccessful(move: Movement): Boolean{
        return gameValidator.validate(move, gameState) is SuccessfulMovementResult
    }

    private fun stateEvaluatorResult(gs: GameState): StateEvaluatorResult{
        return normalStateEvaluator.validate(gs)
    }

    private fun invalidMovementDescription(move: Movement): String{
        return (gameValidator.validate(move, gameState) as InvalidMovementResult).reason
    }

    fun getAdapter(): Adapter{
        return adapter
    }

}