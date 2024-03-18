package org.alex4ndro5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        if (args.length != 1) {
            logger.error("Usage: java -jar JsonVerifier.jar <fileName>");
            System.exit(1);
        }

        String jsonPath = "./src/main/resources/" + args[0];
        JsonVerifier jsonVerifier = new JsonVerifier();
        jsonVerifier.verifyJson(jsonPath);
    }
}