import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TheTweeter {
    List<TweetClass> tweets = new ArrayList<TweetClass>();

//    adds the TweetClass object t to TheTweeter object
    void add(TweetClass t){
        this.tweets.add(t);
    }

//    removes from TheTweeter object all TweetClass objects whose author is author.
    void removeAuthor(String writer){
        ListIterator<TweetClass> iterator = tweets.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().author.equals(writer)){
                iterator.remove();
            }
        }
    }

    public TweetClass get(String writer){
        ListIterator<TweetClass> iterator = tweets.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().author.equals(writer)){
                return iterator.previous();
            }
        }
        return null;
    }

    public static void main(String[] args){
        TheTweeter twitter = new TheTweeter();
        System.out.println("Initial twitter : " + twitter.tweets.size());

        TweetClass tweet1 = new TweetClass("Test 1 tweet", "Ryan");
        TweetClass tweet2 = new TweetClass("Test 2 SENDIT", "Matt");
        TweetClass tweet3 = new TweetClass("Test 3 YEETTWEET", "Neil");
        TweetClass tweet4 = new TweetClass("Test 4 HErewego", "Lewis");
        TweetClass tweet5 = new TweetClass("Test 5 ayayayayyayyyay", "Neil");
        TweetClass tweet6 = new TweetClass("Test 6 GEt out of here", "Whammy");

        twitter.add(tweet1);
        twitter.add(tweet2);
        twitter.add(tweet3);
        twitter.add(tweet4);
        twitter.add(tweet5);
        twitter.add(tweet6);

        System.out.println("Number of tweets after: " + twitter.tweets.size());

        System.out.println("List of names before removing tweets from: Neil");
        for(int i = 0; i < twitter.tweets.size(); i++){
            System.out.println(twitter.tweets.get(i).author);
        }
        twitter.removeAuthor("Neil");
        System.out.println("\nList of names after removing tweets from: Neil");
        for(int i = 0; i < twitter.tweets.size(); i++){
            System.out.println(twitter.tweets.get(i).author);
        }
        System.out.println("Number of tweets after remove: " + twitter.tweets.size());

        System.out.println("Attempting to get tweet from: Matt \n" + twitter.get("Matt").displayTweet());

    }
}
