package org.alex4ndo5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner instance
        //Scanner scanner = new Scanner(System.in);
        // Getting path to file from user
        //System.out.println("Enter the path to Json file:");
        //String jsonPath = scanner.nextLine();

        boolean resource =  checkResource(Objects.requireNonNull(readJson("./src/main/resources/test1.json")));
        System.out.println(resource );
    }
    public static IAMRolePolicy readJson(String jsonPath){


        File jsonFile = new File(jsonPath);

        // ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonFile, IAMRolePolicy.class);
        } catch (JsonMappingException jsonMappingException){
            System.out.println("Error in mapping: " + jsonMappingException);
        } catch (JsonProcessingException jsonProcessingException){
            System.out.println("Error in processing: " + jsonProcessingException);
        } catch (IOException ioException){
            System.out.println("IO Exception: " + ioException);
        }
        return null;
    }
    public static boolean checkResource(IAMRolePolicy policy){
        ArrayList<Statement> statements = new ArrayList<>(policy.getPolicyDocument().getStatement());
        for (Statement statement : statements){
            if (statement.getResource().equals("*")){
                return false;
            }
        }
        return true;
    }
}