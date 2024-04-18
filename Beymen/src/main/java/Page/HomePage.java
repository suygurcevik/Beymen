package Page;

import base.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    public HomePage() {
        PageFactory.initElements( Driver.getDriver(), this);
    }



    @FindBy(id = "onetrust-reject-all-handler")
    public static WebElement btnRejectAllCookies;
    @FindBy(id = "genderWomanButton")
    public static WebElement genderWoman;
    @FindBy(xpath = "(//*[@class='o-header__search--input'])[last()]")
    public static WebElement productButton;
    @FindBy(xpath = "//*[@class='o-header__search--close -hasButton']")
    public static WebElement deleteText;
    @FindBy(xpath = "//*[@class='col-sm-4 col-md-4 col-lg-4 col-xl-4 col-xxl-3 o-productList__itemWrapper']")
    public static List<WebElement>productList;
    @FindBy(id = "priceNew")
    public static WebElement productAmount;
    @FindBy(xpath = "//*[@class='o-header__userInfo--item bwi-cart-o -cart'] ")
    public static WebElement myBasket;
    @FindBy(xpath = "//*[@class='m-addBasketFavorite__basket btn']")
    public static WebElement addToBasket;
    @FindBy(xpath = "(//*[@class='m-orderSummary__value'])[1]")
    public static WebElement productBasketPrice;
    @FindBy(xpath = "//*[@class='m-orderSummary__value']")
    public static WebElement productPagePrice;
    @FindBy(xpath = "//*[@class='a-selectControl -small']")
    public static WebElement productPiece;
    @FindBy(xpath = "//option[@value='2']")
    public static WebElement twoProductQuantityChoice;
    @FindBy(xpath = " (//button[@id='removeCartItemBtn0-key-0'])[1]")
    public static WebElement deleteProducts;
    @FindBy(css = "div.o-header__search--wrapper > input.o-header__search--input")
    public static WebElement searchBar;
    @FindBy(css = "h1.o-productDetail__title > span")
    public static WebElement productNameAtProductPage;
    @FindBy(css = "ins#priceNew")
    public static WebElement productPriceAtProductPage ;
    @FindBy(xpath = "(//*[@class='m-variation__item'])[1]")
    public static WebElement sizeSelection;
    @FindBy(xpath = "//img[@alt='Beymen']")
    public static WebElement beymenLogo;
    @FindBy(id = "o-searchSuggestion__input")
    public static WebElement searchBars;




















}
