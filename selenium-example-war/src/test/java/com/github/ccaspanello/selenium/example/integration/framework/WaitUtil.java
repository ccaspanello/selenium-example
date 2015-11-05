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
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Wait Utility
 *
 * This class will assist in performing different types of AJAX related waits.
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public class WaitUtil
{
  /**
   * Waits for an jQuery AJAX call to be complete.
   *
   * Timeout is set to 10 seconds.
   *
   * @param driver
   */
  public static void waitForAjax(WebDriver driver)
  {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(new AjaxWait());
  }
}
