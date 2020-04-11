package leetcode929;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		
		System.out.println("Emails: " + Arrays.toString(emails));
		
		FindNumOfUniqueEmailFunction solution = new FindNumOfUniqueEmailFunction();
		
		System.out.println("Solution: " + solution.numUniqueEmails(emails));
	}
}
