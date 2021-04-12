C343/Fall 2020
ProblemSet-01
08/25/2020 13:02
Nolan Cauley nmcauley


A:

1.
Output is as follows:
------------------------------------------------------------------------
java.vm.version is 14.0.2+12-46
java.vm.vendor is Oracle Corporation
java.vm.name is OpenJDK 64-Bit Server VM
java.vm.specification.version is 14
java.vm.specification.vendor is Oracle Corporation
java.vm.specification.name is Java Virtual Machine Specification
java.version is 14.0.2
java.vendor is Oracle Corporation
------------------------------------------------------------------------
This was created by inputting the vm methods that output the specifications of the vm being used.

2.
I chose to declare 3 separate students and place them into an array called stuArray. Before doing so I declared them and used the setDepartment method before assigning them to the array. 
For the output I tested a for loop that would display all students in the array by starting at 0 and traversing till the end of the array's length. 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

B:

Sample output from a random test.
------------------------------------------------------------------------
The two DNA sequences 10 characters long: GGAACTTCGT, CCGTGTCCCT
Hamming count: 7

The two DNA sequences 100 characters long: *
Hamming count: 73

The two DNA sequences 1000 characters long: *
Hamming count: 776

The two DNA sequences 10000 characters long: *
Hamming count: 7434
------------------------------------------------------------------------
The sequences from the latter three outputs were omitted due to them being 100 to 10,000 characters in length. Very weird trend that the number 7 makes such a recurring appearance. Indicates some form of measurable probability.

By calling the method computeHam() with the two DNA strings as input the result is achieved by creating a simple for loop that traverses the length of the string and compares each character to the corresponding character at the other DNA string's location. If they equal then the loop continues otherwise they are not and the counter would increment.


