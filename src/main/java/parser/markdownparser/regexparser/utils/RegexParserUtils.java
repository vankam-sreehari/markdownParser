package parser.markdownparser.regexparser.utils;


public class RegexParserUtils {
    public static final String BOLD_TEXT_REGEX = "\\*\\*([A-Z]|[a-z]|[0-9]|_| |\\x{20B9})+\\*\\*";
    public static final String ITALIC_TEXT_REGEX = "_([A-Z]|[a-z]|[0-9]|(\\*\\*)| |\\x{20B9})+_";

}
