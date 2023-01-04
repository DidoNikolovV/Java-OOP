package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator("Angel", "Maria", "Ivan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParamaterShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testMoveMethodSuccessfullyMoved() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveMethodShouldReturnFalseIfThereIsNoNextIndex() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextMethodShouldReturnTrueIfThereIsNextIndex() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextMethodShouldReturnFalseIfIsAlreadyAtTheLastIndex() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testPrintShouldPrintTheElementAtCurrentIndex() {
        while(listIterator.hasNext()) {
            listIterator.print();
            listIterator.move();
        }
    }

}
