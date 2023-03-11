package systems.enji.jsonb.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.JsonbException;

public class AdapterTest {

  /** Pirate to be (de-)serialized. */
  private Pirate blackbeard = new Pirate("Blackbeard", new NastyParrot("Polly"));
  
  @Test
  void failsWithoutAdapter() {
    
    Jsonb jsonb = JsonbBuilder.create();

    // serialization works
    String blackbeardJson = jsonb.toJson(blackbeard);
    System.out.println(blackbeardJson);
    
    // deserialization fails due to the nasty parrot
    Assertions.assertThrows(JsonbException.class, 
        () -> jsonb.fromJson(blackbeardJson, Pirate.class));
    
  }

  @Test
  void worksWithAdapter() {
    
    Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withAdapters(new ParrotAdapter()));

    // serialization works
    String blackbeardJson = jsonb.toJson(blackbeard);
    System.out.println(blackbeardJson);
    
    // deserialization works as well
    Pirate blackbeard2 = jsonb.fromJson(blackbeardJson, Pirate.class);
    
    // compare original with copy
    Assertions.assertEquals(blackbeard, blackbeard2);
    
  }
  
}
