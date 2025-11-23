
// Alunos: Igor Zafriel Schmidt

package src;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ValidadorHtmlGUI());
    }
}