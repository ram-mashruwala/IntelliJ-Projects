package Map;

import MapObjects.*;

import java.util.ArrayList;

public class Room {

    boolean[] direction;

    boolean isSpawnRoom;
    boolean isFinishRoom;
    ArrayList<Enemies> enemies;
    public Room(boolean north, boolean south, boolean west, boolean east, boolean isSpawnRoom, boolean isFinishRoom){
        direction =  new boolean[4];
        direction[0] = north;
        direction[1] = south;
        direction[2] = west;
        direction[3] = east;
        this.isSpawnRoom = isSpawnRoom;
        this.isFinishRoom = isFinishRoom;
        populateEnemies();
    }

    private void populateEnemies(){

        while(true){
            if((int) (Math.random() * 2) == 1){
                addEnemies();
            } else {
                break;
            }
        }

    }

    private void addEnemies(){
        int hi = (int)(Math.random() * 3);
        if(hi == 0){
            enemies.add(new Ogre());
        } else if(hi == 1){
            enemies.add(new Skeleton());
        } else if (hi == 2) {
            enemies.add(new Spider());
        }
    }

    public boolean containsEnemies(){
        return !enemies.isEmpty();
    }

}
