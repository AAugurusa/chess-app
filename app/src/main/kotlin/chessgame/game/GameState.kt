package chessgame

import enums.Colour
import chessgame.board.Board

/**
 * @author Agustin Augurusa
 */
data class GameState(val board: Board, val currColourTurn: Colour)
