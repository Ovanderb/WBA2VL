/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmppclient;

import java.util.List;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

/**
 *
 * @author Olli
 */
public class ItemListener implements ItemEventListener {

    @Override
    public void handlePublishedItems(ItemPublishEvent items) {
        System.out.println("Item count: " + items.getItems().size());
        System.out.println("Blubb"+items.getItems());
        List<Item> itm = items.getItems();
        for(int i = 0; items.getItems().size()>i;i++){
            System.out.println(itm.get(i).toXML());
        }
    }
}
