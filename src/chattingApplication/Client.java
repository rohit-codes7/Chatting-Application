package chattingApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*; // color class
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
// RUN -> main method call -> object call -> Immediate constructor call

public class Client  implements ActionListener {
    JTextField text;
    static JFrame f = new JFrame();
    static JPanel a1;
    static DataOutputStream dout;
    static Box vertical = Box.createVerticalBox();
    Client(){
        f.setLayout(null);

        JPanel p1 =  new JPanel();
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450, 70); // as we have set the layout to null we have to mention the  boundaries
        p1.setLayout(null);

        f.add(p1); // every time you are creating panel you have to add it using add function

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,25,25);
        p1.add(back);




        //action on click
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
                System.exit(0);
            }
        });
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40,10,50,50);
        p1.add(profile);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300,20,30,30);
        p1.add(video);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360,20,35,30);
        p1.add(phone);


        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(410,20,10,25);
        p1.add(morevert);


        JLabel name = new JLabel("Shayam");
        name.setBounds(110,15,100,18);
        name.setForeground(Color.white);  // method to change text color
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.white);  // method to change text color
        status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(status);


        a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        f.add(a1);

        text = new JTextField();  // for text area
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.white);

        // action on send button
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        f.add(send);



        // By default, opening location of the window is top left
        f.setSize(450,700);
        f.setUndecorated(true); // to remove the default header part


        f.setLocation(800,50);
        f.getContentPane().setBackground(Color.white);
        f.setVisible(true); // set visible should always be at last

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String out = text.getText(); // right.add function can't take string we have to make panel for that

            JPanel p1 = formatLabel(out);


            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p1, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(7));
            a1.add(vertical, BorderLayout.PAGE_START);
            dout.writeUTF(out);
            text.setText("");
            f.repaint();
            f.invalidate();
            f.validate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style style =\"width: 150px\">" +out+ "</p></html>");
        panel.add(output);
        output.setFont(new Font("Tohoma",Font.PLAIN,16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;

    }


    public static void main(String[] args) {
        new Client();

        try{
            Socket s = new Socket("127.0.0.1",6001);
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while(true) {
                a1.setLayout(new BorderLayout());
                String msg = din.readUTF();
                JPanel panel = formatLabel(msg);

                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));
                a1.add(vertical, BorderLayout.PAGE_START );
                f.validate();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
