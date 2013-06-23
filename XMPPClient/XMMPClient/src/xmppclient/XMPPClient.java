package xmppclient;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PubSubManager;

public class XMPPClient {
    private static String host = "localhost";
    private static int serverport = 5222;
    private static String username = "getsub";
    private static String password = "getsub";
    private static String actuallnode = "movienews";
    private static String jabberid = "getsub@localhost";
    
    
    
    public static void main(String args[]) throws XMPPException, IOException, InterruptedException, ParserConfigurationException {
        XObj xmppdata = new XObj();
        xmppdata.setHost(host);
        xmppdata.setServerport(serverport);
        xmppdata.setUsername(username);
        xmppdata.setPassword(password);
        xmppdata.setJabberid(jabberid);
        xmppdata.setActuallnode(actuallnode);
        xmppdata.setItemListener(new ItemListener(xmppdata));
        
        JFrame mainframe = new JFrame("Mainframe");
        xmppdata.setPanel(new xmpppanel());
        
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setPreferredSize(new Dimension(600, 400));
        mainframe.add(xmppdata.getPanel());
        

        try {
            //XMPPConnection.DEBUG_ENABLED = true;
            xmppdata.setConnection(new XConnection(username, password, serverport, host));
            xmppdata.setManager(new PublishSubscribe(xmppdata.getConnection().connection, xmppdata));
            
            JButton b1 = xmppdata.getPanel().getjButton1();
            b1.addActionListener(new subscribeEvent(xmppdata));

            JButton b2 = xmppdata.getPanel().getjButton2();
            b2.addActionListener(new unsubscribeEvent(xmppdata));
        
            LeafNode node = xmppdata.getManager().getManager().getNode(actuallnode);
            //node.addItemEventListener(xmppdata.getItemListener());
        } catch (XMPPException e) {
            System.out.println("No Connection possible.");
        }

        mainframe.pack();
        mainframe.setVisible(true);
        
        

        //##########################################################
        // HIER FOLGEN EINIGE VERSUCHE ZUM SMACK BUG.
        // Diese haben wir absichlich als Kommentare drin gelassen.
        // Weitere Funktionalitäten folgen hier nicht mehr
        //##########################################################
        
        
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


        //node.subscribe("getsub@localhost");
        
        
    }
}

class subscribeEvent implements ActionListener{
            
            private XObj xobj;
            
            public subscribeEvent(XObj x) {
                this.xobj = x;
            }
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xobj.getManager().subscribe(xobj);
                } catch ( XMPPException | ParserConfigurationException ex) {
                    Logger.getLogger(subscribeEvent.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error beim Subscriben");
                }
            }
            
        }
        
        class unsubscribeEvent implements ActionListener{
            
            private XObj xobj;
            
            public unsubscribeEvent(XObj x) {
                this.xobj = x;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xobj.getManager().unsubscribe(xobj);
                } catch ( XMPPException | ParserConfigurationException ex) {
                    System.out.println("Error beim Unsubscriben");
                    Logger.getLogger(unsubscribeEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }