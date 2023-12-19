
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

        System.out.println("Welcome to The Game!!\nHere is the list for directions to # (North = 1, South = 2, Up = 3, Down = 4, East = 5, West = 6)\nHere is your first Player:\n");
        System.out.println("\nX is (+)North and (-)South, Y is (+)Up and (-)Down, Z is (+)East and (-)West.\nAll invalid input will be set to a preset input.");
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
                        System.out.println("Here is an updated profile.\n");
                        System.out.println(player1);
                    }else if(attackedPlayer.equalsIgnoreCase("P2")){
                        Player.attack(player2, attackAmount);
                        System.out.println("Here is an updated profile.\n");
                        System.out.println(player2);
                    }else if(attackedPlayer.equalsIgnoreCase("P3")){
                        Player.attack(player3, attackAmount);
                        System.out.println("Here is an updated profile.\n");
                        System.out.println(player3);
                    }

                }else if(choice.equalsIgnoreCase("move")){
                    String movedPlayer = getNonZeroLengString(scan, "Which player was attacked?(P1, P2, P3)");
                    int direction = getInt(scan, "Which direction is the player moving?(1-6)");
                    int distance = getInt(scan, "How far is the Player moving?");
                    if(movedPlayer.equalsIgnoreCase("P1")){
                        Player.move(player1,direction, distance);
                        System.out.println("Here is an updated profile.\n");
                        System.out.println(player1);
                    }else if(movedPlayer.equalsIgnoreCase("P2")){
                        Player.move(player2,direction, distance);
                        System.out.println("Here is an updated profile.\n");
                        System.out.println(player2);
                    }else if(movedPlayer.equalsIgnoreCase("P3")){
                        Player.move(player3,direction, distance);
                        System.out.println("Here is an updated profile.\n");
                        System.out.println(player3);
                    }


                }else if(choice.equalsIgnoreCase("teleport")){
                    String type = getNonZeroLengString(scan, "If a player is teleporting to a certain coordinate enter (C) if they are going to another player enter (P).");
                    if(type.equalsIgnoreCase("c")){
                        String tPlayer = getNonZeroLengString(scan,"Which player is being teleported?(P1, P2, P3)");
                        System.out.println("Enter the X, Y, and Z coordinates the player is being teleported to.");
                        int tX = getInt(scan, "X: ");
                        int tY = getInt(scan, "Y: ");
                        int tZ = getInt(scan, "Z: ");
                        if(tPlayer.equalsIgnoreCase("p1")) {
                            Player.Tp(player1, tX, tY, tZ);
                            System.out.println("Here is an updated profile.\n");
                            System.out.println(player1);
                        }else if(tPlayer.equalsIgnoreCase("p2")) {
                            Player.Tp(player2, tX, tY, tZ);
                            System.out.println("Here is an updated profile.\n");
                            System.out.println(player2);
                        }else if(tPlayer.equalsIgnoreCase("p3")) {
                            Player.Tp(player3, tX, tY, tZ);
                            System.out.println("Here is an updated profile.\n");
                            System.out.println(player3);
                        }
                    }else if(type.equalsIgnoreCase("p")){
                        String playerA = getNonZeroLengString(scan,"Which player is teleporting?(P1, P2, P3)");
                        String playerB = getNonZeroLengString(scan, "Which player is being teleported to(P1, P2, P3)?");
                        if(playerA.equalsIgnoreCase("p1") && playerB.equalsIgnoreCase("p2")){
                            Player.TpPlayer(player1, player2);
                            System.out.println("Here is an updated profile for both players.\n");
                            System.out.println(player1 + "\n");
                            System.out.println(player2);
                        }else if(playerA.equalsIgnoreCase("p1") && playerB.equalsIgnoreCase("p3")){
                            Player.TpPlayer(player1, player3);
                            System.out.println("Here is an updated profile for both players.\n");
                            System.out.println(player1 + "\n");
                            System.out.println(player3);
                        }else if(playerA.equalsIgnoreCase("p2") && playerB.equalsIgnoreCase("p1")){
                            Player.TpPlayer(player2, player1);
                            System.out.println("Here is an updated profile for both players.\n");
                            System.out.println(player2 + "\n");
                            System.out.println(player1);
                        }else if(playerA.equalsIgnoreCase("p2") && playerB.equalsIgnoreCase("p3")){
                            Player.TpPlayer(player2, player3);
                            System.out.println("Here is an updated profile for both players.\n");
                            System.out.println(player2 + "\n");
                            System.out.println(player3);
                        }else if(playerA.equalsIgnoreCase("p3") && playerB.equalsIgnoreCase("p1")){
                            Player.TpPlayer(player3, player1);
                            System.out.println("Here is an updated profile for both players.\n");
                            System.out.println(player3 + "\n");
                            System.out.println(player1);
                        }else if(playerA.equalsIgnoreCase("p3") && playerB.equalsIgnoreCase("p2")){
                            Player.TpPlayer(player3, player2);
                            System.out.println("Here is an updated profile for both players.\n");
                            System.out.println(player3 + "\n");
                            System.out.println(player2);
                        }else if(playerA.equalsIgnoreCase(playerB)){
                            System.out.println("Please choose to different players.");
                        }
                    }

                }else if(choice.equalsIgnoreCase("get a distance") || choice.equalsIgnoreCase("get distance") || choice.equalsIgnoreCase("distance")){
                    String type = getNonZeroLengString(scan, "If a distance for a certain Player enter (C) if you want the distance from one player to another enter (P).");
                    if(type.equalsIgnoreCase("c")){
                        String tPlayer = getNonZeroLengString(scan,"Which player are you getting the distance of?(P1, P2, P3)");
                        System.out.println("Enter the X, Y, and Z coordinates you are trying to get the distance from.");
                        int tX = getInt(scan, "X: ");
                        int tY = getInt(scan, "Y: ");
                        int tZ = getInt(scan, "Z: ");
                        double distance = 0;
                        if(tPlayer.equalsIgnoreCase("p1")) {
                            distance = Player.Distance(player1, tX, tY, tZ);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(tPlayer.equalsIgnoreCase("p2")) {
                            distance = Player.Distance(player2, tX, tY, tZ);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(tPlayer.equalsIgnoreCase("p3")) {
                            distance = Player.Distance(player3, tX, tY, tZ);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }
                    }else if(type.equalsIgnoreCase("p")){
                        String playerA = getNonZeroLengString(scan,"Enter your first player(P1, P2, P3).");
                        String playerB = getNonZeroLengString(scan, "Enter your second player(P1, P2, P3).");
                        double distance = 0;
                        if(playerA.equalsIgnoreCase("p1") && playerB.equalsIgnoreCase("p2")){
                            distance = Player.PDistance(player1, player2);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(playerA.equalsIgnoreCase("p1") && playerB.equalsIgnoreCase("p3")){
                            distance = Player.PDistance(player1, player3);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(playerA.equalsIgnoreCase("p2") && playerB.equalsIgnoreCase("p1")){
                            distance = Player.PDistance(player2, player1);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(playerA.equalsIgnoreCase("p2") && playerB.equalsIgnoreCase("p3")){
                            distance = Player.PDistance(player2, player3);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(playerA.equalsIgnoreCase("p3") && playerB.equalsIgnoreCase("p1")){
                            distance = Player.PDistance(player3, player1);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(playerA.equalsIgnoreCase("p3") && playerB.equalsIgnoreCase("p2")){
                            distance = Player.PDistance(player3, player2);
                            System.out.printf("%-18s%-3.2f%7s", "The distance is",distance, " units.\n");
                        }else if(playerA.equalsIgnoreCase(playerB)){
                            System.out.println("Please choose to different players.");
                        }
                    }
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
