package com.csye6225.spring2019.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.sns.AmazonSNS;
import com.csye6225.spring2019.courseservice.model.DynamoDBConnector;
import com.csye6225.spring2019.courseservice.model.StudentModel;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.csye6225.spring2019.courseservice.model.CourseModel;
import java.util.HashMap;
import java.util.List;

public class StudentService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public StudentService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public StudentModel delete(String id) {
        StudentModel sm = get(id);
        mapper.delete(sm, new DynamoDBDeleteExpression());
        return sm;
    }

    public StudentModel get(String id) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(id));

        DynamoDBQueryExpression<StudentModel> queryExpression = new DynamoDBQueryExpression<StudentModel>()
                .withIndexName("studentId-index")
                .withKeyConditionExpression("studentId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<StudentModel> list =  mapper.query(StudentModel.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<StudentModel> getAll(){
        return mapper.scan(StudentModel.class, new DynamoDBScanExpression());
    }

    public StudentModel add(StudentModel sm) {
        mapper.save(sm);
        return sm;
    }

    public StudentModel update(StudentModel sm) {
        delete(sm.getStudentId());
        mapper.save(sm);
        return sm;
    }

    public void register(String studentId, String courseId) {
        //return if registered courses no less than 3
        if (this.get(studentId).getRegisteredCourses().size() >= 3){
            return;
        }

        CourseService cs = new CourseService();
        CourseModel courseModel = cs.get(courseId);
        StudentModel studentModel = get(studentId);

        //create a new SNS client and set endpoint
        AmazonSNS snsClient = AmazonSNSClient.builder().withRegion("us-west-1").build();
        String topicArn = courseModel.getTopic();

        SubscribeRequest subRequest = new SubscribeRequest(topicArn, "email", studentModel.getEmailAddress());
        snsClient.subscribe(subRequest);
    }

}