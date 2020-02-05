package parser.markdownparser.atlassianparser.styledecorators;

import com.flipkart.rome.datatypes.response.common.enums.FontWeight;
import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import org.commonmark.node.Node;
import parser.markdownparser.atlassianparser.utils.AtlassianParsingVisitorUtils;

public class BoldStyleDecorator implements IAtlassianStyleDecorator {

    @Override
    public void decorate(Node node, TextStyle textStyle) {
        if (AtlassianParsingVisitorUtils.BOLD_IDENTIFIER.equals(node.toString())) {
            textStyle = populateBoldTextStyle(textStyle);
        }
    }

    private TextStyle populateBoldTextStyle(TextStyle textStyle) {
        if (textStyle == null) {
            textStyle = new TextStyle();
        }
        textStyle.setFontWeight(FontWeight.bold);
        return textStyle;
    }
}
