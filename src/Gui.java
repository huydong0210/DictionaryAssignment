
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    Border borderChung=BorderFactory.createLineBorder(Color.blue);

    Container con;

    JButton btnTraTuTiengAnh,btnThemTu,btnSuaTu,btnXoaTu,btnThoat,btnTraTuBangNgonNguKhac, btnOnTap,btnTaoBaiOn;

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
    public void setBackGround(){
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("Hinh\\background\\pencil.png")));
        setLayout(new FlowLayout());
    }
    public JPanel pnMaHinhChinh(){
        JPanel pnMain =new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pnTitle=new JPanel();
        pnTitle.setLayout(new FlowLayout());
        JLabel lblTitle=new JLabel("Từ Điển ");
        lblTitle.setForeground(Color.red);
        lblTitle.setIcon(new ImageIcon("Hinh\\icon\\dictionary.png"));
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
        TitledBorder titleTraCuu=new TitledBorder(borderChung,"Tra cứu");
        titleTraCuu.setTitleJustification(TitledBorder.CENTER);
        titleTraCuu.setTitleFont(generalFont);
        pnTraCuu.setLayout(new FlowLayout());
        btnTraTuTiengAnh=new JButton("Tra cứu tiếng Anh");
        btnTraTuTiengAnh.setIcon(new ImageIcon("Hinh\\icon\\tracuu.png"));
        btnTraTuTiengAnh.setFont(generalFont);
        btnTraTuBangNgonNguKhac=new JButton("API Google Translate");
        btnTraTuBangNgonNguKhac.setIcon(new ImageIcon("Hinh\\icon\\tracuungonngukhac.png"));
        btnTraTuBangNgonNguKhac.setFont(generalFont);
        pnTraCuu.add(btnTraTuTiengAnh);
        pnTraCuu.add(btnTraTuBangNgonNguKhac);
        //pnTraCuu.setBorder(titleTraCuu);
        pnMain.add(pnTraCuu);

        JPanel pnChinhSua=new JPanel();
        TitledBorder titleChinhSua=new TitledBorder(borderChung,"Chỉnh sửa");
        titleChinhSua.setTitleJustification(TitledBorder.CENTER);
        titleChinhSua.setTitleFont(generalFont);
        pnChinhSua.setLayout(new FlowLayout());
        btnSuaTu=new JButton("Sửa 1 từ");
        btnSuaTu.setIcon(new ImageIcon("Hinh\\icon\\repair.png"));
        btnSuaTu.setFont(generalFont);
        btnThemTu=new JButton("Thêm từ");
        btnThemTu.setIcon(new ImageIcon("Hinh\\icon\\themtu.png"));
        btnThemTu.setFont(generalFont);
        btnXoaTu=new JButton("Xóa từ");
        btnXoaTu.setIcon(new ImageIcon("Hinh\\icon\\delete.png"));
        btnXoaTu.setFont(generalFont);
        //pnChinhSua.setBorder(titleChinhSua);
        pnChinhSua.add(btnThemTu);
        pnChinhSua.add(btnSuaTu);
        pnChinhSua.add(btnXoaTu);
        pnMain.add(pnChinhSua);




        JPanel pnHocTap=new JPanel();
        pnHocTap.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnOnTap=new JButton("Ôn tập");
        btnOnTap.setFont(generalFont);
        btnTaoBaiOn=new JButton("Tạo bài ôn");
        btnTaoBaiOn.setFont(generalFont);
        pnHocTap.add(btnOnTap);
        pnHocTap.add(btnTaoBaiOn);
        pnMain.add(pnHocTap);



        JPanel pnBack =new JPanel();
        btnThoat=new JButton();
        btnThoat.setFont(generalFont);
        btnThoat.setIcon(new ImageIcon("Hinh\\icon\\exit.png"));
        pnBack.add(btnThoat);

        pnTitle.setPreferredSize(new Dimension(600,70));
        pnTitle.setBackground(Color.GREEN);
        pnNote.setPreferredSize(new Dimension(600,50));
        pnNote.setBackground(Color.GREEN);
        pnTraCuu.setPreferredSize(new Dimension(600,90));
        pnTraCuu.setBackground(Color.GREEN);
        pnChinhSua.setPreferredSize(new Dimension(600,90));
        pnChinhSua.setBackground(Color.GREEN);
        pnHocTap.setPreferredSize(new Dimension(600,50));
        pnHocTap.setBackground(Color.GREEN);
        pnBack.setPreferredSize(new Dimension(600,100));
        pnBack.setBackground(Color.GREEN);


        pnMain.add(pnBack);


        return pnMain;
    }
    public void addEvents(){

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
        btnTraTuBangNgonNguKhac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhAPITuManHinhChinh();
            }
        });
        btnOnTap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChuyenVaoManHinhOnTap();
            }
        });
        btnTaoBaiOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTaoBaiOn();
            }
        });
    }

    private void xuLyChucNangTaoBaiOn() {
        this.dispose();
        GuiTaoBaiOn guiTaoBaiOn=new GuiTaoBaiOn();
        guiTaoBaiOn.showWindow();
    }

    private void xuLyChuyenVaoManHinhOnTap() {
        this.dispose();
        GuiOnBai guiOnTap=new GuiOnBai();
        guiOnTap.showWindow();
    }

    private void xuLyChuyenVaoManHinhAPITuManHinhChinh() {
        this.dispose();
        GuiTraCuuNgonNguKhac guiTraCuuNgonNguKhac=new GuiTraCuuNgonNguKhac();
        guiTraCuuNgonNguKhac.showWindow();
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
    public void showWindow(){

        this.setSize(600,450);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);

    }

}
