package parser.markdownparser.atlassianparser;

import factory.atlassian.parsingVisitor.ParsingVisitorFactory;
import factory.atlassian.parsingVisitor.ParsingVisitorType;
import models.Element;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import parser.markdownparser.IParser;
import parser.markdownparser.atlassianparser.parsingvisitor.AbstractParsingVisitor;


import java.util.List;

public class AtlassianParser implements IParser {

    public List<Element> parse(String irisValue) {
        Parser parser = Parser.builder().build();
        Node node = parser.parse(irisValue);
        AbstractParsingVisitor parsingVisitor = getParsingVisitor();
        node.accept(parsingVisitor);
        return parsingVisitor.getElements();
    }


    private static AbstractParsingVisitor getParsingVisitor() {
        return ParsingVisitorFactory.getParser(ParsingVisitorType.ATLASSIAN);
    }
}

