import java.util.*;

public class AlgoQ1 {

    public static Set<String> permutationIterative(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            return permutations;
        }

        permutations.add(String.valueOf(str.charAt(0))); 

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            Set<String> newPermutations = new HashSet<>();

            for (String perm : permutations) {
                for (int j = 0; j <= perm.length(); j++) {
                    String newPerm = perm.substring(0, j) + currentChar + perm.substring(j);
                    newPermutations.add(newPerm);
                }
            }
            permutations = newPermutations;
        }
        return permutations;
    }

    public static Set<String> permutationRecursive(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null) {
            return permutations;
        }
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char firstChar = str.charAt(0);
        String remaining = str.substring(1);
        Set<String> words = permutationRecursive(remaining);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String perm = word.substring(0, i) + firstChar + word.substring(i);
                permutations.add(perm);
            }
        }
        return permutations;
    }

    public static boolean arePermutationSetsEqual(Set<String> set1, Set<String> set2) {
        List<String> list1 = new ArrayList<>(set1);
        List<String> list2 = new ArrayList<>(set2);
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    public static void main(String[] args) {
        String str = "abc";
        Set<String> permutationsIterative = permutationIterative(str);
        Set<String> permutationsRecursive = permutationRecursive(str);

        boolean isEqual = arePermutationSetsEqual(permutationsIterative, permutationsRecursive);
        System.out.println("Are both permutation sets equal? " + isEqual);
    }
}
