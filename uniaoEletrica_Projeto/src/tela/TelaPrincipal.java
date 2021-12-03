package tela;

public class TelaPrincipal {
    private String tela = "╔════════════════════════════════╦════════════════════════════════════════╗\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ╠════════════════════════════════════════╣\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "║                                ║                                        ║\n" +
            "╠════════════════════════════════╩════════════════════════════════════════╣\n" +
            "║                                                                         ║\n" +
            "╚═════════════════════════════════════════════════════════════════════════╝\n";

    public void imprimirTela() {
        clearScreen();
        System.out.print(tela);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String ultimaLinha() {
        return "\u001b[H\u001b[19B\u001b[1C                                                                         \u001b[H\u001b[19B\u001b[1C";
    }
}
