package aufgabe.eins;

public class Bruch {
  private final int zaehler;
  private final int nenner;

  public Bruch(int zaehler, int nenner) {
      if(nenner == 0){
          throw new IllegalArgumentException("Nenner darf nicht 0 sein");
      }
    int teiler = ggt(zaehler, nenner);
    this.zaehler = zaehler / teiler;
    this.nenner = nenner / teiler;
  }

  public Bruch(int zaehler) {
    this.zaehler = zaehler;
    this.nenner = 1;
  }

  @Override
  public String toString() {
    return String.format("Zähler: %s, Nenner: %s", zaehler, nenner);
  }

  private int ggt(int a, int b) {
    if (a == b) {
      return a;
    } else if (a < b) {
      return ggt(a, b - a);
    } else {
      return ggt(b, a);
    }
  }

  public Bruch add(Bruch other) {
    int newZaehler = this.zaehler * other.nenner
            + other.zaehler * this.nenner;
    int newNenner = this.nenner * other.nenner;
    return new Bruch(newZaehler, newNenner);
  }

  public Bruch multiply(Bruch other) {
    return new Bruch(
            this.zaehler * other.zaehler,
            this.nenner * other.nenner);
  }
}
