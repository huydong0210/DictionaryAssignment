import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GuiSmartCard extends JFrame {

    JButton btnSmartCard,btnBack,btnNext,btnTroVe,btnPhatAm;
    HashMap<String,String> danhSachTu;
    Vector<String> englishList;
    String tenBaiOn;
    String english,vietnamese;
    int count=0;
    JTextArea txtAreaContent;

    Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
    Font titleFont=new Font("arial",Font.BOLD,30);
    Font fontInText=new Font("arial",Font.ITALIC,16);

    public GuiSmartCard(String tenBaiOn){
        super("Smart Card");
        this.tenBaiOn=tenBaiOn;
        addControls();
        addEvents();
    }
    public void addControls(){
        danhSachTu=OnTap.layDanhSachTu(tenBaiOn);
        Collection<String> x=danhSachTu.keySet();
        englishList=new Vector<String>();
        for (String a :x)
        {

            englishList.add(a);
        }
        ranDom();
        english=englishList.get(count);
        vietnamese=danhSachTu.get(english);
        Container container=getContentPane();
        container.add(pnMain());


    }
    public JPanel pnMain(){
        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnButtonSmartCard=new JPanel();
        pnButtonSmartCard.setLayout(new FlowLayout());


        JPanel pnEast=new JPanel();
        pnEast.setPreferredSize(new Dimension(50,250));
        pnEast.setBackground(Color.white);
        JPanel pnWest=new JPanel();
        pnWest.setPreferredSize(new Dimension(50,250));
        pnWest.setBackground(Color.white);
        JPanel pnNoth=new JPanel();
        pnNoth.setPreferredSize(new Dimension(400,100));
        pnNoth.setBackground(Color.white);
        JPanel pnSouth=new JPanel();
        pnSouth.setPreferredSize(new Dimension(400,50));
        pnSouth.setBackground(Color.white);



        btnSmartCard=new JButton();
        btnSmartCard.setPreferredSize(new Dimension(500,500));
        btnSmartCard.setLayout(new BorderLayout());

        JPanel pnTrongButton=new JPanel();

        pnTrongButton.setPreferredSize(new Dimension(300,250));
        pnTrongButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnTrongButton.setBackground(Color.white);
        txtAreaContent=new JTextArea();
        txtAreaContent.setText(english);
        txtAreaContent.setFont(titleFont);
        txtAreaContent.setWrapStyleWord(true);
        txtAreaContent.setLineWrap(true);
        txtAreaContent.setPreferredSize(new Dimension(300,160));


        pnTrongButton.add(txtAreaContent);
        btnSmartCard.add(pnTrongButton,BorderLayout.CENTER);
        btnSmartCard.add(pnNoth,BorderLayout.NORTH);
        btnSmartCard.add(pnEast,BorderLayout.EAST);
        btnSmartCard.add(pnSouth,BorderLayout.SOUTH);
        btnSmartCard.add(pnWest,BorderLayout.WEST);
        pnButtonSmartCard.add(btnSmartCard);


        JPanel pnChucNang=new JPanel();
        pnChucNang.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnNext=new JButton("Next");
        btnNext.setFont(generalFont);
        btnBack=new JButton("Back");
        btnBack.setFont(generalFont);
        pnChucNang.add(btnBack);
        pnChucNang.add(btnNext);

        JPanel pnPhatAm=new JPanel();
        pnPhatAm.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPhatAm=new JButton();
        btnPhatAm.setIcon(new ImageIcon("Hinh\\icon\\speaker.png"));
        pnPhatAm.add(btnPhatAm);

        JPanel pnTroVe=new JPanel();
        pnTroVe.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnTroVe=new JButton();
        btnTroVe.setIcon(new ImageIcon("Hinh\\icon\\back.png"));
        pnTroVe.add(btnTroVe);


        pnMain.add(pnButtonSmartCard);
        pnMain.add(pnChucNang);
        pnMain.add(pnPhatAm);
        pnMain.add(pnTroVe);
        return pnMain;
    }
    public void addEvents(){
        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTroVe();
            }
        });
        btnSmartCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyKhiBamButton();
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyNutNext();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyNutBack();
            }
        });
        btnPhatAm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyPhatAm();
            }
        });
    }
    public void ranDom(){
        Vector<String> phu1=englishList;
        Vector<String> result=new Vector<String>();
        Random random=new Random();
        while (phu1.size()!=0)
        {
            String a=phu1.get(random.nextInt(phu1.size()));
            result.add(a);
            phu1.remove(a);
        }
        englishList=result;
    }
    private void xuLyPhatAm() {
        Pronounce.read(english);
    }

    private void xuLyChucNangTroVe() {
        this.dispose();
        GuiOnBai gui=new GuiOnBai();
        gui.showWindow();
    }

    public void xuLyNutNext(){
        if (count==englishList.size()-1)
            count=0;
        else
            count++;
        english=englishList.get(count);
        vietnamese=danhSachTu.get(english);
        txtAreaContent.setText(english);
    }
    public void xuLyNutBack(){
        if (count==0)
            count=englishList.size()-1;
        else
            count--;
        english=englishList.get(count);
        vietnamese=danhSachTu.get(english);
        txtAreaContent.setText(english);
    }
    private void xuLyKhiBamButton() {
        if (txtAreaContent.getText().equals(english))
            txtAreaContent.setText(vietnamese);
        else
            txtAreaContent.setText(english);
    }

    public void showWindow(){
        this.setSize(650,700);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }
}
