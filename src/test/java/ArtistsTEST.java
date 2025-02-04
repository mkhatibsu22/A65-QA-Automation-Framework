import org.testng.annotations.Test;

public class ArtistsTEST {
//https://track.testpro.io/browse/INTERNSHIP-101820

    BaseTest smartPlaylist=new BaseTest();

    @Test
    void User_should_be_able_to_see_artists_in_app()
    {

        smartPlaylist.openArtistsPage();
    }
    @Test
    void User_should_be_able_to_find_artists_using_search_field() throws InterruptedException {
        smartPlaylist.openArtistsPage();
        smartPlaylist.searchArtists("chad");


    }

    @Test
    void User_should_be_able_to_play_song_of_selected_artist()
    {
        smartPlaylist.openArtistsPage();
        System.out.println("test 2 can not find css selector");

    }

    @Test
    void Artists_should_be_displayed_correctly_in_DB()

    {

    }
}
