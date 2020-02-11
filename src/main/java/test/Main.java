package test;

import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedMessageData;
import formatter.FormatHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FormatHelper formatManager = new FormatHelper();
        FormattedMessageDataFormatter formattedMessageDataFormatter = new FormattedMessageDataFormatter();
        List<FormattedMessageData> formattedMessageDataList = formatManager.format("I am a**bad**boy",formattedMessageDataFormatter);
        formattedMessageDataList.stream().map(v -> (RichTextValue)v.getValue()).forEach(v -> System.out.println(v.getText()));
    }
}
