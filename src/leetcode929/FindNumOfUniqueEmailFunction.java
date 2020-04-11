package leetcode929;

import java.util.HashSet;

public class FindNumOfUniqueEmailFunction {
	// Most effective
	public int numUniqueEmails(String[] emails) {
		HashSet<String> set = new HashSet<>();

		for (String email : emails) {
			StringBuilder sb = new StringBuilder();
			char[] words = email.toCharArray();

			for (int i = 0; i < words.length; i++) {
				// If we see @, just add the rest of it
				if (words[i] == '@') {
					sb.append(email.substring(i));
					break;
				}

				// Don't care if .
				if (words[i] == '.') {
					continue;
				}

				// If plus, ignore until @
				if (words[i] == '+') {
					while (words[i] != '@') {
						i++;
					}
					sb.append(email.substring(i));

					break;
				}
					
				// Number or character doesn't matter
				sb.append(words[i]);
			}

			set.add(sb.toString());
		}

		return set.size();
	}
	
	// First solution, did extra work
    public int numUniqueEmails2(String[] emails) {
        HashSet<String> set = new HashSet<>();
        
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            char[] words = email.toCharArray();
            
            boolean plusSign = false;
            boolean afterAt = false;
            
            for(int i = 0; i < words.length; i++){
                if((Character.isLetter(words[i]) || Character.isDigit(words[i])) && !plusSign){
                    sb.append(words[i]);
                } else if (words[i] == '+'){
                    plusSign = true;
                } else if (words[i] == '@'){
                    sb.append(words[i]);
                    plusSign = false;
                    afterAt = true;
                } else if (afterAt && words[i] == '.'){
                    sb.append(words[i]);
                }
            }
            System.out.println(sb.toString());
            set.add(sb.toString());
        }
        
        return set.size();
    }
}
