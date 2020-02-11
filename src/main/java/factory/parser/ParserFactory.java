package factory.parser;

import parser.markdownparser.atlassianparser.AtlassianParser;
import parser.markdownparser.IParser;
import parser.markdownparser.regexparser.RegexMarkDownParser;

public class ParserFactory {

    public static IParser getParser(ParserType parserType) {
        switch (parserType) {
            case ATLASSIAN:
                return new AtlassianParser();
            case REGEX:
                return new RegexMarkDownParser();
            default:
                return null;
        }
    }
}
