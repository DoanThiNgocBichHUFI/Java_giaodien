private void file_Open_menuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        JFileChooser fchooser= new JFileChooser();
        int result= fchooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            try{
                edPage.setPage("file:///"+ fchooser.getSelectedFile().getPath());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }                                                  

    private void file_New_menuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        edPage.setText("");
    }                                                 

    private void file_Save_menuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        JFileChooser fChooser= new JFileChooser();
        int result= fChooser.showSaveDialog(null);
        if(result== JFileChooser.APPROVE_OPTION){
            File fname= fChooser.getSelectedFile();
            try{
                PrintWriter pw= new PrintWriter(fname);
                pw.println(edPage.getText());
                pw.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }                                                  

    private void mnColorTextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Color c= JColorChooser.showDialog(null, "chọn màu chữ", Color.yellow);
        txtColor.setForeground(c);
    }                                           

    private void mnBlueActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        Color c=  Color.BLUE;
        txtColor.setBackground(c);
    }                                      

    private void mn_AboutActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        showSoftwareInfo();
    }                                        

    private void mn_exitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        System.exit(0);
    }                                       
 private void showSoftwareInfo() {
        String softwareInfo = "Tên phần mềm: Tên của bạn\n"
                            + "Phiên bản: 1.0\n"
                            + "Tác giả: Tên tác giả";
        javax.swing.JOptionPane.showMessageDialog(this, softwareInfo, "Thông tin phần mềm", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
