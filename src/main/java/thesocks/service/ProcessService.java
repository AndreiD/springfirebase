package thesocks.service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import thesocks.model.Receipt;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ProcessService {

  @Autowired
  private DatabaseReference firebaseReference;

  @Async
  @EventListener
  void processNewReceipt(DataSnapshot dataSnapshot) {

    Receipt receipt = dataSnapshot.getValue(Receipt.class);
    log.info(">>> processing new " + receipt);

    //YOUR LOGIC HERE...

    //simulating work...
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    updateTimeReceipt(dataSnapshot);
    log.info(">>> finished processing >>>");
  }

  //Here's an example how you can UPDATE the data.
  //update the time for a receipt after it's processed.
  private void updateTimeReceipt(DataSnapshot dataSnapshot) {
    long new_timestamp = Instant.now().getEpochSecond();
    DatabaseReference objRef = firebaseReference.child("orders").child(dataSnapshot.getKey());
    Map<String, Object> taskMap = new HashMap<>();
    taskMap.put("timestamp", new_timestamp);
    taskMap.put("is_processed", true);
    objRef.updateChildren(taskMap);
  }
}
