package factory.atlassian.styledecorator;

import parser.markdownparser.atlassianparser.styledecorators.BoldStyleDecorator;
import parser.markdownparser.atlassianparser.styledecorators.IAtlassianStyleDecorator;
import parser.markdownparser.atlassianparser.styledecorators.ItalicStyleDecorator;

import java.util.Arrays;
import java.util.List;

public class AtlassianStyleDecoratorFactory {
    public static List<IAtlassianStyleDecorator> getStyleDecorators() {
        return Arrays.asList(
                new BoldStyleDecorator(),
                new ItalicStyleDecorator());
    }
}
