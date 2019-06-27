package cn.edu.nenu.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Exceptions Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-24 7:34
 */
public class Exceptions {

    public Exceptions() {
    }

    public static RuntimeException unchecked(Exception e) {
        return e instanceof RuntimeException ? (RuntimeException)e : new RuntimeException(e);
    }

    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
        for(Object cause = ex; cause != null; cause = ((Throwable)cause).getCause()) {
            Class[] var6 = causeExceptionClasses;
            int var5 = causeExceptionClasses.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                Class<? extends Exception> causeClass = var6[var4];
                if (causeClass.isInstance(cause)) {
                    return true;
                }
            }
        }

        return false;
    }
}
