import java.util.Arrays;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;

public class NeuralNetwork {
    
	public final static double[] Alex = {1, 0, 0, 0, 0};
	public final static double[] Alfred = {0, 1, 0, 0, 0};
	public final static double[] Anita = {0, 0, 1, 0, 0};
	public final static double[] Anne = {0, 0, 0, 1, 0};
	public final static double[] Bernard = {0, 0, 0, 0, 1};
    static BasicNetwork network = new BasicNetwork();
    static double INPUT[][] = new double[35][7];
	static double OUTPUT[][] = {Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard};
	
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
	    
        double[] answer = GamePlay.playGame();
        String who = guessWho(answer);
        System.out.println(who);
	}
	
	private static void trainNeuralNet(){
	    MLDataSet trainingSet = new BasicMLDataSet(INPUT, OUTPUT);
	    
	    int input_units = 7;
	    int hidden_units = 5;
	    int output_units = 5;
	    

        network.addLayer(new BasicLayer(null, false, input_units));
        
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, hidden_units));
          
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, output_units));
          
        network.getStructure().finalizeStructure();
        network.reset();
        
        Backpropagation train = new Backpropagation(network, trainingSet, 0.5, 0.3);        
        
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
	
	public static String guessWho(double[] out){
//        MLData data = new BasicMLData(answer);
//        MLData output = network.compute(data);
//
//        double[] out = new double[5];
//        for(int i = 0; i < output.size(); i++){
//            out[i] = Math.round(output.getData(i));
//        }

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
}