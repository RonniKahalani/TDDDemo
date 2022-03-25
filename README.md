# TDDDemo
## The step by step tutorial.
This is a small TDD sample, building a headless calculator taking numbers via a number source interface, which is mocked via Mockito.

[TDD Tutorial](doc/TDD-Tutorial.pdf).

---

## Selenium Web UI Testing
This code also contains a few Selenium UI test sample.

NOTE:

You need to download the Selenium WebDriver, you want to test with 
- [Chrome]
- [Firefox](https://firefox-source-docs.mozilla.org/testing/geckodriver/Support.html)
- [Safari](https://developer.apple.com/documentation/webkit/about_webdriver_for_safari)
- [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads)
- [IE](https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver#required-configuration)
- [Opera](https://github.com/operasoftware/operachromiumdriver/releases)

[You find the downloads here](https://www.selenium.dev/downloads/).

Remember to make the WebDriver folder available in your Windows Path system variable, so Selenium can call it.

Setting WebDriver on Windows
> System.setProperty("webdriver.chrome.driver", "<folder>/chromedriver.exe");
> System.setProperty("webdriver.gecko.driver", "<folder>/geckodriver.exe");
> System.setProperty("webdriver.edge.driver",<folder>/msedgedriver.exe");
> System.setProperty("webdriver.ie.driver", "<folder>/IEDriverServer.exe");
> System.setProperty("webdriver.opera.driver", "<folder>/operadriver.exe");
Safari does not need this webdriver setting.
