package com.ds;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ValidSoduku {

    public static void main(String[] args) {

    }

    public static boolean isValidSoduku(List<List<String>> board) {
        for (int i = 0; i < 9; i++) {
            HashSet<String> row_set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                String num = board.get(i).get(j);
                if (row_set.contains(num)) return false;
                else if (!Objects.equals(num, ".")) {
                    row_set.add(num);
                }
            }
        }

            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < 3; j++) {
                    String num = board.get(i).get(j);
                    if (set.contains(num)) return false;
                    else if (!Objects.equals(num, ".")) {
                        set.add(num);
                    }
                }
            }

        return true;
    }

}
