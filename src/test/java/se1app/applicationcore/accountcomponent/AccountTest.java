//package se1app.applicationcore.accountcomponent;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import se1app.applicationcore.Application;
//import se1app.applicationcore.branchcomponent.Spieler;
//import se1app.applicationcore.branchcomponent.SpielerNumberType;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = Application.class)
//public class AccountTest {
//	AccountNumberType accn1;
//	AccountNumberType accn2;
//	int neg;
//	int pos;
//	Spieler b1;
//	Account acc_max;
//
//	@Before
//	public void setUp() throws Exception {
//		this.accn1 = new AccountNumberType(213);
//		this.accn2 = new AccountNumberType(546);
//		this.neg = -100;
//		this.pos = 50;
//		this.b1 = new Spieler(new SpielerNumberType(1));
//		this.acc_max = new Account(accn2, 50, new Spieler(new SpielerNumberType(1)));
//	}
//
//	@Test
//	public void testAccount() {
//	    try {
//	    	new Account(accn1, pos, b1);
//	    } catch (Throwable t) {
//	        throw new Error("fail!");
//	    }
//	}
//	
//	@Test(expected = AccountNotCoveredException.class)
//	public void testAccountNegativeBalance() throws Exception {
//		new Account(accn1, neg, b1);
//	}
//	
//	@Test(expected = AccountNotCoveredException.class)
//	public void testBookAccountNotCoveredException() throws Exception {
//		acc_max.book(neg);
//	}
//	
//	@Test()
//	public void testBook() {
//	    try {
//	    	acc_max.book(pos);
//	    } catch (Throwable t) {
//	        throw new Error("fail!");
//	    }
//		
//	}
//
//}
