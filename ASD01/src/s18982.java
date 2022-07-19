import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class s18982 {

    public static int[] tab;

    public static void main(String[] args) {
        File file = new File(args[0]);
        int len = 0;
        try {
            Scanner scan = new Scanner(file);
            Scanner scanner = new Scanner(file);
            String str = scan.nextLine();

            if (str.length() > 1) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ' ') {
                        len++;
                    }
                }
                if (str.charAt(0) != ' ' && str.charAt(str.length() - 1) != ' ')
                    len++;
                if (str.charAt(0) == ' ' && str.charAt(str.length() - 1) == ' ')
                    len--;
            } else
                len = str.length();

            tab = new int[len];
            int y = 0;
            while (scanner.hasNextInt()) {
                tab[y] = scanner.nextInt();
                y++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int SumaRos = tab[0];
        int ElemRos = 1;
        int IndexPoczRos = 0;

        int NajElemRos = 0;
        int NajSumaRos = 0;
        int NajElemMal = 0;
        int NajSumaMal = 0;
        int NajIndexRos = 0;
        int NajIndexMal = 0;

        int SumaMal = tab[0];
        int ElemMal = 1;
        int IndexPoczMal = 0;

        int FinalSuma = 0;
        int FinalElem = 0;

        if (tab.length == 1) {
            NajElemMal = 1;
            NajSumaMal = tab[0];
            System.out.println(NajElemMal + " " + NajSumaMal);
        } else {
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i + 1] >= tab[i]) {
                    ElemRos++;
                    SumaRos = SumaRos + tab[i + 1];
                    IndexPoczRos = i;
                    if (ElemRos > NajElemRos) {
                        NajElemRos = ElemRos;
                        NajSumaRos = SumaRos;
                        NajIndexRos = IndexPoczRos;
                    }
                } else {
                    if (ElemRos > NajElemRos) {
                        NajElemRos = ElemRos;
                        NajSumaRos = SumaRos;
                        NajIndexRos = IndexPoczRos;
                    }
                    ElemRos = 1;
                    SumaRos = tab[i + 1];
                }

                if (tab[i + 1] <= tab[i]) {
                    ElemMal++;
                    SumaMal = SumaMal + tab[i + 1];
                    IndexPoczMal = i;
                    if (ElemMal > NajElemMal) {
                        NajElemMal = ElemMal;
                        NajSumaMal = SumaMal;
                        NajIndexMal = IndexPoczMal;
                    }
                } else {
                    if (ElemMal > NajElemMal) {
                        NajElemMal = ElemMal;
                        NajSumaMal = SumaMal;
                        NajIndexMal = IndexPoczMal;
                    }
                    ElemMal = 1;
                    SumaMal = tab[i + 1];
                }


                if (NajElemMal > NajElemRos) {
                    FinalElem = NajElemMal;
                    FinalSuma = NajSumaMal;
                }
                if (NajElemMal < NajElemRos) {
                    FinalElem = NajElemRos;
                    FinalSuma = NajSumaRos;
                }
                if (NajElemMal == NajElemRos) {
                    if (NajIndexMal < NajIndexRos) {
                        FinalElem = NajElemMal;
                        FinalSuma = NajSumaMal;
                    } else {
                        FinalElem = NajElemRos;
                        FinalSuma = NajSumaRos;
                    }
                }
                if (i == tab.length - 2) {
                    System.out.println(FinalElem + " " + FinalSuma);
                }

            }


        }


    }
}