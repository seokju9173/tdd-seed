package misson01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @Test
    @DisplayName("요구사항01-1 - \"1,2\" 분리 성공")
    void 문자열_1과_2를_split_했을때_제대로_분리되었는지_확인한다(){

        // given
        final String input = "1,2";

        // when
        final String[] output = input.split(",");

        // then
        assertThat(output).contains("1","2");
        assertThat(output).containsExactly("1","2");
        assertThat(output).hasSize(2);
    }

    @Test
    @DisplayName("요구사항01-2 - \"1\"만 포함한 배열 반환 성공")
    void 문자열_1을_split_했을때_1만을_포함하는_배열이_반환되는지_확인한다(){

        // given
        final String input = "1";

        // when
        final String[] output = input.split(",");

        // then
        assertThat(output).containsExactly("1");
        assertThat(output).hasSize(1);
    }

    @Test
    @DisplayName("요구사항02 - substring()으로 대괄호 삭제 성공")
    void 숫자를_포함한_문자열이_주어졌을때_대괄호를_제거하고_숫자만_반환한다(){

        // given
        final String input = "(1,2)";
        final int leftBracketIdx = 1;
        final int rightBracketIdx = input.length()-1;

        // when
        final String output = input.substring(leftBracketIdx,rightBracketIdx);

        // then
        assertThat(output).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({"0, a","1, b","2, c"})
    @DisplayName("요구사항03 - charAt()으로 문자 가져오기 성공")
    void 알파벳_문자열이_주어졌을때_charAt을_통해서_특정위치의_문자를_가져온다(int number, char alpha){

        // given
        final String alphaString = "abc";

        // when
        assertThatThrownBy(() ->{
            alphaString.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        // then
        assertThat(alphaString).hasSize(3);
        assertThat(alphaString.charAt(number)).isEqualTo(alpha);
    }
}

/**
 * 질문 1. 적절한 final 위치
 * 질문 2. 하나의 내장함수를 테스트를 원할 때, 다른 내장함수 사용 여부
 * 질문 3. 요구사항 3번에 ThrownBy를 통해 체크해야 하는 것
 */