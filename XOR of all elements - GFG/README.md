# XOR of all elements
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a list <strong>A</strong>&nbsp;having <strong>N</strong> positive elements. The task to create another list&nbsp;such as i<sup>th</sup>&nbsp;element&nbsp;is XOR of all elements of&nbsp;&nbsp;A&nbsp;except A[i].</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
A = [2, 1, 5, 9]</span>
<span style="font-size:18px"><strong>Output:</strong>
13 14 10 6</span>
<span style="font-size:18px"><strong>Explanation:</strong>
At first position 1^5^9 = 13
At second position 2^5^9 = 14
At third position 2^1^9 = 10
At last position 2^1^5 = 6</span></pre>

<p><strong><span style="font-size:18px">Example 2:â€‹</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
A = [2, 1]</span>
<span style="font-size:18px"><strong>Output:</strong>
1 2
<strong>Explanation:</strong> 
At first position except first position 
there is only one element = 1
At second position except second position
â€‹there is only one element = 2</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong>&nbsp;&nbsp;<br>
You don't need to read input or print anything. Your task is to complete the function <strong>getXor</strong>()&nbsp;which takes a&nbsp;list A and an integer N which is the size of the list A and return the modified&nbsp;list.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(1), Where N is the size of the input array</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1&lt;= N &lt;=10000<br>
1&lt;= A[i]&nbsp;&lt;=100000</span></p>
</div>