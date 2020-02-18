package parser.markdownparser.regexparser.utils;


import models.Element;
import models.TextStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMarkDownParserUtils {

    public class Regex {
        public static final String BOLD_TEXT_REGEX = "\\*\\*(_[^*^_]+_|[^*^_]+)\\*\\*";
        public static final String ITALIC_TEXT_REGEX = "_(((\\*\\*)[^*]+(\\*\\*))+|[^*]+)_";
        private static final String NORMAL_TEXT_REGEX = "[^*^_]+";
        private static final String SPLIT_REGEX = BOLD_TEXT_REGEX + "|" + ITALIC_TEXT_REGEX + "|" + NORMAL_TEXT_REGEX;
    }

    public static class Patterns {
        private static final Pattern SPLIT_PATTERN = Pattern.compile(Regex.SPLIT_REGEX);
        public static final Pattern BOLD_PATTERN = Pattern.compile(Regex.BOLD_TEXT_REGEX);
        public static final Pattern ITALIC_PATTERN = Pattern.compile(Regex.ITALIC_TEXT_REGEX);
    }


    public static List<String> getLiterals(String input) {
        List<String> literals = new ArrayList<>();
        Matcher matcher = Patterns.SPLIT_PATTERN.matcher(input);
        while (matcher.find()) {
            literals.add(input.substring(matcher.start(), matcher.end()));
        }
        return literals;
    }

    public static void populateTextStyle(Map<String, Element> elementMap, String input, TextStyle textStyle) {
        if (input == null) {
            return;
        }
        String literal = input.replaceAll("[*_]+", "");
        if (!elementMap.containsKey(literal)) {
            elementMap.put(literal, new Element(literal));
        }

        Element element = elementMap.get(literal);

        if (element.getTextStyle() == null) {
            element.setTextStyle(new ArrayList<>(Collections.singleton(textStyle)));
        } else {
            element.getTextStyle().add(textStyle);
        }
    }


}

