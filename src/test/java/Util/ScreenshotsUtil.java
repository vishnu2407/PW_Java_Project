package Util;

import com.microsoft.playwright.Page;

import java.util.Base64;

public class ScreenshotsUtil {

    private ScreenshotsUtil() {
        // Utility class
    }

    /**
     * Captures a lossless screenshot encoded for direct embedding in an HTML report.
     * This avoids broken report images caused by relative or Windows file paths.
     */
    public static String takeScreenshotAsBase64(Page page) {
        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                .setFullPage(true));
        return Base64.getEncoder().encodeToString(screenshot);
    }
}
