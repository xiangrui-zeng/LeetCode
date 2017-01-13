package LeetCode;


public class LicenseKeyFormatting {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String A = "24A0-R74K";
		String B = "24-A0R-74K";
		String C ="2-4A0r7-4k";
		System.out.println(licenseKeyFormatting(B, 3));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--)
            if (S.charAt(i) != '-')
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
	
}



