# Perfect Array
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">There is an array contains some non-negative integers. Check whether the array is perfect or not. An array is called perfect if it is first strictly increasing, then constant and finally strictly decreasing. Any of the three parts can be empty.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> Arr[] = {1, 8, 8, 8, 3, 2}
<strong>Output :</strong> Yes
<strong>Explanation:
</strong>We have an array <strong>[1, 8, 8, 8, 3, 2]</strong>. 
If we look in the range <strong>[0, 1]</strong> then 
we find that in this range the array is 
increasing, in the range <strong>[1, 3]</strong> the array 
is constant and in the range <strong>[3, 4]</strong> the 
array is decreasing.So, it satisfies the above 
condition then we return <strong>true.</strong>

</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> Arr[] = {1, 1, 2, 2, 1}
<strong>Output :</strong> No
</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function c<strong>heckUnimodal() </strong>that takes an array <strong>(arr)</strong>, sizeOfArray <strong>(n)</strong>, and return bool value that is <strong>true </strong>if condition satisfied else <strong>false</strong>. The driver code takes care of the printing.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1).</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup><br>
1 ≤ a<sub>i</sub> ≤ 10<sup>8</sup></span></p>

<p>&nbsp;</p>
</div>