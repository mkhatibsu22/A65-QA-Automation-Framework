import org.testng.annotations.Test;

public class SmartPlaylistTests {
//  https://track.testpro.io/browse/INTERNSHIP-101818

    BaseTest smartTest=new BaseTest();;

    @Test
    public void createSmartPlaylistOneRule() throws InterruptedException {


         smartTest.addOnerule("first try","Title","","any");

    }
    @Test
    public  void createSmartplaylistMultiRules()

    {
System.out.println("not ready becaause can not find css selector");



    }
    @Test
    void createSmartPlaylistwithGroup()
    {
        System.out.println("with group not ready becaause can not find css selector");
    }

    @Test
    void create_Smart_Playlist_with_RelatedSongsDisplay()
    {
        System.out.println(" not ready becaause can not find css selector");
    }

    @Test
    void create_Smart_Playlist_withNoMatchSongs()
    {
        System.out.println(" not ready becaause can not find css selector");
    }

   // @Test
    void create_Smart_Playlist_with_empty_name() throws InterruptedException {
        smartTest.addOnerule("","Title","","any");
    }
@Test
    void create_Smart_Playlist_with_oneChar_name() throws InterruptedException {
        smartTest.addOnerule("E","Title","","any");
    }

    @Test
    void create_Smart_Playlist_with_256Char_name() throws InterruptedException {
        smartTest.addOnerule("w9f8o7h6v5d4n3g2e1r0tqzjxyiwpv3ul8s2km1o5b0e9v3c7l6g4z3ndwqpr7t0ybfk2s1a9k8lm4o7s6ei3v9tq0cz8yj2h4p7b5w9u1r0x3v6o4z8y7gn8j5w2pt1","Title","","any");
    }

    @Test
    void create_Smart_Playlist_with_257Char_name() throws InterruptedException {
        smartTest.addOnerule("w9f8o7ho6v5d4n3g2e1r0tqzjxyiwpv3ul8s2km1o5b0e9v3c7l6g4z3ndwqpr7t0ybfk2s1a9k8lm4o7s6ei3v9tq0cz8yj2h4p7b5w9u1r0x3v6o4z8y7gn8j5w2pt1","Title","","any");
        System.out.println(" smart playlist should not created with 257 chars , this is a BUG");
    }


}


