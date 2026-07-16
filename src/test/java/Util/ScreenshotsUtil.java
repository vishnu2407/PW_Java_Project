package Util;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotsUtil {
    public static String takeScreenshot(Page page, String testName){
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "test-output/screenshots/" + testName + "_" + timestamp + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }
}
