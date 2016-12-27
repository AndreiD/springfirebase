package thesocks.config;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import java.io.IOException;

@Configuration
public class DatabaseConfig {

  @Autowired
  private ApplicationContext appContext;

  @Bean(name = "firebaseReference")
  public DatabaseReference getFirebaseRef() {

    Resource resource = appContext.getResource("classpath:serviceAccountKey.json");

    FirebaseOptions options = null;
    try {
      options = new FirebaseOptions.Builder()
          .setDatabaseUrl("https://the_url_here.firebaseio.com")
          .setServiceAccount(resource.getInputStream())
          .build();
    } catch (IOException e) {
      e.printStackTrace();
    }
    FirebaseApp.initializeApp(options);
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    return database.getReference("/");
  }
}

