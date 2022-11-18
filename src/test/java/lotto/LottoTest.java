package lotto;

import lotto.controller.Controller;
import lotto.model.Lotto;
import lotto.model.Winner;
import lotto.model.WinnerStatus;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByunderSize() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨로또 번호, 보너스 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void createWinnerByDuplicatedNumber1() {
        assertThatThrownBy(() -> new Winner(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨로또 번호, 보너스 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void createWinnerByDuplicatedNumber2() {
        assertThatThrownBy(() -> new Winner(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨로또 번호, 보너스 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerByString1() {
        assertThatThrownBy(() -> new Controller().getWinner(new ArrayList<>(Arrays.asList("1,2,3,a,4,5", "7"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨로또 번호, 보너스 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerByString2() {
        assertThatThrownBy(() -> new Controller().getWinner(new ArrayList<>(Arrays.asList("1,2,3,7,4,5", "b"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("enum class WinnerStatus 생성 테스트")
    @Test
    void createWinnerStatus() {
        WinnerStatus ws = WinnerStatus._3rd;
        ws.setAmount(2);
        assertThat(ws.getPrice()).isEqualTo(1500000);
    }

    @DisplayName("당첨현황체크 메서드 기능 테스트")
    @Test
    void doCheckWinnerStatus() {
        LottoService ls = new LottoService();
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
        Winner winner = new Winner(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(ls.checkWinnerStatus(lottos, winner).get("6").getAmount()).isEqualTo(1);
    }

}
