package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        new DemoApplication().run(args);
    }

    public void run(String... args) {
        LOG.info("Hello, World!");
    }
}
