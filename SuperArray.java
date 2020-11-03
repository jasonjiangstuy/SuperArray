public class SuperArray {
    private String [] data;
    private int size; //The current size

    public SuperArray(){
        data = new String[10];
        size = 0;
        
    }

    public int size(){
        return size;
    }

    public boolean add(String element){
        if (size >= data.length){
            resize();
            data[size] = element;
            size ++;
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
        String [] hold = new String[data.length + 10];
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
        for (int i = 0; i < size; i++){
            if (data[i] != null && s == data[i]){
                return true;
            }
            
        }
        return false;
    }




}
