import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Calculator 
{
	JFrame frame=new JFrame("Calculator");
	JTextField tb=new JTextField("0"); 
	JPanel panel=new JPanel();
	JLabel info=new JLabel();
	JButton[] bt=new JButton[20];
	public Calculator()
	{
		frame.setSize(450,450);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.black);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		addInfoLabel();
		frame.setVisible(true);
	}
	private void addInfoLabel()
	{
		info.setBounds(20,10,360,25);
		frame.add(info); 
		info.setHorizontalAlignment(4);
		info.setFont(new Font("arial",Font.PLAIN,18));
		info.setForeground(Color.yellow);
		addTextBox();
	}

	private void addTextBox()
	{
		tb.setBounds(10,50,415,30);
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
		panel.setBounds(10,80,415,295);
		panel.setBackground(Color.black);
		addButton();
	}
	private void addButton()
	{
		panel.setLayout(new GridLayout(5,4,5,5));
		Font fo=new Font("arial",0,20);
		String[] str= {"Back","CE","C","%","9","8","7","/","6","5","4","*","3","2","1","+","0",".","=","-"};
		CalListener listener=new CalListener();
		for(int i=0;i<20;i++)
		{
			bt[i]=new JButton(str[i]);
			bt[i].setBackground(Color.DARK_GRAY);
			bt[i].addActionListener(listener);
			bt[i].setFont(fo);
			if(i==3 || i==7 || i==11 || i==15 ||i==19 )
			{
				bt[i].setForeground(Color.CYAN);
				bt[i].setFont(new Font("arial",Font.BOLD,25));
			}
			else if(i==0 || i==1|| i==2|| i==18 )
			{
				bt[i].setForeground(Color.WHITE);
				bt[i].setFont(new Font("arial",Font.PLAIN,20));
			}
			else
			{
				bt[i].setForeground(Color.black);
			}
			panel.add(bt[i]);
		}
		bt[17].setFont(new Font("arial",1,35));
	}

	class CalListener implements ActionListener
	{
		private int abc=0;
		private float num1;
		private String op=null;
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(bb==bt[17])
			{
				String str=tb.getText();
				int i=str.indexOf('.');
				if(i!=-1)
					return;
			}
			if(bb==bt[3]||bb==bt[7]||bb==bt[11]||bb==bt[15] ||bb==bt[19] )
			{
				cal();
				abc=1;
				num1=Float.parseFloat(tb.getText());
				op=bb.getText();
				info.setText(tb.getText()+" "+op);
			}
			if(bb==bt[4]||bb==bt[5]||bb==bt[6]||bb==bt[8]||bb==bt[9]||bb==bt[10]
					||bb==bt[12]||bb==bt[13]||bb==bt[14]||bb==bt[16]||bb==bt[17]) 
			{
				String bvalue=bb.getText();
				String tvalue=tb.getText();
				if(tvalue.equals("0")||abc==1)
				{
					tb.setText(bvalue);
					abc=0;
				}
				else
				{
					tb.setText(tvalue+bvalue);
				}
			}
			if(bb==bt[18])
			{
				cal();
			}
			if(bb==bt[2])
			{
				op=null;
				num1=0;
				abc=0;
				tb.setText("0");
				info.setText("");
			}
			if(bb==bt[1])
			{
				tb.setText("0");
			}
			if(bb==bt[0])
			{
				String str=tb.getText();
				if(str.equals("0"))
					return;
				if(str.length()==1)
				{
					tb.setText("0");
					return;
				}
				str=str.substring(0,str.length()-1);
				tb.setText(str);
			}
		}
		private void cal()
		{
			if(op==null)
				return;
			float num2=Float.parseFloat(tb.getText());
			double res=0;
			if(op.equals("+"))
				res=num1+num2;
			else if(op.equals("-"))
				res=num1-num2;
			else if(op.equals("*"))
				res=num1*num2;
			else if(op.equals("/"))
				res=num1/num2;
			else if(op.equals("%"))
				res=num1%num2;
			info.setText(info.getText()+" "+tb.getText()+" =");
			setResult(res);
		}
		private void setResult(double res)
		{
			int nres=(int)res;
			if(nres==res)
				tb.setText(String.valueOf(nres));
			else
				tb.setText(String.valueOf(res));
		}
	}
	public static void main(String[] args) 
	{
		new Calculator();
	}
}