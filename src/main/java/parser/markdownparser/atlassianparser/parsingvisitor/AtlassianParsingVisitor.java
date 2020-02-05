package parser.markdownparser.atlassianparser.parsingvisitor;


import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import factory.atlassian.styledecorator.AtlassianStyleDecoratorFactory;
import models.Element;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import parser.markdownparser.atlassianparser.utils.AtlassianParsingVisitorUtils;
import parser.markdownparser.atlassianparser.styledecorators.IAtlassianStyleDecorator;

import java.util.List;

public class AtlassianParsingVisitor extends AbstractParsingVisitor {

    private static final List<IAtlassianStyleDecorator> decorators = AtlassianStyleDecoratorFactory.getStyleDecorators();

    @Override
    public void visit(Text text) {
        TextStyle textStyle = populateTextStyle(text);
        elements.add(new Element(text.getLiteral(), textStyle));
        visitChildren(text);
    }

    private TextStyle populateTextStyle(Node node) {
        if(doesElementNeedFormatting(node)){

        }
        TextStyle textStyle = new TextStyle();
        while (node.getParent() != null) {
            Node parentNode = node.getParent();
            for(IAtlassianStyleDecorator decorator : decorators){
                decorator.decorate(parentNode,textStyle);
            }
            node = parentNode;
        }
        return textStyle;
    }

    private boolean doesElementNeedFormatting(Node node) {
        return AtlassianParsingVisitorUtils.NORMAL_IDENTIFIER.equals(node.toString());
    }

}
