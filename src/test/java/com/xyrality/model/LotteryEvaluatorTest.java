package com.xyrality.model;

import com.xyrality.logic.LotteryEvaluator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * jUnit tests
 *
 * @author Oleksandr Skoryi
 */
public class LotteryEvaluatorTest {

    private LotteryEvaluator lotteryEvaluator;

    @Before
    public void setUp() throws Exception {
        lotteryEvaluator = LotteryEvaluator.getInstance("456000123");
    }

    @Test
    public void testEvaluatePlayer1() {
        List<String> list = new ArrayList<>(Arrays.asList("1122334455"));
        Player player = new Player("Carlson", "Cynthia", "Chile", list);
        assertEquals(3, lotteryEvaluator.evaluatePlayer(player));
    }

    @Test
    public void testEvaluatePlayer2() {
        List<String> list = new ArrayList<>(Arrays.asList("1234567890", "9988776650"));
        Player player = new Player("Alison", "Alice", "Austria", list);
        assertEquals(6, lotteryEvaluator.evaluatePlayer(player));
    }

    @Test
    public void testEvaluatePlayer3() {
        List<String> list = new ArrayList<>(Arrays.asList("0987654321"));
        Player player = new Player("Bert", "Bertram", "Belgium", list);
        assertEquals(2, lotteryEvaluator.evaluatePlayer(player));
    }

    @Test
    public void testEvaluatePlayer4() {
        List<String> list = new ArrayList<>(Arrays.asList("1111999911"));
        Player player = new Player("Carlson", "Cynthia", "China", list);
        assertEquals(1, lotteryEvaluator.evaluatePlayer(player));
    }

    @Test
    public void testEvaluatePlayer5() {
        List<String> list = new ArrayList<>(Arrays.asList("4680468023"));
        Player player = new Player("Daneson", "Dan Dilbert", "Denmark", list);
        assertEquals(6, lotteryEvaluator.evaluatePlayer(player));
    }

    @Test
    public void testEvaluatePlayer6() {
        List<String> list = new ArrayList<>(Arrays.asList("0000000000"));
        Player player = new Player("Dilbert Daneson", "Dan", "Denmark", list);
        assertEquals(3, lotteryEvaluator.evaluatePlayer(player));
    }

    @Test
    public void testEvaluatePlayer7() {
        List<String> list = new ArrayList<>(Arrays.asList("9988778899"));
        Player player = new Player("Eggbert", "Eric", "Estonia", list);
        assertEquals(0, lotteryEvaluator.evaluatePlayer(player));
    }
}
