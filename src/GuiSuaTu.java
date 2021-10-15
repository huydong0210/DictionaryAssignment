import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSuaTu extends JFrame {
    Container container;

    JTextField txtTiengAnh,txtTiengViet;

    JButton btnTroVe,btnSua;

    Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
    Font titleFont=new Font("arial",Font.BOLD,30);
    Font fontInText=new Font("arial",Font.ITALIC,16);

    public GuiSuaTu(){
        super("Sửa Từ");
        addControls();
        addEvents();
    }

    public void addControls(){
        JPanel pnSuatu=pnSuaTu();
        container=getContentPane();
        container.add(pnSuatu);

    }

    public JPanel pnSuaTu(){

        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle=new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle=new JLabel("Sửa Từ");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);
        pnMain.add(pnTitle);

        JPanel pnTiengAnh=new JPanel();
        pnTiengAnh.setLayout(new FlowLayout());
        JLabel lblTiengAnh= new JLabel("Từ tiếng Anh :");
        lblTiengAnh.setFont(generalFont);
        txtTiengAnh=new JTextField(20);
        pnTiengAnh.add(lblTiengAnh);
        pnTiengAnh.add(txtTiengAnh);
        pnMain.add(pnTiengAnh);

        JPanel pnTiengViet=new JPanel();
        pnTiengViet.setLayout(new FlowLayout());
        JLabel lblTiengViet=new JLabel("Nghĩa tiếng Việt :");
        lblTiengViet.setFont(generalFont);
        txtTiengViet=new JTextField(20);
        pnTiengViet.add(lblTiengViet);
        pnTiengViet.add(txtTiengViet);
        pnMain.add(pnTiengViet);

        JPanel pnSua=new JPanel();
        pnSua.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnSua=new JButton("Sửa");
        btnSua.setFont(generalFont);
        pnSua.add(btnSua);
        pnMain.add(pnSua);

        JPanel pnTroVe=new JPanel();
        pnTroVe.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnTroVe=new JButton("Trở về");
        btnTroVe.setFont(generalFont);
        pnTroVe.add(btnTroVe);
        pnMain.add(pnTroVe);
        lblTiengAnh.setPreferredSize(lblTiengViet.getPreferredSize());
        return pnMain;
    }
    public void addEvents(){
        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTroVeTuSuaTuVeManHinhChinh();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangSuaTuTiengAnh();
            }
        });

    }

    private void xuLyChucNangSuaTuTiengAnh() {
        String tiengAnh=txtTiengAnh.getText().toLowerCase();
        String tiengViet=txtTiengViet.getText().toLowerCase();
        if (tiengAnh.equals("") && tiengViet.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Nhập từ tiếng Anh cần sửa và nghĩa tiếng Việt mới");
        }
        if (tiengAnh.equals("")==false && tiengViet.equals("")){
            JOptionPane.showMessageDialog(null,"Nhập nghĩa của từ tiếng Anh cần sửa");
        }
        if (tiengAnh.equals("") && tiengViet.equals("")==false)
        {
            JOptionPane.showMessageDialog(null,"Nhập từ tiếng Anh cần sửa");
        }
        if (tiengAnh.equals("")==false && tiengAnh.equals("")==false )
        {
            if (Dictionary.word.containsKey(tiengAnh)==false)
            {
                JOptionPane.showMessageDialog(null,"Không tìm thấy từ cần sửa");
            }
            else
            {
                DictionaryManagement.repairWordInDictionary(tiengAnh,tiengViet);
                DictionaryManagement.dictionaryExportToFile();
                JOptionPane.showMessageDialog(null,"Sửa Thành công");
            }
        }
    }

    private void xuLyTroVeTuSuaTuVeManHinhChinh() {
        this.dispose();
        Gui gui=new Gui();
        gui.showWindow();
    }

    public void showWindow(){
        this.setSize(600,600);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }

}
