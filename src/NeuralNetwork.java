import java.util.Arrays;
import java.util.Scanner;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;

public class NeuralNetwork {
    
	public static double[] Alex = {1, 0, 0, 0, 0};
	public static double[] Alfred = {0, 1, 0, 0, 0};
	public static double[] Anita = {0, 0, 1, 0, 0};
	public static double[] Anne = {0, 0, 0, 1, 0};
	public static double[] Bernard = {0, 0, 0, 0, 1};
    static BasicNetwork network = new BasicNetwork();
    public final static int Charactor_Number = 7;
    public final static int Data_Size = 35;
    public static double INPUT[][] = new double[Data_Size][Charactor_Number ];
	public static double OUTPUT[][] = {Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard};
	
	public static Scanner sc = new Scanner(System.in);
	static String new_name = "";
	static String[] new_ch = new String[7];
    private static double[][] new_input = new double[36][7];
    private static double[][] new_output = new double[36][6];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String[] dataset = GetDataset.getData();
	    
	    for(int i = 0; i < dataset.length; i++){
	        String[] chr = dataset[i].split(",");
	        for(int j = 0; j < chr.length - 1; j++){
	            if(chr[j].equals("No")){
	                chr[j] = "0";
	            } else if(chr[j].equals("Yes")){
	                chr[j] = "1";
	            }
	            INPUT[i][j] = Integer.valueOf(chr[j]);
	        }
	    }
	    
	    trainNeuralNet();
        String who = guessWho(GamePlay.playGame());
        System.out.println(who);

        System.out.println("Do you want to add a new character?");
        String option = sc.nextLine();
        if(option.contains("Y") || option.contains("y")){
            new_input = AddCharacter.addCharactor();
            new_output = AddCharacter.addCharacter();
            new_name = AddCharacter.getNewName();
            System.out.println(new_name);
            trainNewNet(new_input, new_output);
            who = guessWho(GamePlay.playGameAgain());
            System.out.println(who);
        } else if (option.contains("N") || option.contains("n")){
            System.exit(0);
        }
        
	}
	
	private static void trainNewNet(double[][] new_input, double[][] new_output){
	    network = new BasicNetwork();
	    MLDataSet trainingSet = new BasicMLDataSet(new_input, new_output);
        int input_units = 7;
        int hidden_units = 14;
        int output_units = 6;
        
        
        
        network.addLayer(new BasicLayer(null, false, input_units));
        
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, hidden_units));
          
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, output_units));
          
        network.getStructure().finalizeStructure();
        network.reset();
        
        Backpropagation train = new Backpropagation(network, trainingSet, 0.03, 0);        
        
        do {
            train.iteration();
        } while(train.getError() > 0.01);
        train.finishTraining();
	}
	
	private static void trainNeuralNet(){
	    MLDataSet trainingSet = new BasicMLDataSet(INPUT, OUTPUT);
	    
	    int input_units = 7;
	    int hidden_units = 14;
	    int output_units = 5;
	    

        network.addLayer(new BasicLayer(null, false, input_units));
        
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, hidden_units));
          
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, output_units));
          
        network.getStructure().finalizeStructure();
        network.reset();
        
        Backpropagation train = new Backpropagation(network, trainingSet, 0.03, 0);        
        
        do {
            train.iteration();
        } while(train.getError() > 0.01);
        train.finishTraining();
	}
	
	public static double[] earlyGuess(double[] answer){
	    MLData data = new BasicMLData(answer);
        MLData output = network.compute(data);

        double[] out = new double[5];
        for(int i = 0; i < output.size(); i++){
            out[i] = Math.round(output.getData(i));
        }
        return out;
	}
	
	public static double[] earlyGuessAgain(double[] answer){
        MLData data = new BasicMLData(answer);
        MLData output = network.compute(data);

        double[] out = new double[6];
        for(int i = 0; i < output.size(); i++){
            out[i] = Math.round(output.getData(i));
        }
        return out;
    }
	
	public static String guessWho(double[] out){

        if(Arrays.equals(out, Alex)){
            return "Your character is Alex!";
        } else if (Arrays.equals(out, Alfred)){
            return "Your character is Alfred!";
        } else if (Arrays.equals(out, Anita)){
            return "Your character is Anita!";
        } else if (Arrays.equals(out, Anne)){
            return "Your character is Anne!";
        } else if (Arrays.equals(out, Bernard)){
            return "Your character is Bernard!";
        }
	    return "You have incorrect answer!";
	}
	
	public static String guessAgain(double[] out, String new_name){
	    if(Arrays.equals(out, Alex)){
            return "Your character is Alex!";
        } else if (Arrays.equals(out, Alfred)){
            return "Your character is Alfred!";
        } else if (Arrays.equals(out, Anita)){
            return "Your character is Anita!";
        } else if (Arrays.equals(out, Anne)){
            return "Your character is Anne!";
        } else if (Arrays.equals(out, Bernard)){
            return "Your character is Bernard!";
        } else if (Arrays.equals(out, AddCharacter.newCharacter())){
            return "Your character is " + new_name + "!";
        }
        return "You have incorrect answer!";
	}
	
	public static double[][] addCharacter(){
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

            System.out.println("What is your character's name? ");
            new_name = sc.nextLine();
            sc.close();
            
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
            INPUT = new double[2 * Data_Size][Charactor_Number];
            int m, n, x;
            for(m = 0; m < in_temp.length; m++){
                for(n = 0; n < new_data.length; n++){
                    INPUT[m][n] = in_temp[m][n];
                }
            }
            for(x = 0;x < new_data.length;x++){
                INPUT[m][x] = new_data[x];
                System.out.println(INPUT[m][x]);
            }
            return INPUT;   
	}
}