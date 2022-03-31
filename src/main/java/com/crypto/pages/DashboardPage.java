package com.crypto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.crypto.steps.TestBase.getDriver;

public class DashboardPage {

    private WebDriver ge;

    public DashboardPage(){
        PageFactory.initElements(getDriver(),this);
    }
    Actions action = new Actions(getDriver());

    @FindBy(css = "div:nth-child(4) span")
    public WebElement demoButton;

    @FindBy(css = "#name")
    public WebElement name;
    @FindBy(css = "#lastName")
    public WebElement lastName;
    @FindBy(css = "#email")
    public WebElement email;
    @FindBy(css = "#phoneInput")
    public WebElement phone;
    @FindBy(css = "div.row.avaInputRow.gdpr-cnt label")
    public WebElement buttonTc;
    @FindBy(css = "#avasFormWidget > div.form-reg > div.row.avaInputRow.form-action")
    public WebElement createAccoutButton;

    @FindBy(css = "div:nth-child(17) iframe")
    public WebElement iframe0;

    @FindBy(css = " div:nth-child(1) .row > h3")
    public WebElement thankYouLabel;

    @FindBy(css = "div:nth-child(1) .row  button")
    public WebElement closeButton;

    @FindBy(linkText = "Favorites")
    public WebElement favorites;

    @FindBy(css = "div:nth-child(1) > div:nth-child(5) > a:nth-child(3)")
    public WebElement crypto;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> BCHUSD;

    @FindBy(xpath = "// span[text()='Skip Tutorial']")
    public WebElement skipTutorial;

    @FindBy(xpath = "//div[@class=\"workspace_bottom__1hmPC\"]")
    public WebElement cryptoVisible;

    @FindBy(css = "tr:nth-child(1) td:nth-child(6) > div > div.watchlist-entity\\.component_favCell__1pYE6")
    public WebElement fav;

    @FindBy(css = "div[class=\"watchlist-entity.component_favCell__1pYE6\"]")
    public List<WebElement> addFav;

    @FindBy(css = "table__row-propstr[data-qa=\"table__row-props\"]")
    public List<WebElement> favList;

    @FindBy(xpath = "(//div[@data-qa=\"watchlist-entity__favorite-icon-cell-fav\"])[1]")
    public WebElement favElement;

    @FindBy(xpath = "//tbody/tr[@data-qa='table__row-props']//td[6]/div[1]/div[2]")
    public List<WebElement> deleteFav;

    @FindBy(css = "div[class=\"empty-category_emptyCategory__container__3HstQ\"]")
    public WebElement emptyContainer;

    @FindBy(linkText = "AUDCAD")
    public WebElement linkAUDCAD;

    @FindBy(xpath = "//tbody/tr[1]/td[1]//span")
    public WebElement firstCoin;

    @FindBy(xpath = "//tbody/tr[2]/td[1]//span")
    public WebElement secondCoin;

    @FindBy(xpath = "//tbody/tr[3]/td[1]//span")
    public WebElement thirdCoin;

    @FindBy(xpath = "//tbody/tr[4]/td[1]//span")
    public WebElement fourthCoin;

    @FindBy(xpath = "//tbody/tr[5]/td[1]//span")
    public WebElement fifthCoin;

    @FindBy(xpath = "//tr// span[text()='AUDCHF']/../../../td[6]//div[@class=\"watchlist-entity.component_favCell__1pYE6\"]")
    public WebElement coinAUDCHFfav;

    @FindBy(xpath = "//tr// span[text()='AUDCHF']")
    public WebElement coinAUDCHF;

    @FindBy(xpath = "//tr")
    public List<WebElement> rowList;

    @FindBy(xpath = "//tr// span[text()='AUDJPY']/../../../td[6]//div[@class=\"watchlist-entity.component_favCell__1pYE6\"]")
    public WebElement coinAUDJPYfav;
    @FindBy(xpath = "//tr// span[text()='AUDJPY']")
    public WebElement coinAUDJPY;



    public void clearFavorites(){

        favList.stream().forEach(e->{

          e = new WebDriverWait(getDriver(),10)
                    .until(ExpectedConditions.visibilityOf(emptyContainer));

            action.moveToElement(e).click().perform();
        });
    }

    public void addFav(WebElement element){

        action.click(element).perform();
        getDriver().navigate().refresh();

    }


}
