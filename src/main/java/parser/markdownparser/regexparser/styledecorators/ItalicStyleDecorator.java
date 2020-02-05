package parser.markdownparser.regexparser.styledecorators;

import com.flipkart.rome.datatypes.response.common.enums.FontStyle;
import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import models.Element;
import parser.markdownparser.regexparser.utils.RegexParserUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItalicStyleDecorator implements IRegexStyleDecorator {
    @Override
    public void decorate(String irisValue, Map<String, Element> elementsMap) {
        Pattern pattern = Pattern.compile(RegexParserUtils.ITALIC_TEXT_REGEX);
        Matcher matcher = pattern.matcher(irisValue);
        while (matcher.find()) {
            String literalWithNoise = irisValue.substring(matcher.start(), matcher.end());
            String literal = literalWithNoise.replaceAll("[*_]+", "");
            populateItalicTextStyle(elementsMap.get(literal));
        }
    }

    private void populateItalicTextStyle(Element element) {
        if (element == null) {
            return;
        }
        if (element.getTextStyle() == null) {
            element.setTextStyle(new TextStyle());
        }
        element.getTextStyle().setFontStyle(FontStyle.italic);
    }
}
