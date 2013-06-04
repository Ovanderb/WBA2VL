package xmppclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;

/**
 *
 * @author Olli
 */
public class XMPPPub {
    public static void main(String args[]) throws XMPPException, IOException {
        // declare variables
        XMPPConnection.DEBUG_ENABLED = true;
        XConnection c = new XConnection("testuser", "password");
        
        PublishSubscribe pubsub = new PublishSubscribe(c.connection);
       
        
        //CollectionNode col = pubsub.newCollection("messages","root");
        //LeafNode lf = pubsub.newleaf("mess", "messages");
        //SimplePayload sp = new SimplePayload("", "", "");
        //PayloadItem<SimplePayload> pi = new PayloadItem<> (null,sp);
        //pubsub.checknodes(null,0);
        LeafNode movienews = pubsub.getManager().getNode("movienews");
        String msg;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String xmlstr ="<movie id=\"1\" name=\"foo\" date=\"2000-01-01+01:00\" image=\"http://w.w.de\" link=\"http://w.w.de\">\n" +
                       "        <discription>Lorem Ipsum</discription>\n" +
                       "    </movie>";
        SimplePayload payload = new SimplePayload(null,null,xmlstr);
        PayloadItem<SimplePayload> paylitm = new PayloadItem<>(null,payload);
        movienews.publish(paylitm);
        
        String xmlstr2 ="<movie id=\"2\" name=\"bar\">\n" +
                       "        <discription>Doloer et amet</discription>\n" +
                       "    </movie>";
        SimplePayload payload2 = new SimplePayload(null,null,xmlstr2);
        PayloadItem paylitm2 = new PayloadItem(null,payload2);
        movienews.publish(paylitm2);
        
        
        while (!(msg = br.readLine()).equals("exit")) {
            //movienews.publish(new Item(msg));
            System.out.println("New Item:"+msg+" send");
        }
        
                   
                
                
        /*c.displayBuddyList();

        System.out.println("-----");

        System.out.println("Who do you want to talk to? - Type contacts full email address:");
        String talkTo = br.readLine();

        System.out.println("-----");
        System.out.println("All messages will be sent to " + talkTo);
        System.out.println("Enter your message in the console:");
        System.out.println("-----\n");

        while (!(msg = br.readLine()).equals("bye")) {
            c.sendMessage(msg, talkTo);
        }

        c.disconnect();*/
        System.exit(0);
    }
}
