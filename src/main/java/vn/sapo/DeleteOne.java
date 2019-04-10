package vn.sapo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class DeleteOne {
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

        mongoCollection.deleteOne(Filters.eq("name", "neymar"));
        mongoCollection.deleteMany(Filters.eq("country", "argentina"));
        System.out.println("--Delete success--");

        System.out.println("--Find All--");
        FindIterable<Document> iterable2 = mongoCollection.find();
        Iterator<Document> iterator2 = iterable2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        mongoClient.close();

    }
}
