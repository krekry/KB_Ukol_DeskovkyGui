public class BoardGame {
    private String jmeno;
    private boolean koupeno;
    private int popularita;

    public BoardGame(String jmeno, boolean koupeno, int popularita) {
        this.jmeno = jmeno;
        this.koupeno = koupeno;
        this.popularita = popularita;
    }

    public String getJmeno() {
        return jmeno;
    }

    public boolean isKoupeno() {
        return koupeno;
    }

    public int getPopularita() {
        return popularita;
    }
}