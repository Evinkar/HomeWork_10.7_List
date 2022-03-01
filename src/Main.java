import java.util.Scanner;

public class Main {
    public static String userInput;
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList(userInput);
        /*

        System.out.println("Введите комманду");
        userInput = scanner.nextLine() + " .";
        ToDoList toDoList = new ToDoList(userInput);
        toDoList.recognizeCommands();

        System.out.println("Введите комманду");
        userInput = scanner.nextLine() + " .";
        toDoList.input = userInput;
        toDoList.recognizeCommands();

        System.out.println("Введите комманду");
        userInput = scanner.nextLine() + ".";
        toDoList.input = userInput;
        toDoList.recognizeCommands();
        */

        do {
            System.out.println("Введите комманду");
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

        //ToDoList toDoList = new ToDoList("ADD to do hren."); // в инпуте всегда добалять точку.



    }
}
