# Project 1: Stable Marriage---------------

Overview: Your program will be given an instance of StableMarriage and a matching and you will
determine how many instabilities it has. Note a stable matching will output 0 and an unstable matching
will output an integer greater than 0.

Details: The input will come from a file called input.txt which will be placed in the same directory as your
java file. The first line of the file will have a single integer value N which will be the number of men (or
women since the number of men equals the number of women). The next N lines will be the whitespace
separated preference lists of the N men (ie each of the next lines will be a permutation of 1, 2, ..., N). The
next N lines will be the whitespace separated preference lists of the N women. The next N lines will be a
whitespace separated matching. See the sample input below for examples.
Your program will determine the number of instabilities and output this value.

Sample execution: If input.txt contains

3\
1 2 3\
2 3 1\
3 1 2\
3 2 1\
1 3 2\
2 1 3\
1 2\
2 3\
3 1

then the output should be just the number of instabilities
0

More detailed explanation of sample input/output:
The input file describes an instance with the preference lists

M1 | W1 W2 W3\
M2 | W2 W3 W1\
M3 | W3 W1 W2

W1 | M3 M2 M1\
W2 | M1 M3 M2\
W3 | M2 M1 M3

and the matching {(M1, W2), (M2, W3), (M3, W1)}. This matching is stable, since every woman is paired
with her favorite man (a sufficient, but not necessary condition). However, your code would likely check the
9 possible man woman pairs (M i, W j) with 1 ≤ i ≤ 3 and 1 ≤ j ≤ 3. In every case the woman would not
want to change (and in some cases the man also wouldn’t want to change).
If input.txt contains

3\
1 2 3\
2 3 1\
3 1 2\
3 2 1\
1 3 2\
2 1 3\
1 3\
2 1\
3 2

the the output should be just the number of instabilities.
3

More detailed explanation of sample input/output:
The input file describes an instance with the preference lists

M1 | W1 W2 W3\
M2 | W2 W3 W1\
M3 | W3 W1 W2

W1 | M3 M2 M1\
W2 | M1 M3 M2\
W3 | M2 M1 M3

and the matching {(M1, W3), (M2, W1), (M3, W2)}. Checking the 9 man/woman pairs:

M1:W1 - M1 would switch, W1 would not switch.
M1:W2 - M1 would switch, W2 would switch (INSTABILITY).
M1:W3 - already part of the matching.
M2:W1 - already part of the matching.
M2:W2 - M2 would switch, W2 would not switch.
M2:W3 - M2 would switch, W3 would switch (INSTABILITY).
M3:W1 - M3 would switch, W1 would switch (INSTABILITY).
M3:W2 - already part of the matching.
M3:W3 - M3 would switch, W3 would not switch.

So there are exactly 3 instabilities.




# Project 2: Puddles---------------

Overview: Your program will be given a “map” of wet and dry locations and you will determine how many
seperate puddles (contiguous wet areas) are depicted.
Details: The input will come from a file called input.txt which will be placed in the same directory as your
java file. The first line of the file will have two integer values R and C which will be the number of rows and
columns in the map (simple rectangular region that can be represented by a 2-D array). Each of the next R
lines will consist of C zeroes or ones. A zero will indicate water and a one will indicate NOT water (grass?).
Two zeroes will be considered to be in the same puddle if they are either directly left/right of each other (ie
(i,j) and (i, j+1)) or directly above/below each other (ie (i,j) and (i+1, j)) or can be connected via repeated
applications of these rules.

Another (more technical) way to picture the situation is that you begin with a graph having R · C vertices
each having label (i,j) where 0 ≤ i < R and 0 ≤ j < C and are divided into two sets “Water” and “Not
Water”. Vertex (i,j) shares an edge with the vertices above, below, left, and right, but not diagonal). In
other words, (i,j) is adjacent to vertices (i-1,j), (i,j-1), (i,j+1), and (i+1, j). You then remove all “Not Water”
vertices and their incident edges.

Your program will output the number of puddles (or in the more technical description the number of com-
ponents in the graph).

Sample execution: If input.txt contains

5 10\
1 1 1 1 1 1 0 1 1 1\
1 1 1 1 1 1 0 1 1 1\
1 1 0 1 1 1 0 1 1 1\
1 1 0 0 0 0 0 1 1 1\
1 1 1 0 0 0 0 1 1 1

then the output should be
1


If input.txt contains

10 15\
0 1 1 1 1 1 1 1 1 1 1 1 1 1 1\
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1\
1 1 0 1 1 1 1 1 1 1 1 1 1 1 1\
1 1 1 0 1 1 1 1 1 1 1 1 1 1 1\
1 1 1 1 0 1 1 1 1 1 1 0 1 0 1\
1 1 1 1 1 0 1 1 1 1 1 0 1 0 1\
1 1 1 1 1 1 0 1 1 1 1 0 1 0 1\
1 1 1 1 1 1 1 0 1 1 1 0 1 0 1\
1 1 1 1 1 1 1 1 0 1 1 0 1 0 1\
1 1 1 1 1 1 1 1 1 0 1 0 1 0 1

the the output should be
12
