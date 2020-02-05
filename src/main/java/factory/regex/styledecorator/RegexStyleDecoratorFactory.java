package factory.regex.styledecorator;

import parser.markdownparser.regexparser.styledecorators.BoldStyleDecorator;
import parser.markdownparser.regexparser.styledecorators.IRegexStyleDecorator;
import parser.markdownparser.regexparser.styledecorators.ItalicStyleDecorator;

import java.util.Arrays;
import java.util.List;

public class RegexStyleDecoratorFactory {

    public static List<IRegexStyleDecorator> getStyleDecorators(){
        return Arrays.asList(new BoldStyleDecorator(), new ItalicStyleDecorator());
    }
}
