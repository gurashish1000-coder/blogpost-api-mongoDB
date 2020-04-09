package ca.utoronto.utm.mcs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.sun.net.httpserver.HttpServer;

import javax.inject.Inject;


public class App
{
    static int port = 8080;

    private static HttpServer server;
    private static MongoClient db;

    public static void main(String[] args) throws IOException
    {

    		Dagger service = DaggerDaggerComponent.create().buildMongoHttp();

            //server context here
            server = service.getServer();
            db = service.getDb();

            // Created the Database
        	MongoDatabase database =  db.getDatabase("sample");
        	
        	// Created the collection
        	if(database.getCollection("posts") == null)
                database.createCollection("posts");
        	
        	server.createContext("/api/v1/post", new Post(db));
        	service.getServer().start();

            System.out.printf("Server started on port %d", port);
        
    }
}