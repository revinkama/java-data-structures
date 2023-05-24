package com.amigoscode;

import java.util.Random;

public class ConwaysGameOfLife {

    private int width;
    private int height;
    private boolean[][] cells;
    private boolean[][] nextCells;
    private Random random;

    public ConwaysGameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new boolean[height][width];
        this.nextCells = new boolean[height][width];
        this.random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = random.nextBoolean();
            }
        }
    }

    public void update() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int count = countNeighbors(i, j);
                if (cells[i][j]) {
                    if (count == 2 || count == 3) {
                        nextCells[i][j] = true;
                    } else {
                        nextCells[i][j] = false;
                    }
                } else {
                    if (count == 3) {
                        nextCells[i][j] = true;
                    } else {
                        nextCells[i][j] = false;
                    }
                }
            }
        }
        cells = nextCells;
        nextCells = new boolean[height][width];
    }

    private int countNeighbors(int i, int j) {
        int count = 0;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ni = i + di;
                int nj = j + dj;
                if (ni >= 0 && ni < height && nj >= 0 && nj < width && !(di == 0 && dj == 0)) {
                    if (cells[ni][nj]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j]) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ConwaysGameOfLife game = new ConwaysGameOfLife(50, 30);
        for (int i = 0; i < 100; i++) {
            game.print();
            game.update();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}
