package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Winner;
import lotto.model.WinnerStatus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_LEN = 6;
    HashMap<String, WinnerStatus> ws = new HashMap<String,WinnerStatus>(){{
        put("3", WinnerStatus._5th);
        put("4", WinnerStatus._4th);
        put("5", WinnerStatus._3rd);
        put("5+b", WinnerStatus._2nd);
        put("6", WinnerStatus._1st);
    }};

    public List<Integer> makeLottoNums(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_LEN);

    }

    public HashMap<String, WinnerStatus> checkWinnerStatus(List<Lotto> userLottos, Winner winner){
        Set<Integer> lottoNums;
        for(Lotto l:userLottos){
            lottoNums = new HashSet<>(l.getNumbers());
            lottoNums.retainAll(winner.getNumbers());
            if(lottoNums.size() < 3){
                continue;
            }
            if(lottoNums.size() != 5){
                ws.get(String.valueOf(lottoNums.size())).setAmount(ws.get(String.valueOf(lottoNums.size())).getAmount() + 1);
                continue;
            }
            if(new HashSet<>(lottoNums).contains(winner.getBonus())){
                ws.get("5+b").setAmount(ws.get("5+b").getAmount() + 1);
                continue;
            }
            ws.get("5").setAmount(ws.get("5").getAmount() + 1);
        }
        return ws;
    }
}
