import java.util.Arrays;
import java.util.Scanner;

public class GamePlay {

    public final static int Charactor_Number = 7;
    final static int Character_Number = 5;
    @SuppressWarnings("resource")
    public static double[] playGame(){
        
        double[] answers = {0, 0, 0, 0, 0, 0, 0};
        double[] answers_yes = {1, 1, 1, 1, 1, 1, 1};
        double[] invalid_early = {0, 0, 0, 0, 0};
        double[] early_yes = new double[Character_Number];
        double[] early_no = new double[Character_Number];
        Scanner sc = new Scanner(System.in);
        String[] answer = new String[Charactor_Number];
        
        System.out.println("Does your character have curly hair? ");
        answer[0] = sc.nextLine();
        
        if(answer[0].contains("Y") || answer[0].contains("y")){
            answer[0] = "1";
            answers[0] = Double.valueOf(answer[0]);
            answers_yes[0] = Double.valueOf(answer[0]);
        } else if (answer[0].contains("N") || answer[0].contains("n")){
            answer[0] = "0";
            answers[0] = Double.valueOf(answer[0]);
            answers_yes[0] = Double.valueOf(answer[0]);
        }
        System.out.println(answers_yes.length);
        early_yes = NeuralNetwork.earlyGuess(answers_yes);
        early_no = NeuralNetwork.earlyGuess(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                return early_yes;
            }
        }
        
        System.out.println("Does your character have blonde hair? ");
        answer[1] = sc.nextLine();
        if(answer[1].contains("Y") || answer[1].contains("y")){
            answer[1] = "1";
            answers[1] = Double.valueOf(answer[1]);
            answers_yes[1] = Double.valueOf(answer[1]);
        } else if (answer[1].contains("N") || answer[1].contains("n")){
            answer[1] = "0";
            answers[1] = Double.valueOf(answer[1]);
            answers_yes[1] = Double.valueOf(answer[1]);
        }
        
        early_yes = NeuralNetwork.earlyGuess(answers_yes);
        early_no = NeuralNetwork.earlyGuess(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                return early_yes;
            }
        }
        
        System.out.println("Does your character have red cheecks? ");
        answer[2] = sc.nextLine();
        if(answer[2].contains("Y") || answer[2].contains("y")){
            answer[2] = "1";
            answers[2] = Double.valueOf(answer[2]);
            answers_yes[2] = Double.valueOf(answer[2]);
        } else if (answer[2].contains("N") || answer[2].contains("n")){
            answer[2] = "0";
            answers[2] = Double.valueOf(answer[2]);
            answers_yes[2] = Double.valueOf(answer[2]);
        }
        
        early_yes = NeuralNetwork.earlyGuess(answers_yes);
        early_no = NeuralNetwork.earlyGuess(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                return early_yes;
            }
        }
        
        System.out.println("Does your character have moustache? ");
        answer[3] = sc.nextLine();
        if(answer[3].contains("Y") || answer[3].contains("y")){
            answer[3] = "1";
            answers[3] = Double.valueOf(answer[3]);
            answers_yes[3] = Double.valueOf(answer[3]);
        } else if (answer[3].contains("N") || answer[3].contains("n")){
            answer[3] = "0";
            answers[3] = Double.valueOf(answer[3]);
            answers_yes[3] = Double.valueOf(answer[3]);
        }
        
        early_yes = NeuralNetwork.earlyGuess(answers_yes);
        early_no = NeuralNetwork.earlyGuess(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                return early_yes;
            }
        }
        
        System.out.println("Does your character have beard? ");
        answer[4] = sc.nextLine();
        if(answer[4].contains("Y") || answer[4].contains("y")){
            answer[4] = "1";
            answers[4] = Double.valueOf(answer[4]);
            answers_yes[4] = Double.valueOf(answer[4]);
        } else if (answer[4].contains("N") || answer[4].contains("n")){
            answer[4] = "0";
            answers[4] = Double.valueOf(answer[4]);
            answers_yes[4] = Double.valueOf(answer[4]);
        }
        
        early_yes = NeuralNetwork.earlyGuess(answers_yes);
        early_no = NeuralNetwork.earlyGuess(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                return early_yes;
            }
        }
        
        System.out.println("Does your character wear ear rings? ");
        answer[5] = sc.nextLine();
        if(answer[5].contains("Y") || answer[5].contains("y")){
            answer[5] = "1";
            answers[5] = Double.valueOf(answer[5]);
            answers_yes[5] = Double.valueOf(answer[5]);
        } else if (answer[5].contains("N") || answer[5].contains("n")){
            answer[5] = "0";
            answers[5] = Double.valueOf(answer[5]);
            answers_yes[5] = Double.valueOf(answer[5]);
        }
        
        early_yes = NeuralNetwork.earlyGuess(answers_yes);
        early_no = NeuralNetwork.earlyGuess(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                return early_yes;
            }
        }
        
        System.out.println("Is your character female? ");
        answer[6] = sc.nextLine();
        if(answer[6].contains("Y") || answer[6].contains("y")){
            answer[6] = "1";
            answers[6] = Double.valueOf(answer[6]);
            answers_yes[6] = Double.valueOf(answer[6]);
        } else if (answer[6].contains("N") || answer[6].contains("n")){
            answer[6] = "0";
            answers[6] = Double.valueOf(answer[6]);
            answers_yes[6] = Double.valueOf(answer[6]);
        }

        
        for(int i = 0; i < Charactor_Number; i++){
            if(answer[i].contains("Y") || answer[i].contains("y")){
                answer[i] = "1";
                answers[i] = Double.valueOf(answer[i]);
            } else if (answer[i].contains("N") || answer[i].contains("n")){
                answer[i] = "0";
                answers[i] = Double.valueOf(answer[i]);
            }
        }
        return NeuralNetwork.earlyGuess(answers);
    }
    
public static double[] playGameAgain(){
        
        double[] answers = {0, 0, 0, 0, 0, 0, 0};
        double[] answers_yes = {1, 1, 1, 1, 1, 1, 1};
        double[] invalid_early = {0, 0, 0, 0, 0, 0};
        double[] early_yes = new double[Character_Number];
        double[] early_no = new double[Character_Number];
        Scanner sc = new Scanner(System.in);
        String[] answer = new String[Charactor_Number];
        
        System.out.println("Does your character have curly hair? ");
        answer[0] = sc.nextLine();
        
        if(answer[0].contains("Y") || answer[0].contains("y")){
            answer[0] = "1";
            answers[0] = Double.valueOf(answer[0]);
            answers_yes[0] = Double.valueOf(answer[0]);
        } else if (answer[0].contains("N") || answer[0].contains("n")){
            answer[0] = "0";
            answers[0] = Double.valueOf(answer[0]);
            answers_yes[0] = Double.valueOf(answer[0]);
        }
        early_yes = NeuralNetwork.earlyGuessAgain(answers_yes);
        early_no = NeuralNetwork.earlyGuessAgain(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                sc.close();
                return early_yes;
            }
        }
        
        System.out.println("Does your character have blonde hair? ");
        answer[1] = sc.nextLine();
        if(answer[1].contains("Y") || answer[1].contains("y")){
            answer[1] = "1";
            answers[1] = Double.valueOf(answer[1]);
            answers_yes[1] = Double.valueOf(answer[1]);
        } else if (answer[1].contains("N") || answer[1].contains("n")){
            answer[1] = "0";
            answers[1] = Double.valueOf(answer[1]);
            answers_yes[1] = Double.valueOf(answer[1]);
        }
        
        early_yes = NeuralNetwork.earlyGuessAgain(answers_yes);
        early_no = NeuralNetwork.earlyGuessAgain(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                sc.close();
                return early_yes;
            }
        }
        
        System.out.println("Does your character have red cheecks? ");
        answer[2] = sc.nextLine();
        if(answer[2].contains("Y") || answer[2].contains("y")){
            answer[2] = "1";
            answers[2] = Double.valueOf(answer[2]);
            answers_yes[2] = Double.valueOf(answer[2]);
        } else if (answer[2].contains("N") || answer[2].contains("n")){
            answer[2] = "0";
            answers[2] = Double.valueOf(answer[2]);
            answers_yes[2] = Double.valueOf(answer[2]);
        }
        
        early_yes = NeuralNetwork.earlyGuessAgain(answers_yes);
        early_no = NeuralNetwork.earlyGuessAgain(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                sc.close();
                return early_yes;
            }
        }
        
        System.out.println("Does your character have moustache? ");
        answer[3] = sc.nextLine();
        if(answer[3].contains("Y") || answer[3].contains("y")){
            answer[3] = "1";
            answers[3] = Double.valueOf(answer[3]);
            answers_yes[3] = Double.valueOf(answer[3]);
        } else if (answer[3].contains("N") || answer[3].contains("n")){
            answer[3] = "0";
            answers[3] = Double.valueOf(answer[3]);
            answers_yes[3] = Double.valueOf(answer[3]);
        }
        
        early_yes = NeuralNetwork.earlyGuessAgain(answers_yes);
        early_no = NeuralNetwork.earlyGuessAgain(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                sc.close();
                return early_yes;
            }
        }
        
        System.out.println("Does your character have beard? ");
        answer[4] = sc.nextLine();
        if(answer[4].contains("Y") || answer[4].contains("y")){
            answer[4] = "1";
            answers[4] = Double.valueOf(answer[4]);
            answers_yes[4] = Double.valueOf(answer[4]);
        } else if (answer[4].contains("N") || answer[4].contains("n")){
            answer[4] = "0";
            answers[4] = Double.valueOf(answer[4]);
            answers_yes[4] = Double.valueOf(answer[4]);
        }
        
        early_yes = NeuralNetwork.earlyGuessAgain(answers_yes);
        early_no = NeuralNetwork.earlyGuessAgain(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                sc.close();
                return early_yes;
            }
        }
        
        System.out.println("Does your character wear ear rings? ");
        answer[5] = sc.nextLine();
        if(answer[5].contains("Y") || answer[5].contains("y")){
            answer[5] = "1";
            answers[5] = Double.valueOf(answer[5]);
            answers_yes[5] = Double.valueOf(answer[5]);
        } else if (answer[5].contains("N") || answer[5].contains("n")){
            answer[5] = "0";
            answers[5] = Double.valueOf(answer[5]);
            answers_yes[5] = Double.valueOf(answer[5]);
        }
        
        early_yes = NeuralNetwork.earlyGuessAgain(answers_yes);
        early_no = NeuralNetwork.earlyGuessAgain(answers);
        if(Arrays.equals(early_yes, early_no)){
            if(!Arrays.equals(early_yes, invalid_early) && !Arrays.equals(early_no, invalid_early)){
                sc.close();
                return early_yes;
            }
        }
        
        System.out.println("Is your character female? ");
        answer[6] = sc.nextLine();
        if(answer[6].contains("Y") || answer[6].contains("y")){
            answer[6] = "1";
            answers[6] = Double.valueOf(answer[6]);
            answers_yes[6] = Double.valueOf(answer[6]);
        } else if (answer[6].contains("N") || answer[6].contains("n")){
            answer[6] = "0";
            answers[6] = Double.valueOf(answer[6]);
            answers_yes[6] = Double.valueOf(answer[6]);
        }

        
        for(int i = 0; i < Charactor_Number; i++){
            if(answer[i].contains("Y") || answer[i].contains("y")){
                answer[i] = "1";
                answers[i] = Double.valueOf(answer[i]);
            } else if (answer[i].contains("N") || answer[i].contains("n")){
                answer[i] = "0";
                answers[i] = Double.valueOf(answer[i]);
            }
        }
        sc.close();
        return NeuralNetwork.earlyGuessAgain(answers);
    }
}
