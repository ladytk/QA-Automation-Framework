import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class SongPlayVerification extends BaseTest{
    @Test(priority = 1, description = "Playing a Song & Validating")
    public static void playSong() {

        browserConfigs();
        clickSubmitBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        recentlyPlayedTab();
        songSelection();
        songBeginsToPlay();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }
}
