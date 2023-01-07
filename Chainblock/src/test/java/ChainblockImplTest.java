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

    @Test
    public void testContains_ShouldReturnTrue() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(0));
        Assert.assertTrue(chainBlockContainsTransaction);
    }

    @Test
    public void testContains_ShouldReturnFalse() {
        chainblock.add(transactions.get(0));
        boolean chainBlockContainsTransaction = chainblock.contains(transactions.get(1));
        Assert.assertFalse(chainBlockContainsTransaction);
    }

    @Test
    public void testContains_ShouldReturnTrueIfIdIsPresented() {
        chainblock.add(transactions.get(0));
        int transactionId = transactions.get(0).getId();
        Assert.assertTrue(chainblock.contains(transactionId));
    }

    @Test
    public void testChangeTransactionStatus_ShouldChangeStatus() {
        Transaction transaction = transactions.get(0);
        chainblock.add(transaction);
        chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);
        Assert.assertEquals(TransactionStatus.FAILED, transaction.getStatus());
    }

    @Test(expected= IllegalArgumentException.class)
    public void testChangeTransactionStatus_ShouldThrowWhenNoSuchTransactionExists() {
        chainblock.add(transactions.get(0));
        chainblock.changeTransactionStatus(2, TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testRemoveTransactionById_ShouldRemoveTransactionIfExists() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.removeTransactionById(0);
        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionById_ShouldThrowIfTransactionDoesNotExist() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.removeTransactionById(3);
    }


}
