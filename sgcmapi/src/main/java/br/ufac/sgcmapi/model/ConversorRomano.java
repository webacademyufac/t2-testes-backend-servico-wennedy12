

public class ConversorRomano {
    public int converte(String str){
        char[] algarismos = {'I','V','X','L','C','D','M'};
        int [] inteiros = {1,5,10,50,100,500,1000};
        int n = 0, atual = -1, pos=-1;
        
        for (int i=0; i<str.length(); i++){
           for(int j=0; j <algarismos.length; j++){
             if(str.charAt(i)==algarismos[j])
             pos = j;
             atual = inteiros[pos];
             for(int j=0; j < algarismos.length || i <str.length()-1; j++)
             if(str.charAt(i+1)== algarismos[j])
             pos = j;
             int prox = inteiros[pos];
             if(atual<= prox)
               n += atual;
               else
               n -= atual;
             
           }
           return n;
        }
    }

}
