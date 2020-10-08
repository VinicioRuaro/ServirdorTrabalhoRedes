package server;


import java.util.ArrayList;

public class SelectionSort {
    
    public static ArrayList SelectionSort(ArrayList<Integer> entrada){
        
        ArrayList<Integer> aux1 = new ArrayList(entrada);
        ArrayList<Integer> aux2 = new ArrayList();
        int tempo = 0 ;
        
        for(int h=0;aux1.size()>0;h++){
            
            for (int i = 0; i < aux1.size(); i++) {
                
                if(i==0){
                    tempo = 0;
                }
                else{
                    if(aux1.get(tempo)>aux1.get(i)){
                        tempo = i;
                        
                    }
                }
            }
            
            aux2.add(aux1.get(tempo));
            aux1.remove(tempo);
 
            
        }
 
        
        return aux2;
    }
}
