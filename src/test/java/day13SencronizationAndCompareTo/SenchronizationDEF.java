package day13SencronizationAndCompareTo;
/*
synocronizaton is a common issue in selenium webdriver to overcome this we use wait: why wait?
We do not know how much we need just guessing so this is not accurate, or less or more time is not good. ex: slow exe is measurable because it is
automation. can not slower than manuel. we need to get optimum
we sue Thread.sleep in selenium. this is one of the optimized solution. you can not put random waiing time, extar wait will be long
Thread.sleep is not java feature it is coming from java. but we use

Senchronization is One of the biggest issue in selenium webdriver. to relosve it, we have
-Thread.sleep  -- pause java prog. not coming from selenium coming from java
-implicit wait-- wait for element to be present in DOM. apply only once. works for find element auto.
-explicit wait--wait for specific element for specific condition
-fluent wait

(IMPLICIT is only for element is presence, EXPLICIT os more like visibility, clickibly, etcc...)
(implicit is general approach, Explicit wait is individual wait)
(implicit is we use once, explicit we can as much as we want it)

--Implicit: apply only once at the begining of the test execution. it works before findElement method automatically.
            If webdriver(your script) can not find an element in the DOM(html code) it waits for defined amount of time for the
            element to appear in the DOM. Once specified wait time is over and element is not found, it will throw NoSuchElementException
            Default impilict wait is 0(zero).
            Only try to look up for element in pecified period of time. if found faster , execution will be resumed

            how u apply?  driver.manage().timeouts().impilicitlyWait(time, time units)
            For ex:
            how u apply?  driver.manage().timeouts().impilicitlyWait(20, TimeUnits.SECONDS)
               -----that means webdriver will be waiting for any element up to 20 seconds

           us only once after driver.get().
           driver.manage().timeouts().impilicitlyWait(20, TimeUnits.SECONDS)

 Recommendation: DO NOT use implicit and explicit waits together. You may get unexpectdly long waits
               it is in before method


  --Explicit: Explicit wait provides better way to wait over  implicit wait. Unlike implicit wait, you can write and use
              pre-defined conditions or custom custom conditions before proceeding further,

              It is exact condition and element  (implicit only 1 condtions, it applies for every findElement)

              How to implement?  we create an object of WebdriverWait class

              WebdriverWait wait=new WebDriverWait(driver, time in seconds)---- it is constructor
              Then we have a expected condition class that provides wait conditions

              ExpectedConditions class provides a set of predefined conditions to wait for before proceeding (it means wait untill element is visible, displayed etc...)
Ex:   elementToBeClickable()
        visibilityOf()
        presenceOfLocatedElement()
        titleContains()

        WebElement buttuinElement=driver.FindElement(By.paty("button6"))

        WebdriverWait wait=new WebDriverWait(driver, 10)
        wait.until(ExpectedConditions.elementToBeClickable(buttonElement))
        ---- this wait means: wait up tp 10 seconds, until button becomes eligible to click


 */

public class SenchronizationDEF {
}
