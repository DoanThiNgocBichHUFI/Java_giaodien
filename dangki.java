// import thư viện
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

void kiemtraRong(StringBuilder sb) {
        if (txt_name.getText().trim().isEmpty()) {
            sb.append("Tên không được để trống.\n");
        }
        // Tương tự cho các trường khác
    }
    void kiemtraNgay(StringBuilder sb) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(txt_birth.getText().trim());
        } catch (ParseException e) {
            sb.append("Ngày sinh không hợp lệ.\n");
        }
    }
    void kiemtraEmail(StringBuilder sb) {
        String email = txt_email.getText().trim();
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            sb.append("Email không hợp lệ.\n");
        }
    }
private void btn_dangkiActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
       StringBuilder sb= new StringBuilder();
       kiemtraRong(sb);
       kiemtraNgay(sb);
       kiemtraEmail(sb);
       if(sb.length() > 0){
           JOptionPane.showMessageDialog(this, sb.toString());return;
       }
       try{
           String Filepath= "C:\\\\Users\\\\84339\\\\OneDrive - Ho Chi Minh city University of Food Industry\\\\nam hoc 23-24\\\\HK 24\\\\cong nghe java\\\\lam o lop hoc\\\\tuan4\\\\src\\\\bai2_5\\\\bai2_5.txt";
           String dataWrite= "Name:"+txt_name.getText()+"\n";
           dataWrite += "Date of birth: "+txt_birth.getText() +"\n";
           dataWrite += "Email: "+txt_email.getText() + "\n";
           if(rdo_male.isSelected()){
               dataWrite += "Sex: male \n";
           } else if(rdo_female.isSelected()){
               dataWrite += "Sex: female \n";
           }
           dataWrite += "Provices: "+cbo_tinh.getSelectedItem().toString() +"\n";
           // sử dụng filewriter để mở tệp với chế độ ghi đè
           FileWriter f= new FileWriter(Filepath);
           // sử dụng bufferedWriter để cung cấp bộ đệm và hiệu suất tốt hơn
           BufferedWriter b= new BufferedWriter(f);
           // ghi dữ liệu vào tệp
           b.write(dataWrite);
           // đóng các luồng để giải phóng tài nguyên 
           b.close();f.close();
           System.out.println("dữ liệu đã ghi vào tệp thành công.");
       }catch(Exception e){
           e.printStackTrace();
       }
    }
