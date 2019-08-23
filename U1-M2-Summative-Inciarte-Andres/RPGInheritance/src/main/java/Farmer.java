public class Farmer extends Character {

    int strength = 75;
    int health = 100;
    int stamina = 75;
    int speed = 10;
    int attackPower = 1;

    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower, int strength1, int health1, int stamina1, int speed1, int attackPower1) {
        super(name, strength, health, stamina, speed, attackPower);
        this.strength = strength1;
        this.health = health1;
        this.stamina = stamina1;
        this.speed = speed1;
        this.attackPower = attackPower1;
    }

    public int plow(int strength) {
        return strength++;
    }

    public int harvest(int stamina){
        return stamina++;
    }

}
