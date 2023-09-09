# Sum of Products
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>Arr</strong>&nbsp;of <strong>N</strong>&nbsp;integers.Calculate the sum of Bitwise ANDs(&amp;) all the pairs formed by the given array.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N=3
Arr={5,10,15}
<strong>Output:</strong>
15
<strong>Explanation:</strong>
The bitwise Ands of all pairs are (5&amp;10)=0
(5&amp;15)=5 and (10&amp;15)=10.Therefore,
total Sum=0+5+10=15.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N=4
Arr={10,20,30,40}
<strong>Output:</strong>
46
<strong>Explanation:</strong>
The sum of bitwise Ands 
of all pairs=0+10+8+20+0+8=46.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything.Your Task is to complete the function <strong>pairAndSum()&nbsp;</strong>which takes an Integer N and an array Arr as input parameters and <strong>returns</strong> the sum of bitwise Ands of all pairs.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>O(N)<br>
<strong>Expected Auxillary Space:</strong>O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1&lt;=N&lt;=10<sup>5</sup><br>
1&lt;=Arr<sub>i</sub>&lt;=10<sup>8</sup></span></p>
</div>