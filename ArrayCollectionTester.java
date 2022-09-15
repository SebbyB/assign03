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


public class ArrayCollectionTester {

    int testStartNum = 0;
    int testRemoveNum = 10;
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

//                assertDoesNotThrow(testingArray.iterator().next());
                assertTrue(testingArray.contains(testingArray.iterator().next()));
            } else if (i == testEndNum) {
                assertFalse(testingArray.iterator().hasNext());
                //assert throws

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
////            else if (i == testEndNum) {assertFalse(testingArray.iterator().hasNext());

            }
        }








}
