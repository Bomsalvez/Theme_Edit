package dev.senzalla.themeEdit;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static dev.senzalla.themeEdit.PathThemeConfig.*;

/**
 * <code>TreatmentTheme</code>
 * Edit the JPanel for themes or ligth or dark
 *
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 * @since 1.0
 */
public class ApplyTheme {

    private static FileInputStream fileInputStream() {
        try {
            return new FileInputStream(getArchive());
        } catch (FileNotFoundException ex) {
            messageError("carregar");
        }
        return null;
    }

    private static Color uploadColor(String container) {
        try {
            FileInputStream input = fileInputStream();
            Properties properties = new Properties();
            properties.load(input);
            String[] cor = properties.getProperty(container).split(",");
            return new Color(Integer.parseInt(cor[0]), Integer.parseInt(cor[1]), Integer.parseInt(cor[2]));
        } catch (IOException ex) {
            messageError("carregar");
        }
        return null;
    }

    /**
     * @param jPanel {@link JPanel}
     */
    public static void uploadTheme(JPanel jPanel) {
        if (fileInputStream() != null) {
            jPanel.setBackground(uploadColor(panel));
            for (Component component : jPanel.getComponents()) {
                checkPanel(component);
                checkButton(component);
                checkTextField(component);
                checkComboBox(component);
                checkFormatedTextField(component);
                checkLabel(component);
            }
        }
    }

    private static void checkLabel(Component component) {
        if (component instanceof JLabel) {
            JLabel lbl = (JLabel) component;
            lbl.setForeground(uploadColor(label));
        }
    }

    private static void checkFormatedTextField(Component component) {
        if (component instanceof JFormattedTextField) {
            JFormattedTextField txt = (JFormattedTextField) component;
            txt.setBackground(uploadColor(textField));
            txt.setForeground(uploadColor(label));
        }
    }

    private static void checkComboBox(Component component) {
        if (component instanceof JComboBox) {
            JComboBox cbx = (JComboBox) component;
            cbx.setBackground(uploadColor(comboBox));
            cbx.setForeground(uploadColor(label));
        }
    }

    private static void checkTextField(Component component) {
        if (component instanceof JTextField) {
            JTextField txt = (JTextField) component;
            txt.setBackground(uploadColor(textField));
            txt.setForeground(uploadColor(label));
        }
    }

    private static void checkButton(Component component) {
        if (component instanceof JButton) {
            JButton btn = (JButton) component;
            btn.setBackground(uploadColor(button));
            btn.setForeground(uploadColor(label));
        }
    }

    private static void checkPanel(Component component) {
        if (component instanceof JPanel) {
            JPanel pnl = (JPanel) component;
            pnl.setBackground(uploadColor(panel));
            uploadTheme(pnl);
        }
    }

    /**
     * @param jTable {@link JTable}
     */
    public static void uploadThemeInTable(JTable jTable) {
        if (fileInputStream() != null) {
            jTable.setBackground(uploadColor(table));
            jTable.setForeground(uploadColor(label));
            jTable.setGridColor(Objects.requireNonNull(uploadColor(gridTable)));
        }
    }

    /**
     * @param jList {@link JList}
     */
    public static void uploadThemeInList(JList jList) {
        if (fileInputStream() != null) {
            jList.setBackground(uploadColor(list));
            jList.setForeground(uploadColor(label));
        }
    }

    /**
     * @param jTree {@link JTree}
     */
    public static void uploadThemeInList(JTree jTree) {
        if (fileInputStream() != null) {
            jTree.setBackground(uploadColor(tree));
            jTree.setForeground(uploadColor(label));
        }
    }

    /**
     * @param button   {@link JButton}
     * @param pathIcon {@link String}
     */
    public static void uploadIconThemeInButton(JButton button, String pathIcon) {
        if (button.getBackground().equals(new Color(0, 0, 0))) {
            Icon icon = new ImageIcon(ApplyTheme.class.getResource(pathIcon));
            button.setIcon(icon);
        }
    }
}
