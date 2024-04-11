package seaBattle;

/*
2. На поле размером nxm размещены корабли (2 трехпалубных, 3 двухпалубных, 4 однопалубных)
        [[0,0,0,1,1,0],
         [0,1,0,0,0,0],
         [0,1,0,1,0,0],
         [0,1,0,1,0,0]];

При ходе [2, 1] программа выдает число 3, т.к. подбит трехпалубный корабль
При ходе [1, 3] программа выдает число 0 (промах) и т.д.
Изменить условие так, чтобы каждый из кораблей мог "отразить" одну атаку,
выдав 0 при первом попадании в него.
Разработать алгоритм, который подобьет все корабли если не за минимальное,
то за некоторое удовлетворительное число ходов.

public class SeaBattle {
    public static void main(String[] args) {

    }
}
 */


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainTest {
    public static int[][] table;

    public static void main(String[] args) {
        Random random = new Random();
        int count = 0;


        table = getTable(table);

        for (int[] anArr : table) {
            for (int anAnArr : anArr) {
                System.out.print(anAnArr + " ");
            }
            System.out.println();
        }

        System.out.println("-----------");


        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                int cols = random.nextInt(10);
                int rows = random.nextInt(10);
                if (table[cols][rows] == 0) {
                    System.out.println("Missed!");
                    count++;
                }
                if (table[cols][rows] == 1) {
                    System.out.println("Ship has dodged the attack!");
                    cols = i + 1;
                    if (table[cols][rows] == 1)
                        table[i][j]++;
                    count++;
                }
                if (table[cols][rows] == 2) {
                    System.out.println("Ship has been destroyed!");
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int[][] getTable(int[][] table) {
        int max = 2;

        Random random = new Random();

        table = new int[10][10];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = random.nextInt(max);
            }
        }
        return table;
    }
}


