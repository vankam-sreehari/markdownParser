package parser.markdownparser.regexparser.styledecorators;

import com.flipkart.rome.datatypes.response.common.enums.FontWeight;
import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import models.Element;
import parser.markdownparser.regexparser.utils.RegexParserUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoldStyleDecorator implements IRegexStyleDecorator {
    private static final Pattern PATTERN = Pattern.compile(RegexParserUtils.BOLD_TEXT_REGEX);

    @Override
    public void decorate(String irisValue, Map<String, Element> elementsMap) {
        Matcher matcher = PATTERN.matcher(irisValue);
        while (matcher.find()) {
            String literalWithNoise = irisValue.substring(matcher.start(), matcher.end());
            String literal = literalWithNoise.replaceAll("[*_]+", "");
            populateBoldTextStyle(elementsMap.get(literal));
        }
    }

    private void populateBoldTextStyle(Element element) {

        if (element == null) {
            return;
        }
        if (element.getTextStyle() == null) {
            element.setTextStyle(new TextStyle());
        }

        element.getTextStyle().setFontWeight(FontWeight.bold);
    }
}
