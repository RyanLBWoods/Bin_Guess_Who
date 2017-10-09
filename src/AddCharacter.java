
public class AddCharacter extends NeuralNetwork{
    
    public final static double[] new_character = {0, 0, 0, 0, 0, 1};
    public final static double[] Alex = {1, 0, 0, 0, 0, 0};
    public final static double[] Alfred = {0, 1, 0, 0, 0, 0};
    public final static double[] Anita = {0, 0, 1, 0, 0, 0};
    public final static double[] Anne = {0, 0, 0, 1, 0, 0};
    public final static double[] Bernard = {0, 0, 0, 0, 1, 0};
    public static double[][] New_OUTPUT = {Alex, Alfred, Anita, Anne, Bernard,
            Alex, Alfred, Anita, Anne, Bernard,
            Alex, Alfred, Anita, Anne, Bernard,
            Alex, Alfred, Anita, Anne, Bernard,
            Alex, Alfred, Anita, Anne, Bernard,
            Alex, Alfred, Anita, Anne, Bernard,
            Alex, Alfred, Anita, Anne, Bernard, new_character};
    
    public static double[][] addCharactor(){
        String[] new_ch = new String[7];
        
        System.out.println("Does your character have curly hair? ");
        new_ch[0] = sc.nextLine();
        
        System.out.println("Does your character have blonde hair? ");
        new_ch[1] = sc.nextLine();
        
        System.out.println("Does your character have red cheecks? ");
        new_ch[2] = sc.nextLine();
        System.out.println("Does your character have moustache? ");
        new_ch[3] = sc.nextLine();
        
        System.out.println("Does your character have beard? ");
        new_ch[4] = sc.nextLine();
        
        System.out.println("Does your character wear ear rings? ");
        new_ch[5] = sc.nextLine();
        
        System.out.println("Is your character female? ");
        new_ch[6] = sc.nextLine();
        
        double[] new_data = new double[7];
        for(int i = 0; i < new_data.length; i++){
            if(new_ch[i].contains("Y") || new_ch[i].contains("y")){
                new_ch[i] = "1";
                new_data[i] = Double.valueOf(new_ch[i]);
            } else if (new_ch[i].contains("N") || new_ch[i].contains("n")){
                new_ch[i] = "0";
                new_data[i] = Double.valueOf(new_ch[i]);
            }
        }
        
        double[][] in_temp = INPUT;
        INPUT = new double[36][Charactor_Number];
        int m, n, x;
        for(m = 0; m < in_temp.length; m++){
            for(n = 0; n < new_data.length; n++){
                INPUT[m][n] = in_temp[m][n];
            }
        }
        for(x = 0;x < new_data.length;x++){
            INPUT[m][x] = new_data[x];
        }
        return INPUT;   
    }
    
    public static String getNewName(){
        System.out.println("What is your character's name? ");
        return new_name = sc.nextLine();
    }
    
    public static double[][] addCharacter(){
        return New_OUTPUT;
    }
    
    public static double[] newCharacter(){
        return new_character;
    }
}
