C343/Fall 2020
ProblemSet-02
09/05/2020 14:23
Nolan Cauley nmcauley

TASK A:


Output from a test run with 3 separate decks:
------------------------------------------------------------------------------------------
Deck 1:
Before initialize(): []
After (and before the other methods): 
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS, KC]

After drawTopCardFromDeck(): KC
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS]

After drawRandomCard(): KH
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KD, KS]

After placing a randomly drawn card on the top: 
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JS, JC, QH, QD, QS, QC, KD, KS, JD]


Deck 2:
Before initialize(): []
After (and before the other methods): 
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS, KC]

After drawTopCardFromDeck(): KC
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS]

After drawRandomCard(): AH
[AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS]

After placing a randomly drawn card on the top: 
[AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS, 8D]


Deck 3:
Before initialize(): []
After (and before the other methods): 
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS, KC]

After drawTopCardFromDeck(): KC
[AH, AD, AS, AC, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS]

After drawRandomCard(): AC
[AH, AD, AS, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8S, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS]

After placing a randomly drawn card on the top: 
[AH, AD, AS, 2H, 2D, 2S, 2C, 3H, 3D, 3S, 3C, 4H, 4D, 4S, 4C, 5H, 5D, 5S, 5C, 6H, 6D, 6S, 6C, 7H, 7D, 7S, 7C, 8H, 8D, 8C, 9H, 9D, 9S, 9C, 10H, 10D, 10S, 10C, JH, JD, JS, JC, QH, QD, QS, QC, KH, KD, KS, 8S]
------------------------------------------------------------------------------------------

Many of the code comments explain nitty gritty details but once we initialize the array for our deck of cards we then can pass it through the draw random, top, and place on top methods.

Draw random simply creates a random number generator and uses that as an index on the .get() for the card deck.


Draw top simply returns the card at the last index of our array. Thankfully since it is a deck of cards the array will always be length 52 so we can .get(51).

Place on top method uses the draw random method to obtain a card from the deck and by using .indexOf() we can obtain the index of the drawn card. From there we can remove the index of the card we drew using .remove() and then adding that card to the top of the deck (index 51).

Initially I did not know that by drawing cards the deck would be changed as in removing the index position of the card drawn (52 -> 51) So I saved the position in a local variable and used the set method .remove() on the previous location before continuing



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


TASK B:

For Task B the process was pretty simple in by having the TweetClass simply comprise of global String variables 
- content 
- author
These variables were then declared in the constructor with two inputs. Display tweet returns the content variable or the tweet itself and the contains method checks to see if the given String is contained within the tweet of the TweetClass object.

By using an ArrayList it was incredibly ideal for removing and adding elements from the list of tweets as in the following methods:

add
- simply utilizes the built in add method for ArrayLists.

removeAuthor
- used an iterator that would check each TweetClass object in the list and see which objects had the author we were looking for, ultimately resulting in removing that writer from the list.

get
- also uses an iterator in the same way as remove author but now to return one of their TweetClass objects.
Learned a lesson with iterator.next() and trying to obtain the current element on this one. Used iterator.previous()


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


TASK C:

1.
----------------------------------------------------------------------------
A two-dimensional array of integers might specify the following operations:
- Declare the array; must be integers. 
- Insert a new integer at a specified location.
- Return the total number of elements in a given array (size). 
- Return a specific element at the input index
----------------------------------------------------------------------------

By constructing our array we can use the set method to put elements in at specified locations. Used simple array ...[i][j] = input; format for setting elements.

get follows the same philosophy.

zeroArray simply iterates through the entire two-dimensional array and sets the value to 0. Uses a nested for loop.

getRow attempts to simply return the row of the array by means of ...[input]. For this I implemented a try and catch method in case the input is outside of the bounds of the array. Returns null if this happens

deleteColumn uses a foreach loop to obtain the specified column and sets the column's value to 0. This is by in every array (or row) we go to the specified index (column) and set the value. 0 was chosen as a form of deleting since these are integers in an Array.
Also if the given column is outside the length of the array then the loop is broken and nothing is done.

