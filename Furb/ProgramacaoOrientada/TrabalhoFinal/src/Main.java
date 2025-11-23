import gui.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Garante que a GUI seja criada na Event Dispatch Thread (EDT)
        
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
