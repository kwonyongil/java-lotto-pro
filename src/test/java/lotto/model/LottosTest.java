package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.generator.InputLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("로또들 InputGenerator 생성 이후 로또들 사이즈 테스트")
    @Test
    void lottosInputSize() {
        TestLottosFactory testLottosFactory = new TestLottosFactory(new InputLottoNumberGenerator("1,2,3,4,5,6"));
        Lottos lottos = testLottosFactory.generate();
        assertThat(lottos.readOnlyLottos()).hasSize(1);
    }

    @DisplayName("로또들 Random 구매 이후 로또들 사이즈 테스트")
    @Test
    void lottosRandomSize() {
        Lottos lottos = Lottos.buy(Money.valueOf(3333));
        assertThat(lottos.readOnlyLottos()).hasSize(3);
    }

    @DisplayName("로또들은 구입할 때 사용한 총 금액을 반환")
    @Test
    void lottosTotalPrice() {
        Lottos lottos = Lottos.buy(Money.valueOf(3333));
        assertThat(lottos.totalPrice()).isEqualTo(Money.valueOf(3000));
    }
}
