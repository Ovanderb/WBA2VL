/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmppclient;

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

    private void login(String userName, String password, int port, String host) throws XMPPException {
        ConnectionConfiguration config = new ConnectionConfiguration(host, port, "");
        connection = new XMPPConnection(config);
        connection.connect();
        connection.login(userName, password);
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

    public void setConnection(XMPPConnection connection) {
        this.connection = connection;
    }

    public XMPPConnection getConnection() {
        return connection;
    }

    public XConnection(String userName, String password, int port, String host) throws XMPPException {
        this.login(userName, password, port, host);
    }
}
