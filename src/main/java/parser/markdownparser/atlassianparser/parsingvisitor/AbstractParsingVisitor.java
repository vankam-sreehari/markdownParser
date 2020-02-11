package parser.markdownparser.atlassianparser.parsingvisitor;

import models.Element;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Text;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParsingVisitor extends AbstractVisitor {
    List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public void visit(Text text) {
        elements.add(new Element(text.getLiteral()));
        visitChildren(text);
    }
}
