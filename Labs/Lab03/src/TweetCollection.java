
import java.lang.reflect.Array;
import java.net.URL;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TweetCollection {
    ArrayList<TweetClass> twitter = new ArrayList<TweetClass>();
    ArrayList<String> tweets = new ArrayList<>();

    public static void main(String[] args) {
        TweetCollection collection = new TweetCollection();
        collection.readURL();
        System.out.println();
        collection.convertTweets();


        ArrayList<TweetClass> noSQLTweet = collection.getTweets("NoSQLDigest");
        System.out.println("Total number of tweets from NoSQLDigest: " + noSQLTweet.size());
        for(int i = 0; i < noSQLTweet.size(); i++){
            System.out.println(noSQLTweet.get(i).content);
        }
        System.out.println(collection.tweetedAbout("NoSQLDigest", "Solar"));

    }

    void readURL(){
        try {
// Step 1: create a scanner
            System.out.println("we're going to create a scanner");
// From a URL
            URL url = new URL("http://homes.soic.indiana.edu/classes/fall2020/csci/c343-mitja/test2020/tweet-data-September10.txt");
            System.out.println("obtained a URL");
            Scanner in = new Scanner(url.openStream());
            System.out.println("scanner created");
// Step 2: read data
            int i = 0;
            while (in.hasNext()) {
                //nextLine() reads a line;
                //Scanner class has other methods to allow the user to read values of various types, eg.., nextInt()
                String str = in.nextLine();
                System.out.print("at line ");
                System.out.print(i);
                System.out.print(" there is [");
                System.out.print(str);
                tweets.add(str);
                System.out.println("]");
                i = i + 1;
            }
//Step 3: close the scanner
            in.close();
        } catch (Throwable e) {
            System.out.println("exception is " + e);
            e.printStackTrace();
        }
    }

//    converts the given string to TweetClass object. string up until first space is name and the rest is the message.
    void convertTweets(){
        for(int i = 0; i < this.tweets.size(); i++){
            String name = "";
            String msg = "";
            boolean firstSpace = false;
            String str = this.tweets.get(i);
            CharacterIterator iterator = new StringCharacterIterator(str);
            while(iterator.current() != CharacterIterator.DONE) {
                String current = String.valueOf(iterator.current());
                if(firstSpace != true && current.equals(" ")){
                    firstSpace = true;
                    continue;
                }

                if(!firstSpace){
                    name = name + current;
                    iterator.next();
                }
                else{
                    msg = msg + current;
                    iterator.next();
                }
            }
            TweetClass newTweet = new TweetClass(msg, name);
            twitter.add(newTweet);
        }
    }

    public ArrayList<TweetClass> getTweets(String author){
        ArrayList<TweetClass> results = new ArrayList<>();
        for(TweetClass tweet: twitter){
            if(tweet.author.equals(author)){
                results.add(tweet);
            }
        }
        return results;
    }

    public boolean tweetedAbout(String author, String content){
        ArrayList<TweetClass> authorTweets = this.getTweets(author);
        for(int i = 0; i < authorTweets.size(); i++){
          if(authorTweets.get(i).content.contains(content))
              return true;
        }
        return false;
    }
}
