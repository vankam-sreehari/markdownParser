package parser.markdownparser.atlassianparser.styledecorators;

import com.flipkart.rome.datatypes.response.common.enums.FontStyle;
import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import org.commonmark.node.Node;
import parser.markdownparser.atlassianparser.utils.AtlassianParsingVisitorUtils;

public class ItalicStyleDecorator implements IAtlassianStyleDecorator {
    @Override
    public void decorate(Node node, TextStyle textStyle) {
        if (AtlassianParsingVisitorUtils.ITALIC_IDENTIFIER.equals(node.toString())) {
            textStyle = populateItalicTextStyle(textStyle);
        }
    }

    private TextStyle populateItalicTextStyle(TextStyle textStyle) {
        if (textStyle == null) {
            textStyle = new TextStyle();
        }
        textStyle.setFontStyle(FontStyle.italic);
        return textStyle;
    }
}
