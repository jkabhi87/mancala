# mancala
Java implementation of Mancala with minimax tree and alpha beta pruning

Game chosen: Two-rank Mancala (also called Kalah).

Rules of the game: 
1	This is a board game with 12 small bins and 2 sink bins. Each player gets 1 sink and 6 small bins. The stones that end up in the sink bin is counted towards the player’s final score. The six small bins on the upper part of the board and the sink bin on the left side of the board belongs to the AI or the game program and rest of the bins are assigned to the player.
2	When it is the player’s turn, the player choses one of the six small bins that he has. Moving clockwise, the game now deposits one of the stones(from the selected bin) in each bin until the stones run out.
3	If the last stone mentioned in rule 2 lands in the player’s sink bin, the player gets an additional turn to play.
4	If the last stone mentioned in rule 2 lands in one of the player’s small bin which happens to be empty, then the player will get all the stones that are in the small bin opposite to the player’s along with his stone.
5	Player with most stones at the end of the game wins.

SOFTWARE: Java (implementation)

HARDWARE: Any machine that supports and runs Java.

STRATEGY AND APPROACH: We have used minimax tree with alpha-beta tree pruning approach to determine the best move for the AI algorithm. There are two parts to this approach.

1. When AI plays as the first player tries to make a move: In this case, AI algorithm plays as the MAX player while the opponent acts as the MIN player. Hence, AI algorithm always tries to maximize it’s gain in each move. This is done in two steps.
a. The AI algorithm tries to calculate it’s maximum gain when it chooses one of the six      bins it can choose to make it’s move. It does this by considering the possibility of getting an extra move when it chooses a bin. If there is an extra move involved, it tries to calculate the maximum gain it can achieve in a recursive manner where it calculates the largest amount of gain it can achieve in each of the extra move it has. It then adds this value to the gains in the previous moves it did that lead to the extra move.
b. The AI algorithm also considers the cases where it will not have the extra moves. Here, it just tries to calculate the maximum gain possible in each of the six bins.
It then chooses the bin with maximum possible gain value out of the six bins. 

2. When AI plays as the second player tries to make a move: In this case, AI algorithm acts as a MIN player while the opponent player acts as the MAX player. Hence, AI just tries to do the opposite of what it does in step 1. In this case, AI always tries to minimize it’s loss in each move. This is again done in two steps.
a. The AI algorithm tries to calculate it’s minimum loss when it chooses one of the six      bins it can choose to make it’s move. It does this by considering the possibility of getting an extra move when it chooses a bin. If there is an extra move involved, it tries to calculate the minimum loss value it can achieve in a recursive manner where it calculates the least amount of loss it can incur in the extra move it has. It then adds this value to the losses in the previous moves it did that lead to the extra move.
b. The AI algorithm also considers the cases where it will not have the extra moves. Here, it just tries to calculate the minimum loss possible in each of the six bins.
It then chooses the bin with minimum possible loss value out of the six bins. The AI tries to look for moves that result in a biggest negative loss value that will results in a gain for AI. Negative loss values for AI algorithm will result in a positive loss values for the opponent player which results in a gain of the equal amount for the AI algorithm.
