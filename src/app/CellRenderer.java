package app;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author dingl01
 */
public class CellRenderer extends DefaultTableCellRenderer {

    JLabel lbl = new JLabel();

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        lbl.setIcon((ImageIcon) value);
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            cell.setBackground(Color.YELLOW);
        } else {
            cell.setBackground(new Color(0xFFFFFF));
        }
        return lbl;
    }
}
