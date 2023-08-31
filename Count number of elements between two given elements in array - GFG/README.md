# Count number of elements between two given elements in array
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an unsorted array and two elements num1 and num2. The task is to count the number of elements occurs between the given elements (excluding num1 and num2). If there are multiple occurrences of num1 and num2, we need to consider leftmost occurrence of num1 and rightmost occurrence of num2.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> Arr[] = {4, 2, 1, 10, 6}
num1 = 4 and num2 = 6
<strong>Output :</strong> 3
<strong>Explanation:
</strong>We have an array <strong>[4, 2, 1, 10, 6]</strong> and 
<strong>num1 = 4 and num2 = 6</strong>. 
So, the left most index of num1 is 0 and 
rightmost index of num2 is 4. 
So, the total number of element between 
them is <strong>[2, 1, 10] </strong>So, function will return 
<strong>3</strong> as an answer.

</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> Arr[] = {3, 2, 1, 4}
num1 = 2 and num2 = 4
<strong>Output :</strong> 1</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function <strong>getCount()</strong> that takes an array <strong>(arr)</strong>, sizeOfArray <strong>(n)</strong>, integer <strong>num1</strong>, integer <strong>num2,</strong>&nbsp;and return the number of elements between these numbers. The driver code takes care of the printing.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
2 ≤ N ≤ 10<sup>5</sup><br>
1&nbsp;≤ A[i], num1, num2 ≤ 10<sup>5</sup></span></p>
</div>