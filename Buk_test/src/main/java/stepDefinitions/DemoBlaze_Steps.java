package stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomeElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DemoBlaze_Steps extends BasePage {

        HomeElements elements = new HomeElements();

        public DemoBlaze_Steps() {
            super(driver);
        }
        private List<String> expectedBrands;


        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
            driver.manage().window().maximize();
        }


        @Given("I navigate to the DemoBlaze main page")
        public void i_navigate_to_the_demo_blaze_main_page() {
            navigateTo("https://www.demoblaze.com/index.html");
        }

        @When("I click on the laptops category link")
        public void i_click_on_the_laptops_category_link()  {
            goToLinkText("Laptops");
        }

        @Then("I should see the correct products of laptops category")
        public void i_should_see_the_correct_products_of_laptops_category() {
            expectedBrands = new ArrayList<>();
            expectedBrands.add("Sony");
            expectedBrands.add("MacBook");
            expectedBrands.add("Dell");

            for (String brand : expectedBrands) {
                WebElement productElement = driver.findElement(By.xpath("//a[contains(text(), '" + brand + "')]"));
                Assert.isTrue(productElement.isDisplayed(), "Product " + brand + " is not displayed");
            }

            waitBetweenSteps();

        }

        @Then("I click on the product")
        public void i_click_on_the_product()  {
            By id_selector = elements.getSelector("product_id");
            clickElement(id_selector);
            waitBetweenSteps();
        }

        @Then("I click in Add to cart")
        public void i_click_in_add_to_cart()  {
            By add_selector = elements.getSelector("add_button");
            clickElement(add_selector);
        }

        @Given("I navigate to the DemoBlaze cart page")
        public void i_navigate_to_the_demo_blaze_cart_page() {
            navigateTo("https://www.demoblaze.com/cart.html");
        }

        @When("I click on the place order button")
        public void i_click_on_the_place_order_button() {
            By selector = elements.getSelector("order_button");
            clickElement(selector);
        }

        @Then("I complete all fills in the form")
        public void i_complete_all_fills_in_the_form(List<Map<String, String>> contactFormData) {
            for (Map<String, String> data : contactFormData) {
                By input = elements.getSelector(data.get("input"));
                String value = data.get("value");
                write(input, value);
            }
            waitBetweenSteps();
        }

        @Then("I click on the purchase button")
        public void i_click_on_the_purchase_button()  {
            By selector = elements.getSelector("purchase_button");
            clickElement(selector);
            waitBetweenSteps();
        }


        @When("I click on the contact link")
        public void i_click_on_the_contact_link() {
            goToLinkText("Contact");
        }

        @Then("I click on the send message")
        public void i_click_on_the_send_message()  {
            By send_selector = elements.getSelector("send_button");
            clickElement(send_selector);
        }

        @Then("I should be presented with a successful contact submission message and accept")
        public void i_should_be_presented_with_a_successful_contact_submission_message_and_accept()  {
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            if (alertMessage.contains("Thanks for the message!!")) {
                alert.accept();
            } else {
                System.out.println("Contact submission message is not presented.");
            }
         waitBetweenSteps();
        }

        @After
        public void afterAll() {
            driver.quit();
            System.out.println("===== That's all folks =====");
        }


}
