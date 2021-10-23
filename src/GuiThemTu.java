import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class GuiThemTu extends JFrame {

    Container container;

    JTextField txtTiengAnh, txtTiengViet,txtPhatAm;

    JButton btnTroVe, btnThem;

    public GuiThemTu() {
        super("Thêm Từ");
        addControls();
        addEvents();
    }

    public void addControls() {
        container = getContentPane();
        JPanel pnThemTu = pnThemTu();
        container.add(pnThemTu);
    }

    public JPanel pnThemTu() {

        Font generalFont = new Font("arial", Font.TYPE1_FONT, 20);
        Font titleFont = new Font("arial", Font.BOLD, 30);
        Font fontInText = new Font("arial", Font.ITALIC, 16);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Thêm Từ");
        lblTitle.setFont(titleFont);
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);
        pnMain.add(pnTitle);

        JPanel pnTiengAnh = new JPanel();
        pnTiengAnh.setLayout(new FlowLayout());
        JLabel lblTiengAnh = new JLabel("Từ tiếng Anh :");
        lblTiengAnh.setFont(generalFont);
        txtTiengAnh = new JTextField(20);
        txtTiengAnh.setFont(fontInText);
        pnTiengAnh.add(lblTiengAnh);
        pnTiengAnh.add(txtTiengAnh);
        pnMain.add(pnTiengAnh);

        JPanel pnTiengViet = new JPanel();
        pnTiengViet.setLayout(new FlowLayout());
        JLabel lblTiengViet = new JLabel("Nghĩa tiếng Việt :");
        lblTiengViet.setFont(generalFont);
        txtTiengViet = new JTextField(20);
        txtTiengViet.setFont(fontInText);
        pnTiengViet.add(lblTiengViet);
        pnTiengViet.add(txtTiengViet);
        pnMain.add(pnTiengViet);

        JPanel pnPhatAm=new JPanel();
        pnPhatAm.setLayout(new FlowLayout());
        JLabel lblPhatAm=new JLabel("Phát Âm:");
        lblPhatAm.setFont(generalFont);
        txtPhatAm=new JTextField(20);
        txtPhatAm.setFont(fontInText);
        pnPhatAm.add(lblPhatAm);
        pnPhatAm.add(txtPhatAm);
        pnMain.add(pnPhatAm);

        JPanel pnThem = new JPanel();
        pnThem.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnThem = new JButton("Thêm");
        btnThem.setFont(generalFont);
        pnThem.add(btnThem);
        pnMain.add(pnThem);

        JPanel pnTroVe = new JPanel();
        pnTroVe.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnTroVe = new JButton();
        btnTroVe.setIcon(new ImageIcon("Hinh\\icon\\back.png"));
        btnTroVe.setFont(generalFont);
        pnTroVe.add(btnTroVe);
        pnMain.add(pnTroVe);

        lblTiengAnh.setPreferredSize(lblTiengViet.getPreferredSize());
        lblPhatAm.setPreferredSize(lblTiengViet.getPreferredSize());

        return pnMain;
    }

    public void addEvents() {
        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTroVeManHinhChinh();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangThemTu();
            }
        });
    }

    private void xuLyChucNangThemTu() {
        String english = txtTiengAnh.getText();
        String vietnamese = txtTiengViet.getText();
        if (english.equals("") || vietnamese.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập từ tiếng anh và nghĩa từ cần thêm");
        } else {
            ArrayList<Word> words=DictionaryManagement.dictionaryLookUp(english);
            Boolean check=true;
            if (words.size()!=0)
            {
                if (words.get(0).getWord().equals(english))
                    check=false;
            }
            if (check==false)
            {
                JOptionPane.showMessageDialog(null,"Từ nãy đã tồn tại trong từ điển");
            }
            else {
                Word word=new Word();
                word.setWord(english);
                word.setDescription(vietnamese);
                GuiCanhBaoThemTu guiCanhBaoThemTu = new GuiCanhBaoThemTu(word);
                guiCanhBaoThemTu.showWindow();
            }
        }
    }

    private void xuLyTroVeManHinhChinh() {
        this.dispose();
        Gui gui = new Gui();
        gui.showWindow();

    }

    public void showWindow() {
        this.setSize(600, 400);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên

    }
}
