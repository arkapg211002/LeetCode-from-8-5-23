# Even occurring elements
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>Arr</strong>&nbsp;of <strong>N</strong> integers that contains odd number of occurrences for all numbers except for a few elements which are present even number of times. Find the elements which have even occurrences in the array.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 11
Arr[] = {9, 12, 23, 10, 12, 12, 
15, 23, 14, 12, 15}
<strong>Output:</strong> 12 15 23

</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 5
Arr[] = {23, 12, 56, 34, 32}
<strong>Output:</strong> -1
<strong>Explanation:</strong>&nbsp;Every integer is present odd 
number of times.
</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>repeatingEven()</strong>&nbsp;which takes the array of integers&nbsp;<strong>arr</strong>&nbsp;and its size&nbsp;<strong>n&nbsp;</strong>as input&nbsp;parameters and returns a&nbsp;<strong>sorted</strong> array denoting the answer. If no such even occuring element is present return -1.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup><br>
0 ≤ Arr[i] ≤ 63</span></p>
</div>