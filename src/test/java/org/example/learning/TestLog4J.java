package org.example.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4J {
    public static Logger logger= LogManager.getLogger(TestLog4J.class);
    static int age=23;

    public static void main(String[] args) {
        logger.info("testing");
        logger.info("age of {} person", age);
        logger.debug("hello");
        logger.error("yes");
        logger.warn("warning");

    }

}
