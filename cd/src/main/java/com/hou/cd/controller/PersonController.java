package com.hou.cd.controller;

import com.hou.cd.entity.Res;
import com.mongodb.client.*;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"5-用户管理"})
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/greeting")
    public Res<String> greeting() {
        return Res.success("Hello, I am cd-app from person");
    }


    public static void main(String[] args) {
//        MongoClient mongoClient = MongoClients.create();

//        MongoClient mongoClient = MongoClients.create(
//                MongoClientSettings.builder()
//                        .applyToClusterSettings(builder ->
//                                builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
//                        .build());


        MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        MongoDatabase database = mongoClient.getDatabase("houston");
        MongoCollection<Document> yang = database.getCollection("yang");

        final FindIterable<Document> documents = yang.find();

        System.out.println("query result");
        System.out.println("query result");
        System.out.println("query result");


        for (Document document : documents) {
            System.out.println("query result");
            System.out.println("query result");
            System.out.println("query result");
            System.out.println(document.toJson());
        }

    }


}
