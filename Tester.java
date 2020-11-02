public class Tester {
    public static void main(String[] args) {
        SuperArray words = new SuperArray();
        words.add("kani");
        words.add("uni");
        words.add("ebi");
        for(int i = 0; i < words.size(); i++){
        System.out.println( words.get(i) );
        }    
        System.out.println("end");

        // test resizing
        SuperArray myWords = new SuperArray();
        for(int i =0; i<20;i++){
            words.add(String.valueOf(i));
        }
        for(int i = 0; i < words.size(); i++){
            System.out.println( words.get(i) );
        }    
        System.out.println("end");

    }
}
