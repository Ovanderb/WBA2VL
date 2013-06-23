/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmppclient;

/**
 * Klasse um alle wichtigen Instanzen für Objektübergaben zu halten und zwischen
 * XMPP, Swing, JAXB, etc. Daten einfach austauschen zu könnenbzw. die EventListener
 * ansprechen zu können.
 * @author Olli
 */
public class XObj {
    private XConnection connection;
    private PublishSubscribe manager;
    private ItemListener itemListener;
    private String host;
    private int serverport;
    private String username;
    private String password;
    private String actuallnode;
    private String jabberid;
    private xmpppanel panel;

    public ItemListener getItemListener() {
        return itemListener;
    }

    public void setItemListener(ItemListener itemlistener) {
        this.itemListener = itemlistener;
    }
    
    public xmpppanel getPanel() {
        return panel;
    }

    public void setPanel(xmpppanel panel) {
        this.panel = panel;
    }
    
    public XConnection getConnection() {
        return connection;
    }

    public void setConnection(XConnection connection) {
        this.connection = connection;
    }

    public PublishSubscribe getManager() {
        return manager;
    }

    public void setManager(PublishSubscribe manager) {
        this.manager = manager;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getServerport() {
        return serverport;
    }

    public void setServerport(int serverport) {
        this.serverport = serverport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActuallnode() {
        return actuallnode;
    }

    public void setActuallnode(String actuallnode) {
        this.actuallnode = actuallnode;
    }

    public String getJabberid() {
        return jabberid;
    }

    public void setJabberid(String jabberid) {
        this.jabberid = jabberid;
    }

   
}
