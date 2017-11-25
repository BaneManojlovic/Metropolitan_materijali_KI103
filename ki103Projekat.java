
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class ki103Projekat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Odaberite jednu od sledecih funkcija: ");
        System.out.println("1. Matematicke funkcije");
        System.out.println("2. Razni zadaci");
        System.out.println("3. Unos i obrada nizova");
        System.out.println("4. Unos i obrada matrica");
        System.out.println("5. Unos i obrada stringova");
        System.out.println("6. Prekid rada");

        Scanner ulaz = new Scanner(System.in);
        int input = ulaz.nextInt();

        switch (input) {
            case 1:
                matFunkcije();
                break;
            case 2:
                razZadaci();
                break;
            case 3:
                niz();
                break;
            case 4:
                matrica();
                break;
            case 5:
                string();
                break;
            case 6:
                System.out.println("Hvala Vam što ste koristili naš program!");
                break;
            default:
                System.out.println("Niste uneli ispravan broj!");
                break;
        }
        ulaz.close();
    }

    private static void matFunkcije() {
        System.out.println("Odaberite jednu od 3 matematičke operacije"
                + "(sqrt, ceil, exp)");
        Scanner ulaz = new Scanner(System.in);
        String input = ulaz.next();
        switch (input) {
            case "sqrt": {
                System.out.println("Unesite broj N:");
                int n = ulaz.nextInt();
                System.out.println("Vas rezultat je: " + Math.sqrt(n));
                break;
            }
            case "ceil": {
                System.out.println("Unesite realni broj N:");
                double n = ulaz.nextDouble();
                System.out.println("Vas rezultat je: " + Math.ceil(n));
                break;
            }
            case "exp": {
                System.out.println("Unesite broj N:");
                int n = ulaz.nextInt();
                System.out.println("Vas rezultat je: " + Math.exp(n));
                break;
            }
            default:
                System.out.println("Niste uneli ispravno ime funkcije!");
                break;
        }
        ulaz.close();
    }

    private static void razZadaci() {
        System.out.println("Izaberite zaadatak koji zelite da resite "
                + " a) racunanje binomnog koeficijenta");
        Scanner ulaz = new Scanner(System.in);
        String input = ulaz.next();
        if (input.equals("a")) {
            System.out.println("Unesite broj N: ");
            int n = ulaz.nextInt();
            System.out.println("Unesite drugi broj K: ");
            int k = ulaz.nextInt();
            int binKoef = factorial(n) / (factorial(k) * factorial(n - k));

            System.out.println("Vas rezultat je: " + binKoef);
        }
        ulaz.close();
    }

    private static int factorial(int x) {
        int fakt = 1;
        for (int i = 1; i <= x; i++) {
            fakt *= i;
        }
        return fakt;
    }

    private static void niz() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite ceo broj elemenata niza N: ");
        int N = ulaz.nextInt();
        System.out.println("Unesite elemente niza a: ");
        int[] a;
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ulaz.nextInt();
        }
        System.out.println("Odaberite opciju za rad sa nizom: ");
        System.out.println("a) Aritmeticka sredina niza");
        System.out.println("b) Da li je uneti niz rastuci niz?");

        String input = ulaz.next();
        switch (input) {
            case "a":
                aritmetickaSredina(a, N);
                break;
            case "b":
                boolean rastuci = rastuciNiz(a, N);
                if (rastuci) {
                    System.out.println("Vas rezultat je: Niz rastuci");
                } else {
                    System.out.println("Vas rezultat je: Niz nije rastuci");
                }                
                break;
            default:
                System.out.println("Greska u unosu!");

        }
        ulaz.close();
    }

    private static void string() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite string: ");
        String S = ulaz.next();
        int brojac = 0, p = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                brojac++;
                p = 1;
            } else if (S.charAt(i) == ')') {
                brojac--;
                p = 1;
            }
        }
        if (p != 1) {
            System.out.println("Zagrade ne postoje");
        } else {
            if (brojac == 0) {
                System.out.println("Zagrade su uaprene");
            } else if (brojac > 0) {
                System.out.println("Nedosteje desna ) zagrada");
            } else {
                System.out.println("Nedostaje leva ( zagrada");
            }
        }
    }

    private static void matrica() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite dimenzije matrice N: ");
        int N = ulaz.nextInt();
        System.out.println("Unesite dimenzije matrice M: ");
        int M = ulaz.nextInt();
        int[][] A;
        A = new int[N][M];
        System.out.println("Unesite elmente matrice A");
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = ulaz.nextInt();
                if (i < j) {
                    sum += A[i][j];
                }
            }
        }
        System.out.println("Vas rezultat je " + sum);
    }

    private static void aritmetickaSredina(int[] a, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i];
        }
        double ArSredina = sum / N;
        System.out.println("Vas rezultat je: " + ArSredina);
    }

    private static boolean rastuciNiz(int[] a, int N) {
        boolean rastuci = false;
        for (int i = 0; i < N - 1; i++) {
            if (a[i] < a[i + 1]) {
                rastuci = true;
            } else {
                rastuci = false;
            }
        }
        return rastuci;
    }
}
