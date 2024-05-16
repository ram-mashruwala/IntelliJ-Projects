package MapObjects;

import Map.Room;

public class Player {

    private int health;
    private int attackDamage;
    private boolean isDead;
    public Player(int health, int attackDamage){
        this.health = health;
        this.attackDamage = attackDamage;
        isDead = false;
    }

    public boolean hit(int damage){
        health -= damage;
        if(health <= 0){
            isDead = true;
        }
        return isDead;
    }

    public void turn(Room room){
        if(room.containsEnemies()) {
            System.out.println("Battle mode");

        }
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public int getAttackDamage() {
        return attackDamage;
    }
}
