package StudentGradeTrackRecorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentGradeTrackRecorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== CodeAlpha Task 1: Student Grade Tracker ===");
        System.out.print("Enter the number of students to add: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numStudents; i++) {
            System.out.println("\nEnter details for student " + i + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            double grade = -1;
            while (true) {
                System.out.print("Grade (0-100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (grade >= 0 && grade <= 100) break;
                } else {
                    scanner.next(); // Clear invalid input
                }
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            }

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            scanner.close();
            return;
        }

        // Calculations
        double sum = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();
        String topStudent = students.get(0).getName();
        String lowStudent = students.get(0).getName();

        for (Student s : students) {
            double g = s.getGrade();
            sum += g;
            if (g > highest) {
                highest = g;
                topStudent = s.getName();
            }
            if (g < lowest) {
                lowest = g;
                lowStudent = s.getName();
            }
        }

        double average = sum / students.size();

        // Display Summary Report
        System.out.println("\n========================================");
        System.out.println("           STUDENT GRADE REPORT         ");
        System.out.println("========================================");
        System.out.println("Total Students: " + students.size());
        System.out.printf("Class Average Grade: %.2f\n", average);
        System.out.println("Highest Score: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (" + lowStudent + ")");
        System.out.println("----------------------------------------");
        System.out.println("Individual Records:");
        for (Student s : students) {
            System.out.printf("- %s: %.2f\n", s.getName(), s.getGrade());
        }
        System.out.println("========================================");

        scanner.close();
    }
}
