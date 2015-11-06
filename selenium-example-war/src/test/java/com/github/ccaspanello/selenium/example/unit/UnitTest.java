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
package com.github.ccaspanello.selenium.example.unit;

import static org.testng.Assert.assertEquals;

import com.github.ccaspanello.selenium.example.HelloWorldMB;
import org.testng.annotations.Test;

/**
 *
 * @author Chris Caspanello <ccaspanello@gmail.com>
 */
public class UnitTest
{
  @Test
  public void testSayHelloInitial()
  {
    HelloWorldMB helloWorldMB = new HelloWorldMB();
    String expected = "Hello World!";
    String actual = helloWorldMB.getMessage();
    assertEquals(expected, actual);
  }

  @Test
  public void testSayHelloEmpty()
  {
    HelloWorldMB helloWorldMB = new HelloWorldMB();
    helloWorldMB.setName("");
    helloWorldMB.sayHello();

    String expected = "Hello World!";
    String actual = helloWorldMB.getMessage();
    assertEquals(expected, actual);
  }

  @Test
  public void testSayHelloWithName()
  {
    HelloWorldMB helloWorldMB = new HelloWorldMB();
    helloWorldMB.setName("Bob");
    helloWorldMB.sayHello();

    String expected = "Hello, Bob!";
    String actual = helloWorldMB.getMessage();
    assertEquals(expected, actual);
  }
}
