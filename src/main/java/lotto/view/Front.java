package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

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

}
