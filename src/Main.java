import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int numPlayers;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        System.out.println("INTRODUCE EL NUMERO DE JUGADORES:");
        numPlayers = sc.nextInt(); // Numero de jugadores

        if(numPlayers<=1){
            System.err.println("FAVOR DE INTRODUCIR MAS DE UN JUGADOR");
            startGame();
        }

        /*String namePlayer[] = new String[numPlayers]; Arreglo de jugadores*/
        Player arrayPlayers[] = new Player[numPlayers]; // Arreglo de 'Players'

        for (int i=0; i<numPlayers; i++){ /** Insercion de nombre de los jugadores*/
            System.out.println("****INTRODUCE EL NOMBRE DEL JUGADOR "+(i+1)+"****");
            String name = sc.next();
            int money = 20;
            int dicePoints = 0;
            arrayPlayers[i] = new Player(name,money,dicePoints);
        }

        showPlayers(arrayPlayers); /**Se muestran los jugadores*/

        try{
            for(int j=0; j<numPlayers;j++){
                do {
                    throwDice(arrayPlayers);
                } while (arrayPlayers[j].getDicePoints() > 100);
                /*if(arrayPlayers[j].getDicePoints() > 100){
                    break;
                } else {
                    throwDice(arrayPlayers);
                }*/
            }
            //throwDice(arrayPlayers);
        }catch (Exception ex){
            System.err.println("Error en throwDice");
        }


    }

    public static void showPlayers(Player arrayPlayer[]){
        for (int i=0; i<numPlayers;i++){
            System.out.println("***JUGADOR "+(i+1)+"***: "+arrayPlayer[i].getName());
        }
    }

    public static void throwDice(Player arrayPlayer[]) throws IOException {
        int dice1 = 0;
        int dice2 = 1;

        for(int i=0; i<numPlayers; i++) {
            int playerPoint = arrayPlayer[i].getDicePoints();
            if(arrayPlayer[i].getDicePoints() < 100){
                do{
                    System.out.print("*********POR FAVOR! TIRA EL DADO NUMERO 1, "+arrayPlayer[i].getName().toUpperCase()+"*********");
                    System.in.read();
                    dice1 = (int)(Math.random()*(5+1)+1);
                    System.out.print("***TU PRIMER LANZAMIENTO ES: "+dice1+"***");
                    System.out.print("\nVUELVE A LANZAR EL DADO");
                    System.in.read();
                    dice2= (int)(Math.random()*(5+1)+1);
                    System.out.print("**TU SEGUNDO LANZAMIENTO ES: "+dice2+"***");
                    if(dice1 == dice2){
                        arrayPlayer[i].setDicePoints(arrayPlayer[i].getDicePoints()+((dice1+dice2)*2));
                        System.out.println("\n~~~LOS PUNTOS DE: "+arrayPlayer[i].getName().toUpperCase()+" SON: "+arrayPlayer[i].getDicePoints()+"~~~");
                        break;
                    } else {
                        arrayPlayer[i].setDicePoints(arrayPlayer[i].getDicePoints()+(dice1+dice2));
                        System.out.println("\n~~~LOS PUNTOS DE: "+arrayPlayer[i].getName().toUpperCase()+" SON: "+arrayPlayer[i].getDicePoints()+"~~~");
                    }

                }while (arrayPlayer[i].getDicePoints() < 100);
            } else {
                break;
            }

        }
    }
}
