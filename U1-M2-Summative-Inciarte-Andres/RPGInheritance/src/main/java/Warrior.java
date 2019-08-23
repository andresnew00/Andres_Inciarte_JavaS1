public class Warrior extends Character {

    int shieldStrength = 100;
    int strength = 75;
    int health = 100;
    int stamina = 100;
    int speed = 50;
    int attackPower = 10;

    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength, int strength1, int health1, int stamina1, int speed1, int attackPower1) {
        super(name, strength, health, stamina, speed, attackPower);
        this.shieldStrength = shieldStrength;
        this.strength = strength1;
        this.health = health1;
        this.stamina = stamina1;
        this.speed = speed1;
        this.attackPower = attackPower1;
    }

    public int decreaseShieldStrength(int shieldStrength){
        return shieldStrength--;
    }
}
