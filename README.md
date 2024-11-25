# Smart Dolphins Problem

This project solves the **Smart Dolphins** problem using dynamic programming to determine the maximum number of food pellets Dynamo the Dolphin can eat during her jump.

Dynamo can eat food pellets in a specific order:  
1. A non-decreasing sequence of altitudes (ascending part of the jump).  
2. A non-increasing sequence of altitudes (descending part of the jump).  

The solution calculates the longest subsequence of food pellets that satisfies these constraints.

---

## Problem Statement

Given a sequence of altitudes of food pellets, Dynamo can eat them in a single jump following the conditions:
1. The first part of the subsequence is non-decreasing.
2. The second part of the subsequence is non-increasing.

The goal is to determine the length of the **longest subsequence** that Dynamo can eat for each test case.

---

## Input and Output Format

### **Input**
The input file (`dolphin.in`) should follow this format:
1. First line: Number of test cases, `n` (1 ≤ n ≤ 1000).
2. For each test case:
   - First line: Number of food pellets, `m` (1 ≤ m ≤ 1000).
   - Next `m` lines: Altitudes of the food pellets (integers).

### **Output**
For each test case, the output is:
`Case X: Dynamo ate Y food pellet(s).`
Where:
- `X` is the test case number.
- `Y` is the maximum number of food pellets Dynamo can eat.

---

## Example

### Input:
2\
5\
12\
11\
13\
12\
11\
6\
10\
20\
30\
20\
40\
20

### Output:
`Case 1: Dynamo ate 4 food pellet(s).`\
`Case 2: Dynamo ate 5 food pellet(s).`


---

## Solution Approach

This problem is solved using **dynamic programming**. The key steps are:

1. **Calculate Longest Increasing Subsequence (LIS)**:
   - For each pellet, compute the maximum subsequence length that ends at that pellet with a non-decreasing sequence.

2. **Calculate Longest Decreasing Subsequence (LDS)**:
   - For each pellet, compute the maximum subsequence length that starts at that pellet with a non-increasing sequence.

3. **Combine LIS and LDS**:
   - For each pellet, compute the total length of the bitonic subsequence:
     
     **Bitonic length at $i = **LIS[i]** + **LDS[i]** - 1$**
     
   - Subtract 1 to avoid double-counting the peak element.

4. **Find the Maximum**:
   - For each test case, find the longest bitonic subsequence among all pellets.

---

## Time and Space Complexity

### Time Complexity:
- Calculating LIS: **$O(m^{2}$)**  for each test case.
- Calculating LDS: **$O(m^{2}$)** for each test case.
- Combining LIS and LDS: **$O(m$)**.
- Overall for **n** test cases: **$O(n \cdot m^{2}$)**.

### Space Complexity:
- Two arrays of size $m$ : **$O(m$)**
- Overall for $n$ test cases: **$O(m$)** per test case.

---



