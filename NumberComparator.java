package assign03;

import java.util.Comparator;

class NumberComparator implements Comparator<Integer> {

    /**

     * Returns a negative value if lhs smaller

     * Returns a positive value if lhs larger .

     * Returns 0 if lhs and rhs are the same

     */




    @Override

    public int compare(Integer lhs, Integer rhs) {


        if (lhs > rhs){

            return 1;

        }

        if (lhs < rhs) {

            return -1;

        }

        return 0;

    }


}

