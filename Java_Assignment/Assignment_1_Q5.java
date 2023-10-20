import java.util.Scanner;

 class SentenceAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        int wordCount = countWords(sentence);
        System.out.println("Number of words in the sentence are : " + wordCount);
        
        String[] words = sentence.split(" ");
        System.out.println("Palindrome word in  the sentence are :");
        for (String element : words) {
            if (isPalindrome(element)) {
                System.out.println(element);
            }
        }
        
        sc.close();
    }
    
    
    public static int countWords(String sentence) {
        String[] words = sentence.split(" ");
        return words.length;
    }
    
    
    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
