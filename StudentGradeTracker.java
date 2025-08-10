import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<String> studentNames;
    private ArrayList<Double> studentGrades;
    private Scanner scanner;

    public StudentGradeTracker() {
        studentNames = new ArrayList<>();
        studentGrades = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("=== Student Grade Tracker ===");
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    calculateStatistics();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add a new student and grade");
        System.out.println("2. View all students and grades");
        System.out.println("3. Calculate statistics");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addStudent() {
        System.out.print("\nEnter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student grade (0-100): ");
        double grade = scanner.nextDouble();
        
        // Validate grade input
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Grade must be between 0 and 100.");
            return;
        }
        
        studentNames.add(name);
        studentGrades.add(grade);
        System.out.println("Student added successfully!");
    }

    private void viewAllStudents() {
        if (studentNames.isEmpty()) {
            System.out.println("\nNo students in the system.");
            return;
        }
        
        System.out.println("\nStudent Grade Report:");
        System.out.println("---------------------");
        System.out.printf("%-20s %-10s%n", "Student Name", "Grade");
        System.out.println("---------------------");
        
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("%-20s %-10.2f%n", studentNames.get(i), studentGrades.get(i));
        }
        System.out.println("---------------------");
    }

    private void calculateStatistics() {
        if (studentGrades.isEmpty()) {
            System.out.println("\nNo grades available to calculate statistics.");
            return;
        }
        
        double sum = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        
        for (double grade : studentGrades) {
            sum += grade;
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }
        
        double average = sum / studentGrades.size();
        
        System.out.println("\nGrade Statistics:");
        System.out.println("-----------------");
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %.2f%n", highest);
        System.out.printf("Lowest Grade:  %.2f%n", lowest);
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.run();
    }
}