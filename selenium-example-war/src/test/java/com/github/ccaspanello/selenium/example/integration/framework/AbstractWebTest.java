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

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Abstract Web Test
 *
 * All web tests should extend this class, it will inject browser / url parameters.  If parameters are not passed in or
 * tests were kicked off by an IDE firefox and local host will be use respectively.
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public abstract class AbstractWebTest
{
  protected String homeUrl;
  protected WebDriver driver;

  @Parameters(value =
          {
                  "browser", "homeUrl"
          })
  @BeforeClass
  public void beforeTest(@Optional(value = "firefox") String browser, @Optional(value = "http://localhost:8080/") String homeUrl)
  {
    this.driver = WebDriverFactory.create(browser);
    this.homeUrl = homeUrl;
  }

  @AfterClass
  public void afterTest()
  {
    try
    {
      driver.quit();
    }
    catch (Exception e)
    {
      driver = null;
    }
  }

}
