# Combinational Logic
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Construct a 6&nbsp;input gate which performs the following logical operation:<br>
<em>&nbsp;(not(A)).B + C.D +E.(not(F))</em><br>
where A, B, C,&nbsp;D, E and F are the inputs to the 6&nbsp;input gate.</span><br>
<br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: A = 1, B = 1, C = 0
&nbsp;      D = 0, E = 1, F = 1
<strong>Output:</strong>&nbsp;0&nbsp;
<strong>Explanation</strong>: <em>(not(A)).B + C.D +E.(not(F))
= (not(1)).1 + 0.0 +1.(not(1)) = 0.</em></span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>A = 1, B = 1, C = 1
&nbsp;      D = 1, E = 1, F = 1
<strong>Output:&nbsp;1</strong>
<strong>Explanation</strong>: <em>(not(A)).B + C.D +E.(not(F))
= (not(1)).1 + 1.1 +1.(not(1)) = 1.</em></span></pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You dont need to read input or print anything. Complete the function <strong>logicalOperation()&nbsp;</strong>which takes A, B, C, D, E, F&nbsp;as input parameter and returns the result after executing the given opearation.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(1)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
0 &lt;= A,B,C,D,E,F &lt;= 1</span></p>
</div>