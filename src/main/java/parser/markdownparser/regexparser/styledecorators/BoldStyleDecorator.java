package parser.markdownparser.regexparser.styledecorators;

import models.Element;
import models.TextStyle;
import parser.markdownparser.regexparser.utils.RegexMarkDownParserUtils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class BoldStyleDecorator implements IRegexStyleDecorator {

    @Override
    public void decorate(List<String> literals, Map<String, Element> elementsMap) {
        literals.stream()
                .filter(this::isBoldFormattingNeeded)
                .forEach(v -> RegexMarkDownParserUtils.populateTextStyle(elementsMap, v, TextStyle.BOLD));
    }

    private boolean isBoldFormattingNeeded(String input) {
        Matcher matcher = RegexMarkDownParserUtils.Patterns.BOLD_PATTERN.matcher(input);
        return matcher.find();
    }
}
