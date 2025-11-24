
package utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("EEMS_LOGGER");

    public static void init() {
        try {
            FileHandler fh = new FileHandler("logs/eems.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.info("Logger initialized.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
