package parser.markdownparser.regexparser;

import junit.framework.TestCase;
import models.Element;
import models.TextStyle;
import org.junit.Before;
import org.junit.Test;
import parser.markdownparser.IParser;

import java.util.List;

public class RegexMarkDownParserTest extends TestCase {

    private IParser parser;

    @Before
    public void setUp() {
        parser = new RegexMarkDownParser();
    }

    private void verifyNormalStyle(Element element, String expected) {

        assertEquals(expected, element.getLiteral());
        assertNull(element.getTextStyle());
    }

    private void verifyBoldStyle(Element element, String expected) {

        assertEquals(expected, element.getLiteral());
        assertNotNull(element.getTextStyle());
        assertTrue(element.getTextStyle().contains(TextStyle.BOLD));
    }

    private void verifyItalicStyle(Element element, String expected) {

        assertEquals(expected, element.getLiteral());
        assertNotNull(element.getTextStyle());
        assertTrue(element.getTextStyle().contains(TextStyle.ITALIC));
    }

    private void verifyBoldAndItalicStyle(Element element, String expected) {

        assertEquals(expected, element.getLiteral());
        assertNotNull(element.getTextStyle());
        assertTrue(element.getTextStyle().contains(TextStyle.BOLD));
        assertTrue(element.getTextStyle().contains(TextStyle.ITALIC));

    }

    private List<Element> buildElements(String input) {
        return parser.parse(input);
    }


    @Test
    public void testCase1() {
        String input = "*input*";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyNormalStyle(elements.get(0), "input");
    }

    @Test
    public void testCase2() {
        String input = "_input_";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyItalicStyle(elements.get(0), "input");
    }

    @Test
    public void testCase3() {
        String input = "**input**";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldStyle(elements.get(0), "input");
    }

    @Test
    public void testCase4() {
        String input = "_**input**_";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldAndItalicStyle(elements.get(0), "input");
    }

    @Test
    public void testCase5() {
        String input = "**_input_**";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldAndItalicStyle(elements.get(0), "input");
    }


    @Test
    public void testCase6() {
        String input = "*__input__*";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyItalicStyle(elements.get(0), "input");
    }

    @Test
    public void testCase7() {
        String input = "__*input*__";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyNormalStyle(elements.get(0), "input");
    }

    @Test
    public void testCase8() {
        String input = "**prefix**suffix";
        List<Element> elements = buildElements(input);
        assertEquals(2, elements.size());
        verifyBoldStyle(elements.get(0), "prefix");
        verifyNormalStyle(elements.get(1), "suffix");
    }

    @Test
    public void testCase9() {
        String input = "prefix**middle**suffix";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyNormalStyle(elements.get(0), "prefix");
        verifyBoldStyle(elements.get(1), "middle");
        verifyNormalStyle(elements.get(2), "suffix");
    }

    @Test
    public void testCase10() {
        String input = "prefix**suffix**";
        List<Element> elements = buildElements(input);
        assertEquals(2, elements.size());
        verifyNormalStyle(elements.get(0), "prefix");
        verifyBoldStyle(elements.get(1), "suffix");
    }

    @Test
    public void testCase11() {
        String input = "*_input_*";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyItalicStyle(elements.get(0), "input");
    }

    @Test
    public void testCase12() {
        String input = "_*input*_";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyNormalStyle(elements.get(0), "input");

    }

    @Test
    public void testCase13() {
        String input = "*_*input*_*";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyNormalStyle(elements.get(0), "input");
    }

    @Test
    public void testCase14() {
        String input = "_*_input*_*";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyNormalStyle(elements.get(0), "input");
    }

    @Test
    public void testCase15() {
        String input = "*_*input_*_";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyNormalStyle(elements.get(0), "input");
    }

    @Test
    public void testCase16() {
        String input = "**We have**_**bold and italic**_**in the middle of text**";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyBoldStyle(elements.get(0), "We have");
        verifyBoldAndItalicStyle(elements.get(1), "bold and italic");
        verifyBoldStyle(elements.get(2), "in the middle of text");
    }

    @Test
    public void testCase17() {
        String input = "**We have**_bold and italic_**in the middle of text**";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyBoldStyle(elements.get(0), "We have");
        verifyItalicStyle(elements.get(1), "bold and italic");
        verifyBoldStyle(elements.get(2), "in the middle of text");
    }

    @Test
    public void testCase18() {
        String input = "____input____";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyItalicStyle(elements.get(0), "input");
    }

    @Test
    public void testCase19() {
        String input = "****input****";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldStyle(elements.get(0), "input");
    }

    @Test
    public void testCase20() {
        String input = "**_input_***";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldAndItalicStyle(elements.get(0), "input");
    }

    @Test
    public void testCase21() {
        String input = "**_1n469PUT7868_***";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldAndItalicStyle(elements.get(0), "1n469PUT7868");
    }

    @Test
    public void testCase22() {
        String input = "**_1234ABCDdacb456_***";
        List<Element> elements = buildElements(input);
        assertEquals(1, elements.size());
        verifyBoldAndItalicStyle(elements.get(0), "1234ABCDdacb456");
    }

    @Test
    public void testCase23() {
        String input = "You have saved**₹10000**on your order";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyNormalStyle(elements.get(0), "You have saved");
        verifyBoldStyle(elements.get(1), "₹10000");
        verifyNormalStyle(elements.get(2), "on your order");
    }

    @Test
    public void testCase24(){
        String input = "_You have saved**₹10000**on your order_";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyItalicStyle(elements.get(0), "You have saved");
        verifyBoldAndItalicStyle(elements.get(1), "₹10000");
        verifyItalicStyle(elements.get(2), "on your order");
    }

    @Test
    public void testCase25(){
        String input = "**You have saved_₹10000_on your order**";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyBoldStyle(elements.get(0), "You have saved");
        verifyBoldAndItalicStyle(elements.get(1), "₹10000");
        verifyBoldStyle(elements.get(2), "on your order");
    }

    @Test
    public void testCase26(){
        String input = "**You have saved_*₹10000_on your order**";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyNormalStyle(elements.get(0), "You have saved");
        verifyNormalStyle(elements.get(1), "₹10000");
        verifyNormalStyle(elements.get(2), "on your order");
    }


    @Test
    public void testCase27(){
        String input = "आप इस आदेश पर**₹1000**बचाते हैं।";
        List<Element> elements = buildElements(input);
        assertEquals(3, elements.size());
        verifyNormalStyle(elements.get(0), "आप इस आदेश पर");
        verifyBoldStyle(elements.get(1), "₹1000");
        verifyNormalStyle(elements.get(2), "बचाते हैं।");
    }

}
