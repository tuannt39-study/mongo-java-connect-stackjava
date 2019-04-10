package vn.sapo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class FindAll {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("stackjava");

        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("player");

        System.out.println("--All Player--");
        FindIterable<Document> iterable = mongoCollection.find();
        Iterator<Document> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("--Find Equal (=)--");
        FindIterable<Document> iterableEq = mongoCollection.find(Filters.eq("country", "brazil"));
        Iterator<Document> iteratorEq = iterableEq.iterator();
        while (iteratorEq.hasNext()) {
            System.out.println(iteratorEq.next());
        }

        mongoClient.close();

    }
}
