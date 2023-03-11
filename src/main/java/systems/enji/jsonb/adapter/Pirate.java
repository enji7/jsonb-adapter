package systems.enji.jsonb.adapter;

import java.util.Objects;

public class Pirate {

  private String name;
  private NastyParrot parrot;
  
  public Pirate() {
  }
  
  public Pirate(String name, NastyParrot parrot) {
    this.name = name;
    this.parrot = parrot;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public NastyParrot getParrot() {
    return parrot;
  }
  
  public void setParrot(NastyParrot parrot) {
    this.parrot = parrot;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Pirate)) {
      return false;
    }
    return Objects.equals(this.name, ((Pirate) obj).getName());
  }

}
