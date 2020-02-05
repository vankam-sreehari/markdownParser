package formatter.markdownformatter;

import Utils.FormattedMessageDataUtils;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedMessageData;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedMessageValue;
import factory.parser.ParserFactory;
import factory.parser.ParserType;
import models.Element;
import org.commonmark.node.Node;
import parser.markdownparser.IParser;

import java.util.List;
import java.util.stream.Collectors;

public class IrisMarkDownFormatter {

    public static FormattedMessageValue getFormattedMessageValueFromString(String irisValue) {
        List<Element> elements = getElements(irisValue);
        FormattedMessageValue formattedMessageValue = new FormattedMessageValue();
        List<FormattedMessageData> formattedMessageDataList = elements.stream()
                .map(e -> FormattedMessageDataUtils.getFormattedRichTextData(e.getLiteral(), null, e.getTextStyle(), null))
                .collect(Collectors.toList());
        formattedMessageValue.setData(formattedMessageDataList);
        return formattedMessageValue;
    }


    private static List<Element> getElements(String irisValue) {
        IParser parser = getParser();
        return parser.parse(irisValue);
    }

    private static IParser getParser() {
        return ParserFactory.getParser(ParserType.REGEX);
    }


}
