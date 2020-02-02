import java.util.Scanner;

public class gew7x6_start {
    public static void main(String[] args) {
        while (startGame() == 1) {
        }
    }

    public static int startGame() {
        System.out.println("________________________________________________");
        System.out.println("                   VIER GEWINNT                 ");
        System.out.println("________________________________________________");
        spielfeld7X6 s = new spielfeld7X6();
        s.askMitComp();
        s.werBeginnt();
        System.out.println("________________________________________________");
        System.out.println("              DAS SPIEL BEGINNT                 ");
        System.out.println("________________________________________________");
        s.ausgabe();
        while (s.gewonnen() == 0) {
            s.zug();
            s.ausgabe();
        }
        System.out.println("Möchten Sie weiter spielen? (j/n)");
        Scanner in = new Scanner(System.in);
        String weiter = in.next();
        if (weiter.equals("j"))
            return 1;
        else {
            System.out.println("________________________________________________");
            System.out.println("              DAS SPIEL BEENDET                 ");
            System.out.println("________________________________________________");
        }
        return 2;
    }
}


