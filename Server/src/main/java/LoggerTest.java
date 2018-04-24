import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {
    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.info("test1");
        logger.debug("test2");
        logger.error("test3");
        logger.warn("test4");
        logger.fatal("test5");
    }
}
