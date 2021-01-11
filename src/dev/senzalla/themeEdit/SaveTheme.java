package dev.senzalla.themeEdit;

import java.io.FileOutputStream;
import java.io.IOException;
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
public class SaveTheme  {
    private static Properties properties;

    public static void saveLightTheme() {
        properties = new Properties();
        properties.setProperty(gridTable, "0,0,0");
        properties.setProperty(label, "0,0,0");
        properties.setProperty(button, "187,187,187");
        properties.setProperty(textField, "187,187,187");
        properties.setProperty(comboBox, "187,187,187");
        properties.setProperty(table, "187,187,187");
        properties.setProperty(tree, "187,187,187");
        properties.setProperty(list, "187,187,187");
        properties.setProperty(panel, "204,204,204");
        saveTheme();
    }

    public static void saveDarkTheme() {
        properties = new Properties();
        properties.setProperty(comboBox, "0,0,0");
        properties.setProperty(button, "0,0,0");
        properties.setProperty(textField, "37,37,37");
        properties.setProperty(table, "37,37,37");
        properties.setProperty(list, "37,37,37");
        properties.setProperty(tree, "37,37,37");
        properties.setProperty(panel, "40,42,54");
        properties.setProperty(gridTable, "204,204,204");
        properties.setProperty(label, "204,204,204");
        saveTheme();
    }


    private static void saveTheme() {
        try {
            FileOutputStream output = new FileOutputStream(getArchive());
            properties.store(output, null);
        } catch (IOException ex) {
            messageError("salvar");
        }
    }
}
