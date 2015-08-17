package uk.co.agilekatas.katas.bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCardGenerator {

    private static final int OFFSET = 15;

    private Random random = new Random();

    public BingoCard generate() {
        List<List<String>> columns = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            columns.add(generateColumn(i));
        return new BingoCard(columns);
    }

    private List<String> generateColumn(int index) {
        List<String> column = new ArrayList<>();
        while (!isFull(column))
            addRandomNumber(column, index);
        if(isMiddleColumn(index))
            replaceCenterSquareWithFreeSpace(column);
        return column;
    }

    private void addRandomNumber(List<String> column, int index) {
        int min = (index * OFFSET) + 1;
        int max = (1 + index) * OFFSET;
        String number = String.valueOf(randomNumberBetween(min, max));
        if (!column.contains(number))
            column.add(number);
    }

    private boolean isFull(List<String> column) {
        return column.size() == 5;
    }

    private void replaceCenterSquareWithFreeSpace(List<String> column) {
        column.remove(2);
        column.add(2, "FREE");
    }

    private boolean isMiddleColumn(int index) {
        return index == 2;
    }

    private int randomNumberBetween(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
