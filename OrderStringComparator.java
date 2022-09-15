package assign03;

import java.util.Comparator;

class OrderStringComparator implements Comparator<String> {

    /**

     * Returns a negative value if lhs beginning/smaller

     * Returns a positive value if lhs later/larger less overdue .

     * Returns 0 if lhs and rhs are the same word

     */


    public int compare(String lhs, String rhs) {




        String LHS = lhs;

        String RHS = rhs;


        int smaller;

        if(LHS.length() < RHS.length()|| LHS.length() == RHS.length()) {

            smaller = LHS.length();

        }

        else{

            smaller = RHS.length();

        }

        for(int i = 0; i < smaller ;i++) {

            if(LHS.charAt(i) < RHS.charAt(i)) {

                return -1;

            }

            if(LHS.charAt(i) > RHS.charAt(i)) {

                return 1;

            }

        }

        if(LHS.length() < RHS.length()) {

            return -1;

        }

        if(RHS.length() < LHS.length()) {

            return 1;

        }

        return 0;


    }


}
