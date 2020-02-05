package formatter;

import com.flipkart.rome.datatypes.response.common.enums.FontStyle;
import com.flipkart.rome.datatypes.response.common.enums.FontWeight;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedMessageData;
import formatter.markdownformatter.IrisMarkDownFormatter;
import junit.framework.TestCase;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IrisMarkDownFormatterTest extends TestCase {

    private void verifyNormalStyle(FormattedMessageData formattedMessageData, String expected) {
        RichTextValue richTextValue = (RichTextValue) formattedMessageData.getValue();
        assertEquals(expected, richTextValue.getText());
        assertNull(richTextValue.getStyle());
    }

    private void verifyBoldStyle(FormattedMessageData formattedMessageData, String expected) {
        RichTextValue richTextValue = (RichTextValue) formattedMessageData.getValue();
        assertEquals(expected, richTextValue.getText());
        assertNotNull(richTextValue.getStyle());
        assertNull(richTextValue.getStyle().getFontStyle());
        assertEquals(FontWeight.bold, richTextValue.getStyle().getFontWeight());
    }

    private void verifyItalicStyle(FormattedMessageData formattedMessageData, String expected) {
        RichTextValue richTextValue = (RichTextValue) formattedMessageData.getValue();
        assertEquals(expected, richTextValue.getText());
        assertNotNull(richTextValue.getStyle());
        assertNull(richTextValue.getStyle().getFontWeight());
        assertEquals(FontStyle.italic, richTextValue.getStyle().getFontStyle());
    }

    private void verifyBoldAndItalicStyle(FormattedMessageData formattedMessageData, String expected) {
        RichTextValue richTextValue = (RichTextValue) formattedMessageData.getValue();
        assertEquals(expected, richTextValue.getText());
        assertNotNull(richTextValue.getStyle());
        assertEquals(FontStyle.italic, richTextValue.getStyle().getFontStyle());
        assertNotNull(richTextValue.getStyle());
        assertEquals(FontWeight.bold, richTextValue.getStyle().getFontWeight());
    }

    private List<FormattedMessageData> buildFormattedMessageData(String input) {
        return IrisMarkDownFormatter.getFormattedMessageValueFromString(input).getData();
    }

    @Test
    public void testCase1() {
        String input = "*input*";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase2() {
        String input = "_input_";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase3() {
        String input = "**input**";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyBoldStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase4() {
        String input = "_**input**_";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyBoldAndItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase5() {
        String input = "**_input_**";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyBoldAndItalicStyle(formattedMessageDataList.get(0), "input");
    }


    @Test
    public void testCase6() {
        String input = "*__input__*";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyBoldAndItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase7() {
        String input = "__*input*__";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyBoldAndItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase8() {
        String input = "**prefix**suffix";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(2, formattedMessageDataList.size());
        verifyBoldStyle(formattedMessageDataList.get(0), "prefix");
        verifyNormalStyle(formattedMessageDataList.get(1), "suffix");
    }

    @Test
    public void testCase9() {
        String input = "prefix**middle**suffix";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(3, formattedMessageDataList.size());
        verifyNormalStyle(formattedMessageDataList.get(0), "prefix");
        verifyBoldStyle(formattedMessageDataList.get(1), "middle");
        verifyNormalStyle(formattedMessageDataList.get(2), "suffix");
    }

    @Test
    public void testCase10() {
        String input = "prefix**suffix**";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(2, formattedMessageDataList.size());
        verifyNormalStyle(formattedMessageDataList.get(0), "prefix");
        verifyBoldStyle(formattedMessageDataList.get(1), "suffix");
    }

    @Test
    public void testCase11() {
        String input = "*_input_*";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase12() {
        String input = "_*input*_";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "input");

    }

    @Test
    public void testCase13() {
        String input = "*_*input*_*";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(1, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "input");
    }

    @Test
    public void testCase14() {
        String input = "_*_input*_*";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(2, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "_input");
        verifyNormalStyle(formattedMessageDataList.get(1), "*");
    }

    @Test
    public void testCase15() {
        String input = "*_*input_*_";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(2, formattedMessageDataList.size());
        verifyItalicStyle(formattedMessageDataList.get(0), "*input");
        verifyNormalStyle(formattedMessageDataList.get(1), "_");
    }

    @Test
    public void testCase16() {
        String input = "**We have**_**bold and italic**_**in the middle of text**";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(3, formattedMessageDataList.size());
        verifyBoldStyle(formattedMessageDataList.get(0), "We have");
        verifyBoldAndItalicStyle(formattedMessageDataList.get(1), "bold and italic");
        verifyBoldStyle(formattedMessageDataList.get(2), "in the middle of text");
    }

    @Test
    public void testCase17() {
        String input = "**We have**_bold and italic_**in the middle of text**";
        List<FormattedMessageData> formattedMessageDataList = buildFormattedMessageData(input);
        assertEquals(3, formattedMessageDataList.size());
        verifyBoldStyle(formattedMessageDataList.get(0), "We have");
        verifyItalicStyle(formattedMessageDataList.get(1), "bold and italic");
        verifyBoldStyle(formattedMessageDataList.get(2), "in the middle of text");
    }
}
