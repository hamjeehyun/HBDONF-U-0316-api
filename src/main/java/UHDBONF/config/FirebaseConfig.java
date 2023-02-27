package UHDBONF.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseAuth getFirebaseAuth() throws IOException {
        FileInputStream serviceAccount =
//                new FileInputStream("src/main/resources/hbd-onf-firebase-adminsdk-7m49q-cd688bd5b0.json");
                new FileInputStream("/usr/local/tomcat9/apache-tomcat-9.0.59/webapps/hbd-onf-firebase-adminsdk-7m49q-cd688bd5b0.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
        return FirebaseAuth.getInstance(FirebaseApp.getInstance());
    }
}