package restserver;

import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;

/**
 *
 * @author Olli
 */
public class XMPPPub {

    XConnection c;
    PublishSubscribe pubsub;

    public XMPPPub(String name, String pass) throws XMPPException {
        //TODO Notfalls das Debugging wieder einschalten
        //XMPPConnection.DEBUG_ENABLED = true;
        this.c = new XConnection(name, pass,5222);
        this.pubsub = new PublishSubscribe(this.c.connection);
    }

    public void publishItem(String xmlstr) throws XMPPException {
        Date date = new Date();
        System.out.println(xmlstr);
        LeafNode movienews = pubsub.getManager().getNode("movienews");
        SimplePayload payload = new SimplePayload(null, null, xmlstr);
        PayloadItem<SimplePayload> paylitm = new PayloadItem<>(String.valueOf(date.getTime()), payload);
        movienews.publish(paylitm);
    }
    /***************************************************************
     * Main Funktion diente zum Testen des Publischen eines Items 
     * Insbesondere wegen den Problemen, mehrere Items wieder aus vom Server
     * zu ziehen.
     * 
     * 
     *
    public void main(String args[]) throws XMPPException, IOException {

        XMPPConnection.DEBUG_ENABLED = true;

        //CollectionNode col = pubsub.newCollection("messages","root");
        //LeafNode lf = pubsub.newleaf("mess", "messages");
        //SimplePayload sp = new SimplePayload("", "", "");
        //PayloadItem<SimplePayload> pi = new PayloadItem<> (null,sp);
        //pubsub.checknodes(null,0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String xmlstr = ""
                + "<bills>\n"
                + "  <bill id=\"5\" cash=\"true\" bank=\"Deutsche Postbank AG\" account=\"0\" code=\"59266874\" owner=\"testNutzer\" date=\"2013/22/05\">\n"
                + "    <movie name=\"tito\" price=\"5.00\"/>\n"
                + "  </bill>\n"
                + "</bills>";
        publishItem(xmlstr);
        
         while (!(msg = br.readLine()).equals("exit")) {
         //movienews.publish(new Item(msg));
         System.out.println("New Item:"+msg+" send");
         }
        System.exit(0);
    }
    
    ENDE MAIN FUNKTION*/
}
