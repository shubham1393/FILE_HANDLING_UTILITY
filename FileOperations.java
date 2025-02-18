import java.io.*;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Write to a file");
        System.out.println("2. Read from a file");
        System.out.println("3. Modify a file");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                writeFile(scanner);
                break;
            case 2:
                readFile(scanner);
                break;
            case 3:
                modifyFile(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void writeFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.println("Enter the content to write to the file (type 'END' to finish):");
        StringBuilder content = new StringBuilder();
        String line;

        while (!(line = scanner.nextLine()).equals("END")) {
            content.append(line).append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content.toString());
            System.out.println("Content written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static void readFile(Scanner scanner) {
        System.out.print("Enter the file name to read: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void modifyFile(Scanner scanner) {
        System.out.print("Enter the file name to modify: ");
        String fileName = scanner.nextLine();

        System.out.println("Enter the new content for the file (type 'END' to finish):");
        StringBuilder newContent = new StringBuilder();
        String line;

        while (!(line = scanner.nextLine()).equals("END")) {
            newContent.append(line).append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(newContent.toString());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }
}
