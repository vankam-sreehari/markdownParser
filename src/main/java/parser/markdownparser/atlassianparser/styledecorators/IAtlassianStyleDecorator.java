package parser.markdownparser.atlassianparser.styledecorators;

import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import org.commonmark.node.Node;

public interface IAtlassianStyleDecorator {
    void decorate(Node node, TextStyle textStyle);
}
