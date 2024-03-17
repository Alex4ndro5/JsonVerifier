package org.alex4ndo5;

import org.alex4ndo5.DTOs.IAMRolePolicy;
import org.alex4ndo5.DTOs.PolicyDocument;
import org.alex4ndo5.DTOs.Statement;
import org.alex4ndo5.Exceptions.EmptyFileException;
import org.alex4ndo5.Exceptions.NoFileException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class JsonVerifierTest {
    private JsonVerifier jsonVerifier;
    @Before
    public void setUp(){
        jsonVerifier = new JsonVerifier();
    }
    @Test(expected = IllegalArgumentException.class)
    public void readJsonToObjectThrowsErrorWhenPathIsNull(){
        jsonVerifier.readJsonToObject(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkResourceThrowsErrorWhenPathIsNull(){
        jsonVerifier.checkResource(null);
    }
    @Test
    public void checkResourceReturnsFalseWhenResourceContainsSingleAsterisk(){
        IAMRolePolicy policy = new IAMRolePolicy();
        PolicyDocument policyDocument = new PolicyDocument();
        Statement statement1 = new Statement();
        ArrayList<Statement> statements = new ArrayList<>();
        statement1.setResource("*");
        statements.add(statement1);
        policyDocument.setStatement(statements);
        policy.setPolicyDocument(policyDocument);

        Assert.assertFalse(jsonVerifier.checkResource(policy));
    }
    @Test
    public void checkResourceReturnsTrueWhenResourceDoesNotContainSingleAsterisk(){
        IAMRolePolicy policy = new IAMRolePolicy();
        PolicyDocument policyDocument = new PolicyDocument();
        Statement statement1 = new Statement();
        ArrayList<Statement> statements = new ArrayList<>();
        statement1.setResource(" ");
        statements.add(statement1);
        policyDocument.setStatement(statements);
        policy.setPolicyDocument(policyDocument);

        Assert.assertTrue(jsonVerifier.checkResource(policy));
    }
    @Test(expected = EmptyFileException.class)
    public void readJsonToObjectThrowsEmptyFileExceptionWhenFileIsEmpty(){
        String jsonPath = "./src/main/resources/empty.json";
        jsonVerifier.readJsonToObject(jsonPath);
    }
    @Test(expected = NoFileException.class)
    public void readJsonToObjectThrowsNoFileExceptionWhenFileDoesNotExist(){
        String jsonPath = "./src/main/resources/nonSuchFile.json";
        jsonVerifier.readJsonToObject(jsonPath);
    }
}