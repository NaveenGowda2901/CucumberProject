# Cucumber BDD Automation Testing Framework(with Java)

### Author: Sana Anwar Farooqui

![CucumberFramework](https://github.com/user-attachments/assets/2db231f8-2221-40f1-8ef5-a5646fc72042)

- Framework Type: Cucumber BDD framework with Selenium-Java
 - Tools and techniques used: Java, Maven, Selenium, Page Object Model
 - To manage Data - Properties files - Apache POI and Feature files
 - Log42j for logging with logging level info, debug and Warn
 - Reports: HTML, JSON, XML, Extent Report and Spark report
 - Screenshot upon test failure using ITestListener interface
 - Base class with Before and After Methods for setUp and tearDown.
 - setUp method to run the test cases localy and remote via Selenium Grid and Docker(docker-compose.yml)
 - Continous Integration to Jenkins and execute tests via Jenkins
 - Functionalities Automated: Account Registration, Signin, Account Deletion, Search and Cart

 ## To generate Extent reports create extent.config and extent-config.xml file under src/test/resources\

 -extent.properties file

```bash
extent.reporter.spark.start=true
extent.reporter.spark.out=extentspark-output/SparkReport/Spark.html
extent.reporter.spark.config=src/test/resources/extent-config.xml

extent.reporter.spark.out=extentspark-output/SparkReport/

screenshot.dir=extentspark-output/
screenshot.rel.path=../
extent.reporter.pdf.start=true
extent.reporter.pdf.out=extentspark-output/PdfReport/ExtentPdf.pdf
#basefolder.name=reports
#basefolder.datetimepattern=d-MMM-YY HH-mm-ss
extent.reporter.spark.vieworder=dashboard,test,category,exception,author,device,log
systeminfo.os=Windows11
systeminfo.user=Sana Farooqui
systeminfo.build=1.1
systeminfo.AppName=AutomationExercise
```

- extent-config.xml



```bash
<?xml version="1.0" encoding="UTF-8"?>
<extentreports>
	<configuration>
		<!-- report theme -->
		<!-- standard, dark -->
		<theme>dark</theme>
		<!-- document encoding -->
		<!-- defaults to UTF-8 -->
		<encoding>UTF-8</encoding>
		<!-- protocol for script and stylesheets -->
		<!-- defaults to https -->
		<protocol>http</protocol>
		<!-- title of the document -->
		<documentTitle>Extent</documentTitle>
		<!-- report name - displayed at top-nav -->
		<reportName>AutomationExercise Report</reportName>
		<!-- location of charts in the test view -->
		<!-- top, bottom -->
		<testViewChartLocation>bottom</testViewChartLocation>
		
    <!-- custom javascript -->
        <scripts>
        <![CDATA[
        $(document).ready(function() {
        });
        ]]>
        </scripts>

        <!-- custom styles -->
        <styles>
        <![CDATA[
        ]]>
        </styles>

	</configuration>
</extentreports>
```

## Test Output Extent and spark reports

![ExtentReportCucmber](https://github.com/user-attachments/assets/bce3b117-5bd4-4dce-b8c9-aea8347c8dd4)
