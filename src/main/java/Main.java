import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.getenv("PATH"));
    System.out.println(System.getenv("HOME"));
  //  System.out.println(System.getenv(""));

    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
   // File pathBinary = new File("src/main/resources/firefox");
  //  FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
   // DesiredCapabilities desired = new DesiredCapabilities();
    FirefoxOptions options = new FirefoxOptions();
   // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
    WebDriver driver = new FirefoxDriver(options);
    driver.get("https://funko.fandom.com/wiki/Pop!_Marvel");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U")));

    WebElement aceptar = driver.findElement(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U"));
    aceptar.click();

    //WebElement wikiTable = driver.findElement(new By.ByClassName("wikitable"));
    List<WebElement> wikiTables = driver.findElements(new By.ByClassName("wikitable"));

    for (WebElement wikitable : wikiTables) {
      List<WebElement> filasWikiTable = wikitable.findElements(new By.ByTagName("tr"));
      String image = null;
      for (WebElement fila : filasWikiTable) {
        try {

          System.out.println(fila.getText());
          image = fila.findElement(new By.ByClassName("image")).getAttribute("href");

          System.out.println(image);

        }catch (NoSuchElementException e) {
          System.out.println("Este Funko todabía no tiene imagen");

        }
        try {
          BufferedWriter outputStream = new BufferedWriter(new FileWriter(new File("src/listaFunkos.csv"),true));

          outputStream.write(fila.getText()+ "\n" + image + "\n");

          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }

   /* List<WebElement> filas = driver.findElements(new By.ByTagName("tr"));
    String image = null;
    for (WebElement fila : filas) {
      try {

        System.out.println(fila.getText());
        image = fila.findElement(new By.ByClassName("image")).getAttribute("href");

        System.out.println(image);

      }catch (NoSuchElementException e) {
        System.out.println("Este Funko todabía no tiene imagen");

      }
      try {
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(new File("src/listaFunkos.csv"),true));
        
          outputStream.write(fila.getText()+ "\n" + image + "\n");

        outputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }*/


    }



  }

}
