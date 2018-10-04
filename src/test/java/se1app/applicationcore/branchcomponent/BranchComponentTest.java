//package se1app.applicationcore.branchcomponent;
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
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = Application.class)
//public class BranchComponentTest {
//    
//    @Autowired
//    private BranchRepository branchRepository;
//	
//	Branch sparkasseHamburg;
//	
//	
//	@Before
//	public void setUp() throws Exception {
//		sparkasseHamburg = new Branch(new BranchNumberType(20000));
//	}
//
//	@Test
//	public void testCreateBranch() {
//		BranchNumberType bn1 = new BranchNumberType(40000);
//		Branch sparkasseOderSpree = new Branch(bn1);
//		branchRepository.save(sparkasseOderSpree);
//		assertEquals(sparkasseOderSpree, branchRepository.findByBranchNumber(bn1));
//	}
//	
//}
