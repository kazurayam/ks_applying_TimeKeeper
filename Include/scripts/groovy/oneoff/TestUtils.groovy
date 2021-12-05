package oneoff

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.file.Path

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class TestUtils {
	
	static List<Tuple> makeFixture(Path dir) {
		List<Tuple> fx = new ArrayList<Tuple>()
		fx.add(new Tuple("https://www.katalon.com/", dir.resolve("01_top.png")))
		fx.add(new Tuple("https://www.katalon.com/katalon-studio", dir.resolve("02_katalon-studio.png")))
		fx.add(new Tuple("https://www.katalon.com/testops", dir.resolve("03_testops.png")))
		fx.add(new Tuple("https://www.katalon.com/katalon-recorder-ide", dir.resolve("04_katalon-recorder-ide.png")))
		fx.add(new Tuple("https://www.katalon.com/web-testing/", dir.resolve("05_web-testing.png")))
		fx.add(new Tuple("https://www.katalon.com/mobile-testing/", dir.resolve("06_mobile-testing.png")))
		fx.add(new Tuple("https://www.katalon.com/api-testing/", dir.resolve("07_api-testing.png")))
		fx.add(new Tuple("https://www.katalon.com/desktop-testing/", dir.resolve("08_desktop-testing.png")))			
		return fx
	}
}
