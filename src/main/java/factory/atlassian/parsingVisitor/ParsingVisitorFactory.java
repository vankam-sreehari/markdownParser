package factory.atlassian.parsingVisitor;

import parser.markdownparser.atlassianparser.parsingvisitor.AbstractParsingVisitor;
import parser.markdownparser.atlassianparser.parsingvisitor.AtlassianParsingVisitor;

public class ParsingVisitorFactory {
    public static AbstractParsingVisitor getParser(ParsingVisitorType parsingVisitorType) {
        switch (parsingVisitorType) {
            case ATLASSIAN:
                return new AtlassianParsingVisitor();
            default:
                return null;
        }
    }
}
