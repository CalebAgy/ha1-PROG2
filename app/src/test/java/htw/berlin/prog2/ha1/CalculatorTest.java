package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should display result after subtracting two negative multi-digit numbers")
    void testNegativeAddition() {
        Calculator calc = new Calculator();


        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();
        calc.pressEqualsKey();

        String expected = "-20";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display the right answer when dividing two decimals")
    void divisionOfTwoDecimal() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();


        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("squared root of decimal")
    void squaredRootOfDecimal() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "0.447";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display a positiv decimal with two digits after comma")
    void shouldDisplayEnoughDigits() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "5.05";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



}

