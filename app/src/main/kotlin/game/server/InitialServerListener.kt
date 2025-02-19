package game.server

import edu.austral.ingsis.clientserver.Message
import edu.austral.ingsis.clientserver.MessageListener

/**
 * @author Agustin Augurusa
 */
class InitialServerListener(private val server: GameServer): MessageListener<Unit> {
    override fun handleMessage(message: Message<Unit>) {
        server.handleInit()
    }

}