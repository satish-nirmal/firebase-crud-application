package com.java.firebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class CRUDRunner {

	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = CRUDRunner.class.getClassLoader();

		File file = new File(classLoader.getResource("serviceAccountKey.json").getFile());

		// Import From FireBase..

		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://fir-tutorial-db-c1c03-default-rtdb.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(CRUDRunner.class, args);
	}

}
