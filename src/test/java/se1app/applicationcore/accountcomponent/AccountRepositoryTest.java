//package se1app.applicationcore.accountcomponent;
//
//import static org.assertj.core.api.Assertions.assertThat;
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
//public class AccountRepositoryTest {
//
//    @Autowired
//    private AccountRepository accountRepository;
//	
//    @Autowired
//    private BranchRepository branchRepository;
//    
//    BranchNumberType bn1;
//    AccountNumberType accn1;
//    AccountNumberType accn2;
//	int pos;
//	Branch b1;
//	Account acc_max;
//
//	@Before
//	public void setUp() throws Exception {
//		this.bn1 = new BranchNumberType(1);
//		this.accn1 = new AccountNumberType(321);
//		this.accn2 = new AccountNumberType(654);
//		this.pos = 50;
//		this.b1 = branchRepository.findByBranchNumber(bn1);
//		this.acc_max = new Account(accn1, 50, b1);
//		accountRepository.save(acc_max);
//	}
//
//	@Test
//	public void testFindByAccountNumber() {
//        Account rest = accountRepository.findByAccountNumber(acc_max.getAccountNumber());
//        assertThat(rest!=null);
//        
//        Account acc_mimi = accountRepository.findByAccountNumber(this.accn2);
//        assertThat(acc_mimi==null);
//	}
//
//}
