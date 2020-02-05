package parser.markdownparser;

import models.Element;

import java.util.List;

public interface IParser {
    List<Element> parse(String irisValue);
}
