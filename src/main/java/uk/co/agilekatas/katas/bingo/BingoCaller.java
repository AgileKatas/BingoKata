package uk.co.agilekatas.katas.bingo;

import java.util.Collections;
import java.util.Stack;

public class BingoCaller {

    private Stack<Integer> numbers;

    public BingoCaller() {
        numbers = new Stack<>();
        for (int i = 1; i <= 75; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
    }

    public int call() {
        return numbers.pop();
    }

}
