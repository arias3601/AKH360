import java.util.*;

public class Main {

    public static void main(String[] args) {
        theList();
        theHash();
        theTree();
        theSet();
    }

    public static void theList(){
        System.out.println("Happy List");
        List<String> myList = new ArrayList<String>();
        myList.add("Some Stuff");
        myList.add("Other Stuff");
        myList.set(0, "Not this stuff");
        myList.remove(1);
        System.out.println(myList);

        System.out.println("\nNASTY LIST");
        //NASTY
        List<String> myNastyList = new ArrayList<String>();
        myNastyList.add("Something That Works");
        //ADD NULL - nothing gets added to the list
        try {
            myNastyList.add(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Remove a number not indexed - out of bound index error
        try {
            myNastyList.remove(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //NULL as the location -  won't work, brakes even in a try catch.
        try {
           myNastyList.set((Integer)null, "YOLO");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //NULL remove - nothing gets removed
        try {
            myNastyList.remove(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Set something out of scope - No error, but doesn't work
        try {
            myNastyList.set(77, "WHERE AM I");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //get something out of scope - No error, but doesn't work
        try {
            System.out.println(myNastyList.get(99));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //get something at a negative scope - No error, but doesn't work
        try {
            System.out.println(myNastyList.get(-21));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(myNastyList);
    }

    public static void theHash(){
        System.out.println("\nHappy Hash Map");
        HashMap<String, Integer> personalNumbers = new HashMap<String, Integer>();
        personalNumbers.put("age", 21);
        personalNumbers.put("favNum", 21);
        personalNumbers.clear();
        personalNumbers.put("wakeUpTime", 6);
        personalNumbers.put("goToSleepTime", 11);
        personalNumbers.remove("wakeUpTime");

        System.out.println(personalNumbers);

        System.out.println("\nNASTY HASH");
        HashMap<String, Number> nastyNumbers = new HashMap<String, Number>();
        nastyNumbers.put("RealNumber", 21);


        //Remove null there - doesn't do anything (NOTE: THIS DOES WORK IF NULL IS SET!!!)
        try {
            nastyNumbers.remove(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Null key - actually puts something called null into it, wtf
        try {
            nastyNumbers.put(null, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //null instead of number - puts null in and it works....
        try {
            nastyNumbers.put("fakeNumber", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Remove something not there - doesn't do anything
        try {
            nastyNumbers.remove("Notreal");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Remove a number (which it could never be) - doesn't do anything
        try {
            nastyNumbers.remove(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(nastyNumbers);

    }

    public static void theTree(){
        System.out.println("\nHAPPY TREE");
        TreeMap<Integer, String> myStuff = new TreeMap<Integer, String>();
        myStuff.put(10, "Ash");
        myStuff.clear();
        myStuff.put(20, "CIT");
        myStuff.put(3, "Tutor");
        myStuff.remove(3);

        System.out.println(myStuff);

        System.out.println("\nNASTY TREE");
        TreeMap<Integer, String> nastyStuff = new TreeMap<Integer, String>();
        nastyStuff.put(10, "Legit");

        //put a postion called null instead of a number - doesn't work...
        try {
            nastyStuff.put(null, "YOLO");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //remove boolean - gets mad saying the key isnt a boolean
        try {
            nastyStuff.remove(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //remove string - gets mad saying the key isnt a string
        try {
           nastyStuff.remove("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nastyStuff);



    }

    public static void theSet(){
        System.out.println("\nHAPPY SET");
        LinkedHashSet animals = new LinkedHashSet();
        animals.add("Dog");
        animals.clear();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Mouse");
        animals.add("Cat");
        //animals.remove("Cat");


        System.out.println(animals);
        System.out.println(animals.size());

        System.out.println("\nNASTY SET");
        LinkedHashSet nastyThings = new LinkedHashSet();
        nastyThings.add("This is Okay");

        //null - will put in something at null
        try {
            nastyThings.add(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //remove boolean that doesn't exsist - no complaint, does nothing
        try {
            nastyThings.remove(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //remove string that doesn't exsist - no complaint, does nothing
        try {
            nastyThings.remove("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Union of sets, intersect of sets, everything not common of sets (ven diagram) and then nasties for those

        System.out.println(nastyThings);


        //COMBINING SETS, SET UP
        LinkedHashSet moreAnimals = new LinkedHashSet();
        moreAnimals.add("Dog");
        moreAnimals.add("Deer");
        moreAnimals.add("Cat");
        moreAnimals.add(21);
        moreAnimals.add("Sheep");

        System.out.println("\nHAPPY INTERSECTION");

        LinkedHashSet intersectionSet = new LinkedHashSet();
        intersectionSet.addAll(moreAnimals);
        intersectionSet.retainAll(animals);
        System.out.println(intersectionSet);

        System.out.println("\nHAPPY UNION");

        LinkedHashSet unionSet = new LinkedHashSet();
        unionSet.addAll(moreAnimals);
        unionSet.addAll(animals);
        System.out.println(unionSet);

        System.out.println("\nHAPPY DIFFRENCE");

        LinkedHashSet diffrenceSet = new LinkedHashSet();
        diffrenceSet.addAll(moreAnimals);
        diffrenceSet.addAll(animals);
        diffrenceSet.removeAll(intersectionSet);
        System.out.println(diffrenceSet);


        System.out.println("\nNASTY INTERSECTION/UNION/DIFFRENCE");
        //add All of null - NO ERROR, but does nothing
        try {
            intersectionSet.addAll(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //remove all of null - NO ERROR, but does nothing
        try {
            intersectionSet.removeAll(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(intersectionSet);

    }
}
