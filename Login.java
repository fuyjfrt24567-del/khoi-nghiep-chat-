import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {

    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin;

    public Login() {

        setTitle("Đăng nhập");
        setSize(300,200);
        setLayout(null);

        JLabel lbUser = new JLabel("Tên đăng nhập");
        lbUser.setBounds(20,20,100,25);

        txtUser = new JTextField();
        txtUser.setBounds(130,20,120,25);

        JLabel lbPass = new JLabel("Mật khẩu");
        lbPass.setBounds(20,60,100,25);

        txtPass = new JPasswordField();
        txtPass.setBounds(130,60,120,25);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(90,110,120,30);

        add(lbUser);
        add(txtUser);
        add(lbPass);
        add(txtPass);
        add(btnLogin);

        btnLogin.addActionListener(e -> {

            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            try {
System.out.println("BAT DAU KET NOI");
System.out.println("KET NOI THANH CONG");
                Connection con = DBConnection.getConnection();

                String sql =
                        "SELECT * FROM TaiKhoan WHERE TenDangNhap=? AND MatKhau=?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, user);
                ps.setString(2, pass);
                System.out.println("User = [" + user + "]");
System.out.println("Pass = [" + pass + "]");
System.out.println("SQL = " + sql);

                ResultSet rs = ps.executeQuery();

boolean found = rs.next();

System.out.println("TIM THAY = " + found);

if(found) {

    JOptionPane.showMessageDialog(null,
            "Đăng nhập thành công");

    dispose();

    new Client();

} else {

    JOptionPane.showMessageDialog(null,
            "Sai tài khoản hoặc mật khẩu");

}

                con.close();

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(null,
                        ex.getMessage());
            }

        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}