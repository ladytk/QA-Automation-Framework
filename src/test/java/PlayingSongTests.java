import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlayingSongTests extends BaseTest {

    @Test(priority = 1, description = "Playing a Song & Validating")
    @Parameters({"BaseUrl"})
    public static void playASong() {

        browserConfigs();
        clickSubmitBtn();
        chooseAllSongsList();
        getContextMenu();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
    }
    @Test(priority = 2, description = "Hover, Play, and Validate")
    @Parameters({"BaseUrl"})
    public void hoverOverPlayButton() {

        browserConfigs();
        clickSubmitBtn();
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    @Test(priority = 3, description = "Editing Playlist Name and Validating")
    @Parameters({"BaseUrl"})
    public void renamePlaylist()  {

        browserConfigs();
        clickSubmitBtn();
        doubleClickChoosePlaylist();
        choosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }

}

