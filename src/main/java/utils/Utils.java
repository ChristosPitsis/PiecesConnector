package utils;

public class Utils {

    /**
     * @param index
     * @return index as a string
     * @desc This is used to return the point name as a String
     * to be used by the graph
     */
    public String getPointFromIndex(Integer index) {

        return "" + index;
    }

    /**
     * @param point
     * @return point as an index
     * @desc This is used to return the index in the list
     * using the point name
     */
    public Integer getIndexFromPoint(String point) {

        return Integer.parseInt(point);
    }

    /**
     * @param a
     * @param b
     * @return merge weight
     * @desc This is used to check if one string can merge with another
     * and how many characters is their merge weight
     */
    public Integer canExtend(String a, String b) {

        char startingB = b.charAt(0);
        for (int i = 0; i < a.length(); i++) {
            // When we find the startingB character
            // check if the rest is the starting of whole B String
            if (a.charAt(i) == startingB) {
                if (b.startsWith(a.substring(i))) {
                    // We return the number of characters that merge
                    return a.length() - i;
                }
            }
        }
        // If we reached that point, the strings cannot merge (b does not extend a)
        // so the merging weight is 0
        return 0;
    }

    public String mergeString(String a, String b) {

        // We will merge a to b, so we just need to remove the duplicate characters
        char startingB = b.charAt(0);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == startingB) {
                if (b.startsWith(a.substring(i))) {
                    //System.out.println("String: " + b + " starts with: " + a.substring(i));
                    //System.out.println("String: " + b + " can merge with: " + a);
                    return a.substring(0, i) + b;
                }
            }
        }

        throw new Error("Error merging " + a + " and " + b);
    }
}