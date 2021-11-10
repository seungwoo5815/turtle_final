import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class First_Scene extends JFrame {
 
	private static Random random;
	private static int enemy1H, enemy1W, enemy2H, enemy2W, enemy3H, enemy3W, enemy4H, enemy4W, enemy5H, enemy5W, enemy6H, enemy6W;
	private static int where, start;
	private static Icon temp1, temp2, temp3, temp4, temp5, temp6, Itemp1, Itemp2, Itemp3, Itemp4, Itemp5, Itemp6;
	String Titem_Queue1[] = new String[20];
	String Titem_Queue2[] = new String[20];
	String Titem_Queue3[] = new String[20];
	String Titem_Queue4[] = new String[20];
	String Titem_Queue5[] = new String[20];
	String Titem_Queue6[] = new String[20];
	private int T_Queue1_Front, T_Queue2_Front, T_Queue3_Front, T_Queue4_Front, T_Queue5_Front, T_Queue6_Front;
	private int T_Queue1_Rear, T_Queue2_Rear, T_Queue3_Rear, T_Queue4_Rear, T_Queue5_Rear, T_Queue6_Rear;
	private static final int FRAME_WIDTH = 990;
	private static final int FRAME_HEIGHT = 650;
	private static final int MAP_SIZE_WIDTH = 20;
	private static final int MAP_SIZE_HEIGHT = 14;
	private static final int MAP_END = MAP_SIZE_WIDTH - 3;
	
    public First_Scene() {
 
        super("TRace"); //타이틀
        JPanel jPanel = new JPanel();
        JButton btn1 = new JButton("GAME START");
        setSize(300, 200); //창 크기 설정
        jPanel.add(btn1);
        add(jPanel);
 
        Dimension frameSize = getSize();
 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
 
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		final JFrame frame = new JFrame();
        		final ImageIcon red = new ImageIcon("red.png");
        		final ImageIcon gold = new ImageIcon("gold.png");
        		final ImageIcon green = new ImageIcon("green.png");
        		final ImageIcon blue = new ImageIcon("blue.png");
        		final ImageIcon purple = new ImageIcon("purple.png");
        		final ImageIcon gray = new ImageIcon("gray.png");
        		final ImageIcon wall = new ImageIcon("wall.png");
        		final ImageIcon turtle1 = new ImageIcon("1_red.png");
        		final ImageIcon turtle2 = new ImageIcon("2_gold.png");
        		final ImageIcon turtle3 = new ImageIcon("3_green.png");
        		final ImageIcon turtle4 = new ImageIcon("4_blue.png");
        		final ImageIcon turtle5 = new ImageIcon("5_purple.png");
        		final ImageIcon turtle6 = new ImageIcon("6_gray.png");
        		final ImageIcon boost = new ImageIcon("boost.png");
        		final ImageIcon stop = new ImageIcon("stop.png");
        		final ImageIcon undo = new ImageIcon("undo.png");
        		final ImageIcon end_line = new ImageIcon("end_line.png");
        		
        		
        		final ImageIcon pacman = new ImageIcon("pacman.png");
        		final ImageIcon enemy = new ImageIcon("enemy.png");
        		final ImageIcon empty = new ImageIcon("empty.png");
        		final ImageIcon bigDot = new ImageIcon("bigDot.png");
        		final ImageIcon smallDot = new ImageIcon("smallDot.png");

        		final JButton button1 = new JButton(red);
        		final JButton button2 = new JButton(gold);
        		final JButton button3 = new JButton(green);
        		final JButton button4 = new JButton(blue);
        		final JButton button5 = new JButton(purple);
        		final JButton button6 = new JButton(gray);
        		final JDialog dialog = new JDialog();
        		
        		random = new Random();

        		dialog.setSize(1080,1080);
        		dialog.setVisible(false);
        		
        		T_Queue1_Front = 0;  T_Queue1_Rear = 19;
        		T_Queue2_Front = 0;  T_Queue2_Rear = 19;
        		T_Queue3_Front = 0;  T_Queue3_Rear = 19;
        		T_Queue4_Front = 0;  T_Queue4_Rear = 19;
        		T_Queue5_Front = 0;  T_Queue5_Rear = 19;
        		T_Queue6_Front = 0;  T_Queue6_Rear = 19;
        		
        		enemy1H=1;  enemy1W=1;
        		enemy2H=3;  enemy2W=1;
        		enemy3H=5; enemy3W=1; 
        		enemy4H=7; enemy4W=1;
        		enemy5H=9; enemy5W=1;
        		enemy6H=11; enemy6W=1;
        		
        		start=2;  
        		Itemp1=empty; Itemp2=empty; Itemp3=empty; Itemp4=empty; Itemp5=empty; Itemp6=empty;
        		
        		
        		final JLabel[][] f = new JLabel[MAP_SIZE_HEIGHT][MAP_SIZE_WIDTH];
        		
        		for (int i=0; i<MAP_SIZE_HEIGHT; i++) {
        			for(int j=0; j<MAP_SIZE_WIDTH; j++) {
        				f[i][j] = new JLabel();
        			}
        		}
        			
        		class Blistener implements ActionListener {
        			public void actionPerformed(ActionEvent event) {
        				System.exit(0);
        			}
        		}

        		class TListener1 implements ActionListener {   //timer클래스 ActionListener
        			public TListener1(int x, int y) {
        				enemy1H = x;
        				enemy1W = y;
        			}
        			
        			public void actionPerformed(ActionEvent event)
        			{
        				
        				if(start<=0) where = 1+random.nextInt(4);
        				else { where = 1; start--; }
        					switch(where) {
        					case 1:
        						if(!(f[enemy1H][enemy1W+1].getIcon()).equals(wall) && !(f[enemy1H][enemy1W+1].getIcon()).equals(stop) && !(f[enemy1H][enemy1W+1].getIcon()).equals(boost) && !(f[enemy1H][enemy1W+1].getIcon()).equals(undo)) {
        							temp1=f[enemy1H][enemy1W+1].getIcon();
        							f[enemy1H][enemy1W+1].setIcon(turtle1);
        							f[enemy1H][enemy1W].setIcon(Itemp1);
        							Itemp1=temp1;
        							enemy1W++;
        						}
        						
        						else if(f[enemy1H][enemy1W+1].getIcon().equals(stop)) {
        							temp1=f[enemy1H][enemy1W-1].getIcon();
        							f[enemy1H][enemy1W+1].setIcon(empty);
        							f[enemy1H][enemy1W].setIcon(Itemp1);
        							Itemp1=temp1;
        							enemy1H = 1;
        							enemy1W = 1;
        							f[enemy1H][enemy1W].setIcon(turtle1);
        							Titem_Queue1[T_Queue1_Front] = "stop";
        							T_Queue1_Front++;
        						}
        						
        						else if(f[enemy1H][enemy1W+1].getIcon().equals(boost)) {
        							temp1=f[enemy1H][enemy1W-1].getIcon();
        							f[enemy1H][enemy1W+1].setIcon(empty);
        							f[enemy1H][enemy1W].setIcon(Itemp1);
        							Itemp1=temp1;
        							enemy1W = enemy1W + 2;
        							f[enemy1H][enemy1W].setIcon(turtle1);
        							Titem_Queue1[T_Queue1_Front] = "boost";
        							T_Queue1_Front++;
        						}
        						else if(f[enemy1H][enemy1W+1].getIcon().equals(undo)) {
        							temp1=f[enemy1H][enemy1W-1].getIcon();
        							f[enemy1H][enemy1W+1].setIcon(empty);
        							f[enemy1H][enemy1W].setIcon(Itemp1);
        							Itemp1=temp1;
        							enemy1W--;
        							f[enemy1H][enemy1W].setIcon(turtle1);
        							Titem_Queue1[T_Queue1_Front] = "undo";
        							T_Queue1_Front++;
        						}
        						break;
        					}
        					if(enemy1W==MAP_END) {
        						f[enemy1H][enemy1W].setIcon(turtle1);
								dialog.add(button1);
        						dialog.setVisible(true);
        						for(int i = 0; i < T_Queue1_Front + 1;i++)
        							System.out.println(Titem_Queue1[i] + " ");
        					}				
        				System.out.println(where);
        			}
        			
        		}
        		
        		class TListener2 implements ActionListener {   //timer클래스 ActionListener
        			public TListener2(int x, int y) {
        				enemy2H = x;
        				enemy2W = y;
        			}
        			
        			public void actionPerformed(ActionEvent event)
        			{
        				if(start<=0) where = 1+random.nextInt(2);
        				else { where = 1; start--; }
        					switch(where) {
        					case 1:
        						if(!(f[enemy2H][enemy2W+1].getIcon()).equals(wall) && !(f[enemy2H][enemy2W+1].getIcon()).equals(stop) && !(f[enemy2H][enemy2W+1].getIcon()).equals(boost) && !(f[enemy2H][enemy2W+1].getIcon()).equals(undo)) {
        							temp2=f[enemy2H][enemy2W+1].getIcon();
        							f[enemy2H][enemy2W+1].setIcon(turtle2);
        							f[enemy2H][enemy2W].setIcon(Itemp2);
        							Itemp2=temp2;
        							enemy2W++;
        						}
        						else if(f[enemy2H][enemy2W+1].getIcon().equals(stop)) {
        							temp2=f[enemy2H][enemy2W-1].getIcon();
        							f[enemy2H][enemy2W+1].setIcon(empty);
        							f[enemy2H][enemy2W].setIcon(Itemp2);
        							Itemp2=temp2;
        							enemy2H = 3;
        							enemy2W = 1;
        							f[enemy2H][enemy2W].setIcon(turtle2);
        							Titem_Queue2[T_Queue2_Front] = "stop";
        							T_Queue2_Front++;
        						}
        						
        						else if(f[enemy2H][enemy2W+1].getIcon().equals(boost)) {
        							temp2=f[enemy2H][enemy2W-1].getIcon();
        							f[enemy2H][enemy2W+1].setIcon(empty);
        							f[enemy2H][enemy2W].setIcon(Itemp2);
        							Itemp2=temp2;
        							enemy2W = enemy2W + 2;
        							f[enemy2H][enemy2W].setIcon(turtle2);
        							Titem_Queue2[T_Queue2_Front] = "boost";
        							T_Queue2_Front++;
        						}
        						
        						else if(f[enemy2H][enemy2W+1].getIcon().equals(undo)) {
        							temp2=f[enemy2H][enemy2W-1].getIcon();
        							f[enemy2H][enemy2W+1].setIcon(empty);
        							f[enemy2H][enemy2W].setIcon(Itemp2);
        							Itemp2=temp2;
        							enemy2W--;
        							f[enemy2H][enemy2W].setIcon(turtle2);
        							Titem_Queue2[T_Queue2_Front] = "undo";
        							T_Queue2_Front++;
        						}
        						break;
        					}
        					if(enemy2W==MAP_END) {
        						f[enemy2H][enemy2W].setIcon(turtle2);
								dialog.add(button2);
        						dialog.setVisible(true);
        						for(int i = 0; i < T_Queue2_Front + 1;i++)
        							System.out.println(Titem_Queue2[i] + " ");
        					}
        				System.out.println(where);
        			}
        		}
        		
        		class TListener3 implements ActionListener {   //timer클래스 ActionListener
        			public TListener3(int x, int y) {
        				enemy3H = x;
        				enemy3W = y;
        			}
        			
        			public void actionPerformed(ActionEvent event)
        			{
        				if(start<=0) where = 1+random.nextInt(2);
        				else { where = 1; start--; }
        					switch(where) {
        					case 1:
        						if(!(f[enemy3H][enemy3W+1].getIcon()).equals(wall) && !(f[enemy3H][enemy3W+1].getIcon()).equals(stop) && !(f[enemy3H][enemy3W+1].getIcon()).equals(boost) && !(f[enemy3H][enemy3W+1].getIcon()).equals(undo)) {
        							temp3=f[enemy3H][enemy3W+1].getIcon();
        							f[enemy3H][enemy3W+1].setIcon(turtle3);
        							f[enemy3H][enemy3W].setIcon(Itemp3);
        							Itemp3=temp3;
        							enemy3W++;
        						}
        						else if(f[enemy3H][enemy3W+1].getIcon().equals(stop)) {
        							temp3=f[enemy3H][enemy3W-1].getIcon();
        							f[enemy3H][enemy3W+1].setIcon(empty);
        							f[enemy3H][enemy3W].setIcon(Itemp3);
        							Itemp3=temp3;
        							enemy3H = 5;
        							enemy3W = 1;
        							f[enemy3H][enemy3W].setIcon(turtle3);
        							Titem_Queue3[T_Queue3_Front] = "stop";
        							T_Queue3_Front++;
        						}
        						
        						else if(f[enemy3H][enemy3W+1].getIcon().equals(boost)) {
        							temp3=f[enemy3H][enemy3W-1].getIcon();
        							f[enemy3H][enemy3W+1].setIcon(empty);
        							f[enemy3H][enemy3W].setIcon(Itemp3);
        							Itemp3=temp3;
        							enemy3W = enemy3W + 2;
        							f[enemy3H][enemy3W].setIcon(turtle3);
        							Titem_Queue3[T_Queue3_Front] = "boost";
        							T_Queue3_Front++;
        						}
        						else if(f[enemy3H][enemy3W+1].getIcon().equals(undo)) {
        							temp3=f[enemy3H][enemy3W-1].getIcon();
        							f[enemy3H][enemy3W+1].setIcon(empty);
        							f[enemy3H][enemy3W].setIcon(Itemp3);
        							Itemp3=temp3;
        							enemy3W--;
        							f[enemy3H][enemy3W].setIcon(turtle3);
        							Titem_Queue3[T_Queue3_Front] = "undo";
        							T_Queue3_Front++;
        						}
        						break;
        					}	
        					if(enemy3W==MAP_END) {
        						f[enemy3H][enemy3W].setIcon(turtle3);
								dialog.add(button3);
        						dialog.setVisible(true);
        						for(int i = 0; i < T_Queue3_Front + 1;i++)
        							System.out.println(Titem_Queue3[i] + " ");
        					}
        				System.out.println(where);
        			}
        		}
        		
        		class TListener4 implements ActionListener {   //timer클래스 ActionListener
        			public TListener4(int x, int y) {
        				enemy4H = x;
        				enemy4W = y;
        			}
        			
        			public void actionPerformed(ActionEvent event)
        			{
        				if(start<=0) where = 1+random.nextInt(2);
        				else { where = 1; start--; }
        					switch(where) {
        					case 1:
        						if(!(f[enemy4H][enemy4W+1].getIcon()).equals(wall) && !(f[enemy4H][enemy4W+1].getIcon()).equals(stop) && !(f[enemy4H][enemy4W+1].getIcon()).equals(boost) && !(f[enemy4H][enemy4W+1].getIcon()).equals(undo)) {
        							temp4=f[enemy4H][enemy4W+1].getIcon();
        							f[enemy4H][enemy4W+1].setIcon(turtle4);
        							f[enemy4H][enemy4W].setIcon(Itemp4);
        							Itemp4=temp4;
        							enemy4W++;
        						}
        						else if(f[enemy4H][enemy4W+1].getIcon().equals(stop)) {
        							temp4=f[enemy4H][enemy4W-1].getIcon();
        							f[enemy4H][enemy4W+1].setIcon(empty);
        							f[enemy4H][enemy4W].setIcon(Itemp4);
        							Itemp4=temp4;
        							enemy4H = 7;
        							enemy4W = 1;
        							f[enemy4H][enemy4W].setIcon(turtle4);
        							Titem_Queue4[T_Queue4_Front] = "stop";
        							T_Queue4_Front++;
        						}
        						
        						else if(f[enemy4H][enemy4W+1].getIcon().equals(boost)) {
        							temp4=f[enemy4H][enemy4W-1].getIcon();
        							f[enemy4H][enemy4W+1].setIcon(empty);
        							f[enemy4H][enemy4W].setIcon(Itemp4);
        							Itemp4=temp4;
        							enemy4W = enemy4W + 2;
        							f[enemy4H][enemy4W].setIcon(turtle4);
        							Titem_Queue4[T_Queue4_Front] = "boost";
        							T_Queue4_Front++;
        						}
        						else if(f[enemy4H][enemy4W+1].getIcon().equals(undo)) {
        							temp4=f[enemy4H][enemy4W-1].getIcon();
        							f[enemy4H][enemy4W+1].setIcon(empty);
        							f[enemy4H][enemy4W].setIcon(Itemp4);
        							Itemp4=temp4;
        							enemy4W--;
        							f[enemy4H][enemy4W].setIcon(turtle4);
        							Titem_Queue4[T_Queue4_Front] = "undo";
        							T_Queue4_Front++;
        						}
        						break;
        					}	
        					if(enemy4W==MAP_END) {
        						f[enemy4H][enemy4W].setIcon(turtle4);
								dialog.add(button4);
        						dialog.setVisible(true);
        						for(int i = 0; i < T_Queue4_Front + 1;i++)
        							System.out.println(Titem_Queue4[i] + " ");
        					}
        				System.out.println(where);
        			}
        		}
        		
        		class TListener5 implements ActionListener {   //timer클래스 ActionListener
        			public TListener5(int x, int y) {
        				enemy5H = x;
        				enemy5W = y;
        			}
        			
        			public void actionPerformed(ActionEvent event)
        			{
        				if(start<=0) where = 1+random.nextInt(2);
        				else { where = 1; start--; }
        					switch(where) {
        					case 1:
        						if(!(f[enemy5H][enemy5W+1].getIcon()).equals(wall) && !(f[enemy5H][enemy5W+1].getIcon()).equals(stop) && !(f[enemy5H][enemy5W+1].getIcon()).equals(boost) && !(f[enemy5H][enemy5W+1].getIcon()).equals(undo)) {
        							temp5=f[enemy5H][enemy5W+1].getIcon();
        							f[enemy5H][enemy5W+1].setIcon(turtle5);
        							f[enemy5H][enemy5W].setIcon(Itemp5);
        							Itemp5=temp5;
        							enemy5W++;
        						}
        						else if(f[enemy5H][enemy5W+1].getIcon().equals(stop)) {
        							temp5=f[enemy5H][enemy5W-1].getIcon();
        							f[enemy5H][enemy5W+1].setIcon(empty);
        							f[enemy5H][enemy5W].setIcon(Itemp5);
        							Itemp5=temp5;
        							enemy5H = 9;
        							enemy5W = 1;
        							f[enemy5H][enemy5W].setIcon(turtle5);
        							Titem_Queue5[T_Queue5_Front] = "stop";
        							T_Queue5_Front++;
        						}
        						
        						else if(f[enemy5H][enemy5W+1].getIcon().equals(boost)) {
        							temp5=f[enemy5H][enemy5W-1].getIcon();
        							f[enemy5H][enemy5W+1].setIcon(empty);
        							f[enemy5H][enemy5W].setIcon(Itemp5);
        							Itemp5=temp5;
        							enemy5W = enemy5W + 2;
        							f[enemy5H][enemy5W].setIcon(turtle5);
        							Titem_Queue5[T_Queue5_Front] = "boost";
        							T_Queue5_Front++;
        						}
        						else if(f[enemy5H][enemy5W+1].getIcon().equals(undo)) {
        							temp5=f[enemy5H][enemy5W-1].getIcon();
        							f[enemy5H][enemy5W+1].setIcon(empty);
        							f[enemy5H][enemy5W].setIcon(Itemp5);
        							Itemp5=temp5;
        							enemy5W--;
        							f[enemy5H][enemy5W].setIcon(turtle5);
        							Titem_Queue5[T_Queue5_Front] = "undo";
        							T_Queue5_Front++;
        						}
        						break;
        					}	
        					if(enemy5W==MAP_END) {
        						f[enemy5H][enemy5W].setIcon(turtle5);
								dialog.add(button5);
        						dialog.setVisible(true);
        						for(int i = 0; i < T_Queue5_Front + 1;i++)
        							System.out.println(Titem_Queue5[i] + " ");
        					}
        				System.out.println(where);
        			}
        		}
        		
        		class TListener6 implements ActionListener {   //timer클래스 ActionListener
        			public TListener6(int x, int y) {
        				enemy6H = x;
        				enemy6W = y;
        			}
        			
        			public void actionPerformed(ActionEvent event)
        			{
        				if(start<=0) where = 1+random.nextInt(2);
        				else { where = 1; start--; }
        					switch(where) {
        					case 1:
        						if(!(f[enemy6H][enemy6W+1].getIcon()).equals(wall) && !(f[enemy6H][enemy6W+1].getIcon()).equals(stop) && !(f[enemy6H][enemy6W+1].getIcon()).equals(boost) && !(f[enemy6H][enemy6W+1].getIcon()).equals(undo)) {
        							temp6=f[enemy6H][enemy6W+1].getIcon();
        							f[enemy6H][enemy6W+1].setIcon(turtle6);
        							f[enemy6H][enemy6W].setIcon(Itemp6);
        							Itemp6=temp6;
        							enemy6W++;
        						}
        						else if(f[enemy6H][enemy6W+1].getIcon().equals(stop)) {
        							temp6=f[enemy6H][enemy6W-1].getIcon();
        							f[enemy6H][enemy6W+1].setIcon(empty);
        							f[enemy6H][enemy6W].setIcon(Itemp6);
        							Itemp6=temp6;
        							enemy6H = 11;
        							enemy6W = 1;
        							f[enemy6H][enemy6W].setIcon(turtle6);
        							Titem_Queue6[T_Queue6_Front] = "stop";
        							T_Queue6_Front++;
        						}
        						
        						else if(f[enemy6H][enemy6W+1].getIcon().equals(boost)) {
        							temp6=f[enemy6H][enemy6W-1].getIcon();
        							f[enemy6H][enemy6W+1].setIcon(empty);
        							f[enemy6H][enemy6W].setIcon(Itemp6);
        							Itemp6=temp6;
        							enemy6W = enemy6W + 2;
        							f[enemy6H][enemy6W].setIcon(turtle6);
        							Titem_Queue6[T_Queue6_Front] = "boost";
        							T_Queue6_Front++;
        						}
        						else if(f[enemy6H][enemy6W+1].getIcon().equals(undo)) {
        							temp6=f[enemy6H][enemy6W-1].getIcon();
        							f[enemy6H][enemy6W+1].setIcon(empty);
        							f[enemy6H][enemy6W].setIcon(Itemp6);
        							Itemp6=temp6;
        							enemy6W--;
        							f[enemy6H][enemy6W].setIcon(turtle6);
        							Titem_Queue6[T_Queue6_Front] = "undo";
        							T_Queue6_Front++;
        						}
        						break;
        					}	
        					if(enemy6W==MAP_END) {
        						f[enemy6H][enemy6W].setIcon(turtle6);
								dialog.add(button6);
        						dialog.setVisible(true);
        						for(int i = 0; i < T_Queue6_Front + 1;i++)
        							System.out.println(Titem_Queue6[i] + " ");
        					}
        				System.out.println(where);
        			}
        		}
        		
        		JPanel panel = new JPanel();
        		panel.setLayout(new GridLayout(MAP_SIZE_HEIGHT,MAP_SIZE_WIDTH));
        		frame.requestFocus();

        		

        		for(int i=0; i<MAP_SIZE_HEIGHT; i++) {
        			for(int j=0; j<MAP_SIZE_WIDTH; j++) {
        					f[i][j].setIcon(wall);
        					panel.add(f[i][j]);
        				
        			}
        		}
        		
        		for(int i=1; i<MAP_SIZE_HEIGHT - 1; i++) {
        			for(int j=1; j<MAP_SIZE_WIDTH - 1; j++) {
        					f[i][j].setIcon(empty);
        					frame.add(panel);
        				
        			}
        		}
        		
        		f[enemy1H][enemy1W].setIcon(turtle1);
        		f[enemy2H][enemy2W].setIcon(turtle2);
        		f[enemy3H][enemy3W].setIcon(turtle3);
        		f[enemy4H][enemy4W].setIcon(turtle4);
        		f[enemy5H][enemy5W].setIcon(turtle5);
        		f[enemy6H][enemy6W].setIcon(turtle6);
        		
        		
        		//적 생성 부분 아래에 넣기
				//장애물 스폰
				int[][] array = new int[MAP_SIZE_HEIGHT][MAP_SIZE_WIDTH];
				
				
				Random r = new Random();
				int temp = 0;
				
				//장애물을 생성하기 위한 가상 배열 설치
				for (int i = 1; i < MAP_SIZE_HEIGHT - 1; i++) {
					for (int j = 3; j < MAP_SIZE_WIDTH - 4; j++) {
							temp = (int)r.nextInt(100);
							if (temp >= 0 && temp < 50) {
								array [i][j] = 0;
							}
							
							else if (temp >= 50 && temp < 60) {
								array [i][j] = 1;
							}
							
							else if (temp >= 60 && temp < 80) {
								array [i][j] = 2;
							}
							
							else if (temp >= 80 && temp < 100) {
								array [i][j] = 3;
							}
					}
				}
			
				//장애물 종류에 따른 다른 장애물 설치
				for (int i = 1; i < MAP_SIZE_HEIGHT - 1; i++) {
					for (int j = 3; j < MAP_SIZE_WIDTH - 4; j++) {
						if (array[i][j] == 0 && ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 9) || (i == 11)))
							f[i][j].setIcon(empty);
						else if (array[i][j] == 1 && ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 9) || (i == 11)))
							f[i][j].setIcon(stop);
						else if (array[i][j] == 2 && ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 9) || (i == 11)))
							f[i][j].setIcon(boost);
						else if (array[i][j] == 3 && ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 9) || (i == 11)))
							f[i][j].setIcon(undo);
						
						frame.add(panel);
					}
				}
        				
        		for(int i=1; i<MAP_SIZE_HEIGHT - 1; i++) {
        			f[i][MAP_END].setIcon(end_line);
        		}
        		
        		TListener1 tListener1 = new TListener1(enemy1H,enemy1W);
        		TListener2 tListener2 = new TListener2(enemy2H,enemy2W);
        		TListener3 tListener3 = new TListener3(enemy3H,enemy3W);
        		TListener4 tListener4 = new TListener4(enemy4H,enemy4W);
        		TListener5 tListener5 = new TListener5(enemy5H,enemy5W);
        		TListener6 tListener6 = new TListener6(enemy6H,enemy6W);
        		
        		button1.addActionListener(new Blistener());
        		button2.addActionListener(new Blistener());
        		button3.addActionListener(new Blistener());
        		button4.addActionListener(new Blistener());
        		button5.addActionListener(new Blistener());
        		button6.addActionListener(new Blistener());
        		
        		Timer t1 = new Timer(500, tListener1);
        		Timer t2 = new Timer(500, tListener2);
        		Timer t3 = new Timer(500, tListener3);
        		Timer t4 = new Timer(500, tListener4);
        		Timer t5 = new Timer(500, tListener5);
        		Timer t6 = new Timer(500, tListener6);
        		
        		t1.start();
        		t2.start();
        		t3.start();
        		t4.start();
        		t5.start();
        		t6.start();
        		
        		frame.setTitle("TurtleGame");
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setVisible(true);
        		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                setVisible(false); // 처음 창 안보이게 하기 
            }
        });
    }
 
}