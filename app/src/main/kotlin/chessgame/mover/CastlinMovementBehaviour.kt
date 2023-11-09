package chessgame.mover

import chessgame.game.state.GameState
import chessgame.movement.Movement
import chessgame.movement.Position
import game.common.colour.Colour.*
import game.common.movement.MovementBehaviour

/**
 * @author Agustin Augurusa
 */
class CastlinMovementBehaviour : MovementBehaviour {
    override fun move(gameState: GameState, movement: Movement): GameState {
        val difAux = movement.to.column - movement.from.column
        val king = gameState.getPiece(movement.from)
        val newGameState = king.mb.move(gameState, movement)

        if(difAux > 0){
            when(gameState.getCurrentColour()){
                WHITE -> {
                    val rook = gameState.getPiece(Position(gameState.board.numCol,1))
                    return rook.mb.move(newGameState, Movement(Position(movement.to.column-1, 1),Position(gameState.board.numCol,1)))
                }
                BLACK -> {
                    val rook = gameState.getPiece(Position(gameState.board.numCol,gameState.board.numRow))
                    return rook.mb.move(newGameState, Movement(Position(movement.to.column-1, gameState.board.numRow), Position(gameState.board.numCol,gameState.board.numRow)))
                }
            }
        }else{
            when(gameState.getCurrentColour()){
                WHITE -> {
                    val rook = gameState.getPiece(Position(1,1))
                    return rook.mb.move(newGameState, Movement(Position(movement.to.column+1, 1), Position(1,1)))
                }
                BLACK -> {
                    val rook = gameState.getPiece(Position(1,gameState.board.numRow))
                    return rook.mb.move(newGameState, Movement(Position(movement.to.column+1, gameState.board.numRow), Position(1,gameState.board.numRow)))
                }
            }
        }
    }
}