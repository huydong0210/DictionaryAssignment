
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiXoaTu extends JFrame {
    Container container;

    JButton btnXoa, btnTroVe;
    JTextField txtTiengAnh;
    Font generalFont = new Font("arial", Font.TYPE1_FONT, 20);
    Font titleFont = new Font("arial", Font.BOLD, 30);
    Font fontInText = new Font("arial", Font.ITALIC, 16);

    public GuiXoaTu() {
        super("Xóa Từ");
        addControls();
        addEvents();

    }

    public void addControls() {
        container = getContentPane();
        JPanel pnXoaTu = pnXoaTu();
        container.add(pnXoaTu);
    }

    public JPanel pnXoaTu() {
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Xoá Từ");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);
        pnMain.add(pnTitle);

        JPanel pnTiengAnh = new JPanel();
        pnTiengAnh.setLayout(new FlowLayout());
        JLabel lblTiengAnh = new JLabel("Từ tiếng Anh cần xóa:");
        lblTiengAnh.setFont(generalFont);
        txtTiengAnh = new JTextField(20);
        txtTiengAnh.setFont(fontInText);
        pnTiengAnh.add(lblTiengAnh);
        pnTiengAnh.add(txtTiengAnh);
        pnMain.add(pnTiengAnh);

        JPanel pnSua = new JPanel();
        pnSua.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnXoa = new JButton("Xóa");
        btnXoa.setFont(generalFont);
        pnSua.add(btnXoa);
        pnMain.add(pnSua);

        JPanel pnTroVe = new JPanel();
        pnTroVe.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnTroVe = new JButton();
        btnTroVe.setIcon(new ImageIcon("Hinh\\icon\\back.png"));
        btnTroVe.setFont(generalFont);
        pnTroVe.add(btnTroVe);
        pnMain.add(pnTroVe);

        return pnMain;
    }

    public void addEvents() {
        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTroVeManHinhChinhTuXoaTu();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLychucNangXoa();
            }
        });
    }

    private void xuLychucNangXoa() {
        String english = txtTiengAnh.getText();
        if (english.equals("")) {
            JOptionPane.showMessageDialog(null, "Hãy nhập từ bạn cần xóa!");
        } else {
            ArrayList<Word> words = DictionaryManagement.dictionaryLookUp(english);
            if (words.size() == 0)
                JOptionPane.showMessageDialog(null, "Không tìm thấy từ này trong từ điển");
            else {
                Word word = new Word();
                word.setWord(english);
                GuiCanhBaoXoaTu guiCanhBaoXoaTu = new GuiCanhBaoXoaTu(word);
                guiCanhBaoXoaTu.showWindow();
            }
        }
    }

    private void xuLyTroVeManHinhChinhTuXoaTu() {
        this.dispose();
        Gui gui = new Gui();
        gui.showWindow();
    }

    public void showWinDow() {
        this.setSize(350, 300);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }

}
