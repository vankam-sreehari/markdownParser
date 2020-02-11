package formatter;

import formatter.markdownformatter.AbstractMarkDownFormatter;
import formatter.markdownformatter.IFormatter;
import formatter.markdownformatter.RegexMarkDownFormatter;

import java.util.List;

public class FormatHelper {
    private IFormatter formatter;

    public List format(String irisValue, AbstractMarkDownFormatter abstractMarkDownFormatter) {
        formatter = new RegexMarkDownFormatter(abstractMarkDownFormatter);
        return formatter.format(irisValue);
    }
}
