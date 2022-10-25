import org.testng.annotations.Test;

public class Hw17 extends BaseTest {

    @Test(description = " Adding a song to Abdi's Playlist ")
    public static void addSongToPlaylist() throws InterruptedException  {

        browserConfigs();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        Thread.sleep(5000);
        allSongsTab();
        addingNewSong();
        addSongToPlaylistBtn();
        abdisPlaylist();
        validation();
        tearDownBrowser();

        allSongsTab();
        addingNewSong();
        addSongToPlaylistBtn();
        abdisPlaylist();
        validation();
    }
}
