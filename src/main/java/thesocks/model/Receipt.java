package thesocks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

  private String receipt_id;
  public boolean is_processed;
  private long timestamp;
  private String body;
}