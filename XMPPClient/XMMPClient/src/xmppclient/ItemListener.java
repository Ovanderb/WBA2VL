/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmppclient;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Klasse um 
 * @author Olli
 */
public class ItemListener implements ItemEventListener {
    private XObj xobj;
    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder dBuilder;
    
    public ItemListener(XObj x) throws ParserConfigurationException {
        this.dBuilder = dbFactory.newDocumentBuilder();
        this.xobj = x;
    }

    
    @Override
    public void handlePublishedItems(ItemPublishEvent items) {
       
        List<Item> itm = items.getItems();
        for(int i = 0; items.getItems().size()>i;i++){
            StringReader inStream = new StringReader(itm.get(i).toXML());
                    InputSource inSource = new InputSource(inStream);
                    try {
                        
                        org.w3c.dom.Document doc = dBuilder.parse(inSource);
                        doc.getDocumentElement().normalize();
                        xobj.getPanel().setMessageName(doc.getElementsByTagName("movie").item(0).getAttributes().getNamedItem("name").getNodeValue());
                        xobj.getPanel().setDescription(doc.getElementsByTagName("discription").item(0).getTextContent());
                        xobj.getPanel().setMessageDate(doc.getElementsByTagName("movie").item(0).getAttributes().getNamedItem("date").getNodeValue());
                        xobj.getPanel().setMessageLink(doc.getElementsByTagName("movie").item(0).getAttributes().getNamedItem("link").getNodeValue());
                        //jt.insert(doc.getElementsByTagName("discription").item(0).getTextContent(), 0);
                    } catch ( SAXException | IOException ex) {
                        Logger.getLogger(XMPPClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
    }
}
