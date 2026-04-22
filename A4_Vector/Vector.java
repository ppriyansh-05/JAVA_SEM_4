public class Vector {
    private double[] components;

    // Constructor checks for 2D or 3D dimensions
    public Vector(double... components) throws InvalidVectorException {
        if (components.length != 2 && components.length != 3) {
            throw new InvalidVectorException("Invalid dimension. Vector must be 2D or 3D. Provided: " + components.length + "D.");
        }
        this.components = components;
    }

    // Method to verify dimension 
    private void checkDimensions(Vector other) throws InvalidVectorException {
        if (this.components.length != other.components.length) {
            throw new InvalidVectorException(
                "Dimension mismatch: Cannot operate on a " +
                this.components.length + "D vector and a " +
                other.components.length + "D vector."
            );
        }
    }

    // Vector Addition
    public Vector add(Vector other) throws InvalidVectorException {
        checkDimensions(other);
        double[] result = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            result[i] = this.components[i] + other.components[i];
        }
        return new Vector(result);
    }

    // Vector Subtraction
    public Vector subtract(Vector other) throws InvalidVectorException {
        checkDimensions(other);
        double[] result = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            result[i] = this.components[i] - other.components[i];
        }
        return new Vector(result);
    }

    // Dot Product
    public double dotProduct(Vector other) throws InvalidVectorException {
        checkDimensions(other);
        double product = 0;
        for (int i = 0; i < this.components.length; i++) {
            product += this.components[i] * other.components[i];
        }
        return product;
    }

    // Display Method
    public void display() {
        System.out.print("[");
        for (int i = 0; i < components.length; i++) {
            System.out.print(components[i]);
            if (i < components.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}