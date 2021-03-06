/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver;

import java.util.Collection;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
/**
 *
 * @author Olli
 */
public class XConnection implements MessageListener{

    XMPPConnection connection;

    private void login(String userName, String password, int port) throws XMPPException {
        ConnectionConfiguration config = new ConnectionConfiguration("localhost", port, "");
        connection = new XMPPConnection(config);
        connection.connect();
        connection.login(userName, password);
    }

    public void sendMessage(String message, String to) throws XMPPException {
        Chat chat = connection.getChatManager().createChat(to, this);
        chat.sendMessage(message);
    }

    
    @Override
    public void processMessage(Chat chat, Message message) {
        if (message.getType() == Message.Type.chat) {
            System.out.println(chat.getParticipant() + " says: " + message.getBody());
        }
    }
    
    public void disconnect() {
        connection.disconnect();
    }

    public XConnection(String userName, String password, int port) throws XMPPException {
        this.login(userName, password, port);
    }
}
