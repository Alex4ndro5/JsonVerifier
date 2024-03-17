package org.alex4ndo5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String jsonPath = "./src/main/resources/asterisk.json";
        // Read the policy from Json file
        IAMRolePolicy policy = readJsonToObject(jsonPath);
        // Check if the policy is null
        if (policy != null) {
            // Check the policy's resource field
            boolean noAsterisk = checkResource(policy);
            System.out.println("JSON Resource field does not contain a single asterisk: " + noAsterisk);
        } else {
            System.out.println("Failed to read JSON file.");
        }
    }
    /**
     * Reads JSON file and maps its content to an IAMRolePolicy object.
     * @param jsonPath The path to the JSON file.
     * @return An IAMRolePolicy object representing the content of the JSON file, or null if an error occurs.
     */
    public static IAMRolePolicy readJsonToObject(String jsonPath){
        // Check if jsonPath is null
        if (jsonPath == null) {
            System.out.println("Error: JSON file path is null.");
            return null;
        }

        // Create a File object for the JSON file
        File jsonFile = new File(jsonPath);

        // ObjectMapper instance for JSON parsing
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON content and map it to IAMRolePolicy object
            return objectMapper.readValue(jsonFile, IAMRolePolicy.class);
        } catch (JsonMappingException e) {
            // Handle JSON mapping exception
            System.out.println("Error in mapping: " + e.getMessage());
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            System.out.println("Error in processing: " + e.getMessage());
        } catch (IOException e) {
            // Handle IO exception
            System.out.println("IO Exception: " + e.getMessage());
        }
        return null;
    }

    /**
     * Checks if JSON Resource field contains a single asterisk.
     * @param policy IAMRolePolicy object.
     * @return Logical false if an input JSON Resource field contains a single asterisk and true in any other case.
     */
    public static boolean checkResource(IAMRolePolicy policy){
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