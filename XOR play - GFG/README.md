# XOR play
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an integer <strong>N</strong>, list all the&nbsp;divisors of N (excluding N) in sorted order. Find the number formed by performing the&nbsp;XOR operation on each divisor in the list.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 10
<strong>Output:
</strong>1 2 5
6
</span><strong><span style="font-size:18px">Explanation:
</span></strong><span style="font-size:18px">All the proper divisors are 1, 2 and 5.
1 XOR 2 XOR 5 = 6</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 8
<strong>Output:
</strong>1 2 4
7
<strong>Explanation:</strong>
All the proper divisors are 1, 2 and 4.
1 XOR 2 XOR 4 = 7</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read or print anything. Your task is to complete the function&nbsp;<strong>xor_play()</strong>&nbsp;which takes N as input parameter and returns a list of integers containing all the proper divisors in sorted order. The last element in the list must contain the XOR result.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(sqrt(N))<br>
<strong>Expected Space Complexity:&nbsp;</strong>O(K) where K is the number of divisors of N.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>9</sup></span></p>
</div>