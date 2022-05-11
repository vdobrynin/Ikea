package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.IkeaCartPage;
import pages.IkeaHomePage;
import pages.IkeaProductsPage;

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
    public void iSearchForInStore(String sofa) {
        System.out.println("iSearchForSofa");
        new IkeaHomePage().searchBox(sofa);
    }

    @And("On product page I find {string} item")
    public void onProductPageIFindItem(String text) {
        System.out.println("iFindFirstSofa");
        new IkeaProductsPage().getFirstItem(text);
    }

    @Then("I add item {string} to cart")
    public void iAddItemToCart(String text) {
        System.out.println("iAddSofaToCart");
        new IkeaProductsPage().getItemToCart();
    }

    @Then("I open cart and validate two items in cart")
    public void iOpenCartAndValidateTwoItemsInCart() {
        System.out.println("iOpenCartAndValidateTwoItemsInCart");
        new IkeaCartPage().getCartButton();
    }
}
