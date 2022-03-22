import java.util.Scanner;

public class Main {
    public static String userInput;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        do {
            System.out.println("Введите комманду: ");
            userInput = scanner.nextLine();
            if(!userInput.equals("exit")) {
                toDoList.input = userInput;
                toDoList.recognizeCommands();

                System.out.println();
            } else {
                System.out.println("Конец программы");
            }
        }   while (!userInput.equals("exit"));
        scanner.close();
    }
}
