package parser.markdownparser.regexparser.styledecorators;

import models.Element;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRegexStyleDecorator {
    void decorate(List<String> literals, Map<String, Element> elementsMap);
}
