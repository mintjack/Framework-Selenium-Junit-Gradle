package tests;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//a tour of common hamcrest matchers
public class HamcrestExamples extends BaseTest {
    @Test
    public void checkURL(){
        driver.get("https://www.worldometers.info/");
        assertThat(driver.findElement(By.className("counter-title-top")).getText(),is("WORLD POPULATION"));
        //string is equal to
        assertThat(driver.getTitle(),is("Worldometer - real time world statistics"));
        assertThat(driver.findElement(By.className("counter-title-top")).getText(),is(equalTo("WORLD POPULATION"))); //more readable version of above
        //list is equal to
        List<String> actualList = Lists.newArrayList("equalTo", "match");
        assertThat(actualList, is(equalTo(Lists.newArrayList("equalTo", "match"))));
        //compares 2 objects (here creates an object with single property of Biscuit and compares)
        Object original = "Biscuit";
        assertThat(original, equalToObject("Biscuit"));
        //NOT a match
        assertThat(driver.getTitle(), not("Worldometer"));
        assertThat(driver.getTitle(), is(not(equalTo("Worldometer"))));
        assertThat(driver.getTitle(), is(not(instanceOf(Integer.class))));
        //null values
        WebElement testObj = driver.findElement(By.cssSelector("div.content-home"));
        assertThat(testObj.getAttribute("class"), is(not(nullValue()))); //this attrib exists
        assertThat(testObj.getAttribute("class"), is(notNullValue())); ///another way of writing it
        assertThat(testObj.getAttribute("biscuit"), is(nullValue())); //this attrib doesn't exist
        //check the value is an instance of a particular class
        WebElement testObj2 = driver.findElement(By.className("linkunderline"));
        assertThat(testObj2.getText(),is(instanceOf(String.class)));
        assertThat(testObj2.getText(),isA(String.class)); // isA is a shortcut to 'instance of class'
        //'all of' checks all conditions are true
        assertThat(testObj2.getText(),allOf(startsWith("Coro"),endsWith("Updates"),containsString("virus")));
        //'any of' passes if any of the conditions are true
        assertThat(testObj2.getText(),anyOf(startsWith("Biscuit"),endsWith("Updates"),containsString("virus")));
        //'hasItem' and 'hasItems' check a collection contains certain things
        List<WebElement> navBarContents = driver.findElements(By.cssSelector("ul.navbar-nav li"));
        List<String> navBarText = new ArrayList<>();
        for(WebElement liText : navBarContents) {
            navBarText.add(liText.getText());
        }
        assertThat(navBarText,hasItem("Population"));
        assertThat(navBarText,hasItems("Coronavirus","Population"));
        assertThat(navBarText, hasItems(isA(String.class), endsWith("tion")));
        assertThat(navBarText, contains("Coronavirus","Population"));
        assertThat(navBarText, containsInAnyOrder("Population","Coronavirus"));
        assertThat(navBarText, everyItem(containsString("n")));
        //'both' passes when both conditions pass
        assertThat(navBarText,both(hasItem("Population")).and(not(hasItem("About"))));
        //'either passes when one condition is true
        assertThat(navBarText,either(hasItem("Help")).or(not(hasItem("About"))));
        //check size of list
        assertThat(navBarText,iterableWithSize(2));
        //string matchers
        assertThat(testObj2.getText(), containsString("Updates"));
        assertThat(testObj2.getText(), containsStringIgnoringCase("UPDATES"));
        assertThat(testObj2.getText(), startsWith("Coro"));
        assertThat(testObj2.getText(), startsWithIgnoringCase("coro"));
        assertThat(testObj2.getText(), endsWith("tes"));
        assertThat(testObj2.getText(), endsWithIgnoringCase("TES"));
        //matching on map collections
        Map<String, Object> map = new HashMap<>();
        map.put("Wales","Cardiff");
        map.put("Northern Ireland","Belfast");
        assertThat(map,hasEntry( "Wales", "Cardiff" ) );
        assertThat(map,not(hasEntry( "France", "Paris" )));
        assertThat(map,hasKey("Wales"));
        assertThat(map,hasValue("Belfast"));
    }

}
