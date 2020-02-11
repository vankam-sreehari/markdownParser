package parser.markdownparser.regexparser;

import factory.regex.styledecorator.RegexStyleDecoratorFactory;
import models.Element;
import parser.markdownparser.IParser;
import parser.markdownparser.regexparser.styledecorators.IRegexStyleDecorator;

import java.util.Arrays;
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
    private static final String SPLIT_DELIMITER = "[*_]+";

    @Override
    public List<Element> parse(String irisValue) {
        List<Element> elements = getElemets(irisValue);
        return elements;
    }


    private List<Element> getElemets(String irisValue) {
        String[] messageUnits = irisValue.split(SPLIT_DELIMITER);
        List<String> literals = Arrays.stream(messageUnits)
                .filter(v -> v.length() > 0)
                .collect(Collectors.toList());
        Map<String, Element> units = literals.stream()
                .collect(Collectors.toMap(v -> v, v -> new Element(v)));
        List<IRegexStyleDecorator> decorators = getStyleDecorators();
        decorators.forEach(decorator -> decorator.decorate(irisValue, units));
        return literals.stream()
                .map(units::get)
                .collect(Collectors.toList());
    }

    private List<IRegexStyleDecorator> getStyleDecorators() {
        return RegexStyleDecoratorFactory.getStyleDecorators();
    }
}