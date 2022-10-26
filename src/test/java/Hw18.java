import org.testng.annotations.Test;

public class Hw18 extends BaseTest{

    @Test(priority = 1, description = "Playing a Song & Validating")
    public static void playSong() throws InterruptedException{

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
