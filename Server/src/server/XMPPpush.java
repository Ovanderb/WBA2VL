package server;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPConnection;

/**
 * Class to fire the XMPP Notification.
 * @author Oliver van der Bürie
 */
public class XMPPpush {

    Connection con;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void connect(){
        this.con = new XMPPConnection("");
    }
}
