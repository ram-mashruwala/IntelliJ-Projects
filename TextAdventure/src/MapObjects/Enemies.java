package MapObjects;

public class Enemies {

    private int health;
    private boolean isDead;
    private int attackDamage;
    public Enemies(int health, int attackDamage){
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

    public void attack(Player player){
        player.setHealth(player.getHealth() - 1);
    }

    public boolean isDead() {
        return isDead;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
