package vn.sapo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Iterator;

public class UpdateOne {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("stackjava");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("player");

        System.out.println("--Find All--");
        FindIterable<Document> iterable = mongoCollection.find();
        Iterator<Document> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        mongoCollection.updateOne(Filters.eq("name", "neymar"), Updates.set("age", 10));
        mongoCollection.updateMany(Filters.eq("country", "argentina"), Updates.set("age", 10));
        System.out.println("--Update success--");

        System.out.println("--Find All--");
        FindIterable<Document> iterable2 = mongoCollection.find();
        Iterator<Document> iterator2 = iterable2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        mongoClient.close();

    }
}
