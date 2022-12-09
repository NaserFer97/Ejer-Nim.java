package org.example;

import java.util.Scanner;

public class Nim {
    private int[] columnas;

    public Nim() {
        columnas = new int[3];
        columnas[0] = 1;
        columnas[1] = 2;
        columnas[2] = 3;
    }

    public void resta(int columna, int n) {
        columnas[columna-1] = columnas[columna-1] - n;
    }

    public boolean ganador() {
        return columnas[0] == 0 && columnas[1] == 0 && columnas[2] == 0;
    }

    public void imprimir() {
        System.out.println("\nColumna 1: " + columnas[0] + "\nColumna 2: " + columnas[1] + "\nColumna 3: " + columnas[2]);
    }

    public static void main(String[] args) {
        Nim game = new Nim();
        Scanner sc = new Scanner(System.in);
        int indice, numero, jugador = 2;
        do {
            if (jugador == 2){
                jugador = 1;
            }else {
                jugador = 2;
            }

            game.imprimir();
            do {
                System.out.print("\nJugador " + jugador + "\nIngrese la columna: ");
                indice = sc.nextInt();
                System.out.print("\nIngrese la cantidad de pilas: ");
                numero = sc.nextInt();
            }while (indice < 0 || indice > 3 || game.columnas[indice-1] < numero);
            game.resta(indice, numero);
        } while (!game.ganador());

        System.out.println("\nGANADOR JUGADOR NUMERO " + jugador);

        sc.close();
    }
}
