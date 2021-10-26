import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiOnBai extends JFrame {

    JComboBox<String> cbListBaiOn;

    JButton btnSmartCard,btnListening,btnBack;

    Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
    Font titleFont=new Font("arial",Font.BOLD,30);
    Font fontInText=new Font("arial",Font.ITALIC,16);

    public GuiOnBai(){
        super("Ôn Bài");
        addControls();
        addEvents();
    }
    public void addControls(){
        Container container=getContentPane();
        container.add(pnMain());
    }

    JPanel pnMain(){
        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle=new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle=new JLabel("Chọn bài ôn");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);



        JPanel pnChonBaiOn=new JPanel();
        pnChonBaiOn.setLayout(new FlowLayout(FlowLayout.CENTER));
        cbListBaiOn=new JComboBox<>();
        cbListBaiOn.setFont(generalFont);
        cbListBaiOn.setPreferredSize(new Dimension(280,40));
        ArrayList <String> danhSachBaiOn=OnTap.layDanhSachBaiOn();
        for (String x :danhSachBaiOn)
        {
            cbListBaiOn.addItem(x);
        }
        pnChonBaiOn.add(cbListBaiOn);


        JPanel pnButtonChucNang=new JPanel();
        pnButtonChucNang.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnSmartCard=new JButton("Smart Card");
        btnSmartCard.setFont(generalFont);
        btnListening=new JButton("Listening");
        btnListening.setFont(generalFont);
        pnButtonChucNang.add(btnSmartCard);
        pnButtonChucNang.add(btnListening);


        JPanel pnButtonBack=new JPanel();
        pnButtonBack.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnBack=new JButton();
        btnBack.setIcon(new ImageIcon("Hinh\\icon\\back.png"));
        pnButtonBack.add(btnBack);


        pnMain.add(pnTitle);
        pnMain.add(pnChonBaiOn);
        pnMain.add(pnButtonChucNang);
        pnMain.add(pnButtonBack);


        return pnMain;
    }
    public void addEvents(){
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangVeManHinhChinh();
            }
        });
        btnSmartCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangSmartCard();
            }
        });
        btnListening.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangListening();
            }
        });
    }

    private void xuLyChucNangListening() {
        this.dispose();
        GuiListening guiListening=new GuiListening((String) cbListBaiOn.getSelectedItem());
        guiListening.showWindow();
    }

    private void xuLyChucNangSmartCard() {
        this.dispose();
        String tenBai=(String) cbListBaiOn.getSelectedItem();
        GuiSmartCard guiSmartCard=new GuiSmartCard(tenBai);
        guiSmartCard.showWindow();
    }

    private void xuLyChucNangVeManHinhChinh() {
        this.dispose();
        Gui gui=new Gui();
        gui.showWindow();
    }

    public void showWindow(){
        this.setSize(300,300);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }

}
