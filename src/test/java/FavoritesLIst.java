import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class FavoritesLIst extends BaseTestIntern {
    @Test(enabled = true)
    public void addingFavoriteSong() {

        login();
        addingSongtoFavorites();
        checkFavoriteList();
    }

    private String getFavSongTitle() {
        WebElement superPlaylistSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']"));
        return superPlaylistSong.getText();
    }

    private void addingSongtoFavorites() {
        WebElement AllSongsPage = driver.findElement(By.cssSelector(".songs"));
        AllSongsPage.click();

        WebElement favoringSong = driver.findElement(By.xpath("//section[@id='songsWrapper']//tr[@class='song-item']//td[@class='favorite']"));
        favoringSong.click();
    }

    private void checkFavoriteList() {
        WebElement favList = driver.findElement(By.xpath("//a[@href='#!/favorites']"));
        favList.click();
    }

    @Test(enabled = true)
    public void deleteFavSongList() {
        login();
        checkFavoriteList();
        deleteAllSongs();

    }
    private void deleteAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']")));
        WebElement favList = driver.findElement(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']"));
        actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.DELETE));
    }

    @Test(enabled = true)
    public void emptyFavList() {
        login();
        checkFavoriteList();
        WebElement song= driver.findElement(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']"));
        song.sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#favoritesWrapper div.text")));
        WebElement textMessage = driver.findElement(By.cssSelector("#favoritesWrapper div.text"));
        textMessage.isDisplayed();
    }

    private boolean noFavorites() {
        WebElement textStatusofEmptyList = driver.findElement(By.xpath("//div[contains(text(),'No favorites']"));
        return textStatusofEmptyList.isDisplayed();
    }
}