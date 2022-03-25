# TDDDemo
## The step by step tutorial.
This is a small TDD sample, building a headless calculator taking numbers via a number source interface, which is mocked via Mockito.

[TDD Tutorial](doc/TDD-Tutorial.pdf).

---

## Selenium Web UI Testing
This code also contains a few Selenium UI test sample.

NOTE:

You need to download the Selenium WebDriver, you want to test with 
- [Chrome](https://chromedriver.chromium.org/)
- [Firefox](https://firefox-source-docs.mozilla.org/testing/geckodriver/Support.html)
- [Safari](https://developer.apple.com/documentation/webkit/about_webdriver_for_safari)
- [Internet Explorer](https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver#required-configuration)
- [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads)
- [Opera](https://github.com/operasoftware/operachromiumdriver/releases)

[You find all downloads here](https://www.selenium.dev/downloads/).

Remember to make your new WebDriver available in your program, using a System Property, so Selenium can call it. See below.
Make sure to set it, before using the driver.
### Sample (ChromeDriver)
> System.setProperty("webdriver.chrome.driver", "C:\\...\\chromedriver.exe");


