package game.server

import edu.austral.dissis.chess.gui.Move
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

/**
 * @author Agustin Augurusa
 */
class MovementListener(private val server: GameServer): MessageListener<Move> {
    override fun handleMessage(message: Message<Move>) {
        server.handleMove(message)
    }


}