package F12.newsfeedproject.global.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTracePrinter {

    public static String getPrintStackTrace(Exception e) {

        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));

        return errors.toString();
    }
}
