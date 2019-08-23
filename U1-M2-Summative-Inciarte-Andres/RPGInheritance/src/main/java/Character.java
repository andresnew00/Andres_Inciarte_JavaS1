public class Character {

    String name;
    int strength;
    int health;
    int stamina;
    int speed;
    int attackPower;

    public Character(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        Strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int run(int speed, int stamina) {

        int CharacterRunning = speed * stamina;

        return CharacterRunning;
    }

    public int attack(int strength, int stamina) {

        int ChrtAttack = strength / stamina;

        return ChrtAttack;
    }

    public int heal(int health, int strength){
        int healingPower = health * strength;

        return healingPower;
    }

    public int decreaseHealth(int health, int attackPower) {

        int healthlower = health - attackPower;

        return  healthlower;
    }

    public int increaseStamina(int health, int stamina){

        if(stamina < 10){
            stamina++;
        } else {
            return health + stamina;
        }
        return stamina;
    }

    public int decreaseStamina(int stamina, int health){
        if (health > 10){
            return stamina;
        } else {
            return stamina;
        }
    }
}
