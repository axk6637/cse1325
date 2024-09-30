public class Complex {
    // Constructor invoked by e.g., Complex c = new Complex(3.0, 4.0);
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    // toString method replaces the default string representation
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }    
    private double a; // (real)      These attribute can't be accessed
    private double b; // (imaginary)   outside of class Complex
}
public static void main(String[] args) {
    Complex c = new Complex(3.0, 4.0);
    System.out.println("Created Complex number " + c);
}
