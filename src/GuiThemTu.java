import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GuiThemTu extends JFrame {

    Container container;

    JTextField txtTiengAnh,txtTiengViet;

    JButton btnTroVe,btnThem;

    public GuiThemTu(){
        super("Thêm Từ");
        addControls();
        addEvents();
    }
    public void addControls(){
        container=getContentPane();
        JPanel pnThemTu=pnThemTu();
        container.add(pnThemTu);
    }

    public JPanel pnThemTu(){

        Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
        Font titleFont=new Font("arial",Font.BOLD,30);
        Font fontInText=new Font("arial",Font.ITALIC,16);

        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle=new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle=new JLabel("Thêm Từ");
        lblTitle.setFont(titleFont);
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

        JPanel pnThem=new JPanel();
        pnThem.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnThem=new JButton("Thêm");
        btnThem.setFont(generalFont);
        pnThem.add(btnThem);
        pnMain.add(pnThem);

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
                xuLyTroVeManHinhChinh();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangThemTu();            }
        });
    }

    private void xuLyChucNangThemTu() {
        String tiengAnh=txtTiengAnh.getText().toLowerCase();
        String tiengViet=txtTiengViet.getText().toLowerCase();
        if (tiengAnh.equals("") && tiengViet.equals(""))
        {
            JOptionPane.showMessageDialog(null," Hãy nhập từ tiếng anh và nghĩa tiếng việt của từ bạn cần thêm");
        }
        if (tiengAnh.equals("") && tiengViet.equals("")==false)
        {
            JOptionPane.showMessageDialog(null,"Hãy từ tiếng Anh của từ cần thêm");
        }
        if (tiengAnh.equals("")==false && tiengViet.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Hãy nhập nghĩa từ tiếng Anh cần thêm");
        }
        if (tiengAnh.equals("")==false && tiengViet.equals("")==false)
        {
            Word word=new Word();
            word.setWord_target(tiengAnh);
            word.setWord_explain(tiengViet);
            DictionaryManagement.insertWordToDictionary(word);
            JOptionPane.showMessageDialog(null,"Thêm thành công");
            DictionaryManagement.dictionaryExportToFile();
        }
    }

    private void xuLyTroVeManHinhChinh() {
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

    }
}
