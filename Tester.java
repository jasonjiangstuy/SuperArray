public class Tester {
    public static void main(String[] args) {
        SuperArray words = new SuperArray();
        words.add("kani"); //0
        words.add("uni"); // 1
        words.add("ebi"); //2
        System.out.println(words.size());
        words.add(1, "jjason"); // tested add
        System.out.println(words.size());
        for(int i = 0; i < words.size(); i++){
        System.out.println( words.get(i) );
        }    
        System.out.println( words.isEmpty() );
        System.out.println( words.toString() );
        System.out.println("end");

        // test resizing
        SuperArray myWords = new SuperArray();
        for(int i =0; i<20;i++){
            // System.out.println("Adding:" + i);
            myWords.add(String.valueOf(i));
        }
        for(int i = 0; i < myWords.size(); i++){
            System.out.println( myWords.get(i) );
        }    
        System.out.println("end");

        myWords.clear();
        for(int i = 0; i < myWords.size(); i++){
            System.out.println( myWords.get(i) );
        }
        System.out.println("clear" + myWords);
        

        // test add(index, ele)
        SuperArray myArr = new SuperArray();
        myArr.add(0, "Second");
        myArr.add(0, "First");
        System.out.println( myArr );

        // test remove(index)
        myArr.remove(0);
        System.out.println( myArr );
        myArr.remove(0);
        System.out.println( myArr );

        // test empty
        System.out.println(myArr.isEmpty());

        System.out.println(myArr);
        // test contains and indexOf
        for(int i = 0; i<20;i++){
            myArr.add(String.valueOf(i));
        }
        System.out.println(myArr);
        System.out.println(myArr.contains("20")); //false
        System.out.println(myArr.contains("19")); //true
        System.out.println(myArr.contains("3")); //true
        System.out.println(myArr.contains("0")); //true

        System.out.println(myArr.indexOf("17")); //17

        System.out.println(myArr.indexOf("1")); //1
        System.out.println(myArr.indexOf("0")); //0
        System.out.println(myArr.indexOf("19")); //19
    }
}
