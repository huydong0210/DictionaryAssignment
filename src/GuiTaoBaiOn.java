import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GuiTaoBaiOn extends JFrame {

    JTextArea txtAreaTiengAnh;

    JList listTiengAnh, listTuTrongBaiOn;

    JTextArea txtAreaNghia;

    JButton btnXoa, btnTraCuu, btnTaoBaiOn, btnBack, btnThemTu;

    Vector<String> listTuMuonThem = new Vector<String>();

    Font generalFont = new Font("arial", Font.TYPE1_FONT, 20);
    Font titleFont = new Font("arial", Font.BOLD, 30);
    Font fontInText = new Font("arial", Font.ITALIC, 16);

    public GuiTaoBaiOn() {
        super("Ôn Tập");
        addControls();
        addEvents();

    }

    public void addControls() {
        Container container = getContentPane();
        container.add(pnMain());

    }

    public JPanel pnMain() {
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));


        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Tạo Bài Ôn");
        lblTitle.setFont(titleFont);
        pnTitle.add(lblTitle);


        JPanel pnTraTuu = new JPanel();
        pnTraTuu.setLayout(new FlowLayout());

        JPanel pnLeft = new JPanel();
        JPanel pnRight = new JPanel();
        JPanel pnMid = new JPanel();


        JPanel pnEnglish = new JPanel();
        pnEnglish.setLayout(new BoxLayout(pnEnglish, BoxLayout.Y_AXIS));
        txtAreaTiengAnh = new JTextArea();
        txtAreaTiengAnh.setFont(fontInText);
        txtAreaTiengAnh.setWrapStyleWord(true);
        txtAreaTiengAnh.setLineWrap(true);
        listTiengAnh = new JList();
        listTiengAnh.setFont(fontInText);
        JScrollPane scListTiengAnh = new JScrollPane(listTiengAnh, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnEnglish.add(txtAreaTiengAnh);
        pnEnglish.add(scListTiengAnh);

        JPanel pnVietnamese = new JPanel();
        pnVietnamese.setLayout(new BoxLayout(pnVietnamese, BoxLayout.Y_AXIS));
        txtAreaNghia = new JTextArea();
        txtAreaNghia.setFont(fontInText);
        txtAreaNghia.setWrapStyleWord(true);
        txtAreaNghia.setLineWrap(true);
        listTuTrongBaiOn = new JList();
        listTuTrongBaiOn.setFont(fontInText);
        JScrollPane scListTuTrongBaiOn = new JScrollPane(listTuTrongBaiOn, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnVietnamese.add(txtAreaNghia);
        pnVietnamese.add(scListTuTrongBaiOn);


        JPanel pnBtnChucNangTraXoa = new JPanel();
        pnBtnChucNangTraXoa.setLayout(new FlowLayout());
        btnTraCuu = new JButton("Tra Cứu");
        btnTraCuu.setFont(generalFont);
        btnXoa = new JButton("Xóa từ");
        btnXoa.setFont(generalFont);
        btnThemTu = new JButton("Thêm từ");
        btnThemTu.setFont(generalFont);

        pnBtnChucNangTraXoa.add(btnTraCuu);
        pnBtnChucNangTraXoa.add(btnThemTu);
        pnBtnChucNangTraXoa.add(btnXoa);


        JPanel pnBtnTaoBaiOn = new JPanel();
        pnBtnTaoBaiOn.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnTaoBaiOn = new JButton("Tạo bài ôn");
        btnTaoBaiOn.setFont(generalFont);
        pnBtnTaoBaiOn.add(btnTaoBaiOn);


        JPanel pnBtnBack = new JPanel();
        pnBtnBack.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnBack = new JButton("Back");
        btnBack.setFont(generalFont);
        pnBtnBack.add(btnBack);


        pnMain.add(pnTitle);
        pnTitle.setPreferredSize(new Dimension(800, 100));

        pnTraTuu.add(pnLeft);
        pnLeft.setPreferredSize(new Dimension(10, 550));

        pnTraTuu.add(pnEnglish);
        pnEnglish.setPreferredSize(new Dimension(370, 550));
        txtAreaTiengAnh.setPreferredSize(new Dimension(370, 100));
        scListTiengAnh.setPreferredSize(new Dimension(370, 450));

        pnTraTuu.add(pnMid);
        pnMid.setPreferredSize(new Dimension(10, 550));

        pnTraTuu.add(pnVietnamese);
        pnVietnamese.setPreferredSize(new Dimension(370, 550));
        txtAreaNghia.setPreferredSize(txtAreaTiengAnh.getPreferredSize());
        scListTuTrongBaiOn.setPreferredSize(scListTiengAnh.getPreferredSize());

        pnTraTuu.add(pnRight);
        pnRight.setPreferredSize(new Dimension(10, 550));

        pnMain.add(pnTraTuu);
        pnTraTuu.setPreferredSize(new Dimension(800, 550));


        pnMain.add(pnBtnChucNangTraXoa);
        pnBtnChucNangTraXoa.setPreferredSize(new Dimension(800, 50));

        pnMain.add(pnBtnTaoBaiOn);
        pnBtnTaoBaiOn.setPreferredSize(new Dimension(800, 50));

        pnMain.add(pnBtnBack);
        pnBtnBack.setPreferredSize(new Dimension(800, 50));


        return pnMain;
    }

    public void addEvents() {
        btnTraCuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTraCuu();
            }
        });
        listTiengAnh.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                xuLyChonListTiengAnh();
            }
        });
        btnThemTu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangThemTu();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangXoaTu();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChucNangTroVe();
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
        if (listTuMuonThem.size() == 0)
            JOptionPane.showMessageDialog(null, "Cần thêm ít nhất 2 từ để tạo bài ôn");
        else {
            GuiCanhBaoTaoBaiOn guiCanhBaoTaoBaiOn = new GuiCanhBaoTaoBaiOn(listTuMuonThem);
            guiCanhBaoTaoBaiOn.showWindow();
        }
    }

    private void xuLyChucNangTroVe() {
        this.dispose();
        Gui gui = new Gui();
        gui.showWindow();
    }

    private void xuLyChucNangXoaTu() {
        listTuMuonThem.removeAll(listTuTrongBaiOn.getSelectedValuesList());
        listTuTrongBaiOn.setListData(listTuMuonThem);

    }

    private void xuLyChucNangThemTu() {
        listTuMuonThem.addAll(listTiengAnh.getSelectedValuesList());
        Vector<String> listPhu = new Vector<String>();
        for (int i = 0; i < listTuMuonThem.size(); i++)
            if (listPhu.contains(listTuMuonThem.get(i)) == false)
                listPhu.add(listTuMuonThem.get(i));
        listTuMuonThem = listPhu;

        listTuTrongBaiOn.setListData(listTuMuonThem);
    }

    private void xuLyChonListTiengAnh() {
        String english = (String) listTiengAnh.getSelectedValue();
        if (english != null) {
            Word word = DictionaryManagement.dictionaryLookUp(english).get(0);
            txtAreaNghia.setText(word.getDescription() + "\n" + word.getPronounce());
            txtAreaTiengAnh.setText(english);
        }
    }

    private void xuLyChucNangTraCuu() {
        String english = txtAreaTiengAnh.getText().toLowerCase();
        ArrayList<Word> words = DictionaryManagement.dictionaryLookUp(english);
        if (words.size() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy từ này trong từ điển");
        } else {
            Vector<String> vector = new Vector<String>();
            for (Word word : words) {
                vector.add(word.getWord());
            }
            listTiengAnh.setListData(vector);
            if (words.get(0).getWord().equals(english)) {
                txtAreaNghia.setText(words.get(0).getDescription() + "\n" + words.get(0).getPronounce());
            }

        }
    }

    public void showWindow() {
        this.setSize(800, 800);// set size
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// thêm chức năng thoát hoàn toàn khỏi chương trình vào nút đỏ
        this.setLocationRelativeTo(null);// để giao diện nằm chính giữa
        this.setResizable(false);// không cho phép thay đổi kích cỡ cửa sổ
        this.setVisible(true);// để giao diện hiện lên
        this.setResizable(false);
    }

}
