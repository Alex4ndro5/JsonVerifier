package org.alex4ndo5;

public class Main {
    public static void main(String[] args) {
        String jsonPath = "./src/main/resources/empty.json";
        JsonVerifier jsonVerifier = new JsonVerifier();
        jsonVerifier.verifyJson(jsonPath);
    }
}