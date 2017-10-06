import java.util.Scanner;

public class GamePlay {

    final static int Charactor_Number = 7;
    public static double[] playGame(){
        
        double[] answers = new double[Charactor_Number];
        Scanner sc = new Scanner(System.in);
        String[] answer = new String[Charactor_Number];
        
        System.out.println("Does your character have curly hair? ");
        answer[0] = sc.nextLine();
        
        System.out.println("Does your character have blonde hair? ");
        answer[1] = sc.nextLine();
        
        System.out.println("Does your character have red cheecks? ");
        answer[2] = sc.nextLine();
        
        System.out.println("Does your character have moustache? ");
        answer[3] = sc.nextLine();
        
        System.out.println("Does your character have beard? ");
        answer[4] = sc.nextLine();
        
        System.out.println("Does your character wear ear rings? ");
        answer[5] = sc.nextLine();
        
        System.out.println("Is your character female? ");
        answer[6] = sc.nextLine();
        
        sc.close();
        
        for(int i = 0; i < Charactor_Number; i++){
            if(answer[i].contains("Y") || answer[i].contains("y")){
                answer[i] = "1";
                answers[i] = Integer.valueOf(answer[i]);
            } else if (answer[i].contains("N") || answer[i].contains("n")){
                answer[i] = "0";
                answers[i] = Integer.valueOf(answer[i]);
            }
        }
        return answers;
    }
}
