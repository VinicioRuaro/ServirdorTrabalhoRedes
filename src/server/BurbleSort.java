
package server;

import java.util.ArrayList;

public class BurbleSort {
  
    public static ArrayList bubblesort (ArrayList<Integer> entrada){
        
        ArrayList<Integer> aux = new ArrayList(entrada);
        
        for(int a=0;aux.size()>a;a++){
            for(int b= 0;b<aux.size()-1;b++){
                if(aux.get(b)>aux.get(b+1)){
                    aux.add(b, aux.get(b+1));
                    aux.remove(b+2);
                }
            }
        }
        
        
        
        return aux;
        
        
    }
}
