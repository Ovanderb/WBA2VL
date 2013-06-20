/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver;

import java.util.Iterator;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.CollectionNode;
import org.jivesoftware.smackx.pubsub.NodeType;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;

/**
 *
 * @author Olli
 */
public class PublishSubscribe {

    PubSubManager mgr;
    String rootnode = "root";
    int MAXITEMS = 10;
    
    public PublishSubscribe(XMPPConnection connection) throws XMPPException {
        mgr = new PubSubManager(connection);
        //this.checknodes(rootnode, 0);

    }

    public PubSubManager getManager(){
        return this.mgr;
    }
    
    public void checknodes(String node, int Level) throws XMPPException {
        try {
            mgr.getNode("root");
        } catch (XMPPException e) {
            CollectionNode col = this.newCollection(rootnode);
        }
        try {
            mgr.getNode("messages");
        }catch (XMPPException e) {
            CollectionNode col = this.newCollection("messages",rootnode);
        }
        try{
            mgr.getNode("movienews");
        }catch (XMPPException e) {
            LeafNode lf = this.newleaf("movienews","messages");
        }
        Iterator<DiscoverItems.Item> existingnodes = mgr.discoverNodes(node).getItems();
        while (existingnodes.hasNext()) {
            String thisnode = existingnodes.next().getNode();
            String out = ":";
            for(int i = 0;i<Level;i++){
                out +="  ";
            }
            System.out.println(out+"|=> " + thisnode);
            this.checknodes(thisnode, Level + 1);
        }
    }

    public LeafNode newleaf(String name) throws XMPPException {
        try {
            return mgr.getNode(name);
        } catch (XMPPException e) {

            ConfigureForm form = new ConfigureForm(FormType.submit);
            form.setAccessModel(AccessModel.open);
            form.setDeliverPayloads(true);
            form.setNotifyRetract(true);
            form.setSubscribe(true);
            form.setMaxItems(MAXITEMS);
            form.setPersistentItems(true);
            form.setPublishModel(PublishModel.open);
            form.setNodeType(NodeType.leaf);
            return (LeafNode) mgr.createNode(name, form);
        }
    }

    public LeafNode newleaf(String name, String parent) throws XMPPException {
        try {
            return mgr.getNode(name);
        } catch (XMPPException e) {
            ConfigureForm form = new ConfigureForm(FormType.submit);
            form.setAccessModel(AccessModel.open);
            form.setDeliverPayloads(true);
            form.setNotifyRetract(true);
            form.setPersistentItems(true);
            form.setSubscribe(true);
            form.setMaxItems(MAXITEMS);
            form.setPublishModel(PublishModel.open);
            form.setNodeType(NodeType.leaf);
            form.setCollection(parent);
            return (LeafNode) mgr.createNode(name,form);
        }
    }

    public CollectionNode newCollection(String name) throws XMPPException {
        try {
            return mgr.getNode(name);
        } catch (XMPPException e) {
            ConfigureForm form = new ConfigureForm(FormType.submit);
            form.setAccessModel(AccessModel.open);
            form.setDeliverPayloads(true);
            form.setNotifyRetract(true);
            form.setSubscribe(true);
            form.setMaxItems(MAXITEMS);
            form.setPersistentItems(true);
            form.setPublishModel(PublishModel.open);
            form.setNodeType(NodeType.collection);
            return (CollectionNode) mgr.createNode(name, form);
        }
    }

    public CollectionNode newCollection(String name, String parent) throws XMPPException {
        try {
            return mgr.getNode(name);
        } catch (XMPPException e) {
            ConfigureForm form = new ConfigureForm(FormType.submit);
            form.setAccessModel(AccessModel.open);
            form.setDeliverPayloads(true);
            form.setNotifyRetract(true);
            form.setSubscribe(true);
            form.setMaxItems(MAXITEMS);
            form.setPersistentItems(true);
            form.setPublishModel(PublishModel.open);
            form.setNodeType(NodeType.collection);
            form.setCollection(parent);
            return (CollectionNode) mgr.createNode(name, form);
        }
    }
}
