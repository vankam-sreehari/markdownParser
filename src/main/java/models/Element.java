package models;


import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;

public class Element {
    String literal;
    TextStyle textStyle;

    public Element(String literal, TextStyle textStyle) {
        this.literal = literal;
        this.textStyle = textStyle;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }
}
