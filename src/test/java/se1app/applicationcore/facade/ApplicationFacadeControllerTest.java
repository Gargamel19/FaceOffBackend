//package se1app.applicationcore.facade;
//
//import static org.hamcrest.Matchers.*;
//import static io.restassured.RestAssured.*;
//
//import io.restassured.RestAssured;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.http.HttpStatus;
//import se1app.applicationcore.Application;
//import se1app.applicationcore.accountcomponent.Account;
//import se1app.applicationcore.accountcomponent.AccountNumberType;
//import se1app.applicationcore.accountcomponent.AccountRepository;
//import se1app.applicationcore.branchcomponent.Branch;
//import se1app.applicationcore.branchcomponent.BranchNumberType;
//import se1app.applicationcore.branchcomponent.BranchRepository;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//public class ApplicationFacadeControllerTest {
//
//	@LocalServerPort
//	int port;
//
//	@Autowired
//	private AccountRepository accountRepository;
//
//	@Autowired
//	private BranchRepository branchRepository;
//	
//	Branch branch;
//	
//	private Account acc1;
//	private Account acc2;
//	private Account acc3;
//
//	@Before
//	public void setUp() throws Exception {
//		branch = branchRepository.findByBranchNumber(new BranchNumberType(1));
//		acc1 = new Account(new AccountNumberType(5), 0, branch);
//		acc2 = new Account(new AccountNumberType(6), 0, branch);
//		acc3 = new Account(new AccountNumberType(7), 0, branch);
//		accountRepository.save(acc1);
//		accountRepository.save(acc2);
//		accountRepository.save(acc3);
//
//		RestAssured.port = port;
//	}
//
//	@Test
//	public void testGetSingleSuccess() {
//		int mickeyNumber = acc1.getAccountNumber().getInt();
//
//		when().get("/customers/{id}", mickeyNumber).then().statusCode(HttpStatus.OK.value())
//				.body("accountnumber", is(mickeyNumber));
//	}
//
//	@Test
//	public void testGetSingleFail() {
//		Integer mickeyId = Integer.MAX_VALUE;
//
//		when().get("/customers/{id}", mickeyId).then().statusCode(HttpStatus.NOT_FOUND.value());
//	}
//
//	@Test
//	public void testGetAllSuccess() {
//		when().get("/accounts").then().statusCode(HttpStatus.OK.value()).body("accountNumber",
//				hasItems(new AccountNumberType(1),new AccountNumberType(2)));
//	}
//
//	@Test
//	public void testCreateSuccess() throws Exception {
//	
//		given().contentType("application/json").body(5).expect().statusCode(HttpStatus.CREATED.value()).when()
//				.post("/register");
//	}
//
//	@Test
//	public void testBookSuccess() {
//
//		given().
//			contentType("application/json").
//			body(100).
//			expect().
//			statusCode(HttpStatus.ACCEPTED.value())
//		.when()
//			.post("/transactions");
//
//	}
//
//}