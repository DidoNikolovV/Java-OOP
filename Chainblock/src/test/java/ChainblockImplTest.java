import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChainblockImplTest {

    private Chainblock chainblock;
    private List<Transaction> transactions;


    @Before
    public void setup() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        this.prepareTransactions();

    }

    public void prepareTransactions() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Sasho", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Tosho", 11.20);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Sasho", "Pesho", 10);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Tosho", "Sasho", 11);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Sasho", "Pesho", 12.20);
        transactions.add(transaction);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
    }


    // Add method adds different transactions
    @Test
    public void testAdd_ShouldAddTransaction() {
        chainblock.add(transactions.get(0));

        Assert.assertEquals(1, chainblock.getCount());
    }

    // Add method should not add duplicated transactions
    @Test
    public void testAdd_ShouldNotAddDuplicatedTransactions() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(0));

        Assert.assertEquals(1, chainblock.getCount());
    }


}
