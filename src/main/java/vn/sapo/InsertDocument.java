package vn.sapo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class InsertDocument {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("demo1");
        MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection("player");

        Document document = new Document().append("id", 1).append("name", "ronaldo").append("country", "portugal").append("age", 33);
        documentMongoCollection.insertOne(document);

        System.out.println("--Inserted!--");
        mongoClient.close();

    }
}
