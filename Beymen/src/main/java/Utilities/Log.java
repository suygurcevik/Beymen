package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import java.util.List;




public class Log {

    public static final Logger LOGGER = LogManager.getLogger(Log.class);

    public static void pass(String message) {
        LOGGER.info(message);

    }

    public static void pass(float message) {
        LOGGER.info(message);

    }
    public static void assertfailWithLogging(String message) {
        LOGGER.error(message);
        Assert.fail();
    }
    public static void pass(int message) {
        LOGGER.info(message);
    }

    public static void pass(List<String> message) {
        LOGGER.info(message);
    }

    public static void fail(String message) {
        LOGGER.error(message);
    }

    public static void warning(String message) {
        LOGGER.warn(message);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }
}
