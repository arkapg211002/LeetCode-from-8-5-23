# Factor OR Multiple
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array A comprising of N non-zero, positive integers and an integer X, find the bitwise&nbsp;OR of all such elements in the array that are a multiple of X. The result of OR operation should be&nbsp; in decimal form.&nbsp;If no multiple of X is found, the answer should be 0.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
<strong>N = </strong>4 , <strong>X = </strong>2
<strong>A = </strong>{3 , 4 , 3 , 9}
<strong>Output:</strong>
4<strong>
Explanation:</strong>
Only multiple of 2 in array is 4.
Hence it is printed.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
<strong>N = </strong>5 , <strong>X = </strong>3
<strong>A = </strong>{9 , 3 , 1 , 6 , 1}
<strong>Output:</strong>
15<strong>
Explanation:</strong>
Multiples of 3 in array are 9,3 and 6.
Their OR value is 15 and thus the Output.</span></pre>

<p><span style="font-size:18px"><strong>Example 3:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
<strong>N = </strong>3 , <strong>X = </strong>8
<strong>A = </strong>{1,2,3}
<strong>Output:</strong>
0<strong>
Explanation:</strong>
There are no multiples of 8 in the array.
So, Output is 0.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>factorOrMultiple()</strong> which takes integers N and X, and an Array A as input and returns the answer.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 &lt;= N,X,A[i] &lt;= 10<sup>5</sup></span></p>
</div>