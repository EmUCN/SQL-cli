package TUI;

import java.util.Scanner;

public class SqlCli {

    private float version = 0.1f;

    public static final String inputConnect = "c";
    public static final String inputExit = "e";
    public static final String inputCheckDatabase = "cd";
    public static final String inputHelp = "h";


    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        SqlCli sqlCli = new SqlCli();

        sqlCli.mainMenu();
    }

    private void mainMenu(){
        
        System.out.println("Welcome to the SQL CLI version" + version);
        displayHelp();
        
        while (true) {

            String userInput = input.nextLine();

            if(menuSelect(userInput) == false){
                System.out.println("Invalid input. Valid inputs: ");
                displayHelp();
            }

            menuSelect(userInput);
        }
    }

    private boolean menuSelect(String input){
        switch(input.toLowerCase()) {

            case inputConnect:
                connectToSqlServer();
                return true;

                case inputCheckDatabase:
                checkDatabaseConnection();
                    return true;

                case inputHelp:
                displayHelp();
                return true;

                case inputExit:
                    exit();
                    return true;

            default:
                System.out.println("Invalid input");
                return false;
        }
    }

    private void connectToSqlServer() {

    }

    private void checkDatabaseConnection() {

        System.out.println("Checking database connection");
    }

    private void exit(){
        System.out.println("Thank you for using the SQL CLI");
        System.exit(0);
    }

    private void displayHelp(){
        
        System.out.println("Please select an option:");
        System.out.println("Connect to a database = C");
        System.out.println("Check database connection = CD");
        System.out.println("E = Exit");
        System.out.println("H = Help menu");
    }
}
