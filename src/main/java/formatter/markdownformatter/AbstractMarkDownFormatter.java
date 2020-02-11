package formatter.markdownformatter;

import models.Element;
import models.TextStyle;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMarkDownFormatter<T> {

    List<T> prepareResponse(List<Element> elements) {
        List<T> tList = new ArrayList<>();
        elements.forEach(e -> prepareList(e, tList));
        return tList;
    }

    private void prepareList(Element element, List<T> tList) {
        T t = setLiteral(element.getLiteral());
        if (element.getTextStyle() != null) {
            element.getTextStyle().forEach(s -> applyStyle(s, t));
        }
        tList.add(t);
    }

    private void applyStyle(TextStyle style, T t) {
        switch (style) {
            case ITALIC:
                applyItalicFormatting(t);
                break;
            case BOLD:
                applyBoldFormatting(t);
                break;
            default:
                break;
        }
    }

    protected abstract T setLiteral(String unit);

    protected abstract void applyBoldFormatting(T t);

    protected abstract void applyItalicFormatting(T t);
}
