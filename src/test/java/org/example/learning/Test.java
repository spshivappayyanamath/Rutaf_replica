package org.example.learning;

import com.google.gson.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void test5(){

    }
    public static void test4() throws FileNotFoundException {
        FileReader reader = new FileReader(new File("\\Users\\DELL\\IdeaProjects\\Rutaf_Replica\\src\\test\\java\\org\\example\\learning\\test.json"));
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement=jsonParser.parse(reader);
//        System.out.println(jsonElement.toString());

        if(jsonElement.isJsonObject()){
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            System.out.println(jsonObject.toString());
            System.out.println(jsonObject.get("topping"));

            if(jsonObject.get("topping").isJsonArray()){
                JsonArray jsonArray = jsonObject.get("topping").getAsJsonArray();
                for (int i=0; i<jsonArray.size(); i++){
                    JsonObject jsonObject1 = jsonArray.get(i).getAsJsonObject();
                    System.out.println(jsonObject1.get("id")+" :: "+jsonObject1.get("type"));
                }


            }
        }


    }
    public static void test3(String input, String pattern){

    }
    public static void test2(){
        System.out.println(Pattern.matches("geeksforge*ks", "geeksforgeeks"));
        System.out.println(Pattern.matches("g*geeks*", "geeksfor"));

        String st ="₹ 6,710\n per adult";
        System.out.println(st.replaceAll("[₹\nper adult,]",""));

//        Pattern pattern =Pattern.compile("[^₹]");
//        Pattern pattern =Pattern.compile("[^₹][,][$per adult]");
//        Matcher matcher= pattern.matcher(st);
//        String op= matcher.pattern();
//        System.out.println(matcher.pattern());

    }
    public static void test1() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("taskkill /F /IM chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.makemytrip.com/");

        driver.findElement(By.xpath("//a[text() ='Search']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div/div[3]/button")));
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class ='listingCard  appendBottom5']/div[2]/div[2]/div/div/div")));

        List<WebElement> value= driver.findElements(By.xpath("//div[@class ='listingCard  appendBottom5']/div[2]/div[2]/div/div/div"));
        int arr[]= new int[value.size()];
        for (int i=0; i< value.size(); i++){
            int a=Integer.valueOf(value.get(i).getText().replaceAll("[₹\nper adult,]",""));
            System.out.println(value.get(i).getText());
            arr[i]=a;
            System.out.println(arr[i]+" :: "+a);
        }
        System.out.println(arr.length);
        Arrays.sort(arr);
        System.out.println(arr[0]+" :: "+arr[arr.length-1]);
        driver.close();
        driver.quit();

    }
    public static void main(String[] args) {

        try {
            test4();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//
//        try {
//            test1();
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
/*
        String str="$%@Ar76u09n Ku32m!ar";
//        Pattern pattern=[A-Z][a-z]

        String input="surus";
        char ch;
        String rev="";

        for(int i=input.length()-1; i>=0;){
            rev=rev+input.charAt(i);
            i--;
        }

        System.out.println(rev);
        if(input.equals(rev)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

        String arr[]={"Java","JavaScript","Python","JavaScript","C#","Java","C++","C++","C#"};
        HashSet<String> set = new HashSet<String>();
        for (int i=0; i< arr.length; i++){
            set.add(arr[i]);
        }
        System.out.println(set);



*/
    }
}

