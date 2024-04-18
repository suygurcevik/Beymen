package Step;

import Page.HomePage;
import Utilities.Log;
import base.Driver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.time.Duration;
import java.util.Random;

import java.io.IOException;





public class HomePageSteps extends HomePage {



    public static void enterKeyCheckbox(WebElement element) {
        clickElement(element);
        element.sendKeys(Keys.ENTER);
        LOGGER.info("ENTER tuşuna tıklandı.");
    }

    public static void navigateToSpesificURL(String url) {
        Driver.getDriver().navigate().to(url);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        Log.pass("Application launched! URL: " + url);
    }

    public static void closeRejectAllCookiesBar() {
        Log.pass("Çerezler info barında 'Tüm Çerezleri Reddet' butonuna basılır ve popup kapatılır");
        clickElement(btnRejectAllCookies);
    }

    public static void clickElement(WebElement webElement) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void sendKeys(WebElement  webElement, String text ) {
        webElement.sendKeys(text);
    }


    public static void elementVisible(WebElement element,int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            LOGGER.info(element + "is visiable.");

        } catch (Exception ex) {
            Log.assertfailWithLogging(element + " is not visiable");
        }
    }



    public static String readExcelSheet(Integer i, Integer j) throws IOException, InvalidFormatException {
        OPCPackage fis = OPCPackage.open(new File("product.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(j);
        return cell.getStringCellValue();
    }




    public static void chooseRandomElement() {
        LOGGER.info("Rastgele Bir Ürünü Sepete Ekler");
        Random random = new Random();
        int index = random.nextInt(productList.size());
        productList.get(index).click();
    }
        public static void getProductBasketPrice() {
            String productBasketPrices = productBasketPrice.getText();
            LOGGER.info("Sepet sayfasındaki fiyat: " + productBasketPrices);
        }


    public static void chooseProductPrice() {
        String productPagePrice =  productAmount.getText();
        LOGGER.info("Ürün sayfasındaki fiyat: " + productPagePrice);
    }

    public static void priceEqualControl() {
        String productBasketPrices = productBasketPrice.getText();
        LOGGER.info("Ürün sayfasındaki fiyat: " + productBasketPrice);
        Assert.assertNotEquals(productBasketPrices, productPagePrice, "Ürün detay ile ürün sepet fiyatları farklı.");
        LOGGER.info("Ürün sayfasındaki fiyat ile sepet sayfasındaki fiyat eşittir.");
    }


    public static void getText(WebElement element){
        Log.info("Elementin texti alınıyor");
        String text = element.getText();

    }

    public static void productInformationToTxtFile() {


        FileWriter fw = null;
        String path = "src/test/java/ProductDetails.txt";
        try {
            fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Price :" + productNameAtProductPage.getText());
            pw.println("Product :" +productNameAtProductPage.getText());
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public static void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



      public static void searchAndWriteProductFromExcel(String filePath, int row, int column) throws IOException {
        String searchData = getDataFromSheet(filePath, row, column);
        sendKeysLikeHuman(productButton,searchData);
    }

        public static String getDataFromSheet(String xlsxPath, int rowNum, int colNum) throws IOException {
            FileInputStream excelFile = new FileInputStream(new File(xlsxPath));
            Workbook workbook = new XSSFWorkbook(excelFile);

            try {
                Sheet datatypeSheet = workbook.getSheetAt(0);


                if (rowNum < 1 || colNum < 1) {
                    return "Invalid row or column number.";
                }

                Row currentRow = datatypeSheet.getRow(rowNum - 1);

                if (currentRow == null) {
                    return "Specified row is not available.";
                }

                Cell currentCell = currentRow.getCell(colNum - 1);

                if (currentCell == null) {
                    return "Specified column not available.";
                }

                return currentCell.getStringCellValue();
            } finally {
                workbook.close();
                excelFile.close();
            }





        }
            public static void sendKeysLikeHuman(WebElement element, String text) {
                Random r = new Random();
                try {
                    for (int i = 0; i < text.length(); i++) {
                        Thread.sleep((int) (r.nextGaussian() * 15 + 300));
                        String s = new StringBuilder().append(text.charAt(i)).toString();
                        element.sendKeys(s);

                    }
                } catch (Exception e) {
                    Log.assertfailWithLogging(element + " sending keys on the element could not be performed");
                }
            }
        }
























