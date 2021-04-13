package com.hou.cd;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MyTest {


    private static MongoCollection<Document> yangCollection = null;
    private static MongoDatabase database = null;


    static {
        MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        database = mongoClient.getDatabase("houston");
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        database = database.withCodecRegistry(pojoCodecRegistry);
        yangCollection = database.getCollection("yang");
    }




    public static void main(String[] args) {
//        testFind();
//        testInsert();
//        testFindFirst();

//        testInsertPojo();
//        testFindPojo();


        MongoCollection<Person> collection = database.getCollection("yang", Person.class);

//        collection.updateOne(eq("name", "Ada Byron"), combine(set("age", 23), set("name", "Ada Lovelace")));


        for (Person person : collection.find()) {
            System.out.println(person);
        }




    }

    public static void testFindPojo(){
        MongoCollection<Person> collection = database.getCollection("yang", Person.class);
        final Person person = collection.find().first();
        System.out.println(person.toString());
    }

    public static void testInsertPojo(){
        Person ada = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1"));
        MongoCollection<Person> collection = database.getCollection("yang", Person.class);
        collection.insertOne(ada);
    }

    public static void testFindFirst(){
        final Document document = yangCollection.find().first();
        System.out.println(document.toJson());
    }

    public static void testInsert(){
        final Document document = new Document("name", "houchunze").append("gender", "female");
        yangCollection.insertOne(document);
    }


    public static void testFind(){
        final FindIterable<Document> documents = yangCollection.find();
        for (Document document : documents) {
            System.out.println(document.toJson());
        }
    }






}
