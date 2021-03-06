package com.csye6225.spring2019.courseservice.model;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBConnector {

    static AmazonDynamoDB dynamoDb ;

    public static void init() {
        if (dynamoDb == null) {

            dynamoDb = AmazonDynamoDBClientBuilder
                    .standard()
                    .withRegion(Regions.US_WEST_2)
                    .build();
            System.out.println("I created the client");
        }

    }

    public AmazonDynamoDB getClient() {
        return dynamoDb;
    }

}