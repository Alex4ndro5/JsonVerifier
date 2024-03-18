package org.alex4ndro5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.alex4ndro5.DTOs.IAMRolePolicy;
import org.alex4ndro5.DTOs.Statement;
import org.alex4ndro5.Exceptions.EmptyFileException;
import org.alex4ndro5.Exceptions.NoFileException;
import org.alex4ndro5.Exceptions.WrongFileTypeException;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;


public class JsonVerifier {
    private final Logger logger = LogManager.getLogger(JsonVerifier.class);
    /**
     * Logs info about single asterisk occurrence in provided IAM::Role Policy JSON file.
     * @param jsonPath The path to the JSON file containing the IAM role policy.
     */
    public void verifyJson(String jsonPath){
        // Read the policy from Json file
        IAMRolePolicy policy = readJsonToObject(jsonPath);
        // Check the policy's resource field
        boolean noAsterisk = checkResource(policy);
        if (noAsterisk){
            logger.info("JSON Resource field does NOT contain a single asterisk.");
        } else {
            logger.info("JSON Resource field does contain a single asterisk.");
        }
    }
    /**
     * Reads JSON file and maps its content to an IAMRolePolicy object.
     * @param jsonPath The path to the JSON file.
     * @return An IAMRolePolicy object representing the content of the JSON file, or null if an error occurs.
     */
    public IAMRolePolicy readJsonToObject(String jsonPath)  {
        // Check if jsonPath is null
        if (jsonPath == null) {
            throw new IllegalArgumentException("JSON file path is null.");
        }
        // Check if file is not a json
        if (!FilenameUtils.getExtension(jsonPath).equals("json")){
            throw new WrongFileTypeException("Provided file is not JSON.");
        }

        // Create a File object for the JSON file
        File jsonFile = new File(jsonPath);

        // Check if file exists
        if (!jsonFile.exists()){
            throw new NoFileException("JSON file not found.");
        }
        // Check if file is empty
        if (jsonFile.length() == 0){
            throw new EmptyFileException("JSON file is empty.");
        }

        // ObjectMapper instance for JSON parsing
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON content and map it to IAMRolePolicy object
            return objectMapper.readValue(jsonFile, IAMRolePolicy.class);
        } catch (Exception e) {
            // Handle exception
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Checks if JSON Resource field contains a single asterisk.
     * @param policy IAMRolePolicy object.
     * @return Logical false if an input JSON Resource field contains a single asterisk and true in any other case.
     */
    public boolean checkResource(IAMRolePolicy policy){
        // Check if jsonPath is null
        if (policy == null) {
            throw new IllegalArgumentException("IAMRolePolicy policy is null.");
        }
        // Create an arraylist of statements
        ArrayList<Statement> statements = new ArrayList<>(policy.getPolicyDocument().getStatement());
        // Iterate over all statements
        for (Statement statement : statements){
            // Check if resource field contains single asterisk
            if (statement.getResource().equals("*")){
                return false;
            }
        }
        return true;
    }
}
