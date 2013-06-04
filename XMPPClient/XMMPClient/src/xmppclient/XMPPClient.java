package xmppclient;

import java.io.*;
import org.jivesoftware.smack.XMPPConnection;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.LeafNode;

public class XMPPClient{

    //TODO nodechecking noch weiter erarbeiten
    public static void main(String args[]) throws XMPPException, IOException, InterruptedException {
        // declare variables
        XMPPConnection.DEBUG_ENABLED = true;
        XConnection c = new XConnection("foo", "password");
        PublishSubscribe pubsub = new PublishSubscribe(c.connection);
       
        
        //CollectionNode col = pubsub.newCollection("messages","root");
        //LeafNode lf = pubsub.newleaf("mess", "messages");
        //SimplePayload sp = new SimplePayload("", "", "");
        //PayloadItem<SimplePayload> pi = new PayloadItem<> (null,sp);
        //pubsub.checknodes(null,0);
        LeafNode movienews = pubsub.mgr.getNode("movienews");
        movienews.addItemEventListener(new ItemListener());
        movienews.subscribe("foo@olli-pc");
        String msg;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            
        
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
        while (!(msg = br.readLine()).equals("exit")) {}
        System.exit(0);
    }
}
