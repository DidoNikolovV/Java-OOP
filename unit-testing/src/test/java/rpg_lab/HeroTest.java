package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class HeroTest {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Pesho";

    @Test
    public void attackGainsExperienceWhenTargetIsDead() {
        Target fakeTarget = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return false;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);

        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience", TARGET_XP, fakeTarget.giveExperience());
    }
}
