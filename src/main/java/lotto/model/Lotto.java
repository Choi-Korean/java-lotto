package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException("[ERROR]: Invalid Input: 중복되지 않는 6개의 숫자를 입력입니다.");
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

}
