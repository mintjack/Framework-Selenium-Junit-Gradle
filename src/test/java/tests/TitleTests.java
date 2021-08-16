package tests;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class TitleTests extends BaseTest{

    @Test
    public void verifyGitHubTitleContains() {
        driver.get("https://www.github.com");
        assertThat(driver.getTitle(), containsString("GitHub"));
    }

    @Test
    public void verifyGitHubTitleExactMatch() {
        driver.get("http://www.github.com");
        Assert.assertEquals("https://github.com/",driver.getCurrentUrl());
    }


}

