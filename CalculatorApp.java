import java.awt.*;
import javax.swing.*;

public class CalculatorApp 
{
	JFrame frame=new JFrame("Calculator");
	JTextField tb=new JTextField("0"); 
	JPanel panel=new JPanel();
	JButton[] bt=new JButton[20];
	public CalculatorApp()
	{
		frame.setSize(350,400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.black);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		addTextBox();
		frame.setVisible(true);
	}
	private void addTextBox()
	{
		tb.setBounds(10,10,315,30);
		frame.add(tb); 
		tb.setHorizontalAlignment(4);
		tb.setFont(new Font("times new roman",Font.BOLD,30));
		tb.setEditable(false);
		tb.setBackground(Color.white);
		tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
		addPanel();
	}
	private void addPanel()
	{		
		frame.add(panel);
		panel.setBounds(10,50,315,295);
		panel.setBackground(Color.black);
		addButton();
	}
	private void addButton()
	{
		panel.setLayout(new GridLayout(5,4,5,5));
		Font fo=new Font("arial",0,20);
		String[] str= {"DL","CE","CA","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		for(int i=0;i<20;i++)
		{
			bt[i]=new JButton(str[i]);
			bt[i].setBackground(Color.DARK_GRAY);
			bt[i].setFont(fo);
			if(i==3 || i==7 || i==11 || i==15 || i==19)
				bt[i].setForeground(Color.red);
			else
				bt[i].setForeground(Color.blue);
			panel.add(bt[i]);
		}
		bt[17].setFont(new Font("arial",1,35));
	}
	
	
	public static void main(String[] args) 
	{
		new CalculatorApp();
	}

}
