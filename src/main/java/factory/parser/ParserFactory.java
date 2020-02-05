package factory.parser;

import parser.markdownparser.atlassianparser.AtlassianParser;
import parser.markdownparser.IParser;
import parser.markdownparser.regexparser.RegexParser;

public class ParserFactory {

    public static IParser getParser(ParserType parserType) {
        switch (parserType) {
            case ATLASSIAN:
                return new AtlassianParser();
            case REGEX:
                return new RegexParser();
            default:
                return null;
        }
    }
}
