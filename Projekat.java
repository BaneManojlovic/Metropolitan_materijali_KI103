/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.projekat;

import java.util.Scanner;

/**
 *
 * @author manojlovic
 */
public class Projekat {

    private static Scanner sc = new Scanner(System.in);
    private static int[] a;
    private static int[][] b;
    private static int nMatrix, mMatrix;

    //method for checking string parenthesis
    public static boolean checkString() {
        System.out.println("Unesite prvi string sa otvorenom zagradom:");
        String first = sc.next();
        System.out.println("Unesite drugi string sa zatvorenom zagradom:");
        String second = sc.next();
        System.out.println("Prvi = " + first);
        System.out.println("Drugi = " + second);
        //definisem promenljive tipa string u kojima cu navesti zagrade koje trazim da uporedim 
        String parenthesisLeft = "(";
        String parenthesisRight = ")";
        //koristim ugradjenu metodu contains() koja treba da proveri da li imam zadatu sekvencu char-ova u stringu
        if (first.contains(parenthesisLeft) && second.contains(parenthesisRight)) {
            System.out.println("Rezutat je: " + true);
            return true;
        }
        System.out.println("Rezultat je: " + false);
        return false;
    }
    
    //method for summaring elements of matrix
     public static int sumElem(int[][] a) {
        int rez = 0;
        for (int i = 0; i < nMatrix; i++) {
            for (int j = 0; j < mMatrix; j++) {
                try {
                    //ovako se dobijaju elementi iznad glavne dijagonale
                    if (i < j) {
                        //ovako se dobija suma elemenata matrice po prethodno zadatom uslovu
                        rez += a[i][j];
                    }
                } catch (Exception ex) {
                    System.out.println("Pozeljno je da n bude jednako m, da bi bila matrica 3x3 ili 4x4!");
                }
            }
        }
        return rez;
    }

    //method for creating matrix
    public static void matrix() {
        System.out.println("Unesite dimenziju n:");
        nMatrix = sc.nextInt();
        System.out.println("Unesite dimenziju m:");
        mMatrix = sc.nextInt();
        //kreiram dvodimenzionalni niz, tj. matricu
        System.out.println("Unesite redom sve elemente matrice:");
        b = new int[nMatrix][mMatrix];
        for (int i = 0; i < nMatrix; i++) {
            for (int j = 0; j < mMatrix; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        //ispis matrice
        System.out.println("b = ");
        for (int i = 0; i < nMatrix; i++) {
            for (int j = 0; j < mMatrix; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        //izbor opcije
        System.out.println("Zelite li da odredite sumu elemenata iznad glavne dijagonale? [Y/N]");
        String response = sc.next();
        if(response.equals("y") || response.equals("Y")){
            System.out.println("DA");
            System.out.println("Suma elemenata iznad glavne dijagonale iznosi: " + sumElem(b));
        }else if(response.equals("n") || response.equals("N")){
            System.out.println("NO");
        }else{
            System.out.println("Error!");
        }
    }

    //method for checking is array increasing
    public static boolean arrayAscending(int[] a) {
        boolean result = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                //System.out.println("Niz je RASTUCI");
                result = true;
            } else if (a[i] > a[i + 1]) {
                //System.out.println("Niz je OPADAJUCI");
                result = false;
            }
            if (result != true) {
                return result;
            }
        }
        return result;
    }

    //method for calculating arithemtic middle of an array
    public static double arithmeticMiddle(int[] a) {
        double aritRez = 0;
        //prvo odredim sumu elemenata niza
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }
        //zatim izracunam aritmeticku sredinu niza
        aritRez = suma / a.length;
        return aritRez;
    }

    //method for creating Array of elements
    public static void arrayCreation() {
        System.out.println("Unesite velicinu niza: ");
        int n = sc.nextInt();
        //kreiranje niza i njegovo popunjavanje elementima
        a = new int[n];
        System.out.println("Unesite redom elemente niza: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //ispis niza
        System.out.print("Niz a = ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        //izbor opcije za zeljenu proveru nizova
        System.out.println("Odaberite opciju:");
        System.out.println("a. Aritmeticka sredina niza");
        System.out.println("b. Proveriti da li je uneti niz rastuci?");
        String choice;
        choice = sc.next();
        switch (choice) {
            case "a":
                System.out.println("Aritmeticka sredina niza iznosi: " + arithmeticMiddle(a));
                break;
            case "b":
                System.out.println("Niz je rastuci: " + arrayAscending(a));
                break;
            default:
                System.out.println("Uneli ste nepostojecu opcijum pokusajte ponovo!");
        }
    }

    //method for calculcating factoriel of a number
    public static int faktorijalBroja(int a) {
        int p = 1;
        for (int i = 1; i <= a; i++) {
            p = p * i;
        }
        return p;
    }

    //method for calculating binomial coeficient from n & k
    public static double calcBinomCoefic() {
        double rez = 0;
        System.out.println("Unesite broj n:");
        int n = sc.nextInt();
        System.out.println("Unesite broj k:");
        int k = sc.nextInt();
        System.out.println("Faktorijal broja n: " + faktorijalBroja(n));
        System.out.println("Faktorijal broja k: " + faktorijalBroja(k));
        int m = n - k;
        System.out.println("Faktorijel broja m:" + faktorijalBroja(m));
        if (k < 0) {
            rez = 0;
        } else if (k > n) {
            rez = 0;
        } else {
            rez = faktorijalBroja(n) / (faktorijalBroja(k) * faktorijalBroja(m));
        }
        return rez;
    }

    //method for calculating of expenential value of entered number
    public static double expMethod() {
        double rez = 0;
        System.out.println("Unesite broj koji zelite da dignete na exponencijalnu vrednost:");
        double a = sc.nextDouble();
        rez = Math.exp(a);
        return rez;
    }

    //method for performing ceil function
    public static double ceilMethod() {
        double rez = 0;
        System.out.println("Unesite broj koji zelite da zaokruzite na prvu gornju vrednost:");
        double a = sc.nextDouble();
        rez = Math.ceil(a);
        return rez;
    }

    //method for performing sqrt function
    public static double sqrtMethod() {
        double rez = 0;
        System.out.println("Unesite broj koji zelite da korenujete:");
        double a = sc.nextDouble();
        rez = Math.sqrt(a);
        return rez;
    }

    //showing meny for choosing math function
    public static void izborMatFunkc() {
        String matOp;
        System.out.println("Odaberite jednu od 3 matematičke operacije (sqrt, ceil, exp):");
        matOp = sc.next();  //<-- Za string u switch se koristi sc.next() umesti sc.nextLine() ZAPAMTI!!!
        switch (matOp) {
            case "sqrt":
                System.out.println("SQRT function");
                System.out.println("Rezultat je: " + sqrtMethod());
                break;
            case "ceil":
                System.out.println("CEIL function");
                System.out.println("Rezultat je: " + ceilMethod());
                break;
            case "exp":
                System.out.println("EXP");
                System.out.println("Rezultat je: " + expMethod());
                break;
            default:
                System.out.println("Odabrali ste nepostojecu matematicku funkciju!!!");
        }
    }

    //showing main meny of the app 
    public static void menyShow() {
        int x;
        System.out.println("Odaberite jednu od sledecih opcija:");
        System.out.println("1. MATEMATICKE FUNKCIJE");
        System.out.println("2. RAZNI ZADACI");
        System.out.println("3. UNOS I OBRADA NIZOVA");
        System.out.println("4. UNOS I OBRADA MATRICA");
        System.out.println("5. UNOS I OBRADA STRINGOVA");
        System.out.println("6. PREKID RADA");
        x = sc.nextInt();
        switch (x) {
            case 1:
                System.out.println("1. MATEMATICKE FUNKCIJE");
                izborMatFunkc();
                break;
            case 2:
                System.out.println("2. RAZNI ZADACI");
                calcBinomCoefic();
                break;
            case 3:
                System.out.println("3. UNOS I OBRADA NIZOVA");
                arrayCreation();
                break;
            case 4:
                System.out.println("4. UNOS I OBRADA MATRICA");
                matrix();
                break;
            case 5:
                System.out.println("5. UNOS I OBRADA STRINGOVA");
                checkString();
                break;
            case 6:
                System.out.println("Hvala Vam sto ste koristili nas program!!!");
                break;
            default:
                System.out.println("Izabrali ste nepostojcu opciju, pokusajte ponovo!");
        }
    }

    public static void main(String[] args) {
        menyShow();
    }
}
