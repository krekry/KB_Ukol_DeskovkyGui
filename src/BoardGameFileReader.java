import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardGameFileReader {
    public List<BoardGame> readGamesFromFile(String cestaKSouboru)  {
        List<BoardGame> boardGames = new ArrayList<>();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(cestaKSouboru)))) {
            while (scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String[] bloky = radek.split(",");

                if (bloky.length == 3){
                    String jmeno = bloky[0].trim();
                    boolean koupeno = bloky[1].trim().equalsIgnoreCase("ano");
                    int oblibenost = Integer.parseInt(bloky[2].trim());

                    BoardGame deskovka = new BoardGame(jmeno, koupeno, oblibenost);
                    boardGames.add(deskovka);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nebyl nalezen: " + cestaKSouboru);
        } catch (NumberFormatException e){
            System.err.println("Chyba při parsování čísla: " + e.getMessage());
        }
        return boardGames;
    }
}
