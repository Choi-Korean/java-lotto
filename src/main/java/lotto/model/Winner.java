package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Winner {
    private final List<Integer> numbers;
    private final Integer bonus;

    public Winner(List<Integer> numbers, Integer bonus) {
        validate(numbers, bonus);
        Collections.sort(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers, Integer bonus) {
        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException("[ERROR]: Invalid Input: 중복되지 않는 6개의 숫자를 입력입니다.");
        }

        if(new HashSet<>(numbers).contains(bonus)){
            throw new IllegalArgumentException("[ERROR]: Invalid Input: 보너스 번호가 당첨번호와 중복될 수 없습니다.");
        }

    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
    public Integer getBonus(){
        return this.bonus;
    }

}
