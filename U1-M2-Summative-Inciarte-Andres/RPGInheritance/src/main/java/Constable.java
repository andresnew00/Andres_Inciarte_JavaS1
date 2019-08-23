public class Constable extends Character {

    String jurisdiction;
    int strength = 60;
    int health = 100;
    int stamina = 60;
    int speed = 20;
    int attackPower = 5;

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction, int strength1, int health1, int stamina1, int speed1, int attackPower1) {
        super(name, strength, health, stamina, speed, attackPower);
        this.jurisdiction = jurisdiction;
        this.strength = strength1;
        this.health = health1;
        this.stamina = stamina1;
        this.speed = speed1;
        this.attackPower = attackPower1;
    }

    public int arrest(int speed, int strength) {
        if (speed > 100 && strength > 50){
            System.out.println("You are under arrest");
            stamina++;
        }
        return stamina ;
    }

}
