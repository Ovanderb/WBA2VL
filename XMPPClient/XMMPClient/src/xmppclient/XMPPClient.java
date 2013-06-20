package xmppclient;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jivesoftware.smack.XMPPConnection;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Item;
//import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;

public class XMPPClient{

    
    public static void main(String args[]) throws XMPPException, IOException, InterruptedException {
        
        XMPPConnection.DEBUG_ENABLED = true;
        XConnection c = new XConnection("getsub", "getsub",5222);
        PubSubManager manager = new PublishSubscribe(c.connection).getManager();
        LeafNode node = manager.getNode("movienews");
        
        /*
        List<String> itm = new LinkedList<>();
        itm.add("snack");
        itm.add("schnubbel");
        List<Item> items = node.getItems(itm);
        int count = items.size();
        System.out.println("Items in Datenbank: "+count);
        for (int i = 0; i < count; i++) {
            System.out.println(items.get(i));
        }
        */
        //Collection<Item> items = node.getItems("");
        /*
        int s = items.size();
        System.out.println(s);
        /*for(Subscription sub: manager.getSubscriptions()){
            System.out.println(sub.getJid());
        };*/
        
        
        //int count = node.getItems().size();
        //System.out.println(count+"\n\n");
        /*for (int i = 0; i < count; i++) {
            System.out.println(items.get(i));
            
        }*/
        
                /*Iterator<org.jivesoftware.smackx.packet.DiscoverItems.Item> discnode = pubsub.getManager().discoverNodes("movienews").getItems();
        	while (discnode.hasNext()) {
                    String temp = discnode.next().getName();

                    System.out.print("- " + temp + "\n");
                }
                
        //CollectionNode col = pubsub.newCollection("messages","root");
        //LeafNode lf = pubsub.newleaf("mess", "messages");
        //SimplePayload sp = new SimplePayload("", "", "");
        //PayloadItem<SimplePayload> pi = new PayloadItem<> (null,sp);
        //pubsub.checknodes(null,0);
        */
        
        node.addItemEventListener(new ItemListener());
        //node.subscribe("getsub@localhost");
        String msg;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        while (!(msg = br.readLine()).equals("exit")) {}
        System.exit(0);
    }
}
