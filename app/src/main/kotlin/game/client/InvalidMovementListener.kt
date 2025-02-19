package game.client

import edu.austral.dissis.chess.gui.InvalidMove
import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

/**
 * @author Agustin Augurusa
 */
class InvalidMovementListener(private val client: GameClient): MessageListener<InvalidMove> {
    override fun handleMessage(message: Message<InvalidMove>) {
        client.handleMoveResult(message.payload)
    }
}