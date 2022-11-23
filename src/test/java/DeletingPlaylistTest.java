import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeletingPlaylistTest extends BaseTest{

    @Test(priority = 1, description = "Deleting A Playlist and Validating w/ Explicit Wait")
    @Parameters({"baseurl"})
    public static void deletePlaylist() {

        browserConfigs();
        clickSubmitBtn();
        playlistToDelete();
        playlistDeleteBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        playlistWasDeleted();
        tearDownBrowser();
    }
}
