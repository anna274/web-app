package parsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTypeTest {
    @Test
    void getSaxParserByName() {
        Class<?> excepted = SAXParserImpl.class;
        Parser parser = ParserType.getParserByName("sax");
        Class<?> actual = parser.getClass();
        assertEquals(excepted, actual);
    }

    @Test
    void getDomParserByName() {
        Class<?> excepted = DOMParserImpl.class;
        Parser parser = ParserType.getParserByName("dom");
        Class<?> actual = parser.getClass();
        assertEquals(excepted, actual);
    }

    @Test
    void getParserByNameNegativeTest() {
        Class<?> excepted = SAXParserImpl.class;
        Parser parser = ParserType.getParserByName("abcd");
        Class<?> actual = parser.getClass();
        assertEquals(excepted, actual);
    }
}