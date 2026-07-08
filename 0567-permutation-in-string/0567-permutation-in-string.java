class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];


        // Count frequency of s1
        for(int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
        }


        int matches = 0;

        // Initially create window
        for(int i = 0; i < 26; i++) {
            if(count1[i] == count2[i]) {
                matches++;
            }
        }


        int left = 0;

        for(int right = 0; right < n2; right++) {

            int index = s2.charAt(right) - 'a';


            // Before changing count, remove old matching status
            if(count1[index] == count2[index]) {
                matches--;
            }

            count2[index]++;


            // After adding, check matching status
            if(count1[index] == count2[index]) {
                matches++;
            }


            // Keep window size equal to s1 length
            if(right - left + 1 > n1) {

                int removeIndex = s2.charAt(left) - 'a';


                if(count1[removeIndex] == count2[removeIndex]) {
                    matches--;
                }

                count2[removeIndex]--;


                if(count1[removeIndex] == count2[removeIndex]) {
                    matches++;
                }

                left++;
            }


            // All 26 characters are matching
            if(matches == 26) {
                return true;
            }
        }


        return false;
    }
}