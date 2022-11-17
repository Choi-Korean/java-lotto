package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoService {

    public List<Integer> makeLottoNums(final int NUM_LEN, final int MIN_NUM, final int MAX_NUM){
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_LEN);

    }
}
