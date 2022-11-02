import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Hw18 extends BaseTest{


    @Test(priority = 0, description = "Playing a Song & Validating")
    @Parameters({"baseURL"})
    public static void playSong(String baseURL) throws InterruptedException{

        browserConfigs();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        Thread.sleep(5000);
        recentlyPlayedTab();
        songSelection();
        songBeginsToPlay();
        Thread.sleep(2000);
        tearDownBrowser();
    }
}
