package com.xyrality.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xyrality.service.LotteryEvaluatorService;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * jUnit tests
 *
 * @author Oleksandr Skoryi
 */
public class LotteryEvaluatorTest {

    private LotteryEvaluatorService lotteryEvaluator;

    @BeforeEach
    public void setUp() {
        lotteryEvaluator = LotteryEvaluatorService.getInstance("456000123");
    }

    @ParameterizedTest
    @MethodSource("provideTestSuites")
    public void testEvaluatePlayer(final String[] lotteryCombinations, final int expectedResult) {
        var player = new Player(
            "LastName",
            "FirstName",
            "Country",
            lotteryCombinations
        );
        assertEquals(expectedResult, lotteryEvaluator.evaluatePlayer(player));
    }

    private static Stream<Arguments> provideTestSuites() {
        return Stream.of(
            Arguments.of(new String[]{"1122334455"}, 3),
            Arguments.of(new String[]{"1234567890", "9988776650"}, 6),
            Arguments.of(new String[]{"0987654321"}, 2),
            Arguments.of(new String[]{"1111999911"}, 1),
            Arguments.of(new String[]{"4680468023"}, 6),
            Arguments.of(new String[]{"0000000000"}, 3),
            Arguments.of(new String[]{"9988778899"}, 0)
        );
    }
}
