public class Player {
    String name;
    int money;
    int dicePoints;

    public Player() {

    }

    public Player(String name, int money, int dicePoints) {
        this.name = name;
        this.money = money;
        this.dicePoints = dicePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDicePoints() {
        return dicePoints;
    }

    public void setDicePoints(int dicePoints) {
        this.dicePoints = dicePoints;
    }
}
