package Utils;

import com.flipkart.rome.datatypes.response.common.leaf.value.ImageValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.TextStyle;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedImageData;
import com.flipkart.rome.datatypes.response.common.leaf.value.product.FormattedRichTextData;

public class FormattedMessageDataUtils {
    public static FormattedImageData getFormattedImageData(String imageUrl, String aspectRatio) {
        ImageValue imageValue = new ImageValue();
        imageValue.setDynamicImageUrl(imageUrl);
        imageValue.setAspectRatio(aspectRatio);
        FormattedImageData formattedImageData = new FormattedImageData();
        formattedImageData.setValue(imageValue);
        formattedImageData.setType(formattedImageData.getClass().getSimpleName());
        return formattedImageData;
    }

    public static FormattedRichTextData getFormattedRichTextData(String text, Integer textSize, TextStyle textStyle, String textColor) {
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText(text);
        richTextValue.setStyle(textStyle);
        richTextValue.setTextColor(textColor);
        richTextValue.setTextSize(textSize);
        FormattedRichTextData formattedRichTextData = new FormattedRichTextData();
        formattedRichTextData.setValue(richTextValue);
        formattedRichTextData.setType(formattedRichTextData.getClass().getSimpleName());
        return formattedRichTextData;
    }
}
