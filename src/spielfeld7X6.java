import java.util.Scanner;

class spielfeld7X6 {
    Scanner sc = new Scanner(System.in);
    private int[][] feld;
    private int s = 1; // Spielernr

    spielfeld7X6() {
        feld = new int[8][9];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 9; j++)
                feld[i][j] = 0;
    }

    void ausgabe() {
        System.out.println("     1     2     3     4     5     6     7");
        System.out.println("  +-----+-----+-----+------+----+-----+-----+");
        for (int i = 1; i < 7; i++) {
            System.out.print("  | ");
            for (int j = 1; j < 8; j++) {
                if (feld[i][j] == 0)
                    System.out.print("    | ");
                else if (feld[i][j] == 1)
                    System.out.print(" 0  | ");
                else
                    System.out.print(" X  | ");
            }
            System.out.println();
            System.out.println("  +-----------------------------------------+");
        }
        System.out.println();
    }

    void zug() {
        int sn = 0, zn = 1;
        if (s == 1)
            System.out.print(" Spieler O bitte Spalte wählen :  ");
        else
            System.out.print(" Spieler X bitte Spalte wählen :  ");
        sn = sc.nextInt();
// Spalte auf leer testen
        while (feld[zn][sn] == 0 & zn < 7) {
            feld[zn][sn] = s;
            feld[zn - 1][sn] = 0;
            zn++;
        }
        if (s == 1)
            s = 2;
        else
            s = 1;
    }

    int gewonnen() {
        int w = 0;
        int i, j, k, m, anz;
// 	Test auf 4 Steine waagerecht
        for (i = 6; i > 0; i--)
            for (k = 1; k < 7; k++) {
                anz = 1;
                j = k;
                while (feld[i][j] == feld[i][j + 1] & feld[i][j] != 0) {
                    anz++;
                    j++;
               //     System.out.println("i= " + i + " j = " + k + " anz= " + anz);
                }
                if (anz == 4) {
                    w = feld[i][j];
                    break;
                }
            }
//	 	Test auf 4 Steine senkrecht
        for (i = 6; i > 0; i--)
            for (k = 1; k < 7; k++) {
                anz = 1;
                j = i;
                while (feld[j][k] == feld[j - 1][k] & feld[j][k] != 0) {
                    anz++;
                    j--;
                  //  System.out.println("i= " + i + " k= " + k + " anz= " + anz);

                }
                if (anz == 4) {
                    w = feld[j][k];
                    break;
                }
            }
//		 	Test auf 4 Steine diagonal rechts
        for (i = 6; i > 0; i--)
            for (k = 1; k < 7; k++) {
                anz = 1;
                j = k;
                m = i;
                while (feld[m][j] == feld[m - 1][j + 1] & feld[m][j] != 0) {
                    anz++;
                    j++;
                    m--;
                    System.out.println("m= " + m + " j= " + j + " anz= " + anz);

                }
                if (anz == 4) {
                    w = feld[m][j];
                    System.out.println("anz= " + anz + " w= " + w);

                    break;
                }
            }
        //		 	Test auf 4 Steine diagonal links
        for (i = 6; i > 0; i--)
            for (k = 1; k < 7; k++) {
                anz = 1;
                j = k;
                m = i;
                while (feld[m][j] == feld[m - 1][j - 1] & feld[m][j] != 0) {
                    anz++;
                    j--;
                    m--;
                    System.out.println("m= " + m + " j= " + j + " anz= " + anz);

                }
                if (anz == 4) {
                    w = feld[m][j];
                    System.out.println("anz= " + anz + " w= " + w);

                    break;
                }
            }
// 	Gewinner ausgeben
        if (w == 1)
            System.out.println(" Spieler O hat gewonnen");
        else if (w == 2)
            System.out.println(" Spieler X hat gewonnen");
        return w;
    }

}
