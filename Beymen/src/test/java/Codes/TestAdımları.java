package Codes;

import Step.HomePageSteps;
import Step.HomePageSteps;
import base.BaseTest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static Step.HomePageSteps.*;


public class TestAdımları extends BaseTest {


  @Test(description = "Beymen urline gitme")
  @Parameters(value = {"browser", "environment", "url"})

  public void beymenDeneme(@Optional("chrome") String browser, @Optional("prod") String environment, @Optional("") String url) throws IOException, InvalidFormatException {
    setupTest(browser);
    navigateToSpesificURL("https://www.beymen.com/");
    closeRejectAllCookiesBar();
    clickElement(genderWoman);
    elementVisible(beymenLogo,2);
    elementVisible(productButton,2);
    waitBySeconds(5);
    searchAndWriteProductFromExcel("./product.xlsx",  1, 1);
    clickElement(deleteText);
    waitBySeconds(5);
    searchAndWriteProductFromExcel("./product.xlsx",  1, 2);
    waitBySeconds(5);
    enterKeyCheckbox(searchBars);
    waitBySeconds(5);
    chooseRandomElement();
    waitBySeconds(5);
    chooseProductPrice();
    productInformationToTxtFile();
    clickElement(sizeSelection);
    waitBySeconds(2);
    clickElement(addToBasket);
    waitBySeconds(10);
    clickElement(myBasket);
    waitBySeconds(2);
    getProductBasketPrice();
    priceEqualControl();
    clickElement(productPiece);
    clickElement(twoProductQuantityChoice);
    clickElement(deleteProducts);
  }

}


