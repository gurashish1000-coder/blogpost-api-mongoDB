package ca.utoronto.utm.mcs;

import java.io.IOException;
import java.util.Arrays;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

import dagger.Module;
import dagger.Provides;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Module
public class DaggerModule {

	private static HttpServer server;
	private static MongoClient db;
	
    @Provides public MongoClient provideMongoClient() {
        /* TODO: Fill in this function */
    	db = MongoClients.create();
    	return db;
    }

    @Provides public HttpServer provideHttpServer() {
        /* TODO: Fill in this function */
    	try {
            server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return server;
    }
}
