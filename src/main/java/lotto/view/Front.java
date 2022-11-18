package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Front {

    public String buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void printLottoBought(List<Lotto> lottos){
        for(Lotto l:lottos){
            System.out.println(String.join(",", l.getNumbers().toString()));
        }
    }

    public List<String> enrollWinNum(){
        List<String> input = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        input.add(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        input.add(Console.readLine());
        return input;
    }


}
