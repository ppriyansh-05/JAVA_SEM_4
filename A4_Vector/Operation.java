public class Operation {
    public static void main(String[] args) {
        try {
            // 3D Vectors
            Vector v1 = new Vector(3.0, 4.0, 2.0);
            Vector v2 = new Vector(1.0, 2.0, 5.0);

            // 2D Vector
            Vector v3 = new Vector(7.0, 8.0);

            // Addition
            System.out.print("v1 + v2 = ");
            Vector sum = v1.add(v2);
            sum.display();

            // Subtraction
            System.out.print("v1 - v2 = ");
            Vector difference = v1.subtract(v2);
            difference.display();

            // Dot Product
            System.out.print("v1 . v2 = ");
            double dot = v1.dotProduct(v2);
            System.out.println(dot);

            // Exception: Dimension mismatch
            System.out.println("Attempting to add a 3D vector to a 2D vector:");
            v1.add(v3);

        } catch (InvalidVectorException e) {
            System.err.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("-----");

        try {
            // Exception: Invalid dimension (4D)
            System.out.println("Attempting to create a 4D Vector:");
            Vector v4 = new Vector(1.0, 2.0, 3.0, 4.0);
        } catch (InvalidVectorException e) {
            System.err.println("Exception Caught: " + e.getMessage());
        }
    }
}