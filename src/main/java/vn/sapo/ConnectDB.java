package vn.sapo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnectDB {
    public static void main(String[] args) {

//        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://tuan:123456@localhost:27017/admin");
//        MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        System.out.println("--list database--");
        for (String t: mongoClient.listDatabaseNames()) {
            System.out.println(t);
        }

        System.out.println("--list collections--");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("demo");

        for (String t: mongoDatabase.listCollectionNames()) {
            System.out.println(t);
        }

        mongoClient.close();

    }
}
