package com.crypto.steps;

import com.crypto.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.core.Is.is;

public class StepDefs extends TestBase {

    @Given("user landed webpage")
    public void user_landed_webpage() throws InterruptedException {


        getDriver().get("https://myvip.avatrade.com/?wtrelogin=1");

        try {
            dashboardPage.demoButton.click();
        } catch (StaleElementReferenceException ex) {
            dashboardPage.demoButton.click();
        }

        dashboardPage.name.sendKeys(getUser().getFirstname());
        dashboardPage.lastName.sendKeys(getUser().getLastname());
        dashboardPage.email.sendKeys(getUser().getEmail());
        dashboardPage.phone.sendKeys(getUser().getPhone());
        Utils.scrollDown();
        Utils.scrollDown();

        action.moveToElement(dashboardPage.buttonTc).click().build().perform();

        action.moveToElement(dashboardPage.createAccoutButton).click().build().perform();


        getDriver().switchTo().frame(dashboardPage.iframe0);


        Assert.assertTrue("Label doesn't contain Thank you " , dashboardPage.thankYouLabel.getText().contains("Thank you"));

        new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(dashboardPage.closeButton));
        action.moveToElement(dashboardPage.closeButton).click().perform();

        getDriver().switchTo().defaultContent();

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(dashboardPage.skipTutorial));
        element.click();


    }

    @Given("user wait for action")
    public void user_wait_for_action() throws InterruptedException {

    }

    @Given("user click stars to add favorites")
    public void user_click_stars_to_add_favorites() {


        action.click(dashboardPage.favorites).perform();

        action.click(dashboardPage.crypto).perform();

        // Adding 1'st element to fav
        dashboardPage.addFav(dashboardPage.addFav.get(0));
        // Adding 2'nd element to fav
        dashboardPage.addFav(dashboardPage.addFav.get(1));
        // Adding 3'rd element to fav
        dashboardPage.addFav(dashboardPage.addFav.get(2));
        // Adding 4'th element to fav
        dashboardPage.addFav(dashboardPage.addFav.get(3));
        // Adding 5'th element to fav
        dashboardPage.addFav(dashboardPage.addFav.get(4));

        action.click(dashboardPage.favorites).perform();

    }

    @When("user at favorites page")
    public void user_at_favorites_page() {
        action.click(dashboardPage.favorites).perform();
    }

    @Then("papers are added to favorites")
    public void papers_are_added_to_favorites() {

        Assert.assertTrue(dashboardPage.firstCoin.isDisplayed());
        Assert.assertTrue(dashboardPage.secondCoin.isDisplayed());
        Assert.assertTrue(dashboardPage.thirdCoin.isDisplayed());
        Assert.assertTrue(dashboardPage.fourthCoin.isDisplayed());
        Assert.assertTrue(dashboardPage.fifthCoin.isDisplayed());
    }
    @When("user click stars to delete from favorites")
    public void user_click_stars_to_delete_from_favorites() {

        Assert.assertEquals(17,dashboardPage.rowList.size());

        action.click(dashboardPage.coinAUDCHFfav).perform();
        getDriver().navigate().refresh();
        action.click(dashboardPage.coinAUDJPYfav).perform();
        getDriver().navigate().refresh();

    }
    @Then("papers are deleted from favorites")
    public void papers_are_deleted_from_favorites() {
        Assert.assertEquals(15,dashboardPage.rowList.size());

    }


}