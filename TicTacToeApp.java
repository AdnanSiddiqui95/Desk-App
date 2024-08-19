import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeApp 
{
	JFrame frame=new JFrame("TicTacToe-App");
	JPanel[] panel=new JPanel[3]; 
	JLabel label=new JLabel("First player turn...");
	JButton[] bt=new JButton[9];
	JButton reset =new JButton("RESET");
	JButton exit =new JButton("EXIT");
	
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));

	int player=1;
	public TicTacToeApp()
	{
		frame.setSize(450,490);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		addPanel();
		frame.setVisible(true);
	}
	private void addPanel()
	{
		for(int i=0;i<3;i++) 
		{
			panel[i]=new JPanel();
			frame.add(panel[i]);
		}
		panel[0].setBounds(20,20,390, 40);
		panel[1].setBounds(20,80,390, 310);
		panel[2].setBounds(20,400,390, 30);
		addLabel();
	}
	private void addLabel()
	{
		panel[0].add(label);
		label.setFont(new Font("elephant",Font.BOLD,20));
		label.setForeground(Color.MAGENTA);
		panel[0].setBackground(Color.pink);
		addButton();
	}
	private void addButton()
	{
		panel[1].setLayout(new GridLayout(3,3));
		TicTacListener listener=new TicTacListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.pink);
			panel[1].add(bt[i]);
		}
		addReserAndExit();
	}
	private void addReserAndExit()
	{
		panel[2].add(reset);
		panel[2].add(exit);
		panel[2].setOpaque(false);
		Font fo=new Font("arial",Font.BOLD,15);
		reset.setFont(fo);
		exit.setFont(fo);
		exit.setForeground(Color.red);
	}
class TicTacListener implements ActionListener
{
	public void actionPerformed(ActionEvent evt) 
	{
		JButton bb=(JButton)evt.getSource();
		if(player==1)
		{
			bb.setIcon(icon1);
			label.setText("Second player turn...");
			label.setForeground(Color.white);
			panel[0].setBackground(Color.gray);
			player=2;
		}
		else if(player==2)
		{
			bb.setIcon(icon2);
			label.setText("First player turn...");
			label.setForeground(Color.magenta);
			panel[0].setBackground(Color.pink);
			player=1;
		}
		bb.setEnabled(false);
		findWinner();
	}
	private void findWinner()
	{
		if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
			winnerFinder(0,1,2);
		else if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
			winnerFinder(0,1,2);
		
		else if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
			winnerFinder(3,4,5);
		else if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
			winnerFinder(3,4,5);
		
		else if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
			winnerFinder(6,7,8);
		else if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
			winnerFinder(6,7,8);
		
		else if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
			winnerFinder(0,3,6);
		else if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
			winnerFinder(0,3,6);
		
		else if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
			winnerFinder(1,4,7);
		else if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
			winnerFinder(1,4,7);
		
		else if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
			winnerFinder(2,5,8);
		else if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
			winnerFinder(2,5,8);
		
		else if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
			winnerFinder(0,4,8);
		else if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
			winnerFinder(0,4,8);
		
		else if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
			winnerFinder(2,4,6);
		else if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
			winnerFinder(2,4,6);
	}
	private void winnerFinder(int i,int j,int k)
	{
		bt[i].setBackground(Color.green);
		bt[j].setBackground(Color.green);
		bt[k].setBackground(Color.green);
		label.setText("GAME IS OVER");
		label.setForeground(Color.white);
		panel[0].setBackground(Color.red);
		
		disableButtons();
		
		if(player==2)
		{
			JOptionPane.showMessageDialog(frame,"First player has won");
		}
		else 
		{
			JOptionPane.showMessageDialog(frame,"Second player has won");
		}
	}
	private void disableButtons()
	{
		for(int i=0;i<9;i++)
		{
			bt[i].setEnabled(false);
		}
	}
}
	public static void main(String[] args) 
	{
		new TicTacToeApp();
	}

}
