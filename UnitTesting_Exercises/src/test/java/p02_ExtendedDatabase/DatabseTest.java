package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabseTest {
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        Person person1 = new Person(1, "Pesho");
        Person person2 = new Person(2, "Dido");
        this.database = new Database(person1, person2);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testFindByMissingUsernameShouldThrowError() throws OperationNotSupportedException {
        this.database.findByUsername("Andrei");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullParametersShouldThrow() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWithInvalidIdShouldThrow() throws OperationNotSupportedException {
        this.database.findById(3);
    }
}
