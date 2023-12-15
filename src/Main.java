
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Player player1 = new Player();



        String name = "";
        int x = 0;
        int y = 0;
        int z = 0;
        String name2 = "";
        int x2 = 0;
        int y2 = 0;
        int z2 = 0;
        String name3 = "";
        int x3 = 0;
        int y3 = 0;
        int z3 = 0;
        int hp3 = 0;
        int d3 = 0;
        boolean done = false;
        String choice = "";

        System.out.println("Welcome to The Game!!\nHere is your first Player:\n");
        System.out.println(player1 + "\n");
        System.out.println("Now enter the Name and Coordinates of the second player: ");
        System.out.println("Name: ");
        if(scan.hasNextLine()){
            name2 = scan.nextLine();
        }
        System.out.println("X: ");
        if(scan.hasNextInt()){
            x2 = scan.nextInt();
        }
        System.out.println("Y: ");
        if(scan.hasNextInt()){
            y2 = scan.nextInt();
        }
        System.out.println("Z: ");
        if(scan.hasNextInt()){
            z2 = scan.nextInt();
        }
        Player player2 = new Player(name2, x2, y2, z2);
        System.out.println("\n" + player2);

        scan.nextLine();
        System.out.println("\nNow enter the Name, Coordinates, HP, and Direction the third player is facing: ");
        System.out.println("Name: ");
        if(scan.hasNextLine()){
            name3 = scan.nextLine();
        }
        System.out.println("X: ");
        if(scan.hasNextInt()){
            x3 = scan.nextInt();
        }
        System.out.println("Y: ");
        if(scan.hasNextInt()){
            y3 = scan.nextInt();
        }
        System.out.println("Z: ");
        if(scan.hasNextInt()){
            z3 = scan.nextInt();
        }
        System.out.println("HP: ");
        if(scan.hasNextInt()){
            hp3 = scan.nextInt();
        }
        System.out.println("Direction: ");
        if(scan.hasNextInt()){
            d3 = scan.nextInt();
        }
        Player player3 = new Player(name3, x3, y3, z3, hp3, d3);
        System.out.println("\n" + player3);
        scan.nextLine();

        do{
            String yn = getYNConfirm(scan, "Has anything happened in the game?[Y/N]");
            System.out.println(yn);
            if(yn.equalsIgnoreCase("true")){
                System.out.println("Has anyone been attacked or been moved?(please enter the words exactly as previewed)");
                if(scan.hasNextLine()){
                    choice = scan.nextLine();
                }else{
                    System.out.println("your input was invalid.");
                }
                if(choice.equalsIgnoreCase("attacked")){

                }else if(choice.equalsIgnoreCase("moved")){

                }
            }

        }while(!done);


    }
    public static String getYNConfirm(Scanner in, String prompt){
        String input = " ";
        boolean yn = false;
        boolean valid = false;
        String end = "";

        System.out.println(prompt);

        do{
            if(in.hasNextLine()){
                input = in.nextLine();
                if(input.equalsIgnoreCase("Y")){
                    yn = true;
                    valid = true;
                }else if(input.equalsIgnoreCase("N")){
                    yn = false;
                    valid = true;
                }else{
                    System.out.println("Your input is invalid.");
                }
            }else{
                System.out.println("Your input is invalid.");
            }
        }while(!valid);

        if(yn == true){
            input = "true";
        }else if(yn == false){
            input = "false";
        }

        return input;
    }
}