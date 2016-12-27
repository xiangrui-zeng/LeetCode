package LeetCode;

public class ValidateIPAddress {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String A = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
		System.out.println(validIPAddress(A));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static String validIPAddress(String IP) {
		if (IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":")) {
			return "Neither";
		}
        String[] Ipv4Array = IP.split("\\.");
        if (Ipv4Array.length == 4) {
        	for (String num : Ipv4Array) {
        		if (!isValidIPv4Num(num)) {
        			return "Neither";
        		}
        	}
        	return "IPv4";
        }
        String[] Ipv6Array = IP.split(":");
        if (Ipv6Array.length == 8) {
        	for (String num : Ipv6Array) {
        		if (!isValidIPv6Num(num)) {
        			return "Neither";
        		}
        	}
        	return "IPv6";
        }
        return "Neither";
    }
	
	public static boolean isValidIPv4Num(String num){
		if (num == null || num.length() > 3 || num.length() == 0 ||( num.length() > 1 && num.charAt(0) == '0' )) {
			return false;
		}
		for (int i = 0; i < num.length(); i++) {
			if ('9'< num.charAt(i) || num.charAt(i) < '0') {
				return false;
			}
		}
		try {
			if (Integer.valueOf(num) > 255) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidIPv6Num(String num){
		if (num == null || num.length() == 0 || num.length() > 4) {
			return false;
		}
		for (int i = 0; i < num.length(); i++) {
			if ('f' >= num.charAt(i) && num.charAt(i) >= 'a') {
				continue;
			}
			if ('F' >= num.charAt(i) && num.charAt(i) >= 'A') {
				continue;
			}
			if ('9' >= num.charAt(i) && num.charAt(i) >= '0') {
				continue;
			}
			return false;
		}
		return true;
	}
    
}



