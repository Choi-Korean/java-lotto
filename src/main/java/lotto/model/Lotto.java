package lotto.model;

import lotto.controller.Controller;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
//        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException(Controller.ERROR_MESSAGE + " Invalid Input: 중복되지 않는 6개의 숫자를 입력입니다.");
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

}
