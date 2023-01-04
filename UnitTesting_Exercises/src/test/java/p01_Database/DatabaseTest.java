package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private  static final Integer[] NUMBERS = {5, 8, 21, 68, 79, 2, 1};

    @Before
    public void setUp() throws OperationNotSupportedException {
        Integer[] numbers = NUMBERS;
        this.database = new Database(numbers);
    }

    @Test
    public void testCreateDatabase() {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length, dbElements.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals(NUMBERS[i], dbElements[i]);
        }
    }

    @Test
    public void testArraySizeMustBeAtMost16Integers() {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length, dbElements.length);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Argument() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan16Arguments() throws OperationNotSupportedException {
        Integer[] bigIntegerArray = new Integer[17];
        new Database(bigIntegerArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithNullArgumentShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();
        Integer[] currentElements = database.getElements();
        Assert.assertEquals(initialSize - 1, currentElements.length);
        int lastElement = currentElements[currentElements.length - 1];
        int expected = NUMBERS[NUMBERS.length - 2];
        Assert.assertEquals(expected, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowErrorWhenRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        Integer[] empty = new Integer[0];
        new Database(empty);
        database.remove();
    }


}
