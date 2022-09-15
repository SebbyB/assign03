package assign03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;



public class ArrayCollectionTester {

    int testStartNum = 0;
    int testRemoveNum = 5;
    int testEndNum = 10;
//add Method Testers ----------------------------------------------------
    @Test
    public void addToCollectionGeneralString(){

        ArrayCollection<String> testingArray = new ArrayCollection<String>();

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";

        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);

        assertTrue(testingArray.contains(string1));
        assertTrue(testingArray.contains(string2));
        assertTrue(testingArray.contains(string3));
        assertTrue(testingArray.contains(string4));

    }

    @Test
    public void addTocollectionGenericInteger(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();

        Integer Int1 = (1);
        Integer Int2 = (12);
        Integer Int3 = (169);
        Integer Int4 = (420);

        testingArray.add(Int1);
        testingArray.add(Int2);
        testingArray.add(Int3);
        testingArray.add(Int4);

        assertTrue(testingArray.contains(Int1));
        assertTrue(testingArray.contains(Int2));
        assertTrue(testingArray.contains(Int3));
        assertTrue(testingArray.contains(Int4));
        
      //add Method + To Array tester ----------------------------------------------------
    }
    @Test
    public void addRepeatWithToArrayArray(){

        ArrayCollection<String> testingArray = new ArrayCollection<String>();
        String[] stringArray = {"cat", "bat", "rat", "hat"};

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "cat";
        String string4 = "rat";
        String string5 = "hat";


        assertTrue(testingArray.add(string1));
        assertTrue(testingArray.add(string2));
        assertFalse(testingArray.add(string3));
        assertTrue(testingArray.add(string4));
        assertTrue(testingArray.add(string5));

        Iterator<String> iteratorTestor = testingArray.iterator();  
        assertEquals(string1, iteratorTestor.next());
        assertEquals(string2, iteratorTestor.next());
        assertEquals(string4, iteratorTestor.next());
        assertEquals(string5, iteratorTestor.next());
        assertFalse(iteratorTestor.hasNext());


    }

//grow Method Testers ----------------------------------------------------
    @Test
    public void growBy10(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 10; i++){
            testingArray.add(i);
        }
        Iterator<Integer> iteratorTestor = testingArray.iterator(); 
        
        for(int i = 0; i<10; i++) {
        assertTrue(iteratorTestor.hasNext());
        iteratorTestor.next();
        }
        assertFalse(iteratorTestor.hasNext());


    }

    @Test
    public void growBy20(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 11; i++){
            testingArray.add(i);
        }
        Iterator<Integer> iteratorTestor = testingArray.iterator(); 
        
        for(int i = 0; i<11; i++) {
        assertTrue(iteratorTestor.hasNext());
        iteratorTestor.next();
        }
        assertFalse(iteratorTestor.hasNext());

    }


    @Test
    public void growBy40(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 21; i++){
            testingArray.add(i);
        }
        Iterator<Integer> iteratorTestor = testingArray.iterator(); 
        
        for(int i = 0; i<21; i++) {
        assertTrue(iteratorTestor.hasNext());
        iteratorTestor.next();

        }
        assertFalse(iteratorTestor.hasNext());
    }
    @Test
    public void growBy1000(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 1000; i++){
            testingArray.add(i);
        }
        Iterator<Integer> iteratorTestor = testingArray.iterator();

        for(int i = 0; i<1000; i++) {
        assertTrue(iteratorTestor.hasNext());
        iteratorTestor.next();

        }
        assertFalse(iteratorTestor.hasNext());
    }



//addAll Method Testers ----------------------------------------------------

    @Test
    public void addAllToCollectionString(){

        ArrayCollection<String> testingArray = new ArrayCollection<String>();
        ArrayCollection<String> testingArrayInput = new ArrayCollection<String>();
        Iterator<String> iteratorTestor = testingArray.iterator(); 

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";

        testingArrayInput.add(string1);
        testingArrayInput.add(string2);
        testingArrayInput.add(string3);
        testingArrayInput.add(string4);
        
        testingArray.addAll(testingArrayInput);

        assertEquals(string1,iteratorTestor.next());
        assertEquals(string2,iteratorTestor.next());
        assertEquals(string3,iteratorTestor.next());
        assertEquals(string4,iteratorTestor.next());

    }
    @Test
    public void addAllToCollectionNothingAddedString(){

        ArrayCollection<String> testingArray = new ArrayCollection<String>();
        ArrayCollection<String> testingArrayInput = new ArrayCollection<String>();
        Iterator<String> iteratorTestor = testingArray.iterator(); 

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";
        
        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);

        testingArrayInput.add(string1);
        testingArrayInput.add(string2);
        testingArrayInput.add(string3);
        testingArrayInput.add(string4);
        

        assertFalse(testingArray.addAll(testingArrayInput));
   
    }
   
    //Clear Method Testers ---------------------------------------------------- 
    @Test
    public void EmptyCollectionString(){

        ArrayCollection<String> testingArray = new ArrayCollection<String>();
        Iterator<String> iteratorTestor = testingArray.iterator(); 

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";
        
        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);
        
        assertTrue(iteratorTestor.hasNext());
        
        testingArray.clear();
        
        assertFalse(iteratorTestor.hasNext());
        assertFalse(testingArray.size() >0);
        assertTrue(testingArray.isEmpty());
    }
    
    //Contains Method Testers ---------------------------------------------------- 
   @Test
   public void containsThing(){

        String thing = "thing";


       ArrayCollection<String> testingArray = new ArrayCollection<String>();
       String string1 = "cat";
       String string2 = "bat";
       String string3 = "hat";
       String string4 = "rat";
       String string5 = "not a thing that is in the array";


       testingArray.add(string1);
       testingArray.add(string2);
       testingArray.add(string3);
       testingArray.add(string4);
       testingArray.add(thing);

       assertTrue(testingArray.contains(thing));
       assertFalse(testingArray.contains(string5));
   }

    @Test
    public void containsAllThing(){

        String thing1 = "thing1";
        String thing2 = "thing2";
        String thing3 = "thing3";
        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";
        String string5 = "this";

        ArrayCollection<String> testingArray = new ArrayCollection<String>();
        ArrayCollection<String> thingList = new ArrayCollection<String>();
        ArrayCollection<String> notThingList = new ArrayCollection<String>();



        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);
        testingArray.add(thing1);
        testingArray.add(thing2);
        testingArray.add(thing3);
        thingList.add(thing1);
        thingList.add(thing2);
        thingList.add(thing3);
        notThingList.add(string5);
        notThingList.add(string1);
        notThingList.add(string4);

        assertTrue(testingArray.containsAll(thingList));
        assertFalse(testingArray.containsAll(notThingList));
    }

    @Test
    public void containsCollectionString(){

        ArrayCollection<String> testingArray = new ArrayCollection<String>();


        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";
        
        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);
        
        assertTrue(testingArray.contains(string1));
        assertFalse(testingArray.contains("NO"));
        assertTrue(testingArray.contains(string2));
        assertFalse(testingArray.contains("sat"));
    }
    //Removes Method Testers ----------------------------------------------------

    @Test
    public void removeInts(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();

      for(int i = testStartNum; i < testEndNum; i++){
          assertTrue(testingArray.add(i));
        }
      for(int j = testStartNum; j < testRemoveNum; j++){
      assertTrue(testingArray.remove(j));
      assertFalse(testingArray.contains(j));}
    }

    @Test
    public void removeIntsMiddle(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        int testIndex = 2;

      for(int i = testStartNum; i < testEndNum; i++){
          assertTrue(testingArray.add(i));
        }

      assertTrue(testingArray.remove(testIndex));
      assertFalse(testingArray.contains(testIndex));
    }
    @Test
    public void removeCollectionInts(){

        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        ArrayCollection<Integer> removeArray = new ArrayCollection<Integer>();

      for(int i = testStartNum; i < testEndNum; i++){
          assertTrue(testingArray.add(i));
          if(i < testRemoveNum){
          removeArray.add(i);}
        }
      assertTrue(testingArray.removeAll(removeArray));

      assertFalse(testingArray.containsAll(removeArray));

    }


    //Iterator Tester ----------------------------------------------------


    @Test
    public void hasNextWorks(){
        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        for(int i = testStartNum; i < testEndNum; i++){

            assertTrue(testingArray.add(i));
            if(i < (testEndNum - 1)){
                assertTrue(testingArray.iterator().hasNext());
            } else if (i == testEndNum) {assertFalse(testingArray.iterator().hasNext());

            }

        }
    }

    @Test
    public void nextWorks(){
        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        for(int i = testStartNum; i < testEndNum; i++){

            assertTrue(testingArray.add(i));
            if(i < (testEndNum - 1)){
                assertTrue(testingArray.iterator().hasNext());
//                assertDoesNotThrow(testingArray.iterator().next())
                assertTrue(testingArray.contains(testingArray.iterator().next()));
            } else if (i == testEndNum) {
                assertFalse(testingArray.iterator().hasNext());
                //assert throws
                assertThrows(NoSuchElementException.class, () -> {testingArray.iterator().next();});

            }

        }
    }

    @Test
    public void iteratorRemoveWorks(){
        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        for(int i = testStartNum; i < testEndNum; i++){

            assertTrue(testingArray.add(i));
            if(i < (testEndNum - 1)){
                testingArray.iterator().remove();
                assertFalse(testingArray.contains(i));}
            else if (i == testEndNum) {
                assertFalse(testingArray.iterator().hasNext());
                assertThrows(IllegalStateException.class, () -> {testingArray.iterator().remove();});
            }

            }
        }
//RetainAll Tester ----------------------------------------------------

    @Test
    public void retainAllSmall(){
        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        ArrayCollection<Integer> removeArray = new ArrayCollection<Integer>();

            assertTrue(testingArray.add(1));
            assertTrue(testingArray.add(2));
            assertTrue(testingArray.add(3));
            assertTrue(testingArray.add(4));
            assertTrue(removeArray.add(1));
            assertTrue(removeArray.add(3));

        assertTrue(testingArray.retainAll(removeArray));
        assertFalse(testingArray.contains(2));
        assertFalse(testingArray.contains(4));



    }

    @Test
        public void retainAllItemsGeneral(){
            ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
            ArrayCollection<Integer> removeArray = new ArrayCollection<Integer>();

            for(int i = testStartNum; i < testEndNum; i++){
                assertTrue(testingArray.add(i));
                if(i < testRemoveNum){
                    removeArray.add(i);}
            }
            assertTrue(testingArray.retainAll(removeArray));
            assertTrue(testingArray.containsAll(removeArray));

    }

    @Test
    public void retainAllDoesntHaveAll(){
        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();
        ArrayCollection<Integer> removeArray = new ArrayCollection<Integer>();

        for(int i = testStartNum; i < testEndNum; i++){
            assertTrue(testingArray.add(i));
            if(i < testRemoveNum){
                removeArray.add(i);}
        }
        removeArray.add(testEndNum + 1);

        assertTrue(testingArray.retainAll(removeArray));
        assertFalse(testingArray.containsAll(removeArray));


    }


    // Testing To Sort array


    @Test

    public void toSortedInteger(){


        ArrayCollection<Integer> testingArray = new ArrayCollection<Integer>();


        Integer Int1 = (1);

        Integer Int2 = (-1);

        Integer Int3 = (169);

        Integer Int4 = (30);



        testingArray.add(Int1);

        testingArray.add(Int2);

        testingArray.add(Int3);

        testingArray.add(Int4);



        Comparator<Integer> compare = new NumberComparator();



        assertEquals(Int2,testingArray.toSortedList(compare).get(0));

        assertEquals(Int1,testingArray.toSortedList(compare).get(1));

        assertEquals(Int4,testingArray.toSortedList(compare).get(2));

        assertEquals(Int3,testingArray.toSortedList(compare).get(3));



    }



    @Test

    public void toSortedString(){


        ArrayCollection<String> testingArray = new ArrayCollection<String>();


        String string1 = "zebra";

        String string2 = "batman";

        String string3 = "bat";

        String string4 = "felt";

        String string5 = "abe";


        testingArray.add(string1);

        testingArray.add(string2);

        testingArray.add(string3);

        testingArray.add(string4);

        testingArray.add(string5);



        Comparator<String> compare = new OrderStringComparator();



        assertEquals("abe",testingArray.toSortedList(compare).get(0));

        assertEquals("bat",testingArray.toSortedList(compare).get(1));

        assertEquals("batman",testingArray.toSortedList(compare).get(2));

        assertEquals("felt",testingArray.toSortedList(compare).get(3));

        assertEquals("zebra",testingArray.toSortedList(compare).get(4));



    }





}


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

