import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    //音樂清單
    private static LinkedList<Song> musicList = new LinkedList<Song>();

    //專輯清單
    private static ArrayList<Album> albumList = new ArrayList<Album>();

    public static void main(String[] args){
        //增加專輯與音樂
        Album jay =new Album("魔杰座");
        albumList.add(jay);
        jay.addSong("稻香", 180);
        jay.addSong("給我一首歌的時間", 154);
        jay.addSong("蘭亭序", 132);
        jay.addSong("時光機", 199);
        jay.addSong("說好的幸福呢", 170);

        Album jb = new Album("Purpose");
        albumList.add(jb);
        jb.addSong("What Do You Mean?", 321);
        jb.addSong("Love yourself", 289);
        jb.addSong("I'll Show You", 277);
        jb.addSong("No Sense", 250);
        jb.addSong("The Feeling", 230);


        //增加音樂至播放清單
        addMusic(jay, "稻香");
        addMusic(jb,"Love yourself");
        addMusic(jay, "給我一首歌的時間");
        addMusic(jb,"What Do You Mean?");
        addMusic(jay, "蘭亭序");
        addMusic(jb,"No Sense");
        addMusic(jay, "時光機");
        addMusic(jay, "說好的幸福呢");
        addMusic(jb,"I'll Show You");
        addMusic(jb,"The Feeling");
        System.out.println("===============================================");
        play();
    }

    //說明書
    private static void instruction(){
        System.out.println("0. Print Instruction.");
        System.out.println("1. Skip forward.");
        System.out.println("2. Skip backward.");
        System.out.println("3. Repeat the song.");
        System.out.println("4. Print the list.");
        System.out.println("5. Quit.");
    }

    //新增音樂
    private static void addMusic(Album album, String songName){
        if(album.getSong(songName) != null){
            musicList.add(album.getSong(songName));
            System.out.println(songName + " has added to playlist successfully.");
        }
        else{
            System.out.println("Fail. " + songName + " do not exist in the album.");
        }
    }

    //play選單
    private static void play(){
        ListIterator <Song> i = musicList.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        boolean goForward = true;
        if(musicList.isEmpty()){
            System.out.println("Music list is empty.");
            System.out.println();
        }
        else{
            System.out.println("It's playing " + i.next().getTitle());
            System.out.println();
        }
        while(go){
            instruction();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    instruction();
                    break;
                case 1:
                    //假如沒有往前，往前跳1
                    if(goForward == false){
                        if(i.hasNext()){
                            i.next();
                        }
                        goForward = true;
                    }

                    if(i.hasNext()){
                        Song nextSong = i.next();
                        System.out.println("It's playing " + nextSong.getTitle());
                        System.out.println();
                    }
                    else{
                        System.out.println("At the bottom of the list.");
                        goForward = false;
                    }
                    break;
                case 2:
                    //假如沒有往後，往後跳1
                    if(goForward == true){
                        if(i.hasPrevious()){
                            i.previous();
                        }
                        goForward = false;
                    }
                    if(i.hasPrevious()){
                        Song previousSong = i.previous();
                        System.out.println("It's playing " + previousSong.getTitle());
                        System.out.println();
                    }
                    else{
                        System.out.println("At the start of the list.");
                        goForward = true;
                    }
                    break;
                case 3:
                    if(goForward == true){
                        if(i.hasPrevious()){
                            Song currentSong = i.previous();
                            System.out.println("It's playing " + currentSong.getTitle());
                            System.out.println();
                            goForward = false;
                        }
                        else{
                            System.out.println("At the start of the list.");
                        }
                    }
                    else{
                        if(i.hasNext()){
                            Song currentSong = i.next();
                            System.out.println("It's playing " + currentSong.getTitle());
                            System.out.println();
                            goForward = true;
                        }
                        else{
                            System.out.println("At the end of the list.");
                        }
                    }
                    break;
                case 4:
                    while(i.hasNext()){
                        System.out.println(i.next().getTitle());
                    }
                    break;
                case 5:
                    go = false;
                    break;

            }
        }
    }
}
