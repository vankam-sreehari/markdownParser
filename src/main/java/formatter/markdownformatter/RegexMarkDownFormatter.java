package formatter.markdownformatter;

import factory.parser.ParserFactory;
import factory.parser.ParserType;
import models.Element;
import parser.markdownparser.IParser;

import java.util.List;

public class RegexMarkDownFormatter implements IFormatter {
    AbstractMarkDownFormatter abstractMarkDownFormatter;

    public RegexMarkDownFormatter(AbstractMarkDownFormatter abstractMarkDownFormatter) {
        this.abstractMarkDownFormatter = abstractMarkDownFormatter;
    }

    @Override
    public List format(String input) {
        List<Element> elements = getElements(input);
        return abstractMarkDownFormatter.prepareResponse(elements);
    }

    private List<Element> getElements(String irisValue) {
        IParser parser = getParser();
        return parser.parse(irisValue);
    }

    private IParser getParser() {
        return ParserFactory.getParser(ParserType.REGEX);
    }

}
