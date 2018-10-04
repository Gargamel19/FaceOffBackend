//package se1app.applicationcore.branchcomponent;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.not;
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
//import se1app.applicationcore.branchcomponent.Spieler;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = Application.class)
//public class BranchRepositoryTest {
//
//    @Autowired
//    private SpielerRepository branchRepository;
//	
//    SpielerNumberType bn;
//    SpielerNumberType bn2;
//    Spieler sparkasseHamburg;
//	
//	@Before
//	public void setUp(){
//		bn = new SpielerNumberType(1);
//		bn2 = new SpielerNumberType(23145);
//	}
//
//	@Test
//	public void testFindByBranchNumber() {
//        Spieler sparHH = branchRepository.findByBranchNumber(bn);
//        assertThat(sparHH!=null);
//        
//        Spieler noBranch = branchRepository.findByBranchNumber(bn2);
//        assertThat(not(noBranch!=null));
//	}
//
//}
