import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    Container con;

    JButton btnTraTuTiengAnh,btnTraTuTiengViet,btnThemTu,btnSuaTu,btnXoaTu,btnThoat;

    JPanel pnManHinhChinh= pnMaHinhChinh();

    Font generalFont=new Font("arial",Font.TYPE1_FONT,20);
    Font titleFont=new Font("arial",Font.BOLD,30);
    Font fontInText=new Font("arial",Font.ITALIC,16);


    public Gui(){
        super("Từ điển");// tiêu đề.
        addControls();
        addEvents();
    }
    public void addControls(){
        //lấy lớp chứa cửa số ra
        con=getContentPane();
        pnManHinhChinh=pnMaHinhChinh();
        con.add(pnManHinhChinh);
    }
    public JPanel pnMaHinhChinh(){
        JPanel pnMain =new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle=new JPanel();
        pnTitle.setLayout(new FlowLayout());
        JLabel lblTitle=new JLabel("Từ Điển ");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);
        pnMain.add(pnTitle);

        JPanel pnNote=new JPanel();
        pnNote.setLayout(new FlowLayout());
        JLabel lblNote= new JLabel("Phát triển bởi : Bùi Huy Đông - K65 - Đại Học Công nghệ");
        lblNote.setFont(new Font("arial",Font.ITALIC,20));
        pnNote.add(lblNote);
        pnMain.add(pnNote);

        JPanel pnTraCuu=new JPanel();
        pnTraCuu.setLayout(new FlowLayout());
        JLabel lblTraCuu=new JLabel("Tra Cứu : ");
        btnTraTuTiengAnh=new JButton("Tra cứu từ tiếng Anh");
        btnTraTuTiengViet=new JButton("Tra cứu từ tiếng Việt");
        lblTraCuu.setFont(generalFont);
        btnTraTuTiengAnh.setFont(generalFont);
        btnTraTuTiengViet.setFont(generalFont);
        pnTraCuu.add(lblTraCuu);
        pnTraCuu.add(btnTraTuTiengViet);
        pnTraCuu.add(btnTraTuTiengAnh);
        pnMain.add(pnTraCuu);

        JPanel pnChinhSua=new JPanel();
        pnChinhSua.setLayout(new FlowLayout());
        JLabel lblChinhSua= new JLabel("Chỉnh sửa :");
        lblChinhSua.setFont(generalFont);
        btnSuaTu=new JButton("Sửa 1 từ");
        btnSuaTu.setFont(generalFont);
        btnThemTu=new JButton("Thêm từ");
        btnThemTu.setFont(generalFont);
        btnXoaTu=new JButton("Xóa từ");
        btnXoaTu.setFont(generalFont);
        pnChinhSua.add(lblChinhSua);
        pnChinhSua.add(btnThemTu);
        pnChinhSua.add(btnSuaTu);
        pnChinhSua.add(btnXoaTu);
        pnMain.add(pnChinhSua);

        JPanel pnBack =new JPanel();
        btnThoat=new JButton("Thoát");
        btnThoat.setFont(generalFont);
        pnBack.add(btnThoat);
        pnMain.add(pnBack);

        return pnMain;
        //   lblTraCuu.setPreferredSize(lblChinhSua.getPreferredSize()); //set dodoj rong

    }
    public void addEvents(){
        btnTraTuTiengViet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhTraTuTiengVietTuManHinhChinh();
            }
        });
        btnTraTuTiengAnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhTraTuTiengAnhTuManHinhChinh();
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangThoatKhoiChuongTrinh();
            }
        });

        btnThemTu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhThemTuTuManHinhChinh();
            }
        });
        btnSuaTu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhSuaTuTuManHinhChinh();
            }
        });
        btnXoaTu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhXoaTuTuManHinhChinh();
            }
        });
    }

    private void xuLyChuyenVaoManHinhXoaTuTuManHinhChinh() {
        this.dispose();
        GuiXoaTu guiXoaTu=new GuiXoaTu();
        guiXoaTu.showWinDow();
    }

    private void xuLyChuyenVaoManHinhSuaTuTuManHinhChinh() {
        this.dispose();
        GuiSuaTu guiSuaTu=new GuiSuaTu();
        guiSuaTu.showWindow();
    }

    private void xuLyChuyenVaoManHinhThemTuTuManHinhChinh() {
        this.dispose();
        GuiThemTu guiThemTu=new GuiThemTu();
        guiThemTu.showWindow();
    }

    private void xuLyChucNangThoatKhoiChuongTrinh() {
        System.exit(0);
    }

    private void xuLyChuyenVaoManHinhTraTuTiengAnhTuManHinhChinh() {

        this.dispose();
        GuiTraCuuTuTiengAnh guiTraCuuTuTiengAnh=new GuiTraCuuTuTiengAnh();
        guiTraCuuTuTiengAnh.showWindow();
    }
    public void xuLyChuyenVaoManHinhTraTuTiengVietTuManHinhChinh(){
        this.dispose();
        GuiTraCuuTuTiengViet guiTraCuuTuTiengViet=new GuiTraCuuTuTiengViet();
        guiTraCuuTuTiengViet.showWindow();
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
