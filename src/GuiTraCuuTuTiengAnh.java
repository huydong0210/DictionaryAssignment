import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GuiTraCuuTuTiengAnh extends JFrame {

    JTextField txtTiengAnhCanTra,txtTiengVietNhanLai;

    JButton btnChucNangTraCuuTiengAnh,btnTroVeManHinhChinhTuTraCuuTiengAnh,btnPhatAm;

    Container con;

    JPanel pnTraCuuTuTiengAnh=pnTraCuuTuTiengAnh();


    public GuiTraCuuTuTiengAnh(){
        super("Từ Điển");
        addControls();
        addEvents();
    }
    public void addControls(){
        con=getContentPane();
        con.add(pnTraCuuTuTiengAnh);
    }

    public void addEvents(){
        btnTroVeManHinhChinhTuTraCuuTiengAnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTroVeManHinhChinhTuTraCuuTiengAnh();
            }
        });
        btnChucNangTraCuuTiengAnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTraCuuTuTiengAnh();
            }
        });
        btnPhatAm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangPhatAm();
            }
        });

    }

    private void xuLyChucNangPhatAm() {
        String tiengAnh=txtTiengAnhCanTra.getText().toLowerCase();
        Pronounce.read(tiengAnh);
    }

    private void xuLyChucNangTraCuuTuTiengAnh() {
        String tiengAnh=txtTiengAnhCanTra.getText().toLowerCase();
        if (Dictionary.word.containsKey(tiengAnh))
        {
            txtTiengVietNhanLai.setText(Dictionary.word.get(tiengAnh));
        }
        else
        {
            txtTiengVietNhanLai.setText("Không tìm thấy từ cần tra");
        }

    }

    private void xuLyTroVeManHinhChinhTuTraCuuTiengAnh() {
        this.dispose();
        Gui gui=new Gui();
        gui.showWindow();
    }

    public JPanel pnTraCuuTuTiengAnh(){

        Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
        Font titleFont=new Font("arial",Font.BOLD,30);
        Font fontInText=new Font("arial",Font.ITALIC,16);

        JPanel pnMain=new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle= new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle=new JLabel("Tra cứu từ tiếng Anh");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);
        pnMain.add(pnTitle);

        JPanel pnTiengAnh=new JPanel();
        pnTiengAnh.setLayout(new FlowLayout());
        JLabel lblTiengAnh=new JLabel("Tiếng Anh:");
        lblTiengAnh.setFont(generalFont);
        txtTiengAnhCanTra=new JTextField("Nhập từ tiếng Anh bạn cần tra",20);
        txtTiengAnhCanTra.setFont(fontInText);
        pnTiengAnh.add(lblTiengAnh);
        pnTiengAnh.add(txtTiengAnhCanTra);
        pnMain.add(pnTiengAnh);

        JPanel pnTiengViet=new JPanel();
        pnTiengViet.setLayout(new FlowLayout());
        JLabel lblTiengViet=new JLabel("Nghĩa tiếng Việt:");
        lblTiengViet.setFont(generalFont);
        txtTiengVietNhanLai=new JTextField(20);
        txtTiengVietNhanLai.setFont(fontInText);
        pnTiengViet.add(lblTiengViet);
        pnTiengViet.add(txtTiengVietNhanLai);
        pnMain.add(pnTiengViet);

        JPanel pnPhatAm=new JPanel();
        pnPhatAm.setLayout(new FlowLayout());
        btnPhatAm=new JButton("Phát Âm");
        btnPhatAm.setFont(generalFont);
        pnPhatAm.add(btnPhatAm);
        pnMain.add(pnPhatAm);

        JPanel pnTraCuu=new JPanel();
        pnTraCuu.setLayout(new FlowLayout());
        btnChucNangTraCuuTiengAnh=new JButton("Tra cứu");
        btnChucNangTraCuuTiengAnh.setFont(generalFont);
        pnTraCuu.add(btnChucNangTraCuuTiengAnh);
        pnMain.add(pnTraCuu);

        JPanel pnTroVe=new JPanel();
        pnTroVe.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnTroVeManHinhChinhTuTraCuuTiengAnh=new JButton("Trở về");
        btnTroVeManHinhChinhTuTraCuuTiengAnh.setFont(generalFont);
        pnTroVe.add(btnTroVeManHinhChinhTuTraCuuTiengAnh);
        pnMain.add(pnTroVe);

        lblTiengAnh.setPreferredSize(lblTiengViet.getPreferredSize());

        return pnMain;
    }

    public void showWindow(){
        this.setSize(600,600);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên

    }
}
