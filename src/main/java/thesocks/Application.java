package thesocks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import thesocks.service.FirebaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class Application {

  public static void main(String[] args) throws IOException {
    ApplicationContext appContext = SpringApplication.run(Application.class, args);
    log.info(":::::::::::::::::::: Running  ::::::::::::::::::::");

    appContext.getBean(FirebaseService.class).startFirebaseListenerOrders();
  }
}