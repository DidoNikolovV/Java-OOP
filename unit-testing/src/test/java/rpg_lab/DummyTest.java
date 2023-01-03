package rpg_lab;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int ATTACK_POINTS = 10;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 10;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyThrowsWhenAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void deadDummyGivesXp() {
        deadDummy.giveExperience();
    }

    @Test(expected = IllegalStateException.class)
    public void dummyCantGiveXp() {
        dummy.giveExperience();
    }

}
