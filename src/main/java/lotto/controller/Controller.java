package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Winner;
import lotto.service.LottoService;
import lotto.view.Front;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    Front front = new Front();
    LottoService service = new LottoService();
    List<Lotto> userLottos;
    Winner winner;
    public void run(){
        int i = moneyToQuantity(front.buyLotto());
        userLottos = new ArrayList(i);
        while(i > 0){
            i -= 1;
            userLottos.add(new Lotto(service.makeLottoNums(6, 1, 45)));
        }
        front.printLottoBought(userLottos);
        winner = getWinner(front.enrollWinNum());
        System.out.println(winner);
    }

    public Integer moneyToQuantity(String input){
        try{
            if(Integer.parseInt(input) / 1000 > 0){
                return Integer.parseInt(input) / 1000;
            }
            throw new IllegalArgumentException("1000원 단위(1000원 이상)의 숫자를 입력해주세요.");
        }catch (Exception e){
            throw new IllegalArgumentException("1000원 단위의 숫자를 입력해주세요.");
        }
    }

    public Winner getWinner(List<String> enrollWinNum){
        try{
            return new Winner(Arrays.asList(enrollWinNum.get(0).split(","))
                    .stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList())
                    , Integer.parseInt(enrollWinNum.get(1)));
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR]: Invalid Input: 6개의 숫자와 1개의 보너스 숫자를 입력하세요.");
        }
    }
}
