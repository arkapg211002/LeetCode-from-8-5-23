# Numbers having alternate bits in range 1 to n
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a positive integer <strong>N</strong>. The problem is to print the numbers in the range 1 to n having bits in alternate pattern. Here alternate pattern means that the set and unset bits in the number occur in alternate order. For example- 5 has an alternate pattern i.e. 101.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
N = 10
<strong>Output:</strong>&nbsp;1 2 5 10
<strong>Explanation</strong>:
Binary representation of 1 : 0001
Binary representation of 2 : 0010
Binary representation of 5 : 0101
Binary representation of 10 : 1010
Here, We can see that the bits 
pattern in all the above configuration 
is alternate. So, we return an array
having {1, 2, 5 and 10}. 
</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 50
<strong>Output: </strong>1 2 5 10 21 42
</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>printNumHavingAltBitPatrn()</strong>&nbsp;which takes the integer N as input parameters and returns an array of integers with alternate bits in the range <strong>1</strong> to <strong>N</strong>.<br>
<br>
<strong>Expected Time Complexity:</strong> O(log(n))<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>CONSTRAINTS:</strong><br>
1&lt;= N &lt;=10<sup>5</sup></span></p>
</div>