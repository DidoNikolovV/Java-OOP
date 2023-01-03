package rpg_lab;

public interface Target {
    public void takeAttack(int attackPoints);
    public int getHealth();
    public int giveExperience();
    public boolean isDead();
}
