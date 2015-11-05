/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.ccaspanello.selenium.example.integration;

import com.github.ccaspanello.selenium.example.integration.framework.AbstractWebTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 * Hello World Page Test
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public class HelloWorldMBTest extends AbstractWebTest
{
  private HelloWorldPage helloWorldPage;

  @Test
  public void testInitialPageState() throws InterruptedException
  {
    helloWorldPage = new HelloWorldPage(driver);
    driver.get(homeUrl);

    String pnlHeader = helloWorldPage.panelHeader();
    Assert.assertEquals(pnlHeader, "Hello World Example");

    String lblName = helloWorldPage.nameLabel();
    Assert.assertEquals(lblName, "Name");

    String txtName = helloWorldPage.getTxtNameValue();
    Assert.assertEquals(txtName, "");

    String txtMessage = helloWorldPage.message();
    Assert.assertEquals(txtMessage, "Hello World!");
  }

  @Test(dependsOnMethods = "testInitialPageState")
  public void testSayHelloName() throws InterruptedException
  {
    helloWorldPage.setNameValue("Chris");
    helloWorldPage.clickButton();

    String txtMessage = helloWorldPage.message();
    Assert.assertEquals(txtMessage, "Hello, Chris!");
  }

  @Test(dependsOnMethods = "testSayHelloName")
  public void testSayHelloBlank() throws InterruptedException
  {
    helloWorldPage.setNameValue("");
    helloWorldPage.clickButton();

    String txtMessage = helloWorldPage.message();
    Assert.assertEquals(txtMessage, "Hello World!");
  }

  //@Test
  public void testFailureForChrome()
  {
    if (driver instanceof ChromeDriver)
    {
      assertTrue(false, "Mock Failure for Chrome");
    }
    else
    {
      assertTrue(true);
    }
  }

  //@Test
  public void testFailureForFirefox()
  {
    if (driver instanceof FirefoxDriver)
    {
      assertTrue(false, "Mock Failure for Firefox");
    }
    else
    {
      assertTrue(true);
    }
  }

}
