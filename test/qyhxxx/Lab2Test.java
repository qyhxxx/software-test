package qyhxxx;

import static org.junit.Assert.*;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Lab2Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        baseUrl = "http://121.193.130.195:8800";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testStudent() throws Exception {
        driver.get(baseUrl + "/");

        String filePath = System.getProperty("user.dir") + "/src/resources/data/软件测试名单.xlsx";
        InputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        for(int i = 2; i <= rows; i++) {
            sheet.getRow(i).getCell(1).setCellType(CellType.STRING);
            String id = sheet.getRow(i).getCell(1).getStringCellValue();
            String password = id.substring(4);
            String name = sheet.getRow(i).getCell(2).getStringCellValue();
            String git = sheet.getRow(i).getCell(3).getStringCellValue();

            driver.findElement(By.name("id")).clear();
            driver.findElement(By.name("id")).sendKeys(id);
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.id("btn_login")).click();

            assertEquals(id, driver.findElement(By.id("student-id")).getText());
            assertEquals(name, driver.findElement(By.id("student-name")).getText());
            assertEquals(git, driver.findElement(By.id("student-git")).getText());

            driver.findElement(By.id("btn_logout")).click();
            driver.findElement(By.id("btn_return")).click();
        }
    }

//    @After
//    public void tearDown() throws Exception {
////    driver.quit();
////    String verificationErrorString = verificationErrors.toString();
////    if (!"".equals(verificationErrorString)) {
////      fail(verificationErrorString);
////    }
//    }

//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = ((Alert) alert).getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
}
