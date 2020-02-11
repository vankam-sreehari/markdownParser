package parser.markdownparser.regexparser.styledecorators;

import models.Element;
import models.TextStyle;
import parser.markdownparser.regexparser.utils.RegexMarkDownParserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItalicStyleDecorator implements IRegexStyleDecorator {
    private static final Pattern PATTERN = Pattern.compile(RegexMarkDownParserUtils.ITALIC_TEXT_REGEX);

    @Override
    public void decorate(String irisValue, Map<String, Element> elementsMap) {
        Matcher matcher = PATTERN.matcher(irisValue);
        while (matcher.find()) {
            String literalWithNoise = irisValue.substring(matcher.start(), matcher.end());
            String[] literal = literalWithNoise.split("[*_]+");
            Arrays.stream(literal).filter(elementsMap::containsKey).forEach(v -> populateItalicTextStyle(elementsMap.get(v)));
        }
    }

    private void populateItalicTextStyle(Element element) {
        if (element == null) {
            return;
        }
        if (element.getTextStyle() == null) {
            element.setTextStyle(new ArrayList<>(Collections.singleton(TextStyle.ITALIC)));
        } else {
            element.getTextStyle().add(TextStyle.ITALIC);
        }
    }
}
