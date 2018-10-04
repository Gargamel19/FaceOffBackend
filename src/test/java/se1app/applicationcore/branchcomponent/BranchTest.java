//package se1app.applicationcore.branchcomponent;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
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
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = Application.class)
//public class BranchTest {
//
//	Spieler b2;
//	Spieler b3;
//	SpielerNumberType bn2;
//	SpielerNumberType bn3;
//
//	@Before
//	public void setUp() throws Exception {
//		
//		bn2 = new SpielerNumberType(2);
//		bn3 = new SpielerNumberType(3);
//		b2 = new Spieler(bn2);
//		b3 = new Spieler(bn3);
//	}
//
//	@Test
//	public void testEquals() {
//	    assertEquals(b2, new Spieler(bn2));
//	    assertNotEquals(b2, b3);
//	}
//	
//}
