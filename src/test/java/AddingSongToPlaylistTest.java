import org.testng.annotations.Test;

import java.time.Duration;

public class AddingSongToPlaylistTest extends BaseTest {
    @Test(priority = 1,description = " Adding a song to Abdi's Playlist ")
    public static void addSongToPlaylist() {

        browserConfigs();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        allSongsTab();
        addingNewSong();
        addSongToPlaylistBtn();
        abdisPlaylist();
        validation();
        tearDownBrowser();
    }
}
