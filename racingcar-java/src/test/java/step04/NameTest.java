package step04;

import misson04.domain.Name;
import misson04.exception.NamingEmptyOrNullException;
import misson04.exception.NamingSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("올바른 양식의 이름들이 들어왔을 때 - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"박종찬", "진영", "최김우재", "윙"})
    void isCorrectName(String eachName) {
        Name name = new Name(eachName);

        assertThat(name.getName()).isEqualTo(eachName);
    }

    @DisplayName("들어온 이름 중, 5글자 이상의 이름이 있을 때 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"배가너무고프다", "하기가싫다", "포트폴리온언제고치냐"})
    void nameLengthISTooMuch(String eachName) {
        assertThatThrownBy(() -> new Name(eachName))
                .isInstanceOf(NamingSizeException.class)
                .hasMessage("이름이 5글자가 넘습니다.");
    }

    @Test
    @DisplayName("들어온 이름 중, null 값일때 - 실패")
    void namePatternHasNull() {
        String name = null;

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(NamingEmptyOrNullException.class)
                .hasMessage("이름이 비어있습니다.");
    }

    @Test
    @DisplayName("들어온 이름 중, 공백만 있을 때 - 실패")
    void namePatternHasEmpty() {
        String name = "";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(NamingEmptyOrNullException.class)
                .hasMessage("이름이 비어있습니다.");
    }
}
