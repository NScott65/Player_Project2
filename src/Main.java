
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
            if(yn.equalsIgnoreCase("true")){
                System.out.println("Would you like to move, teleport, attack, or get a distance (please enter the words exactly as previewed).");
                if(scan.hasNextLine()){
                    choice = scan.nextLine();
                }else{
                    System.out.println("your input was invalid.");
                }
                if(choice.equalsIgnoreCase("attack")){
                    String attackedPlayer = getNonZeroLengString(scan, "Which player was attacked?(P1, P2, P3)");

                    int attackAmount = getInt(scan, "How much damage was done?");
                    int finalAttack = 0;
                    if(attackedPlayer.equalsIgnoreCase("P1")){
                        Player.attack(player1, attackAmount);
                        System.out.println(player1);
                    }else if(attackedPlayer.equalsIgnoreCase("P2")){
                        Player.attack(player2, attackAmount);
                        System.out.println(player2);
                    }else if(attackedPlayer.equalsIgnoreCase("P3")){
                        Player.attack(player3, attackAmount);
                        System.out.println(player3);
                    }

                }else if(choice.equalsIgnoreCase("moved")){

                }else if(choice.equalsIgnoreCase("teleport")){

                }else if(choice.equalsIgnoreCase("get a distance") || choice.equalsIgnoreCase("get distance") || choice.equalsIgnoreCase("distance")){

                }
            }else if(yn.equalsIgnoreCase("false")){
                done = true;
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

        if(yn){
            input = "true";
        }else if(!yn){
            input = "false";
        }

        return input;
    }

    public static String getNonZeroLengString(Scanner in, String prompt){
        String input = " ";
        boolean valid = false;

        System.out.println(prompt);
        do {
            if (in.hasNextLine()) {
                input = in.nextLine();
                if (input.length() > 0) {
                    valid = true;
                } else {
                    System.out.println("Your String is less than one.");
                }
            } else {
                System.out.println("Your input is invalid.");
            }
        }while(!valid);
        return input;
    }

    public static int getInt(Scanner in, String prompt){
        boolean done = false;
        int x = 0;

        System.out.println(prompt);
        do {
            if(in.hasNextInt()){
                x = in.nextInt();
                done = true;
            }else{
                System.out.println("Invalid input. Do better.");
            }
            in.nextLine(); //clear buffer
        }while(!done);
        return x;
    }
}