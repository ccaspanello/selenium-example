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

import com.github.ccaspanello.selenium.example.integration.framework.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Hello World Page Definition
 *
 * Defines how the Web Driver will fetch certain elements of the page.  This is abstracted away from the test so you can
 * refactor html/css elements and minimize the amount of refactoring of the actual test classes.
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public class HelloWorldPage
{
  private static final String PNL_HELLO_WORLD = "pnlHelloWorld";
  private static final String TXT_NAME = "txtName";
  private static final String LBL_NAME = "lblName";
  private static final String BTN_SAY_HELLO = "btnSayHello";
  private static final String TXT_MESSAGE = "txtMessage";

  private final WebDriver webDriver;

  public HelloWorldPage(WebDriver webDriver)
  {
    this.webDriver = webDriver;
  }

  public String panelHeader()
  {
    WebElement pnlHeader = webDriver.findElement(By.id(PNL_HELLO_WORLD));
    return pnlHeader.findElement(By.className("ui-panel-title")).getText();
  }

  public String message()
  {
    return webDriver.findElement(By.id(TXT_MESSAGE)).getText();
  }

  public String nameLabel()
  {
    return webDriver.findElement(By.id(LBL_NAME)).getText();
  }

  public void setNameValue(String value)
  {
    WebElement txtName = webDriver.findElement(By.id(TXT_NAME));
    txtName.clear();
    txtName.sendKeys(value);
  }

  public String getTxtNameValue()
  {
    return webDriver.findElement(By.id(TXT_NAME)).getText();
  }

  public void clickButton()
  {
    webDriver.findElement(By.id(BTN_SAY_HELLO)).click();
    WaitUtil.waitForAjax(webDriver);
  }
}
