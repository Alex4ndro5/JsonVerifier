package org.alex4ndo5;

import org.junit.Before;
import org.junit.Test;

public class JsonVerifierTest {
    private JsonVerifier jsonVerifier;
    @Before
    public void setUp(){
        jsonVerifier = new JsonVerifier();
    }
    @Test(expected = IllegalArgumentException.class)
    public void readObjectToJsonThrowsErrorWhenPathIsNull(){
        jsonVerifier.readJsonToObject(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkResourceThrowsErrorWhenPathIsNull(){
        jsonVerifier.checkResource(null);
    }
}