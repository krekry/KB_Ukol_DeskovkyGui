import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(()) zajistí bezpečnější spuštění
        SwingUtilities.invokeLater(() -> {
            try {
                BoardGameFileReader cteckaSouboru = new BoardGameFileReader();
                List<BoardGame> seznamHer = cteckaSouboru.readGamesFromFile("deskovky.txt");

                if (seznamHer.isEmpty()) {
                    System.out.println("Soubor neobsahuje žádné hry.");
                    return;
                }

                BoardGameGUI gui = new BoardGameGUI(seznamHer);
                gui.setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
