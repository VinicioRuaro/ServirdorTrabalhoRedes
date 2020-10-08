package server;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;

public class InsertionSort {
   
    public static ArrayList insertionSort(ArrayList<Integer> inicio){
        
        ArrayList<Integer> entrada = new ArrayList(inicio);
        
        for(int h=0; h<entrada.size();h++){
        for(int a=1; a<entrada.size();a++){
            if(entrada.get(a)<entrada.get(a-1)){
                entrada.add(a-1, entrada.get(a));
                entrada.remove(a+1);
            }
        }
        }
        return entrada;
    }
    }


   