public class SuperArray {
    private String [] data;
    private int size; //The current size

    public SuperArray(){
        data = new String[10];
        size = 0;
        
    }
    public SuperArray(int InitialCapacity){
        data = new String[InitialCapacity];
        size = 0;
        
    }



    public int size(){
        return size;
    }

    public boolean add(String element){
        if (size >= data.length){
            resize();
        }
        data[size] = element;
        size ++;
        
        return true;
    }

    public String get(int index){
        return data[index];
    }

    public String set(int index, String element){
        String hold = data[index];
        data[index] = element;
        return hold;
    }

    private void resize(){
        String [] hold = new String[data.length * 2];
        for (int i = 0; i < data.length; i ++){
            hold[i] = data[i];
        }
        data = hold;
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public String toString(){
        String total = "[";
        boolean finishForloop = false;
        for (int i = 0; i < size; i++){
            total += data[i];
            total += ", ";
            finishForloop = true;
        }
        if (finishForloop){
            total = total.substring(0, total.length() - 2);
        }
        total += "]";
        return total;
    }

    public boolean contains(String s){

        return (-1 != indexOf(s));
    }
    public void clear(){
        for (int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }
    // test with small arrays, afraid of the - 1
    public void add(int index, String element){
        if (0 <= index || index < size){
            if ((size + 1) > data.length){
                resize();
            }

            for (int i = size; i > 0; i--){
                data[i] = data[i - 1];
                if (i - 1 == index){
                    data[i - 1] = element;
                    size += 1;
                    break;
                }
            }

            // exception if the index == 0 and size == 0
            // or if index == size - 1 => append or add 
            if ((index == 0 && size == 0) || index == size - 1){
                add(element);
            }
        }
    }

    public String remove(int index){
        if (0 <= index || index < size){
            String prevEle = null;
            String temp;
            for (int i = size - 1; i >= 0; i--){
                temp = data[i];
                data[i] = prevEle;
                prevEle = temp;
                if (i == index){
                    size -= 1;
                    return prevEle;
                }
            }
        }
        return "Fail";
    }   

    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. 
    public int indexOf(String s){
        for (int i= 0; i < size; i++){
            if (data[i].equals(s)){
                return i;
            }
        }
        return -1;
    }

    // Including nulls
    public String[] toArray(){
        String[] newArray = new String[size];
        // System.out.println("Size: "+this.size);
        for (int i= 0; i < size; i++){
            newArray[i] = data[i];
        }
        return newArray;
    }

    public int lastIndexOf(String value){
        for (int i= size; i >= 0; i --){
            if (data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    public boolean equals(SuperArray other){
        for (int i = 0; i< size; i++)    {
            if (!(data[i].equals(other.get(i)))){
                return false;
            }
        }
        return true;
    }

    
}
