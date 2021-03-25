# Selenium Webdriver Topics
---
### Description:
This repository contains the individual topics of Selenium WebDriver from basic to advance.

---

###Author:
* Created By: Sarang Holey & Mr. Akash Tyagi
* Reach out us at: sarangholey@gmail.com and akashdktyagi@gmail.com

---

#### Topics Covered:
* How to create a maven project
* Different browser invocations
* Locator strategy 
* Xpath basics
* Drop down handling and mouse actions
* Alert, Browser pop up and Frame handling
* Desired capabilities - Headless browser, Set browser window size, etc
* Tool tip handling
* Synchronization
* Screenshot capturing
* JavaScript Utilities
* Properties file reading
* Cross browser testing
* Testing over cloud based tool
* Interact with existing chrome session with WebDriver
* Validation of colour and size of element on a webpage
* Different date picker scenario automation
* Concept of runnable jar file
* Webtable handling with Xpath by Axes
* Code to capture broken link & images from a webpage
* StaleElementException handling code
* HashMap & its use case

---

### Steps to setup a Selenium Java Maven Project
* 1. Create maven project - File -> New -> Project -> Maven -> Maven Project
* 2. Add following code under properties tag in pom.xml file

```xml
		<properties>
			<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
			<maven.compiler.source>1.8</maven.compiler.source>
			<maven.compiler.target>1.8</maven.compiler.target>
		</properties>
```

* 3. Add the following Selenium WebDriver dependency from link under dependencies tag - 

```
		https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59 
```

```xml
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
		    <groupId>org.seleniumhq.selenium</groupId>
		    <artifactId>selenium-java</artifactId>
		    <version>3.141.59</version>
		</dependency>
```

* 4. Update the project Right clicl on project -> go to maven -> Update Project, this will change the project status java 1.5 to java 1.8
* 5. Download chromedriver, Firefox driver, opera driver & Edge driver according to the browser version installed in your system from following links

``` 
		i. Chromedriver - https://chromedriver.chromium.org/downloads
		ii.Firefoxdriver (geckodriver) - https://github.com/mozilla/geckodriver/releases
		iii. Opera driver - https://github.com/operasoftware/operachromiumdriver/releases
		Iv. Edge driver - https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
```

* 6. Unzip all those driver files accordingly & paste in the root folder inside the maven project just created
* 7. Now, refresh the project by right clicking the project folder in eclipse -> refresh
* 8. Now you can start to code for Selenium with java along with the required browser.

---

### Note - For making operations on any required browser
	i. It should be installed on your system.
	ii. The compatible browser driver version should be downloaded depending on the current browser vendors version.
