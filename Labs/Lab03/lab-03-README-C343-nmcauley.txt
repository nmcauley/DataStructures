C343/Fall 2020
Lab-03
09/11/2020 18:30
Nolan Cauley nmcauley

So the main process that took the hardest amount of work was by obtaining the string from the URL and handling it appropriately to allocate which part of it was the name and which was the actual tweet itself. 

I opted for creating a method called convertTweets() that would loop through the arrayList of strings from the URL with a character iterator to look for the first " " in the string.
By having a boolean and checking if we have seen the firstSpace then the program would assign the characters to either the name variable or the msg. Before the next increment of the for loop the information was saved into a new TweetClass and then added into the main ArrayList. 

getTweets
Uses a nested for loop to iterate over the twitter ArrayList and if the TweetClass has the corresponding author then It is added into a separate list.

TweetedAbout 
Uses getTweets to obtain the list of author specific tweets and then uses a for loop to see if any of the tweets contain the content we are searching for.