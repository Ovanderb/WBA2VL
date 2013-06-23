/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmppclient;

import javax.xml.parsers.ParserConfigurationException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
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
    XMPPConnection connection;
    String rootnode = "root";
    private XObj xobj;
    int MAXITEMS = 10;
    
    public PublishSubscribe(XMPPConnection connection,XObj x) throws XMPPException {
        mgr = new PubSubManager(connection);
        this.xobj = x;
        this.connection = connection;
        this.checknodes(rootnode, 0);

    }

    public PubSubManager getManager(){
        return this.mgr;
    }
    
    public XMPPConnection getConnection(){
        return this.connection;
    }
    
    
    
    private void checknodes(String node, int Level) throws XMPPException {
        try {
            mgr.getNode("root");
        } catch (XMPPException e) {
            System.out.println("Can't find root node.");
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
    
    /**
     * Funktion um sich in eine Node einzutragen.
     * @param name
     * @param panel
     * @throws XMPPException
     * @throws ParserConfigurationException 
     */
    public void subscribe(XObj xobj) throws XMPPException, ParserConfigurationException {
        System.out.println("\nSubscribe Action performed");
        LeafNode node = mgr.getNode(xobj.getActuallnode());
        System.out.println("Got node");
        xobj.setItemListener(new ItemListener(xobj));
        node.addItemEventListener(xobj.getItemListener());
        System.out.println("Added Itemlistener");
        node.subscribe(xobj.getJabberid());
        System.out.println("Subscribed node");
    }
    
    /**
     * Funktion, um sich aus einer Node auszuschreiben
     * @param name
     * @param panel
     * @throws XMPPException
     * @throws ParserConfigurationException 
     */
    public void unsubscribe(XObj xobj) throws XMPPException, ParserConfigurationException {
        System.out.println("\nUnsubscribe Action performed");
        LeafNode node = mgr.getNode(xobj.getActuallnode());
        System.out.println("Got node");
        node.removeItemEventListener(xobj.getItemListener());
        System.out.println("Removed Itemlistener");
        node.unsubscribe(xobj.getJabberid());
        System.out.println("Unsubscribed node");
    }
    
    public void disconnect() {
        this.connection.disconnect();
    }

}
