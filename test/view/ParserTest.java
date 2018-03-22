package view;

import integration.CreditCardDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.YearMonth;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        parser = null;
    }

    @Test
    public void getCommandCorrectInput() throws IOException {
        String other = "next";
        boolean expectedResult = true;
        String input = "next";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        parser = new Parser();
        Command result = parser.getCommand();

        assertEquals("The input matches does not match NEXT", expectedResult, result.getCommandWord().toString().equals(other));
    }

    @Test
    public void getCommandWrongInput() throws IOException {
        String other = "next";
        boolean expectedResult = false;
        String input = "nextt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        parser = new Parser();
        Command result = parser.getCommand();

        assertEquals("The input matches matches NEXT", expectedResult, result.getCommandWord().toString().equals(other));
    }

    @Test
    public void getCommandUnknownInputTest() throws IOException {
        String other = "?";
        boolean expectedResult = true;
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        parser = new Parser();
        Command result = parser.getCommand();

        assertEquals("The input matches matches NEXT", expectedResult, result.getCommandWord().toString().equals(other));
    }

    @Test
    public void getCreditCardNumberTestCorrectInput() throws IOException {
        CreditCardDTO creditCardNumber = new CreditCardDTO(1234, "SKJG122344JIF", "Nino Prekratic" ,  YearMonth.parse("2020-12"), 174);
        boolean expectedResult = true;
        String input = "2\n" + "nweg\n" + "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        parser = new Parser();
        CreditCardDTO result = parser.getCreditCardNumber();

        assertEquals("The card holder doesn't match", expectedResult, result.getCardHolder().equals(creditCardNumber.getCardHolder()));
        assertEquals("The card pin doesn't match", expectedResult, result.getPin() == creditCardNumber.getPin());
        assertEquals("The card number doesn't match", expectedResult, result.getNumber().equals(creditCardNumber.getNumber()));
        assertEquals("The card date doesn't match", expectedResult, result.getExpiryDate().equals(creditCardNumber.getExpiryDate()));
        assertEquals("The card number doesn't match", expectedResult, result.getNumber().equals(creditCardNumber.getNumber()));
        assertEquals("The card CVC doesn't match", expectedResult, result.getCVC() == creditCardNumber.getCVC());
    }

    @Test
    public void getInspectionResultsCorrect() throws IOException {
        String other = "pass";
        boolean expectedResult = true;
        String input = "pass";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        parser = new Parser();
        String result = parser.inspectionResult();

        assertEquals("The result doesn't match", expectedResult, result.equals(other));
    }

    @Test
    public void getInspectionResultsIncorrect() throws IOException {
        String other = "fail";
        boolean expectedResult = false;
        String input = "pass";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        parser = new Parser();
        String result = parser.inspectionResult();
        assertEquals("The result doesn't match", expectedResult, result.equals(other));
    }


}