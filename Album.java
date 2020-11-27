import java.util.ArrayList;

//專輯物件
public class Album {
    public String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Album(String name) {
        this.name = name;
    }

    //找尋歌
    public Song getSong(String songName){
        for(int i = 0; i < songs.size(); i = i + 1){
            if(songs.get(i).getTitle().equals(songName)){
                return songs.get(i);
            }
        }
        return null;
    }

    //取得ArrayList
    public ArrayList<Song> getSongs() {
        return songs;
    }

    //取得專輯名稱
    public String getName() {
        return name;
    }

    //新增歌曲至專輯
    public void addSong(String title, int duration){
        Song newSong = new Song(title, duration);
        songs.add(newSong);
    }
}
