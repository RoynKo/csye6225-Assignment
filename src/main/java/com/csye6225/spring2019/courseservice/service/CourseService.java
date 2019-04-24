package com.csye6225.spring2019.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.sns.AmazonSNS;
import com.csye6225.spring2019.courseservice.model.Database;
import com.csye6225.spring2019.courseservice.model.CourseModel;
import com.csye6225.spring2019.courseservice.model.DynamoDBConnector;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.regions.Regions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseService {
    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public CourseService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public CourseModel delete(String id) {
        CourseModel cm = get(id);
        mapper.delete(cm, new DynamoDBDeleteExpression());
        return cm;
    }

    public CourseModel get(String id) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(id));

        DynamoDBQueryExpression<CourseModel> queryExpression = new DynamoDBQueryExpression<CourseModel>()
                .withIndexName("courseId-index")
                .withKeyConditionExpression("courseId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<CourseModel> list =  mapper.query(CourseModel.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<CourseModel> getAll(){
        return mapper.scan(CourseModel.class, new DynamoDBScanExpression());
    }

    public CourseModel add(CourseModel cm) {
        // create a new SNS client and set endpoint
        AmazonSNS snsClient = AmazonSNSClient.builder().withRegion(Regions.US_WEST_2).build();

        //create a new SNS topic
        CreateTopicRequest createTopicRequest = new CreateTopicRequest(cm.getCourseId());
        CreateTopicResult createTopicResult = snsClient.createTopic(createTopicRequest);

        cm.setTopic(createTopicResult.getTopicArn());
        mapper.save(cm);
        return cm;
    }

    public CourseModel update(CourseModel cm) {
        delete(cm.getCourseId());
        mapper.save(cm);
        return cm;
    }
}