import java.util.Scanner;
public class gew7x6_start {
	public static void main(String[] args) {
		System.out.println("________________________________________________");
		System.out.println("                   VIER GEWINNT                 ");
		System.out.println("________________________________________________");
		//System.out.println("Wählen Sie die Feldgröße");
		spielfeld7X6 s = new spielfeld7X6();
		s.ausgabe();
		while (s.gewonnen() == 0) {
			s.zug();
			s.ausgabe();
		}
	}
}
