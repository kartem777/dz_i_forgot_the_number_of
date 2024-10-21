import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Ihor Karabinovych\\IdeaProjects\\dz_i_forgot_the_number_of\\src\\names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.getMessage();
        }

        NameProcessor printNames = name -> System.out.println(name);
        System.out.println("All names:");
        names.forEach(printNames::process);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Letter for counting names: ");
        String letter = scanner.nextLine().toUpperCase();

        long count = names.stream()
                .filter(name -> name.toUpperCase().startsWith(letter))
                .count();
        System.out.println("Count names that starts with " + letter + ": " + count);

        NameProcessor toUpperCase = name -> System.out.println(name.toUpperCase());
        System.out.println("Names in upper case:");
        names.forEach(toUpperCase::process);
    }
}