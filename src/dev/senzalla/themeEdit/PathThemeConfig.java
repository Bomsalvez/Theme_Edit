package dev.senzalla.themeEdit;

import javax.swing.*;
import java.io.File;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class PathThemeConfig {
     final static String gridTable = "gridTable";
     final static String label = "label";
     final static String button = "button";
     final static String textField = "textField";
     final static String comboBox = "comboBox";
     final static String table = "table";
     final static String tree = "tree";
     final static String list = "list";
     final static String panel = "panel";


     static String getArchive() {
        final String PATH = "\\tema.properties";
        final File DIR = new File(System.getProperty("user.dir") + "/config/");
        DIR.mkdir();
        return DIR + PATH;
    }

    public static void messageError(String action) {
        JOptionPane.showMessageDialog(
                new JFrame(),
                "Erro ao " + action + " diretorio!",
                "Erro no Arquivo",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
