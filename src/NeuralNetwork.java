import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;

public class NeuralNetwork {
    
	final static double[] Alex = {1, 0, 0, 0, 0};
	final static double[] Alfred = {0, 1, 0, 0, 0};
	final static double[] Anita = {0, 0, 1, 0, 0};
    final static double[] Anne = {0, 0, 0, 1, 0};
    final static double[] Bernard = {0, 0, 0, 0, 1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String[] dataset = GetDataset.getData();
	    double INPUT[][] = new double[35][7];
	    double OUTPUT[][] = {Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard,
	            Alex, Alfred, Anita, Anne, Bernard};
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
	    
	    MLDataSet trainingSet = new BasicMLDataSet(INPUT, OUTPUT);
	    
	    int input_units = 7;
	    int hidden_units = 10;
	    int output_units = 5;
	    
        BasicNetwork network = new BasicNetwork();
  
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
        
        double[] t = new double[]{0, 1, 1, 0, 0, 0, 1};
        MLData data = new BasicMLData(t);
        MLData output = network.compute(data);
        
        System.out.println("input = " + data.getData(0) + " " + data.getData(1) + " " + data.getData(2) + " " + data.getData(3) + " " + data.getData(4) + " " + data.getData(5) + " " + data.getData(6));
        System.out.println("actual = " + output.getData(0) + " " + output.getData(1) + " " + output.getData(2) + " " + output.getData(3) + " " + output.getData(4));
	}

}
