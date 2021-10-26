import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

public class GuiCanhBaoTaoBaiOn extends JFrame {


    Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
    Font titleFont=new Font("arial",Font.BOLD,30);
    Font fontInText=new Font("arial",Font.ITALIC,16);

    JTextField txtTenBai;
    Vector<String> listTuMuonThem;
    HashMap<String,String> list;
    JButton btnChapNhan,btnHuy;

    public GuiCanhBaoTaoBaiOn(){
        super("Tạo bài ôn");
        addControls();
        addEvents();
    }
    public GuiCanhBaoTaoBaiOn(Vector<String> listTuMuonThem){
        super("Tạo bài ôn");
        this.listTuMuonThem=listTuMuonThem;
        list=xuLyListTu();
        addControls();
        addEvents();
    }
    public void addControls(){
        Container container=getContentPane();
        container.add(pnMain());
    }
    public JPanel pnMain(){
        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle=new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle=new JLabel("Đặt tên bài ôn :");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);

        JPanel pnTenBai=new JPanel();
        pnTenBai.setLayout(new FlowLayout(FlowLayout.CENTER));
        txtTenBai=new JTextField(20);
        txtTenBai.setFont(fontInText);
        pnTenBai.add(txtTenBai);


        JPanel pnButton=new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnChapNhan=new JButton("Chấp nhận");
        btnChapNhan.setFont(generalFont);
        btnHuy=new JButton("Hủy");
        btnHuy.setFont(generalFont);
        pnButton.add(btnChapNhan);
        pnButton.add(btnHuy);

        pnMain.add(pnTitle);
        pnMain.add(pnTenBai);
        pnMain.add(pnButton);


        return pnMain;
    }
    public void addEvents(){
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTroVe();
            }
        });
        btnChapNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangChapNhan();
            }
        });
    }

    private void xuLyChucNangChapNhan() {
        OnTap.taoBaiOn(list,txtTenBai.getText());
        this.dispose();
        JOptionPane.showMessageDialog(null,"Tạo bài thành công");

    }

    private void xuLyChucNangTroVe() {
        this.dispose();
    }
    public HashMap<String,String> xuLyListTu(){
        HashMap<String,String> list=new HashMap<String,String>();
        for (String key:listTuMuonThem)
        {
            list.put(key,DictionaryManagement.dictionaryLookUp(key).get(0).getDescription());
        }
        return list;
    }
    public void showWindow(){
        this.setSize(300,250);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }
}
