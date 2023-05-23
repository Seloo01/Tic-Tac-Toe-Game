package com.company;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] alan = new char[3][3];
        for (int row = 0; row < alan.length; row++) {
            for (int col = 0; col < alan[row].length; col++) {
                alan[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean isGameOver = false;

        while (!isGameOver) {
            try {
                alanCiz(alan);
                System.out.print("Oyuncu " + player + " giriş yap: ");
                int sira = scanner.nextInt();
                int sutun = scanner.nextInt();
                if ((sira & sutun) < 3) {
                    if (alan[sira][sutun] == ' ') {
                        alan[sira][sutun] = player;
                        if (isGameOver) {
                            System.out.println("Oyuncu " + player + " Kazandı: ");
                        } else {
                            player = (player == 'X') ? 'O' : 'X';
                        }
                    } else {
                        System.out.println("Zaten bu kısım dolu?");
                    }
                    if (kazanmaKontrol(alan, player)) {
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isGameOver = false;
                break;
            }
            System.out.println();
        }
    }

    public static void alanCiz(char[][] alan) {
        for (int row = 0; row < alan.length; row++) {
            for (int col = 0; col < alan[row].length; col++) {
                System.out.print(alan[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static void sonAlanCiz(char[][] alan) {
        for (int row = 0; row < alan.length; row++) {
            for (int col = 0; col < alan[row].length; col++) {
                System.out.print(alan[row][col] + " -|- ");
            }
            System.out.println();
        }
        System.out.println("Tebrikler! Oyunu bitirdiniz!");
    }

    public static boolean kazanmaKontrol(char[][] alan, char player) {
        if (alan[0][0] == 'X' && alan[0][1] == 'O' && alan[0][2] == 'X') {
            sonAlanCiz(alan);
            System.exit(0);
            return true;
        } else if (alan[1][0] == 'X' && alan[1][1] == 'O' && alan[1][2] == 'X') {
            sonAlanCiz(alan);
            System.exit(0);
            return true;
        } else if (alan[2][0] == 'X' && alan[2][1] == 'O' && alan[2][2] == 'X') {
            sonAlanCiz(alan);
            System.exit(0);
            return true;
        } else if (alan[0][0] == 'X' && alan[1][0] == 'O' && alan[2][0] == 'X') {
            sonAlanCiz(alan);
            System.exit(0);
            return true;
        } else if (alan[0][1] == 'X' && alan[1][1] == 'O' && alan[2][1] == 'X') {
            sonAlanCiz(alan);
            System.exit(0);
            return true;
        } else if (alan[0][2] == 'X' && alan[1][2] == 'O' && alan[2][2] == 'X') {
            sonAlanCiz(alan);
            System.exit(0);
            return true;
        }
        return false;
    }
}
