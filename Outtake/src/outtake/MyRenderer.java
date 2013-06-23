package outtake;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class MyRenderer extends DefaultListCellRenderer {
    public MyRenderer() {
        super();
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
        this.setAutoscrolls(false);
        this.setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setBackground((isSelected) ? list.getSelectionBackground() : (index%2 == 0) ? Color.WHITE : list.getBackground());
        setForeground((isSelected) ? list.getSelectionForeground() : list.getForeground());
        setText(value.toString());
        return this;
    }
}
