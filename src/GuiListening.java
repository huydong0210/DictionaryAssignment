import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GuiListening extends JFrame {

    JButton btnPhatAm,btnNext,btnBack;

    JRadioButton rad1,rad2,rad3,rad4;

    ButtonGroup groupDapAn;

    ArrayList<String> englishList;

    ArrayList<String> chuaSuDungLamDapAn=new ArrayList<String>();

    int diem=0;

    String dapAn;

    int count;
    int dapAnDung;

    String tenBai;

    JLabel lblKetQua;

    Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
    Font titleFont=new Font("arial",Font.BOLD,30);
    Font fontInText=new Font("arial",Font.ITALIC,16);

    public GuiListening(String tenBai){
        super("Listening");
        this.tenBai=tenBai;
        addControls();
        addEvents();
    }
    public void addControls(){
        Container container=getContentPane();
        englishList=new ArrayList<String>();
        englishList.addAll((Collection<String>) OnTap.layDanhSachTu(tenBai).keySet());
        chuaSuDungLamDapAn.addAll(englishList);
        count=englishList.size();
        container.add(pnMain());
    }

    public JPanel pnMain(){
        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnPhatAm=new JPanel();
        pnPhatAm.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPhatAm=new JButton();
        btnPhatAm.setIcon(new ImageIcon("Hinh\\icon\\speaker.png"));
        pnPhatAm.add(btnPhatAm);


        JPanel pnDapAn=new JPanel();
        pnDapAn.setLayout(new BoxLayout(pnDapAn,BoxLayout.Y_AXIS));
        rad1=new JRadioButton();
        rad1.setFont(generalFont);
        rad2=new JRadioButton();
        rad2.setFont(generalFont);
        rad3=new JRadioButton();
        rad3.setFont(generalFont);
        rad4=new JRadioButton();
        rad4.setFont(generalFont);
        groupDapAn=new ButtonGroup();
        groupDapAn.add(rad1);
        groupDapAn.add(rad2);
        groupDapAn.add(rad3);
        groupDapAn.add(rad4);
        pnDapAn.add(rad1);
        pnDapAn.add(rad2);
        pnDapAn.add(rad3);
        pnDapAn.add(rad4);

        JPanel pnKetQua=new JPanel();
        pnKetQua.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lblKetQua=new JLabel(diem+"/"+englishList.size());
        lblKetQua.setFont(generalFont);
        pnKetQua.add(lblKetQua);


        JPanel pnNext=new JPanel();
        pnNext.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnNext=new JButton("Next");
        btnNext.setFont(generalFont);
        pnNext.add(btnNext);

        JPanel pnBack=new JPanel();
        pnBack.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnBack=new JButton();
        btnBack.setIcon(new ImageIcon("Hinh\\icon\\back.png"));
        pnBack.add(btnBack);

        thietLapCauHoi();

        pnMain.add(pnPhatAm);
        pnMain.add(pnDapAn);
        pnMain.add(pnKetQua);
        pnMain.add(pnNext);
        pnMain.add(pnBack);


        return pnMain;
    }
    public void addEvents(){
        btnPhatAm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangPhatAm();
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangNext();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTroVe();
            }
        });
    }

    private void xuLyChucNangTroVe() {
        this.dispose();
        GuiOnBai guiOnBai=new GuiOnBai();
        guiOnBai.showWindow();
    }

    private void xuLyChucNangPhatAm() {
        Pronounce.read(dapAn);
    }

    private void xuLyChucNangNext() {
        if ((dapAnDung==1 && rad1.isSelected()) || (dapAnDung==2 && rad2.isSelected()) || (dapAnDung==3 && rad3.isSelected())
            || (dapAnDung==4 && rad4.isSelected()))
        {
           // lblKetQua.setText("Đúng");
            diem++;
        }
//        else
//            lblKetQua.setText("Sai");
        if (chuaSuDungLamDapAn.size()==0) {
            JOptionPane.showMessageDialog(null, "điểm số : "+diem+"/"+englishList.size());
            this.dispose();
            GuiOnBai gui=new GuiOnBai();
            gui.showWindow();
        }
        else
        thietLapCauHoi();
    }

    public void thietLapCauHoi(){
        Random random=new Random();
        ArrayList<String> daLayLamCauHoi=new ArrayList<String>();
        ArrayList<String> chuaLayLamCauHoi=new ArrayList<String>();
        chuaLayLamCauHoi.addAll(englishList);
        int index;
        lblKetQua.setText(diem+"/"+englishList.size());
        //Tạo đáp án:
        index=random.nextInt(chuaSuDungLamDapAn.size());
        dapAn=chuaSuDungLamDapAn.get(index);
        chuaSuDungLamDapAn.remove(index);

        System.out.println(chuaLayLamCauHoi);

        daLayLamCauHoi.add(dapAn);
        chuaLayLamCauHoi.remove(dapAn);

        index=random.nextInt(chuaLayLamCauHoi.size());
        daLayLamCauHoi.add(chuaLayLamCauHoi.get(index));
        chuaLayLamCauHoi.remove(index);

        index=random.nextInt(chuaLayLamCauHoi.size());
        daLayLamCauHoi.add(chuaLayLamCauHoi.get(index));
        chuaLayLamCauHoi.remove(index);

        index=random.nextInt(chuaLayLamCauHoi.size());
        daLayLamCauHoi.add(chuaLayLamCauHoi.get(index));
        chuaLayLamCauHoi.remove(index);

        index=random.nextInt(daLayLamCauHoi.size());
        if (daLayLamCauHoi.get(index)==dapAn)
            dapAnDung=1;
        rad1.setText(daLayLamCauHoi.get(index));
        daLayLamCauHoi.remove(index);

        index=random.nextInt(daLayLamCauHoi.size());
        if (daLayLamCauHoi.get(index)==dapAn)
            dapAnDung=2;
        rad2.setText(daLayLamCauHoi.get(index));
        daLayLamCauHoi.remove(index);

        index=random.nextInt(daLayLamCauHoi.size());
        if (daLayLamCauHoi.get(index)==dapAn)
            dapAnDung=3;
        rad3.setText(daLayLamCauHoi.get(index));
        daLayLamCauHoi.remove(index);

        index=random.nextInt(daLayLamCauHoi.size());
        if (daLayLamCauHoi.get(index)==dapAn)
            dapAnDung=4;
        rad4.setText(daLayLamCauHoi.get(index));
        daLayLamCauHoi.remove(index);

    }
    public void ranDom(){
        ArrayList<String> phu1=englishList;
        ArrayList<String> result=new ArrayList<String>();
        Random random=new Random();
        while (phu1.size()!=0)
        {
            String a=phu1.get(random.nextInt(phu1.size()));
            result.add(a);
            phu1.remove(a);
        }
        englishList=result;
    }
    public void showWindow(){
        this.setSize(400,350);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }
}
