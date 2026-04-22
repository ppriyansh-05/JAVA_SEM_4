import java.io.*;
import java.util.*;

public class StudentCSVCRUD {

    static String fileName = "Students.csv";

    public static void main(String[] args) {

        try {
            createFile();
            addInitialRows();
            addMoreRows();
            updateMarks();
            calculatePercentage();
            deleteRow(2); // delete student with ID = 2
            displayFile();

        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Force exception demonstration
        try {
            BufferedReader br = new BufferedReader(new FileReader("WrongFile.csv"));
        } catch (IOException e) {
            System.out.println("Exception Example: File not found -> " + e.getMessage());
        }
    }

    // 1. Create file with header
    public static void createFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");
        bw.close();
        System.out.println("File created with header.");
    }

    // 2. Add initial rows
    public static void addInitialRows() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        bw.write("1,John,CSE,80,85,90,,,\n");
        bw.write("2,Alice,IT,75,70,65,,,\n");

        bw.close();
        System.out.println("Initial rows added.");
    }

    // 3. Add more rows (marks4 & marks5 initially 0)
    public static void addMoreRows() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        bw.write("3,Bob,ECE,60,65,70,0,0,\n");
        bw.write("4,Emma,ME,88,77,66,0,0,\n");
        bw.write("5,Liam,CE,90,92,85,0,0,\n");

        // extra record
        bw.write("6,Noah,IT,78,80,82,0,0,\n");

        bw.close();
        System.out.println("Additional rows added.");
    }

    // 4. Update all marks (fill missing values)
    public static void updateMarks() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine(); // header
        lines.add(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            for (int i = 3; i <= 7; i++) {
                if (i >= data.length || data[i].isEmpty()) {
                    data = Arrays.copyOf(data, 9);
                    data[i] = "70"; // default marks
                }
            }

            lines.add(String.join(",", data));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            bw.write(l + "\n");
        }
        bw.close();

        System.out.println("Marks updated.");
    }

    // 5. Calculate percentage
    public static void calculatePercentage() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine(); // header
        lines.add(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            int total = 0;
            for (int i = 3; i <= 7; i++) {
                total += Integer.parseInt(data[i]);
            }

            double percentage = total / 5.0;
            data[8] = String.valueOf(percentage);

            lines.add(String.join(",", data));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            bw.write(l + "\n");
        }
        bw.close();

        System.out.println("Percentage calculated.");
    }

    // 6. Delete a row by studentId
    public static void deleteRow(int studentId) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine(); // header
        lines.add(line);

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) != studentId) {
                lines.add(line);
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            bw.write(l + "\n");
        }
        bw.close();

        System.out.println("Deleted student with ID: " + studentId);
    }

    // 7. Display file content
    public static void displayFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        System.out.println("\nFinal File Content:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}