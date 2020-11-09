public class Demo{
    // not using dict
    public static void removeDuplicates(SuperArray s){
        for (int i = 0; i < s.size(); i ++){
            String hold = s.get(i);
            // System.out.println("Target:" + hold);
            for (int x = i + 1; x < s.size(); x++) {
                // System.out.println("Found:" + s.get(x));
                if (s.get(x).equals(hold)){
                    s.remove(x);
                    x--;
                }
            

            }
        }
    }

    public static SuperArray findOverlap(SuperArray a, SuperArray b){
        removeDuplicates(a);
        // find the unique values in a, + find them in b
        SuperArray result = new SuperArray();
        for (int i= 0; i < a.size(); i++){
            String target = a.get(i);
            // System.out.println("Target:" + target);

            // System.out.println(b.size());
            for (int x= 0; x < b.size(); x++){
                // System.out.println("Found:" + target.equals(b.get(x)));
                if (target.equals(b.get(x))){
                    result.add(target);
                    // b.remove(x);
                    break;
                }
                // System.out.println(x+1< b.size());
            }
        }
        return result;


        
    }

    public static SuperArray zip(SuperArray a, SuperArray b){
        SuperArray result = new SuperArray(a.size() + b.size());
        for (int i = 0; i < a.size() || i < b.size(); i++){
            if (i < a.size()){
                result.add(a.get(i));
            }
            if (i < b.size()){
                result.add(b.get(i));
            }
        }
        return result;


    }

    public static void main(String[]args){
      SuperArray words = new SuperArray();
      //grouped to save vertical space
      words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");     
      words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
      words.add("una");    words.add("ebi");     words.add("toro"); 
  
      System.out.println(words);
      removeDuplicates(words);
      System.out.println(words);  
    
    // test overlap
      SuperArray num1 = new SuperArray();
      num1.add("9"); num1.add("1"); num1.add("2"); 
      num1.add("2"); num1.add("3"); num1.add("4"); 
      SuperArray num2 = new SuperArray();
      num2.add("0"); num2.add("4"); num2.add("2"); 
      num2.add("2"); num2.add("9"); 

      System.out.println(findOverlap( num1, num2 )); 
      
//   test zip
// zip (  ["a","b","c","d","e","f"], ["0","1","2","3"] ) 
SuperArray zip1 = new SuperArray();
zip1.add("a"); zip1.add("b"); zip1.add("c"); 
zip1.add("d"); zip1.add("e"); zip1.add("f"); 

SuperArray zip2 = new SuperArray();
zip2.add("0"); zip2.add("1"); zip2.add("2"); 
zip2.add("3");

//  returns    ["a","0","b","1","c","2", "d","3","e","f"]
System.out.println(zip(zip1, zip2));
System.out.println(zip(zip1, zip2).toString().equals("[a, 0, b, 1, c, 2, d, 3, e, f]"));


// zip (  ["a","b","c"], ["0","1","2","3","4"] )  returns    ["a","0","b","1","c","2","3","4"]  )
SuperArray zip3 = new SuperArray();
zip3.add("a"); zip3.add("b"); zip3.add("c"); 

SuperArray zip4 = new SuperArray();
zip4.add("0"); zip4.add("1"); zip4.add("2"); 
zip4.add("3"); zip4.add("4"); 

System.out.println(zip(zip3, zip4));
System.out.println(zip(zip3, zip4).toString().equals("[a, 0, b, 1, c, 2, 3, 4]"));

    }


    //   
  }