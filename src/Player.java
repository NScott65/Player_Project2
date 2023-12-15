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
    public void move(int direction, int unit){
        if(direction >= 1 && direction <= 6){
            this.direction = direction;
        }
        else{
            direction = 1;
        }
        if(direction == 1){
            this.x += unit;
        }
        else if(direction == 2){
            this.x -= unit;
        }
        else if(direction == 3){
            this.y += unit;
        }
        else if(direction == 4){
            this.y -= unit;
        }
        else if(direction == 5){
            this.z += unit;
        }
        else if(direction == 6){
            this.z -= unit;
        }
    }
    public void Tp(int x,int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void TpPlayer(Player player){
        this.x = player.x;
        this.y = player.y;
        this.z = player.z;
    }
    public void attack(Player player, int damage){
        player.hp -= damage;
    }
}