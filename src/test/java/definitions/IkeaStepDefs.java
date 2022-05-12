package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.IkeaCartPage;
import pages.IkeaHomePage;
import pages.IkeaProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class IkeaStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        System.out.println("iGoToHomePage");
        new IkeaHomePage().open();
    }

    @Then("I go to input box {string}")
    public void iGoToInputBox(String inputBox) {
        System.out.println("iGoToInputBox");
        new IkeaHomePage().searchInput(inputBox);
    }

    @And("I search for {string} in store")
    public void iSearchForInStore(String text) {
        System.out.println("iSearchForSofaInStore");
        new IkeaHomePage().searchBox(text);
    }

    @And("On product page I find {string} item")
    public void onProductPageIFindItem(String text) {
        System.out.println("iFindFirsItem");
        new IkeaProductsPage().getFirstItem(text);
    }

    @Then("I add item {string} to cart")
    public void iAddItemToCart(String text) {
        System.out.println("iAddItemToCart");
        new IkeaProductsPage().getItemToCart();
    }

    @Then("I search for {string} at store")
    public void iSearchForAtStore(String text) {
        System.out.println("iSearchForTableAtStore");
    }

    @And("On page I find {string} item")
    public void onPageIFindItem(String text) {
        System.out.println("iFindThirdItem");
        new IkeaProductsPage().getThirdItem(text);
    }

    @Then("I open cart")
    public void iOpenCart() {
        System.out.println("iOpenCart");
        new IkeaCartPage().getCartButton();
    }

    @And("I validate that two items in cart")
    public void iValidateThatTwoItemsInCart() {
        System.out.println("iValidateTwoItemsInCart");
        IkeaCartPage cartPage = new  IkeaCartPage();
        String actualResultText = cartPage.getCartListResult();

        System.out.println("iValidateUppland");
        assertThat(actualResultText).containsIgnoringCase(("uppland"));

        System.out.println("iValidateJokkmokk");
        assertThat(actualResultText).containsIgnoringCase(("jokkmokk"));

        System.out.println("iDoneValidate");
    }


    @Then("I enter discount code to apply")
    public void iEnterDiscountCodeToApply() {
        System.out.println("iEnterDiscountCodeToApply");
    }

    @Then("I validate that {string} but error message is displayed")
    public void iValidateThatButErrorMessageIsDisplayed(String text) {
        System.out.println("iValidateThatButErrorMessageIsDisplayed");
    }
}
