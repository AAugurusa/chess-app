package factory

import chessgame.board.Board

/**
 * @author Agustin Augurusa
 */
interface BoardFactory {
    fun factory(): Board
}