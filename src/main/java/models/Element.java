package models;

import java.util.List;

public class Element {
    String literal;
    List<TextStyle> textStyle;

    public Element(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public List<TextStyle> getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(List<TextStyle> textStyle) {
        this.textStyle = textStyle;
    }
}
