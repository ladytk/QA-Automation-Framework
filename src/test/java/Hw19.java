import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Hw19 extends BaseTest{

@Test(priority = 1, description = "Deleting A Playlist and Validating")
@Parameters({"baseurl"})
    public static void deletePlaylist() throws InterruptedException {

    browserConfigs();
    provideEmail("dcabdi@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
    Thread.sleep(5000);
    playlistToDelete();
    playlistDeleteBtn();
    Thread.sleep(1000);
    playlistWasDeleted();
    tearDownBrowser();

    }
}
