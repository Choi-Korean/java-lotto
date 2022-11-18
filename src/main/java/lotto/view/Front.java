package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.WinnerStatus;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Front {

    public String buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        System.out.println();
        return Console.readLine();
    }

    public void printLottoBought(List<Lotto> lottos){
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for(Lotto l:lottos){
            System.out.println(String.join(",", l.getNumbers().toString()));
        }
        System.out.println();
    }

    public List<String> enrollWinNum(){
        List<String> input = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        input.add(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        input.add(Console.readLine());
        return input;
    }

    public void printWinnerStatus(HashMap<String, WinnerStatus> ws, int bought){
        WinnerStatus status;
        String label;
        String prize;
        int total = 0;
        int amount;
        for(String k:ws.keySet()){
            status = ws.get(k);
            label = status.getLabel();
            prize = NumberFormat.getInstance().format(status.getPrice());
            total += status.getTotal();
            amount = status.getAmount();

            System.out.printf("%s 일치 (%s원) - %d개%n", label, prize, amount);
        }
        System.out.println("총 수익률은 " + String.format("%.1f",(double) total / (double) bought * 100.0) +  "%입니다.");
    }


}
