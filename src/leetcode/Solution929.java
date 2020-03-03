package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution929 {
	public int numUniqueEmails(String[] emails) {
		Set<String> uniqEmails = new HashSet<>();
		for (String email : emails) {
			String[] localAndDomain = email.split("@");
			StringBuilder sb = new StringBuilder();
			for (char c : localAndDomain[0].toCharArray()) {
				if (c == '.') {
					continue;
				} else if (c == '+') {
					break;
				} else {
					sb.append(c);
				}
			}
			sb.append("@").append(localAndDomain[1]);
			uniqEmails.add(sb.toString());
		}
		return uniqEmails.size();
	}
}