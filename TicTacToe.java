/**
    Buangjug, Joy Lyka B.
	OOPROG
		TIC TAC TOE GAME	
*/
import java.awt.*; //abstact windowing toolkit
import java.awt.event.*; //for event listener
import javax.swing.*; //java extension
public class TicTacToe extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel button = new JPanel();
	JLabel txtField = new JLabel();
	JButton[] btns = new JButton[9];
	boolean player1Turn=true; //indicator for first turn
	
	public TicTacToe() {
		frame.setTitle("Tic Tac Toe"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		txtField.setForeground(Color.white);
		txtField.setFont(new Font("Helvetica",Font.BOLD,25));
		txtField.setHorizontalAlignment(JLabel.CENTER);
		
		button.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++) {
			btns[i] = new JButton();
			button.add(btns[i]);
			btns[i].setFont(new Font("MV Boli",Font.BOLD,55));
			btns[i].setFocusable(false); //used to activate/deactivate the focus event of the view
			btns[i].setBackground(Color.black);
			btns[i].addActionListener(this);
		}
		
		panel.setBackground(Color.black);
		panel.add(txtField);
		frame.add(panel,BorderLayout.NORTH); 
		frame.add(button);
		
		firstTurn();
	}
	public void firstTurn() {
		//default player 1 first to move for this game
		if(player1Turn) {
			txtField.setText("X turn");
		}
	}
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==btns[i]) {
				if(player1Turn) {
					if(btns[i].getText()=="") {
						btns[i].setForeground(Color.red);
						btns[i].setText("X");
						player1Turn=false;
						txtField.setText("O turn"); //player 2
						check();
					}
				}
				else { 
					if(btns[i].getText()=="") {
						btns[i].setForeground(Color.blue);
						btns[i].setText("O");
						player1Turn=true;
						txtField.setText("X turn"); //player 1
						check();
					}
				}
			}
		}
		
	}
	public void check() {
		//check X wins
		if(btns[0].getText()=="X" && btns[1].getText()=="X" && btns[2].getText()=="X") {
			xWinner(0,1,2);
		}
		if(btns[3].getText()=="X" && btns[4].getText()=="X" && btns[5].getText()=="X") {
			xWinner(3,4,5);
		}
		if(btns[6].getText()=="X" && btns[7].getText()=="X" && btns[8].getText()=="X") {
			xWinner(6,7,8);
		}
		if(btns[0].getText()=="X" && btns[3].getText()=="X" && btns[6].getText()=="X") {
			xWinner(0,3,6);
		}
		if(btns[1].getText()=="X" && btns[4].getText()=="X" && btns[7].getText()=="X") {
			xWinner(1,4,7);
		}
		if(btns[2].getText()=="X" && btns[5].getText()=="X" && btns[8].getText()=="X") {
			xWinner(2,5,8);
		}
		if(btns[0].getText()=="X" && btns[4].getText()=="X" && btns[8].getText()=="X") {
			xWinner(0,4,8);
		}
		if(btns[2].getText()=="X" && btns[4].getText()=="X" && btns[6].getText()=="X") {
			xWinner(2,4,6);
		}
		//check O wins
		if(btns[0].getText()=="O" && btns[1].getText()=="O" && btns[2].getText()=="O") {
			oWinner(0,1,2);
		}
		if(btns[3].getText()=="O" && btns[4].getText()=="O" && btns[5].getText()=="O") {
			oWinner(3,4,5);
		}
		if(btns[6].getText()=="O" && btns[7].getText()=="O" && btns[8].getText()=="O") {
			oWinner(6,7,8);
		}
		if(btns[0].getText()=="O" && btns[3].getText()=="O" && btns[6].getText()=="O") {
			oWinner(0,3,6);
		}
		if(btns[1].getText()=="O" && btns[4].getText()=="O" && btns[7].getText()=="O") {
			oWinner(1,4,7);
		}
		if(btns[2].getText()=="O" && btns[5].getText()=="O" && btns[8].getText()=="O") {
			oWinner(2,5,8);
		}
		if(btns[0].getText()=="O" && btns[4].getText()=="O" && btns[8].getText()=="O") {
			oWinner(0,4,8);
		}
		if(btns[2].getText()=="O" && btns[4].getText()=="O" && btns[6].getText()=="O") {
			oWinner(2,4,6);
		}
		//check if it's a tie
		// this will execute only if all button has value which is X or O 
		if( (btns[0].getText()=="X" || btns[0].getText()=="O") && (btns[1].getText()=="X" || btns[1].getText()=="O") && (btns[2].getText()=="X" || btns[2].getText()=="O") && (btns[3].getText()=="X" || btns[3].getText()=="O") && (btns[4].getText()=="X" || btns[4].getText()=="O") && (btns[5].getText()=="X" || btns[5].getText()=="O") && (btns[6].getText()=="X" || btns[6].getText()=="O") && (btns[7].getText()=="X" || btns[7].getText()=="O") && (btns[8].getText()=="X" || btns[8].getText()=="O") ) { 
			tie();
		}
	}
	public void xWinner(int a, int b, int c) {
		btns[a].setBackground(Color.green);
		btns[b].setBackground(Color.green);
		btns[c].setBackground(Color.green);
		for(int i=0;i<9;i++) {
			btns[i].setEnabled(false); //after winning this will set the button unable so player cant do anything to the buttons
		}
		txtField.setText("X wins");
	}
	public void oWinner(int a, int b, int c) {
		btns[a].setBackground(Color.green);
		btns[b].setBackground(Color.green);
		btns[c].setBackground(Color.green);
		for(int i=0;i<9;i++) {
			btns[i].setEnabled(false); //after winning this will set the button unable so player cant do anything to the buttons
		}
		txtField.setText("O wins");
	}
	public void tie() {
		txtField.setText("It's a Tie!");
	}
	public static void main(String[] args) {
		new TicTacToe();
	}
}