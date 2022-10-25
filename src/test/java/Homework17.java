
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public static void addSongToPlaylist() throws InterruptedException {

        enterEmail("tasiakwiggins@gmail.com");
        enterPassword("te$t$tudent");
        submitButton();
        Thread.sleep(2000);
        viewAllSongs();
        songClick();
        addingSong();
        addingToPlaylist();
        abbottSearch();
        String addedSong = verifySong();

    }
    private static void viewAllSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.xpath("//a[text()='All Songs']"));
        allSongs.click();
        Thread.sleep(5000);
    }
    private static void songClick() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Cinematic')]"));
        song.click();
    }
    private static void addingSong() throws InterruptedException {
        WebElement selectingSong = driver.findElement(By.xpath("//button[contains(@title,'Add selected songs')]"));
        selectingSong.click();
        Thread.sleep(1000);
    }
    private static void addingToPlaylist() throws InterruptedException {
        WebElement addToPlaylist = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[contains(text(), 'Abbott')]"));
        addToPlaylist.click();
        Thread.sleep(1000);
    }
    private static void abbottSearch() throws InterruptedException {
        WebElement playlistName = driver.findElement(By.xpath("//a[contains(text(),'Abbott')]"));
        playlistName.click();
        Thread.sleep(1000);
    }
    private static String verifySong() {
        WebElement addedSong = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Cinematic')]"));
        return addedSong.getText();
    }

}

//    Create a new file Homework17.java file with @Test annotation in IntelliJ IDEA
//        Create a test case addSongToPlaylist() using @Test annotations
//        and the helper/reusable methods we created
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Add a song to a playlist
//        Validate that there is a song added
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework

