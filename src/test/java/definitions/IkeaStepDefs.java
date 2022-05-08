package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import pages.IkeaHomePage;
import pages.IkeaProductPage;

import static support.TestContest.getDriver;

public class IkeaStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        System.out.println("iGoToHomePage");
        new IkeaHomePage().open();
    }

    @Then("I go to input box {string}")
    public void iGoToInputBox(String inputBox) {
        System.out.println("In iGoToInputBox");
        new IkeaHomePage().searchInput(inputBox);
    }

    @And("I search for {string} in store")
    public void iSearchForInStore(String sofa) throws InterruptedException {
        System.out.println("iSearchForSofa");
        new IkeaHomePage().searchBox(sofa);
    }
}
