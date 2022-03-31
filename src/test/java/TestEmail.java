import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class TestEmail {
    @Test
    public void checkEmail() {
        Pattern pattern = Pattern.compile("([a-zA-Z-_0-9.]+@[a-zA-Z-_0-9]+\\.[a-z]{2,3})");
        Matcher matcher = pattern.matcher("elcll11@gmail.com");

        assertTrue(matcher.matches());
    }
}
