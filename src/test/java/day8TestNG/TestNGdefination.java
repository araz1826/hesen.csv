package day8TestNG;

public class TestNGdefination {

        /*
    TestNG:  is a testing framwork
             Centralized contoller
             Batch Execution
             Optional Execution

    TestNG: it is unit testing, functional testing, end to end testing tool.  we use testNG along with selenium webdriver to
          develop UI test automation scripts. testNg was inspried by Junit(another very popular unit testing framwork)

          TestNG has:
             annonations for more complex tests. like @beforeSuite, @beforeClass @beforeMethod, @test etcc..
             -has in-build HTML report
             -allows to group tests
             -allows to do data driven testing

Assertios:  assertTrue(true),  assertTrue(1==1), assertTrue(element.isDisplayed())
    these methods overloaded, it comes from assert class.
    For all test cases you have to have assertions to verify. it is as expected

Annotations: they change thebehavior of the method. ex. when you put test annotation it make the method runnable. that makes
                 the method as test method. beside test all of them have before after.
                 You do not have to write all before and after it is optinal, but test.
                 @BeforeClass. this method will be run before all methods and tests  Webdriver driver=new ChromeDriver
                 @AfterClass, after methods and tests    driver.quit
                 @Before Method   driver.get(google.com)
                 @AfterMethod runs after every test  driver.close

 INTERVIEW: you have 500 test cases and you can only run 40 of them for smoke testing? how will you do that?
      So, we use xml runners to create suite of tests and we already have xml runner fo the smoke test. In y framework,
      we group test scripts based on modules. So for every module we have a corresponding package with test scripts.

     */
}
