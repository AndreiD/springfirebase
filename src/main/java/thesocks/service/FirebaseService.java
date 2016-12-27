package thesocks.service;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import thesocks.model.Receipt;

@Slf4j
@Service
public class FirebaseService {

  @Autowired
  private DatabaseReference firebaseReference;

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public void startFirebaseListenerOrders() {

    log.info("starting the firebase listener for orders");
    firebaseReference.child("orders")
        .limitToLast(5)
        .addChildEventListener(new ChildEventListener() {
          @Override
          public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            log.info("++++++++++ child added on orders +++++++++++++");
            eventPublisher.publishEvent(dataSnapshot);
          }

          @Override
          public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            log.info("++++++++++ child changed on orders +++++++++++++");
            Receipt receipt = dataSnapshot.getValue(Receipt.class);
            log.info(receipt.toString());
          }

          @Override
          public void onChildRemoved(DataSnapshot dataSnapshot) {

          }

          @Override
          public void onChildMoved(DataSnapshot dataSnapshot, String s) {

          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
        });
  }

}
