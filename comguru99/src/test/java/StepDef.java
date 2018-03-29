import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertTrue;

public class StepDef {

   public static WebDriver driver;

   @Before
   public void startBrowser(){
       WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
   }

   @After
   public void stopBrowser(){
       driver.quit();
   }
    @Given("^as a User I am on HomePage$")
    public void as_a_User_I_am_on_HomePage() {

        driver.get("http://newtours.demoaut.com/");
    }

    @When("^I enter Username as \"([^\"]*)\"$")
    public void i_enter_Username_as(String arg1) {
       driver.findElement(By.name("userName")).sendKeys(arg1);

    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void i_enter_password_as(String arg1) {
        driver.findElement(By.name("password")).sendKeys(arg1);


    }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String arg1) {
        driver.findElement(By.name("login")).click();



    }

    @Then("^I can view \"([^\"]*)\" page$")
    public void i_can_view_page(String arg1){

        String expected=driver.getCurrentUrl();
        System.out.println(expected);
       // assertThat(expected,endsWith("9fb"));
        assertThat(expected,startsWith("http://newtours"));
    }




    @Given("^as a User I am on Flight Search Page$")
    public void as_a_User_I_am_on_Flight_Search_Page(){
        driver.get("http://newtours.demoaut.com/");
        this.i_enter_Username_as("eastham");
        this.i_enter_password_as("eastham");
        this.i_click_on("Sign-On");

    }




    @When("^I select journey type \"([^\"]*)\"$")
    public void i_select_journey_type(String arg1){
        List <WebElement> elements= driver.findElements(By.name("tripType"));
        for (WebElement element : elements){
            if(element.getText().equalsIgnoreCase(arg1)){
                element.click();
                break;
            }
        }

    }

    @When("^I select passengers \"([^\"]*)\"$")
    public void i_select_passengers(String arg1) {
       WebElement passenger=driver.findElement(By.name("passCount"));
        Select selectpassenger=new Select(passenger);
        selectpassenger.selectByValue(arg1);

    }

    @When("^i select  Departing From \"([^\"]*)\"$")
    public void i_select_Departing_From(String arg1) {
        WebElement elements = driver.findElement(By.name("fromPort"));
        Select selectPort= new Select(elements);
        selectPort.selectByValue(arg1);


    }

    @When("^I select Arriving In> \"([^\"]*)\"$")
    public void i_select_Arriving_In(String arg1) {
        WebElement elements=driver.findElement(By.name("toPort"));
        Select selectDesPort= new Select(elements);
        selectDesPort.selectByValue(arg1);
    }

    @When("^I select Service Class \"([^\"]*)\"$")
    public void i_select_Service_Class(String arg1) {
        List<WebElement> elements=driver.findElements(By.name("servClass"));
        for(WebElement ele4 :elements){
            if(ele4.getText().equalsIgnoreCase(arg1)){
                ele4.click();
                break;
            }
        }

    }

    @When("^I click on CONTINUE$")
    public void i_click_on_CONTINUE() {
        driver.findElement(By.name("findFlights")).click();


    }

    @When("^I can view \"([^\"]*)\"$")
    public void i_can_view(String arg1){

       //String actual=driver.findElement(By.cssSelector(".title>font>b>font")).getText();

       //Assert.assertTrue(actual.contains("Depart"));
    }

    @When("^i click continue$")
    public void i_click_continue(){
    driver.findElement(By.name("reserveFlights")).click();
    }

    @When("^i should navigate to book flight page to get the ticket$")
    public void i_should_navigate_to_book_flight_page_to_get_the_ticket() {
   //String actual=driver.findElement(By.linkText("     Total Price (including taxes):")).getText();
        //assertTrue(actual.contains("Total Price"));
   }

    @When("^i enter customer firstname \"([^\"]*)\"$")
    public void i_enter_customer_firstname(String firstname){

        driver.findElement(By.name("passFirst0")).sendKeys(firstname);
    }

    @When("^i enter customer lastname \"([^\"]*)\"$")
    public void i_enter_customer_lastname(String lastname) {
       driver.findElement(By.name("passLast0")).sendKeys(lastname);
    }

    @When("^i enter customer card number \"([^\"]*)\"$")
    public void i_enter_customer_card_number(String cardnumber){
       driver.findElement(By.name("creditnumber")).sendKeys(cardnumber);
    }

    @When("^i enter customer address \"([^\"]*)\"$")
    public void i_enter_customer_address(String address) {
       driver.findElement(By.name("billAddress1")).sendKeys(address);
    }

    @When("^i enter customer city \"([^\"]*)\"$")
    public void i_enter_customer_city(String city) {
        driver.findElement(By.name("billCity")).sendKeys(city);
    }

    @When("^i enter customer postal code \"([^\"]*)\"$")
    public void i_enter_customer_postal_code(String postcode){
        driver.findElement(By.name("billZip")).sendKeys(postcode);
    }

    @When("^i select customer country \"([^\"]*)\"$")
    public void i_select_customer_country(String billcountry){
       Select country= new Select(driver.findElement(By.name("billCountry")));
       country.selectByVisibleText(billcountry);
        driver.findElement(By.name("ticketLess")).click();
        driver.findElement(By.name("delAddress1")).clear();
        driver.findElement(By.name("delCity")).clear();
        driver.findElement(By.name("delState")).clear();
        driver.findElement(By.name("delZip")).clear();
    }

    @When("^i click on secure purchase$")
    public void i_click_on_secure_purchase() {

       driver.findElement(By.name("buyFlights")).click();

    }

    @Then("^i should navigate to \"([^\"]*)\"$")
    public void i_should_navigate_to(String arg1) throws IOException{
       String actual=driver.findElement(By.cssSelector(".frame_header_info>b>font")).getText();
        assertThat(actual,containsString(arg1));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\temp\\screenshot.png"));

    }

}
