import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.openqa.selenium.WebDriver

import com.kazurayam.ashotwrapper.AShotWrapper
import com.kazurayam.ashotwrapper.AShotWrapper.Options
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Path projectDir = Paths.get(RunConfiguration.getProjectDir())

// using Katalon Studio's built-in keywords,
// take full page screenshots while recording duration statistic
Path dir1 = projectDir.resolve("tmp/screenshots/builtin")
if (Files.exists(dir1)) {
	dir1.toFile().deleteDir()
}
Files.createDirectories(dir1)
// prepare pairs of target URL and output file
List<Tuple> fx1 = oneoff.TestUtils.makeFixture(dir1);
WebUI.openBrowser('')
WebUI.comment("with Builtin keyword")
for (t in fx1) {
	String url = t.get(0)
	Path file = t.get(1)
	WebUI.comment("URL=\"" + url + "\" file=\"" + projectDir.relativize(file).toString() + "\"")
	WebUI.navigateToUrl(url, FailureHandling.OPTIONAL)
	WebUI.takeFullPageScreenshot(file.toString())
}
WebUI.closeBrowser()

// using AShot library
Path dir2 = projectDir.resolve("tmp/screenshots/ashot")
if (Files.exists(dir2)) {
	dir2.toFile().deleteDir()
}
Files.createDirectories(dir1)
// prepare pairs of target URL and output file
List<Tuple> fx2 = oneoff.TestUtils.makeFixture(dir2);
WebUI.openBrowser('')
WebUI.comment("with AShot")
WebDriver driver = DriverFactory.getWebDriver()
for (t in fx2) {
	String url = t.get(0)
	Path file = t.get(1)
	WebUI.comment("URL=\"" + url + "\" file=\"" + projectDir.relativize(file).toString() + "\"")
	WebUI.navigateToUrl(url, FailureHandling.OPTIONAL)
	Options opt = new Options.Builder().timeout(100).build()
	AShotWrapper.saveEntirePageImage(driver, opt, file.toFile())
}
WebUI.closeBrowser()
