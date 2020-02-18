package parser.markdownparser.regexparser.styledecorators;

import models.Element;
import models.TextStyle;
import parser.markdownparser.regexparser.utils.RegexMarkDownParserUtils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItalicStyleDecorator implements IRegexStyleDecorator {

    @Override
    public void decorate(List<String> literals, Map<String, Element> elementsMap) {
        literals.stream()
                .filter(this::isItalicFormattingNeeded)
                .forEach(v -> RegexMarkDownParserUtils.populateTextStyle(elementsMap, v, TextStyle.ITALIC));
    }

    private boolean isItalicFormattingNeeded(String input) {
        Matcher matcher = RegexMarkDownParserUtils.Patterns.ITALIC_PATTERN.matcher(input);
        return matcher.find();
    }
}
