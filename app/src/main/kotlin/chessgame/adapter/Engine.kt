package chessgame.adapter

import adt.ResultMovement
import chessgame.factory.GameStateFactory
import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.PieceMover
import validator.GameValidator

/**
 * @author Agustin Augurusa
 */
class Engine {

    private val gameValidator : GameValidator = GameValidator()
    private val gameStateFactory : GameStateFactory = GameStateFactory()
    private val pieceMover : PieceMover = PieceMover()
    //private val gameState : GameState = init()

    fun init() : GameState{
        return gameStateFactory.initialiceGameState()
    }

    fun evaluateMove(gameState: GameState, move: Movement): ResultMovement{
        return gameValidator.validate(move, gameState)
    }

    fun applyMove(gameState: GameState, move: Movement): GameState{
        return pieceMover.movePiece(move, gameState)
    }

    fun changeTurn(gameState: GameState): GameState{
        TODO()
    }



}