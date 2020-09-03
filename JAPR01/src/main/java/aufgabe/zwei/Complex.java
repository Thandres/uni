package aufgabe.zwei;

public class Complex implements Comparable<Complex> {
  private final double real;
  private final double imaginary;

  public Complex(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public Complex(double real) {
    this(real, 0);
  }

  private double betrag() {
    return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
  }

  // rest aus der Lerneinheit entnehmen

  @Override
  public int compareTo(Complex other) {
    double betrag = this.betrag();
    double otherBetrag = other.betrag();
    return Double.compare(betrag, otherBetrag);
  }
}
