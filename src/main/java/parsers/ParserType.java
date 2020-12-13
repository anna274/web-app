package parsers;

import java.util.Arrays;

public enum ParserType {
    DOM(new DOMParserImpl()),
    SAX(new SAXParserImpl());

    private final Parser parser;

    ParserType(Parser parser) {
        this.parser = parser;
    }

    public Parser getParser() {
        return parser;
    }

    public static Parser getParserByName(String parserName) {
        return Arrays.stream(values())
                .filter(type -> type.name().equalsIgnoreCase(parserName))
                .findFirst()
                .orElse(SAX)
                .getParser();
    }
}
