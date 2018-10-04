//package se1app.applicationcore.accountcomponent;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import se1app.applicationcore.Application;
//import se1app.applicationcore.branchcomponent.Branch;
//import se1app.applicationcore.branchcomponent.BranchNumberType;
//import se1app.applicationcore.branchcomponent.BranchRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = Application.class)
//public class AccountComponentTest {
//
//    @Autowired
//    private AccountComponentInterface accountComponent;
//    
//    @Autowired
//    private AccountRepository accountRepository;
//    
//    @Autowired
//    private BranchRepository branchRepository;
//    
//    BranchNumberType bn1;
//	AccountNumberType accn1;
//	AccountNumberType accn2;
//	AccountNumberType accn3;
//	int neg;
//	int pos1;
//	int pos2;
//	int pos3;
//	Branch b1;
//	Account acc_max;
//	Account acc_mimi;
//
//	@Before
//	public void setUp() throws Exception {
//		this.bn1 = new BranchNumberType(1);
//		this.accn1 = new AccountNumberType(123);
//		this.accn2 = new AccountNumberType(456);
//		this.accn3 = new AccountNumberType(789);
//		this.neg = -100;
//		this.pos1 = 50;
//		this.pos2 = 500;
//		this.pos3 = 5;
//		this.b1 = branchRepository.findByBranchNumber(bn1);
//		this.acc_max = new Account(accn1, pos1, b1);
//		this.acc_mimi = new Account(accn2, pos1, b1);
//		accountRepository.save(acc_max);
//		accountRepository.save(acc_mimi);
//	}
//
//	@Test
//	public void testUeberweise() throws AccountNotExistException, AccountNotCoveredException {
//	    assertEquals(pos1, accountRepository.findByAccountNumber(acc_max.getAccountNumber()).getBalance());
//	    assertEquals(pos1, accountRepository.findByAccountNumber(acc_mimi.getAccountNumber()).getBalance());
//	    
//	    accountComponent.ueberweise(accn1, accn2, pos3);
//		
//	    assertEquals(pos1-pos3, accountRepository.findByAccountNumber(acc_max.getAccountNumber()).getBalance());
//	    assertEquals(pos1+pos3, accountRepository.findByAccountNumber(acc_mimi.getAccountNumber()).getBalance());
//	}
//	
//	@Test(expected = AccountNotCoveredException.class)
//	public void testBookAccountNotCoveredException() throws AccountNotExistException, AccountNotCoveredException {
//
//		accountComponent.ueberweise(accn1, accn2, pos2);
//	}
//	
//	@Test(expected = AccountNotExistException.class)
//	public void testAccountNotExistException() throws AccountNotExistException, AccountNotCoveredException  {
//		accountComponent.ueberweise(accn1, accn3, pos2);
//	}
//
//}
