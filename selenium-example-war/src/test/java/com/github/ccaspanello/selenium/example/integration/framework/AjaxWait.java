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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * AJAX Wait
 *
 * This is a way to tell Selenium to wait for jQuery or PrimeFaces AJAX calls to complete before moving to the next
 * step in the test.
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public class AjaxWait implements ExpectedCondition<Object>
{
  private static final String JS_JQUERY_DEFINED = "return typeof jQuery != 'undefined';";
  private static final String JS_PRIMEFACES_DEFINED = "return typeof PrimeFaces != 'undefined';";
  private static final String JS_JQUERY_ACTIVE = "return jQuery.active != 0;";
  private static final String JS_PRIMEFACES_QUEUE_NOT_EMPTY = "return !PrimeFaces.ajax.Queue.isEmpty();";

  @Override
  public Object apply(WebDriver webDriver)
  {
    boolean ajax = false;
    boolean jQueryDefined = executeBooleanJavascript(webDriver, JS_JQUERY_DEFINED);
    boolean primeFacesDefined = executeBooleanJavascript(webDriver, JS_PRIMEFACES_DEFINED);

    if (jQueryDefined)
    {
      // jQuery is still active
      ajax = executeBooleanJavascript(webDriver, JS_JQUERY_ACTIVE);
    }
    if (primeFacesDefined)
    {
      // PrimeFaces queue isn't empty
      ajax = executeBooleanJavascript(webDriver, JS_PRIMEFACES_QUEUE_NOT_EMPTY);
    }

    // continue if all ajax request are processed
    return !ajax;
  }

  private boolean executeBooleanJavascript(WebDriver input, String javascript)
  {
    return (Boolean) ((JavascriptExecutor) input).executeScript(javascript);
  }
}
