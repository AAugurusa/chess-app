package chessgame.adapter

import adt.*
import chessgame.factory.GameStateFactory
import chessgame.factory.HistoryUpdater
import chessgame.game.state.GameState
import chessgame.game.state.StateEvaluator
import chessgame.movement.Movement
import chessgame.movement.PieceMover
import edu.austral.dissis.chess.gui.GameOver
import edu.austral.dissis.chess.gui.InvalidMove
import edu.austral.dissis.chess.gui.MoveResult
import enums.Colour
import validator.GameValidator

/**
 * @author Agustin Augurusa
 */
class ChessEngine {

    private val gameValidator : GameValidator = GameValidator()
    private val gameStateFactory : GameStateFactory = GameStateFactory()
    private val historyUpdater : HistoryUpdater = HistoryUpdater()
    private val pieceMover : PieceMover = PieceMover()
    private val stateEvaluator : StateEvaluator = StateEvaluator()
    private val adapter = Adapter()
    private var gameState = init()

    fun init() : GameState{
        return gameStateFactory.normalGameStateBuilder()
    }

    fun makeAMove(move: Movement): MoveResult {
        if(isMovementSuccessful(move)){
            val newGameState = historyUpdater.update(pieceMover.movePiece(move, gameState))
            when(stateEvaluatorResult()){
                is InProgressStateResult -> {
                    gameState = newGameState
                    adapter.adaptGameState(gameState)
                }
                is TieStateResult -> return GameOver(adapter.adaptPieceColorToPlayerColor(Colour.WHITE))//EN VERDAD VER COMO PASARLE EL TIE
                is WinStateResult -> return GameOver(adapter.adaptPieceColorToPlayerColor((stateEvaluatorResult() as WinStateResult).wonColour))
            }
        }
        return InvalidMove(invalidMovementDescription(move))
    }

    private fun isMovementSuccessful(move: Movement): Boolean{
        return gameValidator.validate(move, gameState) is SuccessfulMovementResult
    }

    private fun stateEvaluatorResult(): StateEvaluatorResult{
        return stateEvaluator.stateEvaluator(gameState)
    }

    private fun invalidMovementDescription(move: Movement): String{
        return (gameValidator.validate(move, gameState) as InvalidMovementResult).reason
    }

    fun getAdapter(): Adapter{
        return adapter
    }

}