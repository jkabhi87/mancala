/**
 * AI.java
 * Implements MiniMax search with A-B pruning and iterative deepening search (IDS). 
 * boardStat function is simple: the # of stones in AIPlayer's mancala minus the # in opponent's mancala.
 */

public class AI extends Player {

    /*Use IDS search to find the best move. The step starts from 1 and increments by step 1.
     * The max Iterative Depth is MAX_DEPTH which means it calculates MAX_DEPTH moves ahead.
     * The search can be interrupted by time limit.
     */
    public static int MAX_DEPTH = 3;
    
    public void move(GameState state) {
        	int i = 1;	
        //while(true){
        while(i <= MAX_DEPTH){
        		moveValue newMove = maxAction(state, i);
        		this.move = newMove.getBin();
        		//System.out.println("Iteration " + i + " Move/Value: " + newMove.getBin() + " " + newMove.getValue());
        		i++;
        	}
    }

    //Return best move for max player. Note that this is a wrapper function created for ease to use.
    public moveValue maxAction(GameState state, int maxDepth) {
        	return maxAction(state, 0, maxDepth, -10000, 10000);
    	}
    
    //return best move for min player. Note that this is a wrapper function created for ease to use.
    public moveValue minAction(GameState state, int maxDepth) {
        	return minAction(state, 0, maxDepth, -10000, 10000);
    }
    
    //return best move for max player
    public moveValue maxAction(GameState state, int currentDepth, int maxDepth, int alpha, int beta) {
        	moveValue newMove = new moveValue(-10001, 1);
        	if(state.gameOver() || currentDepth == maxDepth){
        		newMove.setBin(14);
        		newMove.setValue(boardStat(state));
        		return newMove;
    	    }
        	int v = -10000;
        	for(int bin = 5; bin >= 0; bin--){
        		if(!state.illegalMove(bin)){
        			GameState copy = new GameState(state);
        			boolean extraTurn = copy.applyMove(bin);
        			
        			int beforeV = v;
        			if(!extraTurn)
        				v = Math.max(v, minAction(copy, currentDepth + 1, maxDepth, alpha, beta).getValue());
        			else
        				v = Math.max(v, maxAction(copy, currentDepth + 1, maxDepth, alpha, beta).getValue());
        			
                if(beforeV < v){
        				newMove.setValue(v);
        				newMove.setBin(bin);
        			}
        			alpha = Math.max(alpha, v);
        			if(v > beta)
        				return newMove;
        		}
        	}
        	return newMove;
    }
    
    //return best move for min player
    public moveValue minAction(GameState state, int currentDepth, int maxDepth, int alpha, int beta){
        	moveValue newMove = new moveValue(10001, 1);
        	if(state.gameOver() || currentDepth == maxDepth){
        		newMove.setBin(14);
        		newMove.setValue(boardStat(state));
        		return newMove;
        	}
        	int v = 10000;
        	for(int bin = 12; bin > 6; bin--){
        		if(!state.illegalMove(bin)){
        			GameState copy = new GameState(state);
        			boolean extraTurn = copy.applyMove(bin);
        			int beforeV = v;
        			if(!extraTurn)
        				v = Math.min(v, maxAction(copy, currentDepth + 1, maxDepth, alpha, beta).getValue());
        			else
        				v = Math.min(v, minAction(copy, currentDepth + 1, maxDepth, alpha, beta).getValue());
        			
                if(beforeV > v){
        				newMove.setValue(v);
        				newMove.setBin(bin);
        			}
        			beta = Math.min(beta, v);
        			if(v < alpha)
        				return newMove;
        		}
        	}
        	return newMove;
    }

    //the boardStat function calculates the difference in stone counts in the mancala boxes for the two players and the difference in the stone count of the bins. 
    private int boardStat(GameState state) {
        	return (int)(
        			(state.stoneCount(6) - state.stoneCount(13))+
        			((state.stoneCount(5) + state.stoneCount(4) + state.stoneCount(3) + state.stoneCount(2) + state.stoneCount(1) + state.stoneCount(0))
        			-(state.stoneCount(12) + state.stoneCount(11) + state.stoneCount(10) + state.stoneCount(9) + state.stoneCount(8) + state.stoneCount(7))
        			));
    }
}

