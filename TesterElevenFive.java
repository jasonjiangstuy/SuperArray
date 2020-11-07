import java.util.Arrays;

public class TesterElevenFive {

  public static void main(String[] args) {
    System.out.println("SuperArray Tester");
    boolean failure = false;
    failure = constructorTester() || failure;
    failure = addAndGetAndSizeTester() || failure;
    //failure = outOfBoundsGetTester()  || failure;
    failure = setTester() || failure;
    failure = resizeTester() || failure;
    failure = clearTester() ||  failure;
    failure = isEmptyTester() || failure;
    failure = toStringTester() || failure;
    failure = containsTester() || failure;
    failure = constructorWithInitialCapacityTester() || failure;
    failure = addAtIndexTester() || failure;
    failure = removeTester() || failure;
    failure = indexOfTester() ||failure;
    failure = toArrayTester() || failure;

    System.out.println("\n ~~~ Overall Result ~~~");
    if (failure) {
      System.out.println("Is that blue smoke?");
    } else {
      System.out.println("All's good in the neighborhood");
    }
  }

  private static void passMessage (int testCase) {
    System.out.println("Test case " + testCase + " passed.");
  }

  private static void errorMessage(int testCase, String expected, String actual) {
    System.out.println("WE HAVE FAILED AT TEST CASE " + testCase);
    System.out.println("EXPECTED: " + expected);
    System.out.println("ACTUAL: " + actual);
  }

  private static void methodMessage(String method, boolean failure) {
    if (failure) {
      System.out.println("\nAt least one test case failed for " + method);
    } else {
      System.out.println(method + " PASSED");
    }
  }

  private static SuperArray defaultTestArray() {
    SuperArray test = new SuperArray();
    for (int i = 0; i < 8; i++) {
      test.add("test" + i);
      // System.out.println(test.size());
    }
    return test;
  }

  public static boolean constructorTester() {
    System.out.println("\n ~~~ constructor TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    if (test.size() == 0) {
      //passMessage(0);
    } else {
      failure = true;
      errorMessage(0, "" + 0, "" + test.size());
    }

    methodMessage("constructorTester()", failure);
    return failure;
  }

  public static boolean addAndGetAndSizeTester() {
    System.out.println("\n ~~~ add() AND get() AND size() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    String[] elementsToAdd = {
      "foo",
      "bar",
      "bread"
    };

    System.out.println("add() + size() Portion of Testing");
    for (int index = 0; index < elementsToAdd.length; index++) {
      test.add(elementsToAdd[index]);
      int expectedSize = index + 1;
      if (test.size() == expectedSize) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "" + (expectedSize), "" + test.size());
      }
    }
    methodMessage("add() and size() testing", failure);


    System.out.println("\nget() Portion of Testing");
    boolean failureForGet = false;
    for (int index = 0; index < elementsToAdd.length; index++) {
      String expectedGet = elementsToAdd[index];
      if (test.get(index).equals(expectedGet)) {
        //passMessage(index);
      } else {
        failureForGet = true;
        errorMessage(index, expectedGet, test.get(index));
      }
    }
    methodMessage("get()", failureForGet);

    failure = failure || failureForGet;
    methodMessage("\naddAndGetAndSizeTester()", failure);
    return failure;
  }

  public static boolean outOfBoundsGetTester() {
    System.out.println("\n ~~~ Out of Bounds get() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    String[] elementsToAdd = {
      "foo",
      "bar",
      "bread"
    };
    for (int index = 0; index < elementsToAdd.length; index++) {
      test.add(elementsToAdd[index]);
    }
    for (int index = 3; index < 12; index++) {
      if (test.get(index) == null) {
        //passMessage(index - 3);
      } else {
        failure = true;
      }
    }

    methodMessage("out of bounds get() ", failure);
    return failure;
  }

  public static boolean setTester() {
    System.out.println("\n ~~~ set() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    String[] elementsToAdd = {
      "foo",
      "bar",
      "bread"
    };

    System.out.println("Testing while not adding");
    boolean unchangedArrayFailure = false;
    for (int index = 0; index < elementsToAdd.length; index++) {
      test.add(elementsToAdd[index]);
    }
    for (int index = 0; index < elementsToAdd.length; index++) {
      String output = test.set(index, "banas");
      String expected = elementsToAdd[index];

      if (output.equals(expected)) {
        /*System.out.println("Returns correct value.");
        passMessage(index);*/
      } else {
        failure = true;
        unchangedArrayFailure = true;
        System.out.println("Does not return correct value.");
        errorMessage(index, expected, output);
      }

      if (test.get(index).equals("banas")) {
        /*System.out.println("Sets correct value.");
        passMessage(index);*/
      } else {
        failure = true;
        unchangedArrayFailure = true;
        System.out.println("Sets incorrect value.");
      }
    }
    methodMessage("unchangedArray set()", unchangedArrayFailure);

    System.out.println("\nTesting while adding.");
    test = new SuperArray();
    boolean changingArrayFailure = false;
    for (int index = 0; index < elementsToAdd.length; index++) {
      test.add(elementsToAdd[index]);
      String output = test.set(index, "banas");
      String expected = elementsToAdd[index];

      if (output.equals(expected)) {
        /*System.out.println("Returns correct value.");
        passMessage(index);*/
      } else {
        failure = true;
        changingArrayFailure = true;
        System.out.println("Does not return correct value.");
        errorMessage(index, expected, output);
      }

      if (test.get(index).equals("banas")) {
        /*System.out.println("Sets correct value.");
        passMessage(index);*/
      } else {
        failure = true;
        changingArrayFailure = true;
        System.out.println("Sets incorrect value.");
        errorMessage(index, "banas", test.get(index));
      }
    }
    methodMessage("changingArray set()", changingArrayFailure);

    failure = failure || changingArrayFailure || unchangedArrayFailure;
    methodMessage("setTester()", failure);
    return failure;
  }

  public static boolean resizeTester() {
    System.out.println("\n ~~~ resize() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    for (int n = 0; n < 32; n++) {
      test.add("foo");
    }

    for (int index = 0; index < 32; index++) {
      if (test.get(index).equals("foo")) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "foo", test.get(index));
      }
    }

    if (test.size() != 32) {
      failure = true;
      System.out.println("Sizing is incorrect.");
    } else {
      System.out.println("Sizing is correct.");
    }

    methodMessage("resize()", failure);
    return failure;
  }

  public static boolean clearTester() {
    System.out.println("\n ~~~ clear() TESTER ~~~");
    boolean failure = false;
    SuperArray test = defaultTestArray();
    SuperArray before = defaultTestArray();

    for (int index = 0; index < test.size(); index++) {
      if (test.get(index).equals(before.get(index))) {
        //passMessage(index);
      } else {
        failure = true;
        System.out.println("Uh oh. Default array assignment is off.");
        errorMessage(index, before.get(index), test.get(index));
      }
    }

    test.clear();
    /* for (int index = 0; index < before.size() /*this checks if any referrals to old values; index++) {
      boolean passed = true;
      if (test.get(index) != null) {
        passed = false;
        errorMessage(index, null, test.get(index));
      }
      if (before.get(index) == null) {
        passed  = false;
        errorMessage(index, defaultTestArray().get(index), before.get(index));
      }
      if (passed) {
        //passMessage(index);
      }
      failure = failure || !passed;
    }*/

    methodMessage("clear()", failure);
    return failure;
  }

  public static boolean isEmptyTester() {
    System.out.println("\n ~~~ isEmpty() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();

    if (test.isEmpty()) {
      //System.out.println("New SuperArrays do verify as empty.");
    } else {
      failure = true;
      System.out.println("New SuperArrays don't verify as empty.");
    }

    test = defaultTestArray();
    if (test.isEmpty() == false) {
      //System.out.println("Occupied SuperArrays aren't empty.");
    } else {
      failure = true;
      System.out.println("Occupied SuperArrays evaluate as empty.");
    }

    test.clear();
    if (test.isEmpty()) {
      //System.out.println("Cleared SuperArrays are empty.");
    } else {
      failure = true;
      System.out.println("Cleared SuperArrays do not evaluate as empty.");
    }

    methodMessage("isEmpty()", failure);
    return failure;
  }

  public static boolean toStringTester() {
    System.out.println("\n ~~~ toString() TESTER ~~~");
    boolean failure = false;
    SuperArray[] tests = {
      new SuperArray(),
      defaultTestArray(),
      //defaultTestArray()
    };
    //tests[2].set(2, null);                                                      //pops holes in some areas of the SuperArray
    //tests[2].set(6, null);

    String[] expected = {
      "[]",
      "[test0, test1, test2, test3, test4, test5, test6, test7]",
      "[test0, test1, test3, test4, test5, test7]"
    };

    for (int index = 0; index < tests.length; index++) {
      if (tests[index].toString().equals(expected[index])) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, expected[index], tests[index].toString());
      }
    }

    methodMessage("toString()", failure);
    return failure;
  }

  public static boolean containsTester() {
    System.out.println("\n ~~~ contains() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();

    System.out.println("Testing with an empty array.");
    if (test.contains("blah")) {
      failure = true;
      System.out.println("Uh oh, it thinks new empty arrays have stuff.");
    } else {
      //System.out.println("Empty arrays contain nothing!");
    }

    if (test.contains(null)) {
      failure = true;
      System.out.println("It should not contain null.");
    } else {
      //System.out.println("Yup, it ignores null");
    }

    System.out.println("\nTesting with not empty array.");
    test = defaultTestArray();
    if (test.contains("test7") && test.contains("test0") && test.contains("test2")) {
      //System.out.println("It does contain all the stuff! Even the extremities!");
    } else {
      failure = true;
      System.out.println("You got an error with contains. Probably the extremities.");
    }

    if (!test.contains("test8")) {
      //System.out.println("It doesn't think it contains stuff that's not in the Array.");
    } else {
      failure = true;
      System.out.println("It thinks the array has stuff it doesn't.");
    }
    System.out.println(test);
    if (test.contains(null)) {
      failure = true;
      System.out.println("How does it think it has null? The array is filled.");
    } else {
      //System.out.println("Your array doesn't think it has null values in a full array!");
    }

    /* System.out.println("\nTesting with not holes in array.");
    test.set(2, null);
    test.set(6, null);
    if (test.contains("test7") && test.contains("test0") && test.contains("test1")) {
      //System.out.println("It does contain all the stuff! Even the extremities!");
    } else {
      failure = true;
      System.out.println("You got an error with contains. Probably the extremities.");
    }

    if (test.contains("test2")) {
      failure = true;
      System.out.println("It thinks it contains a deleted value.");
    } else {
      //System.out.println("It does not think it contains a deleted value.");
    }

    if (!test.contains("test8")) {
      //System.out.println("It doesn't think it contains stuff that's not in the Array.");
    } else {
      failure = true;
      System.out.println("It thinks the array has stuff it doesn't.");
    }

    if (test.contains(null)) {
      failure = true;
      System.out.println("How does it think it has null? It shouldn't think that.");
    } else {
      //System.out.println("Your array doesn't think it has null values even with holes in the static!");
    }

*/
    methodMessage("contains()", failure);
    return failure;
  }

  public static boolean constructorWithInitialCapacityTester() {
    System.out.println("\n ~~~ constructor with initial array size TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray(200);
    for (int i = 0; i < 500; i++) {
      try {
        test.add("" + i);
        //System.out.println("" + i + " added");
      } catch (Exception e) {
        errorMessage(i, "It to add.", "It didn't add");
        failure = true;
      }
    }

    methodMessage("constructorWithInitialCapacitySet()", failure);
    return failure;
  }

  public static boolean addAtIndexTester() {
    System.out.println("\n ~~~ addAtIndexTester() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    System.out.println("Testing negative and out of bounds methods.");
    //try {
      //test.add(-1, "0");
      //failure = true;
      //System.out.println("Someone added to a negative index.");
  //  } catch (Exception e) {
      //System.out.println("Yup, can't add to a negative index.");
  //  }

  /*  try {
      test.add(0, "0");
      failure = true;
      System.out.println("Inserting at out of bounds index!");
    } catch (Exception e) {
      //System.out.println("Yup, can't insert to something out of index.");
    }

    try {
      test.add(1, "0");
      failure = true;
      System.out.println("Inserting at out of bounds index!");
    } catch (Exception e) {
      //System.out.println("Yup, can't insert to something out of index 2.");
    }*/

    System.out.println("\nTesting actual insertions: Extremities");
    test = defaultTestArray();
    int[] indexToInsert = {
      0,
      7,
      6,
    };
    String[] expected = {
      "[0, test0, test1, test2, test3, test4, test5, test6, test7]",
      "[test0, test1, test2, test3, test4, test5, test6, 0, test7]",
      "[test0, test1, test2, test3, test4, test5, 0, test6, test7]",
    };

    for (int index = 0; index < indexToInsert.length; index++) {
      try {
        //System.out.println(test.toString());
        test.add(indexToInsert[index], "0");
        if (test.toString().equals(expected[index])) {
          //System.out.println("Added right! \n" + test.toString());
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, expected[index], test.toString());
        }

        if (test.size() == 9) {
          //System.out.println("Size right!"";
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, "" + 9, "" + test.size());
        }
      } catch (Exception e) {
        failure = true;
        System.out.println("You're adding out of index, kid. You shouldn't.");
      }
      test = defaultTestArray();
    }

    System.out.println("\nTesting actual insertions with Holes: Extremities");
    test = defaultTestArray();
    String[] newExpecteds = {
      "[0, test1, test2, test3, test4, test5, test6, test7]",
      "[test0, test1, test2, test3, test4, test5, test6, 0]",
      "[test0, test1, test2, test3, test4, test5, 0, test7]",
    };
    expected = newExpecteds;

    /*for (int index = 0; index < indexToInsert.length; index++) {
      test.set(indexToInsert[index], null);
      try {
        //System.out.println(test.toString());
        test.add(indexToInsert[index], "0");
        if (test.toString().equals(expected[index])) {
          //System.out.println("Added right! \n" + test.toString());
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, expected[index], test.toString());
        }

        if (test.size() == 9) {
          //System.out.println("Size right!"";
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, "" + 8, "" + test.size());
        }
      } catch (Exception e) {
        failure = true;
        System.out.println("You're adding out of index, kid. You shouldn't.");
      }
      test = defaultTestArray();
    }*/

    int expectedSize = 9;
    String[] newExpecteds2 = {
      "[0, test0, test1, test2, test4, test5, test6, test7]",
      "[0, test0, test1, test2, test4, test5, test6, 0, test7]",
      "[0, test0, test1, test2, test4, test5, 0, test6, 0, test7]"
    };
    expected = newExpecteds2;
    /*test.set(3, null);
    for (int index = 0; index < indexToInsert.length; index++) {
      try {
        //System.out.println(test.toString());
        test.add(indexToInsert[index], "0");
        if (test.toString().equals(expected[index])) {
          //System.out.println("Added right! \n" + test.toString());
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, expected[index], test.toString());
        }

        if (test.size() == expectedSize) {
          //System.out.println("Size right!"";
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, "" + expectedSize, "" + test.size());
        }
      } catch (Exception e) {
        failure = true;
        System.out.println("You're adding out of index, kid. You shouldn't.");
      }
      expectedSize++;
    }
*/
    methodMessage("addAtIndex()", failure);
    return failure;
  }

  public static boolean removeTester() {
    System.out.println("\n ~~~ remove() TESTER");
    boolean failure = false;
    SuperArray test = new SuperArray();
    System.out.println("Testing negative and out of bounds methods.");
    try {
      test.remove(-1);
      failure = true;
      System.out.println("Someone tried to remove a negative index.");
    } catch (Exception e) {
      System.out.println("Yup, can't remove from a negative index.");
    }

    try {
      test.remove(0);
      failure = true;
      System.out.println("Removing at out of bounds index!");
    } catch (Exception e) {
      System.out.println("Yup, can't remove something out of index.");
    }

    try {
      test.remove(1);
      failure = true;
      System.out.println("Removing at out of bounds index!");
    } catch (Exception e) {
      System.out.println("Yup, can't remove something out of index 2.");
    }

    System.out.println("\nTesting actual removals: Extremities");
    test = defaultTestArray();
    int[] indexToRemove = {
      0,
      7,
      6,
    };
    String[] expectedArrays = {
      "[test1, test2, test3, test4, test5, test6, test7]",
      "[test0, test1, test2, test3, test4, test5, test6]",
      "[test0, test1, test2, test3, test4, test5, test7]",
    };
    String[] expectedRemoveds = {
      "test0",
      "test7",
      "test6",
    };

    for (int index = 0; index < indexToRemove.length; index++) {
      try {
        //System.out.println(test.toString());
        System.out.println(indexToRemove[index]);
        String output = test.remove(indexToRemove[index]);
        if (test.toString().equals(expectedArrays[index])) {
          //System.out.println("Removed right! \n" + test.toString());
        } else {
          failure = true;
          System.out.println("You're not removing right.");
          errorMessage(index, expectedArrays[index], test.toString());
        }

        if (output.equals(expectedRemoveds[index]))  {
          //System.out.println("Returned right value \n" + output);
        }  else {
          failure = true;
          System.out.println("Not returning right value");
          errorMessage(index, expectedRemoveds[index], output);
        }
      } catch (Exception e) {
        failure = true;
        System.out.println("You're removing out of index, kid. You shouldn't.");
      }
      test = defaultTestArray();
    }

    System.out.println("\nTesting actual removals with Holes: Extremities");
    test = defaultTestArray();
    String[] newExpecteds = {
      "[test2, test3, test4, test5, test6, test7]",
      "[test0, test1, test2, test3, test4, test5, test6]",
      "[test0, test1, test2, test3, test4, test5]",
    };
    expectedArrays = newExpecteds;

  /*  for (int index = 0; index < indexToRemove.length; index++) {
      test.set(indexToRemove[index], null);
      try {
        //System.out.println(test.toString());
        test.remove(indexToRemove[index]);
        if (test.toString().equals(expectedArrays[index])) {
          //System.out.println("Removed Right");
        } else {
          failure = true;
          System.out.println("You're not removing right.");
          errorMessage(index, expectedArrays[index], test.toString());
        }

        if (test.size() == 7) {
          //System.out.println("Size right!"";
        } else {
          failure = true;
          System.out.println("You're not adding right.");
          errorMessage(index, "" + 7, "" + test.size());
        }
      } catch (Exception e) {
        failure = true;
        System.out.println("You're removing out of index, kid. You shouldn't.");
      }
      test = defaultTestArray();
    }

    int expectedSize = 7;
    String[] newExpecteds2 = {
      "[test0, test1, test2, test4, test5, test6]",
      "[test0, test1, test2, test4, test6]",
      "[test1, test2, test4, test6]"
    };
    int[] newIndexRemoveds = {
      6,
      4,
      0
    };
    indexToRemove = newIndexRemoveds;
    expectedArrays = newExpecteds2;
    test.set(3, null);
    for (int index = 0; index < indexToRemove.length; index++) {
      try {
        //System.out.println(test.toString());
        test.remove(indexToRemove[index]);
        if (test.toString().equals(expectedArrays[index])) {
          //System.out.println("Removed right!"");
        } else {
          failure = true;
          System.out.println("You're not removing right.");
          errorMessage(index, expectedArrays[index], test.toString());
        }

        if (test.size() == expectedSize) {
          //System.out.println("Size right!"";
        } else {
          failure = true;
          System.out.println("You're not removing right.");
          errorMessage(index, "" + expectedSize, "" + test.size());
        }
      } catch (Exception e) {
        failure = true;
        System.out.println("You're adding out of index, kid. You shouldn't.");
      }
      expectedSize--;
    }
*/
    methodMessage("remove()", failure);
    return failure;
  }

  public static boolean indexOfTester() {
    System.out.println("\n ~~~ indexOf() TESTER ~~~");
    boolean failure = false;
    SuperArray test = new SuperArray();
    String[] toFind = {
      "test8",
      "aardvark",
      null,
      ""
    };

    System.out.println("Testing known bads with empty Array.");
    for (int index = 0; index < toFind.length; index++) {
      if (test.indexOf(toFind[index]) == -1) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "-1", "" + test.indexOf(toFind[index]));
      }
    }

    System.out.println("\nTesting known bads with occupied Array.");
    test = defaultTestArray();
    for (int index = 0; index < toFind.length; index++) {
      if (test.indexOf(toFind[index]) == -1) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "-1", "" + test.indexOf(toFind[index]));
      }
    }

    System.out.println("\nTesting with known goods: continuous array");
    String[] toFind2 = {
      "test0",
      "test1",
      "test2",
      "test3",
      "test4",
      "test5",
      "test6",
      "test7"
    };
    toFind = toFind2;
    for (int index = 0; index < toFind.length; index++) {
      if (test.indexOf(toFind[index]) == index) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "" + index, "" + test.indexOf(toFind[index]));
      }
    }

    System.out.println("\nTesting with mixed goods: holes in array");
  System.out.println("Testing with holes set by set()");
    int[] expectedOutput = {
      -1,
      0,
      1,
      2,
      -1,
      3,
      4,
      -1
    };
    /* test.set(0, null);
    test.set(7, null);
    test.set(4, null);
    for (int index = 0; index < toFind.length; index++) {
      if (test.indexOf(toFind[index]) == expectedOutput[index]) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "" + expectedOutput[index], "" + test.indexOf(toFind[index]));
      }
    }
*/
    System.out.println("Testing with holes set by remove()");
    test = defaultTestArray();
    test.remove(7);
    test.remove(4);
    test.remove(0);
    for (int index = 0; index < toFind.length; index++) {
      if (test.indexOf(toFind[index]) == expectedOutput[index]) {
        //passMessage(index);
      } else {
        failure = true;
        errorMessage(index, "" + expectedOutput[index], "" + test.indexOf(toFind[index]));
      }
    }

    methodMessage("indexOf()", failure);
    return failure;
  }

  public static boolean toArrayTester() {
    System.out.println("\n ~~~ toArray() TESTER ~~~");
    System.out.println("Nothing bad should happen below. It's standard, no whammies.");
    boolean failure = false;
    SuperArray test = new SuperArray();
    if (test.toArray().length == 0) {
      //System.out.println("Deals with 'empty' Arrays");
    } else {
      failure = true;
      System.out.println("Doesnt go well with size == 0");
    }

    test = defaultTestArray();
    if(Arrays.toString(test.toArray()).equals(test.toString())) {

      System.out.println("jASON Array returns right");

    } else {
      failure = true;
      defaultTestArray();
      // System.out.println("___________________________________________");
        // System.out.println("Size: "+ test.size());

      errorMessage(0, test.toString(), Arrays.toString(test.toArray()));
    }

    /*System.out.println("Now time to punch some holes in it.");
    test.set(0, null);
    test.set(7, null);
    test.set(5, null);
    if(Arrays.toString(test.toArray()).equals(test.toString())) {
      //System.out.println("Array returns right");
    } else {
      failure = true;
      errorMessage(0, test.toString(), Arrays.toString(test.toArray()));
    }*/
    System.out.println("Now let's do it with remove()");
    test = defaultTestArray();
    test.remove(7);
    test.remove(5);
    test.remove(0);
    if (Arrays.toString(test.toArray()).equals(test.toString())) {
      //System.out.println("Array returns right");
    } else {
      failure = true;
      errorMessage(0, test.toString(), Arrays.toString(test.toArray()));
    }

    System.out.println("Now let's see if you actually returned different arrays.");
    test = defaultTestArray();
    String[] output = test.toArray();
    if (output == test.toArray()) {
      failure = true;
      System.out.println("2 toArray() outputs have the same mem address. Not supposed to happen");
    } else {
      //System.out.println("Good job! Two toArray() occurances dont share the same mem address.");
    }
    System.out.println("Now let's double check by changing some values");
    test.add("foo");
    test.remove(5);
    test.add(1, "bar");
    if (!Arrays.toString(output).equals(test.toString())) {
      //System.out.println("Confirmed");
    } else {
      failure = true;
      System.out.println("Rejected.");
    }

    methodMessage("toArray()", failure);
    return failure;
  }

}
