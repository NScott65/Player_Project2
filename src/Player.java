import java.util.Scanner;
public class Player {
    Scanner scan = new Scanner(System.in);

    private int x;
    private int y;
    private int z;
    private int direction;
    private int hp;
    private String name;
    private int pCount = 1;


    public Player(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.hp = 20;
        this.name = ("P" + pCount);
    }

    public Player(String name, int x, int y, int z ){
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hp = 20;
        this.direction = 1;
    }

    public Player(String name, int x, int y, int z, int hp, int direction){
        String d = "";
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hp = hp;
        this.direction = direction;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }

    public int getHp(){
        return hp;
    }

    public int getDirection(){
        return direction;
    }

    public String getName(){
        return name;
    }

    public int getpCount(){
        return pCount;
    }


    public String toString(){
        String out = "";
        if(direction >= 1 && direction <= 6){
            out = ("Name: " + name + "\nHP: " + hp + "\nX: " + x + " Y: " + y + " Z: " + z + "\nDirection: " + direction);
        }else{
            out = ("Name: " + name + "\nHP: " + hp + "\nX: " + x + " Y: " + y + " Z: " + z);
        }
        return out;
    }

    //void methods
    public void setHp(int hp){
        if(hp >= 0 && hp <= 100){
            this.hp = hp;
        }
        else{
            hp = 20;
        }
    }
    public void setDirection(int direction){
        if(direction >= 1 && direction <= 6){
            this.direction = direction;
        }
        else{
            direction = 1;
        }
    }
    public static void move(Player player, int direction, int unit){
        if(direction >= 1 && direction <= 6){
            player.direction = direction;
        }
        else{
            direction = 1;
        }
        if(direction == 1){
            player.x += unit;
        }
        else if(direction == 2){
            player.x -= unit;
        }
        else if(direction == 3){
            player.y += unit;
        }
        else if(direction == 4){
            player.y -= unit;
        }
        else if(direction == 5){
            player.z += unit;
        }
        else if(direction == 6){
            player.z -= unit;
        }
    }
    public static void Tp(Player player, int x,int y, int z){
        player.x = x;
        player.y = y;
        player.z = z;
    }
    public static void TpPlayer(Player playerA, Player playerB){
        playerB.x = playerA.x;
        playerB.y = playerA.y;
        playerB.z = playerA.z;
    }
    public static void attack(Player player, int damage){
        player.hp -= damage;
    }

    public static double Distance(Player player, int x, int y, int z){
        double distance = Math.sqrt(Math.pow(x - player.x,2) + Math.pow(y - player.y,2) + Math.pow(z - player.z, 2) );
        return distance;

    }

    public static double PDistance(Player playerA, Player playerB){
        double distance = Math.sqrt(Math.pow(playerA.x - playerB.x,2) + Math.pow(playerA.y - playerB.y,2) + Math.pow(playerA.z - playerB.z,2));
        return distance;
    }
}
