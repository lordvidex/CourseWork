package ru.kpfu.Game;

public class Player {
    public static int MAX_HP = 100;
    private boolean isAlive;
    private final String name;
    private int hp;

    public Player() {
        this.name = "Player" +this.hashCode() ;
        this.hp = MAX_HP;
        isAlive = true;
    }

    public Player(String name) {
        this.name = name;
        this.hp = MAX_HP;
        isAlive = true;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void hit(Player hitPlayer, int force) {
        hitPlayer.gotHit(force);
    }

    public void updateIsAlive() {
        isAlive = this.hp > 0;
    }

    public void gotHit(int force) {
        assert (force >= 1 && force <= 10);
        this.hp -= force;
        updateIsAlive();
    }

    public boolean dodgeHit(int lastMove) {
        if (lastMove == 0) return false;
        int prob = (int) (Math.random() * 10);
        if (prob < lastMove) return false;
        System.out.println(">" + this.name + " dodged this hit...");
        return true;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.hp;
    }
}
