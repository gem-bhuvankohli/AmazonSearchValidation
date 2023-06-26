//        **********************VALIDATING AMAZON SEARCH**********************

package org.example;
//Package Imports
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;



//  Main Class
public class Main {
    public static void main(String[] args) {

//      Input User Search
        System.out.println("Search Amazon.in");
        System.out.println("Enter your search here!");
        Scanner user_input = new Scanner(System.in);
        String search_input = user_input.nextLine();

//      Change web driver according to your browser. Here Chrome browser has been used.
        WebDriver driver = new ChromeDriver();

    try {

//      Opening Amazon.in
        driver.get("https://www.amazon.in/");

//      Maximize window size
        driver.manage().window().maximize();

//      Searching amazon.in for the entered user input
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
                .sendKeys(search_input + Keys.ENTER);

/*     Storing amazon.in "results for" string to validate whether the
       search result is in accordance with the user search input*/
        String search_result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();

//      Storing first search result's title
        String first_result_title = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();

//      Closing driver window
        driver.close();

//      Validating whether the results shown by Amazon.in match the user input
        if (search_result.contains(search_input)) {
            System.out.println("Search results successfully validated!");
//          Printing first search result's title
            System.out.println("First result title:\n"+first_result_title+"\n");
        } else {
            System.out.println("Incorrect results");
        }
        System.out.println("Thank You!");
    }
    catch (Exception e){
        e.printStackTrace();
    }

    }
}

//        **********************THANK YOU**********************

/*CREDITS:
    Bhuvan Kohli
    bhuvan.kohli@geminisolutions.com
*/
