package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.Front;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    Front front = new Front();
    LottoService service = new LottoService();
    List<Lotto> userLottos;
    public void run(){
        int i = inputToQuantity(front.buyLotto());
        userLottos = new ArrayList(i);
        while(i > 0){
            i -= 1;
            userLottos.add(new Lotto(service.makeLottoNums(6, 1, 45)));
        }
        front.printLottoBought(userLottos);
    }

    public Integer inputToQuantity(String input){
        try{
            if(Integer.parseInt(input) / 1000 > 0){
                return Integer.parseInt(input) / 1000;
            }
            throw new IllegalArgumentException("1000원 단위(1000원 이상)의 숫자를 입력해주세요.");
        }catch (Exception e){
            throw new IllegalArgumentException("1000원 단위의 숫자를 입력해주세요.");
        }
    }
}
