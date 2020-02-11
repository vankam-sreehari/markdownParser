package test;

import com.flipkart.rome.datatypes.response.common.enums.FontStyle;
import com.flipkart.rome.datatypes.response.common.enums.FontWeight;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedMessageData;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedRichTextData;
import formatter.markdownformatter.AbstractMarkDownFormatter;

public class FormattedMessageDataFormatter extends AbstractMarkDownFormatter<FormattedMessageData> {

    @Override
    protected FormattedMessageData setLiteral(String unit) {
        FormattedMessageData formattedMessageData = new FormattedRichTextData();
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText(unit);
        formattedMessageData.setValue(richTextValue);
        return formattedMessageData;
    }

    @Override
    protected void applyBoldFormatting(FormattedMessageData obj) {
        RichTextValue richTextValue = (RichTextValue) obj.getValue();
        TextStyle textStyle = new TextStyle();
        textStyle.setFontWeight(FontWeight.bold);
        richTextValue.setStyle(textStyle);
    }

    @Override
    protected void applyItalicFormatting(FormattedMessageData obj) {
        RichTextValue richTextValue = (RichTextValue) obj.getValue();
        TextStyle textStyle = new TextStyle();
        textStyle.setFontStyle(FontStyle.italic);
        richTextValue.setStyle(textStyle);
    }
}
