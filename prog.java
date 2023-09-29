
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.PriorityQueue;  
import javax.swing.*;   
 
class Node  
{    
    Character ch;    
    Integer freq;    
    Node left = null;  
    Node right = null;    
    Node(Character ch, Integer freq)  
    {  
        this.ch = ch;  
        this.freq = freq;  
    }    
    public Node(Character ch, Integer freq, Node left, Node right)  
    {  
        this.ch = ch;  
        this.freq = freq;  
        this.left = left;  
        this.right = right;  
    }  
}    

class Analyse{
    public Analyse(String og ,String FinalCode)
    {
        Frame anal = new Frame("ANALYSIS");
        anal.setLayout(null);
        anal.setSize(500,500);
        anal.setVisible(true);
        anal.setBackground(Color.LIGHT_GRAY);

        Label l1 = new Label("ANALYSIS");
        l1.setBounds(180,50,300,30);
        l1.setFont(new Font("Monospaced",Font.BOLD,25));
        anal.add(l1);

        Label l2 = new Label("Memory Occupied by original String:");
        l2.setBounds(10, 100, 320, 30);
        l2.setBackground(Color.WHITE);
        l2.setFont(new Font("Monospaced",Font.ITALIC,15));
        anal.add(l2);

        int temp1= og.length()*8;
        String t1 = Integer.toString(temp1);
        t1=t1+" bytes";

        Label l2o = new Label(t1);
        l2o.setBounds(350, 100, 150, 30);
        l2o.setFont(new Font("Monospaced",Font.BOLD,25));
        anal.add(l2o);

        


        Label l3 = new Label("Memory Occupied by encoded String:");
        l3.setBounds(10, 150, 320, 30);
        l3.setBackground(Color.WHITE);
        l3.setFont(new Font("Monospaced",Font.ITALIC,15));
        anal.add(l3);

        int temp2= FinalCode.length();
        String t2 = Integer.toString(temp2);
        t2=t2+" bytes";

        Label l3o = new Label(t2);
        l3o.setBounds(350, 150, 150, 30);
        l3o.setFont(new Font("Monospaced",Font.BOLD,25));
        anal.add(l3o);

        Label l4 = new Label("MEMORY SAVED");
        l4.setBounds(150,250,300,30);
        l4.setFont(new Font("Monospaced",Font.BOLD,25));
        anal.add(l4);

        int p = 100-(temp2*100)/temp1;
        String save = Integer.toString(p);
        save = save + " %";

        Label l5 = new Label(save);
        l5.setBounds(200,300,300,50);
        l5.setFont(new Font("Monospaced",Font.BOLD,45));
        anal.add(l5);
        


        anal.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            System.exit(0);
            }
            });
        
    }
}


class Step4{

    public Step4(String str,String FinalCode){
        
        Frame s1 = new Frame("STEP 3");
        s1.setBackground(Color.LIGHT_GRAY);
        s1.setLayout(null);
        s1.setSize(500,500);
        s1.setVisible(true);
        Label height = new Label("YOUR HUFFMAN STRING WAS : ");
		height.setBounds(20, 180, 200, 20);
		s1.add(height);


        Label l = new Label("FINAL STEP : ");
        l.setBounds(20, 80, 400, 20);
        l.setFont(new Font("Monospaced",Font.BOLD,20));
        s1.add(l);

        Label l5 = new Label("To create encoded string");
        l5.setBounds(20, 110, 500, 20);
        l5.setFont(new Font("Monospaced",Font.ITALIC,17));
        s1.add(l5);

		Label t1 =new Label(str);
        t1.setBounds(250,180,200,20);
        t1.setFont(new Font("Monospaced",Font.ITALIC,20));
        t1.setBackground(Color.WHITE);
		s1.add(t1);


        Label finalt = new Label("YOUR ENCODED STRING IS :  ");
		finalt.setBounds(20,270,500,20);
        finalt.setFont(new Font("Monospaced",Font.BOLD,25));
		s1.add(finalt);

		Label t2=new Label(FinalCode);
        t2.setBounds(20,310,400,50);
        t2.setFont(new Font("Monospaced",Font.ITALIC,20));
        t2.setBackground(Color.WHITE);
		s1.add(t2);

        Button b1 = new Button("ANALYSE");
		b1.setBounds(400, 400, 70, 80);
        b1.setBackground(Color.WHITE);
		s1.add(b1);

        


        s1.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            System.exit(0);
            }
            });

            b1.addActionListener(new ActionListener(){  
            
                public void actionPerformed(ActionEvent e){  
                    s1.setVisible(false);

                    Analyse an = new Analyse(str, FinalCode);

                      
                }  
                });


    }
}


class Step2{
    String BitCode,FinalCode;

    public Step2(String str,String BitCode,String FinalCode){
        this.BitCode=BitCode;
        this.FinalCode=FinalCode;
        Frame s3 = new Frame("STEP 2 ");
		s3.setVisible(true);
		s3.setSize(500, 500);
		s3.setLayout(null);
		
		s3.setBackground(Color.LIGHT_GRAY);

        Label l = new Label("STEP 2 : ");
        l.setBounds(20, 80, 100, 20);
        l.setFont(new Font("Monospaced",Font.BOLD,20));
        s3.add(l);

        Label l5 = new Label("To assign BIT codes");
        l5.setBounds(20, 110, 500, 20);
        l5.setFont(new Font("Monospaced",Font.ITALIC,17));
        s3.add(l5);

		Button b1 = new Button("NEXT");
		b1.setBounds(400, 400, 70, 80);
        b1.setBackground(Color.WHITE);
		s3.add(b1);

		Label height = new Label("YOUR HUFFMAN STRING WAS : ");
		height.setBounds(20, 180, 200, 20);
		s3.add(height);

		Label t1 =new Label(str);
        t1.setBounds(250,180,200,20);
        t1.setFont(new Font("Monospaced",Font.ITALIC,20));
        t1.setBackground(Color.WHITE);
		s3.add(t1);

		Label finalt = new Label("ASSIGN BIT CODE :  ");
		finalt.setBounds(20,270,220,20);
		s3.add(finalt);

		Label t2=new Label(BitCode);
        t2.setBounds(20,310,400,50);
        t2.setFont(new Font("Monospaced",Font.ITALIC,20));
        t2.setBackground(Color.WHITE);
		s3.add(t2);

        s3.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            System.exit(0);
            }
            });



            b1.addActionListener(new ActionListener(){  
            
                public void actionPerformed(ActionEvent e){  
                    s3.setVisible(false);

                    Step4 s4 = new Step4(str, FinalCode);

    
                    
                      
                }  
                });

        




    }
}

class Step1{
    String og,freq,BitCode,FinalCode;
    public Step1(String str,String str2,String BitCode,String FinalCode) {
        this.BitCode=BitCode;
        this.FinalCode=FinalCode;
        og=str;
        freq=str2;
        Frame s1 =new Frame("STEP 1 ");
        s1.setVisible(true);
        s1.setSize(500,500);
        s1.setLayout(null);

        Button b1=new Button("NEXT");
        b1.setBounds(400,400,70,80);
        s1.add(b1);
        s1.setBackground(Color.LIGHT_GRAY);

   
        Label height=new Label("YOUR HUFFMAN STRING WAS ");
        height.setBounds(20,180,200,20);
        s1.add(height);

        Label l = new Label("STEP 1 : ");
        l.setBounds(20, 80, 100, 20);
        l.setFont(new Font("Monospaced",Font.BOLD,20));
        s1.add(l);

        Label l5 = new Label("To count frequency of all Unique Characters");
        l5.setBounds(20, 110, 500, 20);
        l5.setFont(new Font("Monospaced",Font.ITALIC,17));
        s1.add(l5);


        Label t1 =new Label(og);
        t1.setBounds(250,180,200,20);
        t1.setFont(new Font("Monospaced",Font.ITALIC,20));
        t1.setBackground(Color.WHITE);
        s1.add(t1);

        Label finalt=new Label("COUNT THE NUMBER OF CHARACTER ");
        finalt.setBounds(20,270,220,20);
        s1.add(finalt);

        Label t2=new Label(str2);
        t2.setBounds(20,310,400,50);
        t2.setFont(new Font("Monospaced",Font.ITALIC,20));
        t2.setBackground(Color.WHITE);
        s1.add(t2);


        s1.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            System.exit(0);
            }
            });


            b1.addActionListener(new ActionListener(){  
            
                public void actionPerformed(ActionEvent e){  
                    s1.setVisible(false);

                    Step2 s2 = new Step2(og, BitCode, FinalCode);

    
                    
                      
                }  
                });
    }

    
}





public class Prog  
{    
    public static String str,Frequency;
    public static StringBuilder createHuffmanTree(String text)  
    {    
        if (text == null || text.length() == 0)  
        {  
            // return;                                                                    //to fix
        }    
        Map<Character, Integer> freq = new HashMap<>();  
        //loop iterates over the string and converts the text into character array  
        for (char c: text.toCharArray())  
        {    
            freq.put(c, freq.getOrDefault(c, 0) + 1);  
        }    
        //Here a point to note that the highest priority means the lowest frequency  
        final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));  
        //Loop iterate over the Map and returns a Set view of the mappings contained in this Map  
        
        for (var entry: freq.entrySet())  
        {  
            //creates a leaf node and add it to the queue  
            pq.add(new Node(entry.getKey(), entry.getValue()));  
        }  
        Frequency = convertWithIteration(freq);
        System.out.println("d;s;kdjfl   "+freq);
        while (pq.size() != 1)  
        {  
            //removing the nodes having the highest priority (the lowest frequency) from the queue  
            Node left = pq.poll();  
            Node right = pq.poll();    
            int sum = left.freq + right.freq;  
            pq.add(new Node(null, sum, left, right));  
        }    
        Node root = pq.peek();    
        Map<Character, String> huffmanCode = new HashMap<>();  
        encodeData(root, "", huffmanCode);    
        System.out.println("Huffman Codes of the characters are: " + huffmanCode);    
        System.out.println("The initial string is: " + text);    
        StringBuilder sb = new StringBuilder();
        for (char c: text.toCharArray())  
        {    
            sb.append(huffmanCode.get(c));  
        }  
        System.out.println("The encoded string is: " + sb);  


        

        str = convertWithIteration(huffmanCode);
        
        System.out.println("printingg  "+str);


        


        System.out.print("The decoded string is: ");  
        if (isLeaf(root))  
        {  
            //special case: For input like a, aa, aaa, etc.  
            while (root.freq-- > 0)  
            {  
                System.out.print(root.ch);  
            }  
        }  
        else  
        {  
            //decoding...  
            int index = -1;  
            while (index < sb.length() - 1)  
            {  
                index = decodeData(root, index, sb);  
            }  
        }  
        return sb;
    }    
    public static void encodeData(Node root, String str, Map<Character, String> huffmanCode)  
    {  
        if (root == null)  
        {  
            return;  
        }  
        if (isLeaf(root))  
        {  
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");  
        }  
        encodeData(root.left, str + '0', huffmanCode);  
        encodeData(root.right, str + '1', huffmanCode);  
    }    
    public static int decodeData(Node root, int index, StringBuilder sb)  
    {  
        //checks if the root node is null or not  
        if (root == null)  
        {  
            return index;  
        }  
        //checks if the node is a leaf node or not  
        if (isLeaf(root))  
        {  
            System.out.print(root.ch);  
            return index;  
        }  
        index++;  
        root = (sb.charAt(index) == '0') ? root.left : root.right;  
        index = decodeData(root, index, sb);  
        return index;  
    }  
    //function to check if the Huffman Tree contains a single node  
    public static boolean isLeaf(Node root)  
    {  
        //returns true if both conditions return true  
        return root.left == null && root.right == null;  
    }  
    //driver code  
    public static void main(String args[])  
    {  //GUI
        Frame f2 =new Frame("HUFFMAN ENCODING");
        f2.setVisible(true);
        f2.setSize(500,500);
        f2.setLayout(null);

        Button b1=new Button("SUBMIT");
        b1.setBounds(400,350,60,70);
        f2.add(b1);
        f2.setBackground(Color.LIGHT_GRAY);
   
        Label height=new Label("HUFFMAN ENCODING");
        height.setBounds(110,100,350,30);
        f2.add(height);
        

        Label hml1 = new Label("ENTER A STRING TO ENCODE IT :");
        hml1.setBounds(100, 190, 300, 50);
        f2.add(hml1);
        hml1.setFont(new Font("Monospaced",Font.ITALIC,15));
        
        height.setFont(new Font("Serif",Font.BOLD,25));


        TextField t1 =new TextField();
        t1.setBounds(100,250,300,50);
        f2.add(t1);

        

        f2.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            System.exit(0);
            }
            });

        b1.addActionListener(new ActionListener(){  
            
            public void actionPerformed(ActionEvent e){  
                String text = t1.getText();  
                StringBuilder sbb = createHuffmanTree(text);
                String singleString = sbb.toString();



                JFrame f3 = new JFrame();
                f3.setLayout(null);
                f3.setSize(400,400);
                f2.setVisible(false);

                Step1 s1 = new Step1(text,Frequency,str,singleString);


                f3.setVisible(false);

                String[] str2 = new String[]{ str };
                String[][] stringArray = new String[][]{ str2 };

                
                  
            }  
            });  
    }  



    public static String convertWithIteration(Map<Character, ?> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (Character key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
}
