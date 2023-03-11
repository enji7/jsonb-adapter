package systems.enji.jsonb.adapter;

import jakarta.json.bind.adapter.JsonbAdapter;

/**
 * This adapter shows JSONB how to deal with the unmappable "NastyParrot" 
 * by adapting it to the mappable "GoodParrot".
 * 
 * Serialization would also work without this adapter, whereas deserialization would not.
 */
public class ParrotAdapter implements JsonbAdapter<NastyParrot, GoodParrot> {

  @Override
  public GoodParrot adaptToJson(NastyParrot obj) throws Exception {
    return new GoodParrot(obj.getName());
  }

  @Override
  public NastyParrot adaptFromJson(GoodParrot obj) throws Exception {
    return new NastyParrot(obj.getName());
  }

}
