package com.basics.math;

class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("Time & Space Complexity Analysis:\n");

        System.out.println("isPalindrome_String");
        System.out.println("Time Complexity  -> O(d) = O(log n)");
        System.out.println("Space Complexity -> O(d)  (extra string used)\n");

        System.out.println("isPalindrome_Math");
        System.out.println("Time Complexity  -> O(d) = O(log n)");
        System.out.println("Space Complexity -> O(1)  (no extra storage)\n");

        System.out.println("isPalindrome_Optimal");
        System.out.println("Time Complexity  -> O(d/2) ≈ O(log n)");
        System.out.println("Space Complexity -> O(1)  (half reverse stored)\n");
    }


    public static boolean isPalindrome_String(int n) {
        if (n < 0) return false;                          // 1 comparison
        String original = String.valueOf(n);              // d operations (convert each digit)
        String reversed = "";
        for (int i = original.length()-1; i >= 0; i--) {  // runs d times
            reversed += original.charAt(i);               // 1 charAt + 1 concat × d = 2d operations
        }
        return original.equals(reversed);                 // d comparisons (char by char)
    }

    public static boolean isPalindrome_Math(int n) {
        if (n < 0) return false;                    // 1 comparison
        if (n != 0 && n % 10 == 0) return false;   // 1 comparison + 1 modulo + 1 comparison + 1 AND = 4 operations
        int original = n;                           // 1 assignment
        int reversed = 0;                           // 1 assignment
        while (n != 0) {                            // runs d times
            int digit = n % 10;                     // 1 modulo + 1 assignment × d = 2d
            reversed = reversed * 10 + digit;       // 1 multiply + 1 add + 1 assignment × d = 3d
            n /= 10;                                // 1 division + 1 assignment × d = 2d
        }
        return original == reversed;                // 1 comparison + 1 return = 2 operations
    }

    public static boolean isPalindrome_Optimal(int n) {
        if (n < 0) return false;                    // 1 comparison
        if (n != 0 && n % 10 == 0) return false;   // 4 operations
        int reversed = 0;                           // 1 assignment
        while (n > reversed) {                      // runs d/2 times
            reversed = reversed * 10 + n % 10;      // 1 multiply + 1 modulo + 1 add + 1 assignment × d/2 = 4(d/2)
            n /= 10;                                // 1 division + 1 assignment × d/2 = 2(d/2)
        }
        return n == reversed || n == reversed / 10; // 1 comparison + 1 division + 1 comparison + 1 OR + 1 return = 5
    }


}