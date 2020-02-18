package parser.markdownparser.regexparser;

import factory.regex.styledecorator.RegexStyleDecoratorFactory;
import models.Element;
import parser.markdownparser.IParser;
import parser.markdownparser.regexparser.styledecorators.IRegexStyleDecorator;
import parser.markdownparser.regexparser.utils.RegexMarkDownParserUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Rules:
 * 1) Italic is represented by _text_
 * 2) Bold is represented by **text**
 * 3) Bold and Italic is represented by **_text_** as well as _**text**_
 * 4) If the text is enclosed by wrong pattern, closest formatting would be returned. For example *_text_* represents italic
 * 5) If the text is enclosed by wrong pattern and there is no closest formatting, then normal text is returned. _*text*_ represents normal
 */

public class RegexMarkDownParser implements IParser {
    private static final String FORMATTING_NOISE = "[*_]+";

    @Override
    public List<Element> parse(String irisValue) {
        return getElements(irisValue);
    }

    private List<Element> getElements(String irisValue) {
        List<String> messageUnits = RegexMarkDownParserUtils.getLiterals(irisValue);
        Map<String, Element> units = new HashMap<>();
        List<IRegexStyleDecorator> decorators = getStyleDecorators();
        decorators.forEach(decorator -> decorator.decorate(messageUnits, units));
        return messageUnits.stream()
                .map(v -> v.replaceAll(FORMATTING_NOISE, ""))
                .map(v -> getElement(units, v))
                .collect(Collectors.toList());
    }

    private Element getElement(Map<String, Element> units, String literal) {
        if (units.containsKey(literal)) {
            return units.get(literal);
        }
        return new Element(literal);
    }

    private List<IRegexStyleDecorator> getStyleDecorators() {
        return RegexStyleDecoratorFactory.getStyleDecorators();
    }
}
