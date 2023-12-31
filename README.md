# Prestashop Automation
Welcome to the task-aqa-prestashop automation repository!

# Table of Content
- [Tooling](#tooling)
- [Requirements](#requirements)
- [Framework overview](#framework-overview)
  - [Framework functionality](#framework-functionality)
  - [Testing functionality](#testing-functionality)
- [Feature files](#feature-files)
- [Quick Start](#quick-start)
- [Reporting](#reporting)
  - [Generate manually](#generate-manually)
  - [Generate automatically](#generate-automatically)
  - [Allure configuration file](#allure-configuration-file)
  - [Allure environment properties file](#allure-environment-properties-file)
- [Configuration](#configuration)
  - [Configuration file](#configuration-file)
  - [Configuration settings](#configuration-settings)
- [Logger](#logger)
  - [Enable/disable logger](#enabledisable-logger)
  - [Logger configuration](#logger-configuration)
- [Ways to run](#ways-to-run)
  - [Via TestRunner.java](#via-testrunnerjava)
  - [Via maven](#via-maven)
  - [Directly from feature file](#directly-from-feature-file)
  - [From script](#from-script)

## Tooling
1. [Java](https://www.java.com/ru/)
2. [Cucumber](https://cucumber.io/docs/cucumber/)
3. [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
4. [Allure](https://docs.qameta.io/allure/)
5. [Webdriver Manager](https://github.com/bonigarcia/webdrivermanager)
6. [Log4j](https://logging.apache.org/log4j/2.x/)
7. [Lombok](https://projectlombok.org/)
8. [Jakson-databind](https://github.com/FasterXML/jackson-databind)

## Requirements
- Java >= v20
- Maven >= 3.9.2
- Allure >= 2.22.3
- Firefox/Chrome

## Framework overview
There are 2 main folders in this repo:
- `src/main` - Contains framework which is written as wrapper around Selenium Webdriver api
- `src/test` - Contains all the AUT sources 
### Framework functionality
- `src/main/**/constants/BrowserTypes` - Simple enum uses to store browser names
- `src/main/**/factory` - Folder contains classes to serve as factory methods to get browser and options based on values stored in `settings.json`
- `src/main/**/helpers` - Stores helpers like `AllureHelper`, `AssertHelpers`, `ConditionalWaiters`, `ConfigHelpers` and etc. Also it stores models for data bind
- `src/main/**/interfaces` - Stores interfaces like `BaseDriver`, `BaseElement`, `BaseForm` and etc
- `src/main/**/services` - Stores the main services like `Automation`, `Logger` and etc.
### Testing functionality
- `src/test/**/features` - Stores cucumber feature files
- `src/test/**/helpers` - Stores helper class which belongs only for testing purposes
- `src/test/**/hooks` - Stores cucumber hooks
- `src/test/**/pages` - Stores PageObject-oriented classes and represent states/actions of real AUT pages
- `src/test/**/steps` - Stores implemented Gherkin steps
- `src/test/**/transformations` - Stores cucumber datatable transformations
- `src/test/**/TestRunner` - Class for running tests

## Feature files
- `F01_AddOneProduct` - 2 scenarios
- `F02_AddMultipleProducts` - 1 scenario
- `F03_RemoveProducts` - 2 scenarios
- `F04_OrderProduct` - 2 scenario

_All the feature files are `Scenario Outline`'s so it can be customizable any time and way_

# Quick Start
:warning: Make sure you have all the required tools installed (See [Requirements](#requirements))

1. Clone repo:
```
git clone https://github.com/lyuskod/task-aqa-prestashop.git
```
2. Open repo root and simply run:
```
mvn clean test
```

_To generate an allure report, just run the following command from `target` directory:_
```
allure serve
```
PS: By default, the test will be running in headless mode. If you want to enable headed mode, remove `--headless` option from `options` list in `settings.json` file. For more info see [Configuration settings](#configuration-settings)

## Reporting
Here you can see how the actual report looks:
![img.png](https://bafybeie2rquzzjr7bp6pw73ye7msus5kdnhgfrvgtg2ihc4gfw5egq6rf4.ipfs.nftstorage.link/)

Also this section describes how to generate allure report.
### Generate manually
Run this command from `~target` directory:
```
allure serve
```
### Generate automatically
Run this script after test execution to generate allure report automatically:
```
script/open_report.bash
```
### Allure configuration file
The `allure.properties` configuration file is located here `src/main/resources/allure.properties`. Here you can add particular settings for allure
### Allure environment properties file
The `environment.properties` file is located here `src/main/resources/environment.properties`. To attach environment variables to the allure report just simply write down these env vars to this file

## Configuration
![img.png](https://bafkreiaryjv6l73cgzdsueodqwnwgzuxqdvq773nziqefvjkhnysuxuv2m.ipfs.nftstorage.link/)
This section describes the way how to configure framework settings
### Configuration file
You can find framework configuration file by the following path:
- `src/main/resources/settings.json` - Here you can change settings you want
### Configuration settings
ALl the possible configuration settings can be found in this table:

Property | Values                                 | Description                                                                           |
--- |----------------------------------------|---------------------------------------------------------------------------------------|
browserName | `firefox`, `chrome`                    | Browser                                                                               |
version | `116`                                  | Browser version                                                                       |
baseUrl | https://demo.prestashop.com/#/en/front | AUT base url                                                                          |
options |  default: `["--headless"]`          | Browser arguments. Can be passed like `["--headless"]`                                |
elementHighlightEnabled | `true`                                 | When interact with webelement, then the simple red border will be drawn around it     |
timeouts.timeoutImplicitSec | `40`                                   | Implicit wait time in seconds                                                         |
timeouts.timeoutScriptSec | `20`                                   | Script load timeout in seconds                                                        |
timeouts.timeoutPageLoadSec | `60`                                   | Page load timeout in seconds                                                          |
logger.enabled | `true`                                 | Enable framework logging                                                              | 
screenResolution.width | `1920`                                 | Browser window resolution width                                                       |
screenResolution.height | `1080`                                 | Browser window resolution height                                                      |
executionSpeedDelayMs | `250`                                  | Sleep time before each webelement interaction. Simply need to slow down the execution |

## Logger
This section describes how to enable/disable logger and turn on/off particular stdouts
By default, logger is configured to write log messages into `console` and `file` by the following path:
`target/log4j2/test.log`
### Enable/disable logger
You can `enable` or `disable` logger by setting boolean value for `enabled` key in `settings.json` file for property:
```
  "logger": {
    "enabled": true
  },
```
### Logger configuration
Logger configuration can be found and changed by the following path:
- `src/main/resources/log4j2.xml`

## Ways to run
This section describes how to run tests

### Via TestRunner.java
![img.png](https://bafybeialtmv6jdpq7adoc3gxxicd4cn6r7qo7befxb6h6ay6ar6ctmrjuy.ipfs.nftstorage.link/)
Right click on `src/test/java/com/github/prestashop/TestRunner.java` and select `Run 'TestRunner'`

### Via maven
![img.png](https://bafkreigytdaurilqeklmyokyt6bypcanfp3sektrk7kn7orvuwn6njufwu.ipfs.nftstorage.link/)
Simply run the following command from the project root directory:
```
mvn clean test
```
### Directly from feature file
![img.png](https://bafybeidoiooa7lgonz6xt4jutl7zdyhexblcvmfx4p3kf45rcktzap3cii.ipfs.nftstorage.link/)
In that way, you should have been installed `Cucumber` extension for your IDE.
Make use the following configuration settings are filled in:
- `Main Class = io.cucumber.core.cli.Main`
- `Glue = com.github.prestashop.transformations com.github.prestashop.hooks com.github.prestashop.steps`

How to run:
- Right click on any feature file and select `Run ${feature-file-name}`
- Open any feature file content and click `Run` near feature file name or scenario

### From script
![img.png](https://bafybeict4x3dv4qy5dveqx65hlkihgetnxkcmyvmxrvorpshyh43chte3q.ipfs.nftstorage.link/)
Simply run `scripts/run_with_report.bash` via right click -> `Run` or from terminal.
It will run tests, generate allure report, and open it in browser right after test run