package mrBuggy2;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    LoginPage loginPage;

    @After
    public void closeBrowser() {
        loginPage.closeBrowser();
    }

    @Given("I go to login page")
    public void iGoToLoginPage() {
        loginPage = new LoginPage();
        loginPage.goTo();
    }

    @When("I enter e-mail address {string}")
    public void iEnterUsername(String email) {
        loginPage.typeLogin(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.typePassword(password);
    }

    @And("I click button Login")
    public void iClickButtonLogin() {
        loginPage.submitButtonLogin();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        loginPage.verifyIsLoggedIn();
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        loginPage.verifyIsNotLoggedIn();
    }
}


