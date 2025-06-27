package Web_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeTest {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        driver.get("https://automationexercise.com/");
	        driver.manage().window().maximize();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
	        
	        Thread.sleep(5000);
	        // Step 3: Fill signup form with your custom email
            String yourEmail = "Sabbir38@gmail.com"; // 👈 CHANGE THIS
            driver.findElement(By.name("name")).sendKeys("Sabbir"); // 👈 CHANGE NAME
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(yourEmail);
            driver.findElement(By.xpath("//button[text()='Signup']")).click();
            
            Thread.sleep(5000);
            
         // Step 5: Fill full form manually using sendKeys
            driver.findElement(By.id("id_gender1")).click(); // Mr.
            driver.findElement(By.id("password")).sendKeys("haque121122@#"); // 👈 Change password
            new Select(driver.findElement(By.id("days"))).selectByValue("12");
            new Select(driver.findElement(By.id("months"))).selectByValue("4");
            new Select(driver.findElement(By.id("years"))).selectByValue("1994");

            driver.findElement(By.id("first_name")).sendKeys("Syed");
            driver.findElement(By.id("last_name")).sendKeys("Haque");
            driver.findElement(By.id("address1")).sendKeys("Nikunjo 2");
            new Select(driver.findElement(By.id("country"))).selectByVisibleText("Canada");
            driver.findElement(By.id("state")).sendKeys("Dhaka");
            driver.findElement(By.id("city")).sendKeys("Dhaka");
            driver.findElement(By.id("zipcode")).sendKeys("1216");
            driver.findElement(By.id("mobile_number")).sendKeys("1983182443");
            
            Thread.sleep(3000);

            // Step 6: Create account
            driver.findElement(By.xpath("//button[text()='Create Account']")).click();
            Thread.sleep(5000);
            
         // Step 7: Assert "ACCOUNT CREATED!" is visible
         // Wait for "ACCOUNT CREATED!" message
         // ✅ 1. Check if the success message is present
            boolean isSuccess = driver.getPageSource().contains("Congratulations! Your new account has been successfully created!");
            if (isSuccess) {
                System.out.println("✅ Account creation confirmation message found.");
            } else {
                System.out.println("❌ Account creation message not found.");
                return;
            }

            // ✅ 2. Click the Continue button using JavaScript to avoid intercept issues
            WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Continue']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);

            System.out.println("➡️ Continue button clicked successfully.");
            
            
            
         // Step 1: Click on "Products" link
            Thread.sleep(3000);
            WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Products']")));
            productsLink.click();

            // Step 2: Search for "Shirt"
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
            searchBox.sendKeys("Shirt");
            driver.findElement(By.id("submit_search")).click();
            
         // Step 4: Add first shirt to cart
            WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Add to cart'])[1]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
          
         
         // Step 5: Click "View Cart"
         // Wait for the modal to appear first
           
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

            // Click the actual "View Cart" link by XPath
            WebElement viewCartBtn = driver.findElement(By.xpath("//u[text()='View Cart']/parent::a"));
            viewCartBtn.click();
            System.out.println("🛒 Clicked 'View Cart' successfully.");
            
            
            Thread.sleep(6000);

          // Click "Proceed To Checkout" button
            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[text()='Proceed To Checkout']")));
            checkoutBtn.click();
            System.out.println("➡️ Proceeded to checkout.");

            // Optional: Confirm checkout page is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(text(),'Address Details')]")));
            System.out.println("✅ Checkout page loaded successfully!");
            
            // place order
            driver.findElement(By.linkText("Place Order")).click();
            System.out.println("🛒 'Place Order' clicked!");
            
            
            //payment 

         // Fill out the payment form
         driver.findElement(By.name("name_on_card")).sendKeys("Syed Haque");
         driver.findElement(By.name("card_number")).sendKeys("4111111111111111"); // dummy Visa number
         driver.findElement(By.name("cvc")).sendKeys("123");
         driver.findElement(By.name("expiry_month")).sendKeys("12");
         driver.findElement(By.name("expiry_year")).sendKeys("2026");

         // Click "Pay and Confirm Order"
         driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();
         System.out.println("💳 Payment submitted.");
         
         Thread.sleep(3000);
         driver.findElement(By.linkText("Continue")).click();
         System.out.println("➡️ Clicked 'Continue' after placing order.");
         Thread.sleep(3000);
         driver.findElement(By.linkText("Logout")).click();
         System.out.println("🚪 Logged out successfully.");


            
	}

}
