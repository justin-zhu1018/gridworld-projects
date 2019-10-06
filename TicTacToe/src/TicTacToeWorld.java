import javax.swing.JOptionPane;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


public class TicTacToeWorld extends World{

	// Up here, you put the info that you need to keep track of 
	// all you need to keep track of in a tic-tac-toe game...
	boolean xTurn = true;
	int turn=0;
	int rowNumber;
	int columnNumber;
	int ScoreO=0;
	int ScoreX=0;
	Location box1=new Location (0,0);
	Location box2=new Location (0,1);
	Location box3=new Location (0,2);
	Location box4=new Location (1,0);
	Location box5=new Location (1,1);
	Location box6=new Location (1,2);
	Location box7=new Location (2,0);
	Location box8=new Location (2,1);
	Location box9=new Location (2,2);

	public TicTacToeWorld(){
		// what does the default tic tac toe game look like?
		super(new BoundedGrid(3,3));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("SCORE: "+ScoreO+"-"+ScoreX);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
	public void clearBoard(){
		// restarts the game
		this.getGrid().remove(box1);
		this.getGrid().remove(box2);
		this.getGrid().remove(box3);
		this.getGrid().remove(box4);
		this.getGrid().remove(box5);
		this.getGrid().remove(box6);
		this.getGrid().remove(box7);
		this.getGrid().remove(box8);
		this.getGrid().remove(box9);
		turn=0;
		System.out.println("SCORE: "+ScoreO+"-"+ScoreX);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int Reset=0;
		String answer=JOptionPane.showInputDialog("If you want to reset press 0. To proceed, press 1.");
		Reset=Integer.parseInt(answer);
		if(Reset>0){
			JOptionPane.showMessageDialog(null,"You may proceed...");
		}
		if(Reset<=0){
			ScoreO=0;
			ScoreX=0;
			JOptionPane.showMessageDialog(null,"Score has been reset!");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("NEW SCORE: "+ScoreO+"-"+ScoreX);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
	}

	@Override
	public boolean locationClicked(Location loc){
		// what should happen when someone clicks a square?\
		Grid g=getGrid();
		Object there=g.get(loc);
		
		if(there!=null){
			return true;
		}
		if(turn%2==0){
//			System.out.println(loc + " was clicked!");
//			this.setMessage(loc + " was clicked!");
			add(loc,"O");
		}
		else{
//			System.out.println(loc + " was clicked!");
//			this.setMessage(loc + " was clicked!");
			add(loc,"X");
		}
		turn++;
		System.out.println("Turn #: "+turn);
		gameOver(loc);
		return true;
	}
	
	
	
	public boolean gameOver(Location loc){
		// this method checks to see if the game is over.  Location loc
		// is the location of the last marker placed into the board

		Grid g = this.getGrid();
		Location check = new Location(0,0);
		System.out.println(g.get(check));
		
		if(topRow()){
			if(box1!=null||box2!=null||box3!=null){
				return true;
			}
		}
		if(midRow()){
			if(box4!=null||box5!=null||box6!=null){
				return true;
			}
		}
		if(bottomRow()){
			if(box7!=null||box8!=null||box9!=null){
				return true;
			}
		}
		if(leftColumn()){
			if(box1!=null||box4!=null||box7!=null){
				return true;
			}
		}
		if(midColumn()){
			if(box2!=null||box5!=null||box8!=null){
				return true;
			}
		}
		if(rightColumn()){
			if(box3!=null||box6!=null||box9!=null){
				return true;
			}
		}
		if(Vertical1()){
			if(box1!=null||box5!=null||box9!=null){
				return true;
			}
		}
		if(Vertical2()){
			if(box3!=null||box5!=null||box7!=null){
				return true;
			}
		}
		return false;
	}

	public boolean topRow() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o1=g.get(box1);
		Object o2=g.get(box2);
		Object o3=g.get(box3);

		if(o1==null||o2==null||o3==null){
			return false;
		}
		if(o1==o2&&o2==o3){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 1 Wins with 3 matching in the top row!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 2 Wins with 3 matching in the top row!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
		if(turn == 9){
			System.out.println("");
		}
		if(o1!=o2&&o2!=o3){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
		
	}
	
	private boolean midRow() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o4=g.get(box4);
		Object o5=g.get(box5);
		Object o6=g.get(box6);
		if(o4==null||o5==null||o6==null){
			return false;
		}
		if(o4==o5&&o5==o6){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 1 Wins with 3 matching in the middle row!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null, "Player 2 Wins with 3 matching in the middle row!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
		if(o4!=o5&&o5!=o6){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}

	public boolean bottomRow() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o7=g.get(box7);
		Object o8=g.get(box8);
		Object o9=g.get(box9);
		if(o7==null||o8==null||o9==null){
			return false;
		}
		if(o7==o8&&o8==o9){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 1 Wins with 3 matching in the bottom row!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 2 Wins with 3 matching in the bottom row!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
		if(o7!=o8&&o8!=o9){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}

	private boolean leftColumn() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o1=g.get(box1);
		Object o4=g.get(box4);
		Object o7=g.get(box7);
		if(o1==null||o4==null||o7==null){
			return false;
		}
		if(o1==o4&&o4==o7){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showInputDialog("Player 1 Wins with 3 matching in the left column!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showInputDialog("Player 2 Wins with 3 matching in the left column!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
//		if(turn == 9){
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		}
		if(o1!=o4&&o4!=o7){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}

	private boolean midColumn() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o2=g.get(box2);
		Object o5=g.get(box5);
		Object o8=g.get(box8);
		if(o2==null||o5==null||o8==null){
			return false;
		}
		if(o2==o5&&o5==o8){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null, "Player 1 Wins with 3 matching in the middle column!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 2 Wins with 3 matching in the middle column!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
		if(o2!=o5&&o5!=o8){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}
	
	private boolean rightColumn() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o3=g.get(box3);
		Object o6=g.get(box6);
		Object o9=g.get(box9);
		if(o3==null||o6==null||o9==null){
			return false;
		}
		if(o3==o6&&o6==o9){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 1 Wins with 3 matching in the right column!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 2 Wins with 3 matching in the right column!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
//		if(turn == 9){
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		}
		if(o3!=o6&&o6!=o9){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}
	private boolean Vertical1() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o1=g.get(box1);
		Object o5=g.get(box5);
		Object o9=g.get(box9);
		if(o1==null||o5==null||o9==null){
			return false;
		}
		if(o1==o5&&o5==o9){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showInputDialog("Player 1 Wins with 3 matching vertically!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showInputDialog("Player 2 Wins with 3 matching vertically!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
		if(o1!=o5&&o5!=o9){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}
	private boolean Vertical2() {
		// TODO Auto-generated method stub
		Grid g=this.getGrid();
		Object o3=g.get(box3);
		Object o5=g.get(box5);
		Object o7=g.get(box7);
		if(o3==null||o5==null||o7==null){
			return false;
		}
		if(o3==o5&&o5==o7){
			if(turn%2==1){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 1 (O) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 1 Wins with 3 matching vertically!");
				ScoreO++;
			}
			else{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Player 2 (X) wins!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				JOptionPane.showMessageDialog(null,"Player 2 Wins with 3 matching vertically!");
				ScoreX++;
			}
			clearBoard();
			return true;
		}
		if(o3!=o5&&o5!=o7){
			if(turn == 9){
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("The Game is Over!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("It is a tie!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				clearBoard();
			}
		}
		return false;
	}

}
