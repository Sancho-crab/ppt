import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "LAGARTIJA", "SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int fi, si;

	    fi = getIndex(first);
	    si = getIndex(second);
	    
	    /*"TIJERAS" = 0
	     "PAPEL" = 1
	     "PIEDRA" = 2
	     "LAGARTIJA" = 3
	     "SPOCK" = 4*/

//	    if (first_i == second_i) return EMPATE;
//	    
//	    return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	    
	    if (fi == 0 & (si == 1 || si == 3)) {
	    	return GANA;
	    } else if (fi == 1 && (si == 2 || si == 4)) {
	    	return GANA;
	    } else if (fi == 2 && (si == 3 ||  si == 0)) {
	    	return GANA;
	    } else if (fi == 3 && (si ==4 || si == 1)) {
	    	return GANA;
	    } else if (fi == 4 && (si  == 0 || si == 2)) {
	    	return GANA;
	    } else if (fi == si) {
	    	return EMPATE;
	    } else {
	    	return PIERDE;
	    }
	    
	}
	
} 
