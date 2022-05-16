package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.Set;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputLottoNumberGeneratorTest {
    static final Set<LottoNumber> lottoNumbers = initLottoNumbers();

    static Set<LottoNumber> initLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(LottoNumber.valueOf(2));
        lottoNumbers.add(LottoNumber.valueOf(4));
        lottoNumbers.add(LottoNumber.valueOf(5));
        lottoNumbers.add(LottoNumber.valueOf(7));
        lottoNumbers.add(LottoNumber.valueOf(9));
        lottoNumbers.add(LottoNumber.valueOf(30));
        return lottoNumbers;
    }

    @DisplayName("입력받은 문자열을 콤마(,)로 구분하여 trim 한 값으로 Integer List 를 생성한다.")
    @Test
    void inputLottoNumberGenerator() {
        InputLottoNumberGenerator inputLottoNumberGenerator = new InputLottoNumberGenerator(" 2, 4 ,5 ,  7  ,9,30");
        Set<LottoNumber> lottoNumbers = inputLottoNumberGenerator.generate();
        assertAll(
                () -> assertThat(lottoNumbers).hasSize(6),
                () -> assertThat(lottoNumbers).isEqualTo(InputLottoNumberGeneratorTest.lottoNumbers)
        );
    }

    @DisplayName("숫자 변환에 유효하지 않은 문자열에 대해 IllegalArgumentException 테스트")
    @ParameterizedTest(name = "숫자 변환에 유효하지 않은 문자열{0}에 대해 IllegalArgumentException 테스트")
    @ValueSource(strings = {"1 ,p,0", "1. 1, 2", ",#", "3,,3"})
    void inputLottoNumberGeneratorInValidate(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputLottoNumberGenerator(input))
                .withMessage("유효하지 않은 입력값입니다.");
    }
}
