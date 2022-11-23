import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlaylistDeleteVerification extends BaseTest{

@Test(priority = 1, description = "Deleting A Playlist and Validating")
@Parameters({"baseurl"})
    public static void deletePlaylist() {

    browserConfigs();
    provideEmail("dcabdi@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    playlistToDelete();
    playlistDeleteBtn();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    playlistWasDeleted();
    tearDownBrowser();

    }
}
