package de.idealo.junit.rules.samples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import de.idealo.junit.rules.TestLoggerRuleFactory;

public class LogLevelPerLoggerTest {

    private final Logger log1 = LoggerFactory.getLogger("test1");
    private final Logger log2 = LoggerFactory.getLogger("test2");

    @Rule
    public TestRule testLogger = TestLoggerRuleFactory
            .withLevel("test1", Level.ERROR)
            .silence("test2")
            .build();

    @Test
    public void test(){
        //this will be visible
        log1.error("really important log message for test");
        // this will be swallowed
        log2.error("not important log message for test");
    }
}