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
package com.github.ccaspanello.selenium.example.integration.framework;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * WebDriver Factory
 *
 * Will create an instance of a WebDriver given the specific type passed in.
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public class WebDriverFactory
{
  public static WebDriver create(String browser)
  {
    if (browser.equalsIgnoreCase("firefox"))
    {
      return new FirefoxDriver();
    }
    else if (browser.equalsIgnoreCase("chrome"))
    {
      return new ChromeDriver();
    }
    else if (browser.equalsIgnoreCase("ie"))
    {
      return new InternetExplorerDriver();
    }
    else if (browser.equalsIgnoreCase("safari"))
    {
      return new SafariDriver();
    }
    else if(browser.equalsIgnoreCase("html"))
    {
      HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
      htmlUnitDriver.setJavascriptEnabled(true);
      return htmlUnitDriver;
    }
    else
    {
      throw new IllegalArgumentException("The Browser Type is Undefined");
    }
  }
}
