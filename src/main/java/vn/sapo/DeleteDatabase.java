package vn.sapo;

import com.mongodb.MongoClient;

public class DeleteDatabase {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        mongoClient.dropDatabase("demo");
        System.out.println("--drop database success--");
        mongoClient.close();
    }
}
