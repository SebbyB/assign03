package assign03;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayCollectionTester {


    @Test public void testetst(){
        assertEquals(1,1);
    }
//add Method Testers ----------------------------------------------------
    @Test
    public void addToArrayString(){

        ArrayCollection testingArray = new ArrayCollection<String>();

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
    public void addToArrayGeneric(){

        ArrayCollection testingArray = new ArrayCollection<Integer>();

        Integer Int1 = new Integer(1);
        Integer Int2 = new Integer(12);
        Integer Int3 = new Integer(169);
        Integer Int4 = new Integer(420);

        testingArray.add(Int1);
        testingArray.add(Int2);
        testingArray.add(Int3);
        testingArray.add(Int4);

        assertTrue(testingArray.contains(Int1));
        assertTrue(testingArray.contains(Int2));
        assertTrue(testingArray.contains(Int3));
        assertTrue(testingArray.contains(Int4));
    }
    @Test
    public void addToArrayRepeatandtoArray(){

        ArrayCollection testingArray = new ArrayCollection<String>();
        String[] stringArray = {"cat", "bat", "rat", "hat"};

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "cat";
        String string4 = "rat";
        String string5 = "hat";

        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);
        testingArray.add(string5);

        assertTrue(testingArray.add(string1));
        assertTrue(testingArray.add(string2));
        assertTrue(testingArray.add(string4));
        assertTrue(testingArray.add(string5));
        assertFalse(testingArray.add(string3));
        assertEquals(stringArray,testingArray.toArray());

    }

//grow Method Testers ----------------------------------------------------
    @Test
    public void growBy10(){

        ArrayCollection testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 10; i++){
            testingArray.add(new Integer(i));
        }
//        assertEquals(10, testingArray.getData().length);



    }

    @Test
    public void growBy20(){

        ArrayCollection testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 11; i++){
            testingArray.add(new Integer(i));
        }
//        assertEquals(20, testingArray.getData().length);

    }


    @Test
    public void growBy40(){

        ArrayCollection testingArray = new ArrayCollection<Integer>();

        for(int i = 0; i < 21; i++){
            testingArray.add(new Integer(i));
        }
//        assertEquals(40, testingArray.getData().length);
    }


//addAll Method Testers ----------------------------------------------------

    @Test
    public void addAllToArrayString(){

        ArrayCollection testingArray = new ArrayCollection<String>();
        ArrayCollection testingArray2 = new ArrayCollection<String>();

        String string1 = "cat";
        String string2 = "bat";
        String string3 = "hat";
        String string4 = "rat";

        testingArray.add(string1);
        testingArray.add(string2);
        testingArray.add(string3);
        testingArray.add(string4);
//
//        assertEquals(string1,testingArray.getData[1]);
//        assertEquals(string2,testingArray.getData[2]);
//        assertEquals(string3,testingArray.getData[3]);
//        assertEquals(string4,testingArray.getData[4]);

    }


}
