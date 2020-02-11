package parser.markdownparser.regexparser.utils;


public class RegexMarkDownParserUtils {
    public static final String BOLD_TEXT_REGEX = "\\*\\*[^*]+\\*\\*";//"\\*\\*([A-Z]|[a-z]|[0-9]|_| |\\x{20B9})+\\*\\*";
    public static final String ITALIC_TEXT_REGEX ="_[^*]*((\\*\\*)+[^*]*)*_"; //"_([A-Z]|[a-z]|[0-9]|(\\*\\*)| |\\x{20B9})+_";
}
