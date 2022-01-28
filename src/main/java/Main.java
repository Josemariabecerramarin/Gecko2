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
    /*for (WebElement wikitable : wikiTables)*/
    int contadortable = 1;
    int contadorfila = 1;
    int contadortotal = 0;
    for (;contadortable < wikiTables.size(); contadortable++) {

        if(contadortotal>=1000){
          break;
        }
        String image = null;
        String numero;
        String nombre;
        String año;
        String variante;
        String coleccion;


        for (;contadorfila < 101; contadorfila++) {
          if(contadorfila>100){
            contadorfila=1;
            contadortotal+=100;
            if(contadortotal>=1000){
              break;
            }
          }
          try {
            /*System.out.println(fila.getText());*/
            image = driver.findElement(new By.ByClassName("image")).getAttribute("href");
            numero = driver.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/th[1]")).getText();
            nombre = driver.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/th[2]")).getText();
            año = driver.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/td[2]")).getText();
            variante = driver.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/td[3]")).getText();
            coleccion = driver.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/td[4]")).getText();


            /*  System.out.println(image);*/
            System.out.println(numero);
            System.out.println(nombre);
            /*System.out.println(año);
            System.out.println(variante);
            System.out.println(coleccion);*/

          } catch (NoSuchElementException e) {
            System.out.println("Este Funko todavía no tiene imagen");

          }

        /* tipo = searchItem.findElement(new By.ByClassName("buy--type")).getText();
        precio = searchItem.findElement(new By.ByClassName("buy--price")).getText();
        imagen = searchItem.findElement(new By.ByTagName("img")).getAttribute("src");*/


          /*edicionColeccionistas.add(new EdicionColeccionista(nombre, tipo, precio, imagen));*/
        }


      System.out.println();
    }
    }


      /*try {
        List<WebElement> filasWikiTable = wikitable.findElements(new By.ByTagName("tr"));
        String image = null;
        String numero;
        String nombre;
        String año;
        String variante;
        String coleccion;
        contadortable++;

        for (WebElement filas : filasWikiTable) {
          try {

            *//*System.out.println(fila.getText());*//*
            image = filas.findElement(new By.ByClassName("image")).getAttribute("href");
            numero = filas.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/th[1]")).getText();
            nombre = filas.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/th[2]")).getText();
            año = filas.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/td[2]")).getText();
            variante = filas.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/td[3]")).getText();
            coleccion = filas.findElement(new By.ByXPath("//table["+contadortable+"]/tbody/tr["+contadorfila+"]/td[4]")).getText();


          *//*  System.out.println(image);*//*
            System.out.println(numero);
            System.out.println(nombre);
            *//*System.out.println(año);
            System.out.println(variante);
            System.out.println(coleccion);*//*
            contadorfila++;
            if(contadorfila>100){
              contadorfila=1;
            }
          } catch (NoSuchElementException e) {
            System.out.println("Este Funko todavía no tiene imagen");

          }

        *//* tipo = searchItem.findElement(new By.ByClassName("buy--type")).getText();
        precio = searchItem.findElement(new By.ByClassName("buy--price")).getText();
        imagen = searchItem.findElement(new By.ByTagName("img")).getAttribute("src");*//*


          *//*edicionColeccionistas.add(new EdicionColeccionista(nombre, tipo, precio, imagen));*//*
        }

      } catch(Exception ex){
        System.out.println("ya no hay mas");
        *//*System.out.println(searchItemEdiciones.size());*//*
      }
      System.out.println();
    }*/


    /*for (WebElement wikitable : wikiTables) {
      List<WebElement> filasWikiTable = wikitable.findElements(new By.ByTagName("tr"));
      String image = null;
      for (WebElement fila : filasWikiTable) {
        try {

          System.out.println(fila.getText());
          image = fila.findElement(new By.ByClassName("image")).getAttribute("href");

          System.out.println(image);

        }catch (NoSuchElementException e) {
          System.out.println("Este Funko todavía no tiene imagen");

        }*/
       /* try {
          BufferedWriter outputStream = new BufferedWriter(new FileWriter(new File("src/listaFunkos.csv"),true));
          outputStream.write(fila.getText()+ "\n" + image + "\n");
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }*/

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


