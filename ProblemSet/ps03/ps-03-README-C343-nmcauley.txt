C343/Fall 2020
ProblemSet-03
09/14/2020 14:42
Nolan Cauley nmcauley

TASK A:

While the static method is incredibly efficient in that it is constant time for setting the desired index to null it also has some ramifications that leaves handling the array afterwards rather difficult.

It would prove to be inefficient when trying to access indices that actually contain values and avoiding those that are null.

With the dynamic array we can establish what the actual size of the array is in terms of valid values and then what the original size is including the null values.

If you wanted a small array containing indices that you knew you were going to remove and keep track of which were null and not then a static method would be feasible. Otherwise, the dynamic method is superior in that it handles larger amounts of data (albeit slower, more efficiently.)

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK B:

1.
Assuming that we do not know where the value 15 is stored we will need to move through the array until we find the value.
getValue(); for every index and then 
next(); to traverse the list
Once we get the value we are looking for we then use remove();

2.
 a. Array-based: (8 * 20) = 160	 Linked: (8 + 4) * 20 =   240 
BREAKEVEN : (20*8)/(4 + 8) = 13.333

 b. Array-based: (2 * 30) =  60	 Linked: (2 + 4) * 30 =   180
BREAKEVEN : (30*2)/(4 + 2) = 10

 c. Array-based: (1 * 30) =  30	 Linked: (1 + 4) * 30 =   150 
BREAKEVEN : (30*1)/(4 + 1) = 6

 d. Array-based: (32 * 40)=1280  Linked: (32 + 4) * 40 = 1440 
BREAKEVEN : (40*32)/(4 + 32) = 35.556

The linked list would be more efficient for problem a. because the space is under the break-even point. The rest would be better because they are larger than the break-even point.


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

TASK C:

1.
	[ 2, log_2n, log_3n, 20n,  4n^2, n^2/3, 3^n ,n! ]
I followed the list from the lecture notes of slowest to fastest when ranking these. For 2  was the quickest since it was a constant computation; following were the logarithmic, linear the polynomial, and finally by the exponential functions which were just ordered by the bigger numbers 3^n being the fastest because n can be much bigger than any of the other exponents. n factorial being the fastest. 

2. 

a. O(n) and Ω(1) for c = c1 and n_0 = 1

b. O(n^3) and Ω() for c_2 = 1 and c_3 *= 1

c. O(nlog_n + n) and Ω(n) for 

d. O(2^n + n^6) and Ω(2^n)


3.
O(n) and Ω(n)
Big Theta would be BigTheta(n) since, no matter what, best case runtime is iterating through the size n. To counter that, best case runtime would still require iterating through the entirety of n and adding to the variable sum.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



