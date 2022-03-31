import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class TestPhoneNumber {
    @Test
    public void checkNumber() {
        Pattern pattern = Pattern.compile("(\\+\\d{3}\\(\\d{2}\\)\\d{3}\\-\\d{2}\\-\\d{2})");
        Matcher matcher = pattern.matcher("+375(33)643-41-86");

        assertTrue(matcher.matches());
    }

}
