/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.OrganMatchWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Donor;
import Business.Person.Recipient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import userInterface.AdminWorkSpace.ManageCitiesJPanel;
import userInterface.AdminWorkSpace.OTAWorkArea;
/**
 *
 * @author Siddhi
 */
public class OrganMatchByRecipientJPanel extends javax.swing.JPanel {

    JPanel rightPanel;
    EcoSystem system;
    List<Recipient> recipientList;
    Donor donorEmail;
    Recipient recipientEmail;

    /**
     * Creates new form ManageOrganMatchJPanel
     */
    public OrganMatchByRecipientJPanel(JPanel rightPanel, EcoSystem system, List<Recipient> recipientList) {
        initComponents();
        this.rightPanel = rightPanel;
        this.system = system;
        this.recipientList = recipientList;
        populateRecipientTable();
        recipientInfoJTable.getTableHeader().setFont(new Font("Times New Roman", Font.ITALIC, 23));
        donorInfoJTable.getTableHeader().setFont(new Font("Times New Roman", Font.ITALIC, 23));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        recipientInfoJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        donorInfoJTable = new javax.swing.JTable();
        donorTblButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipientInfoJTable.setBackground(new java.awt.Color(255, 204, 204));
        recipientInfoJTable.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        recipientInfoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Recipient Name", "Network", "Organ", "Severity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recipientInfoJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 800, 170));

        donorInfoJTable.setBackground(new java.awt.Color(255, 204, 204));
        donorInfoJTable.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        donorInfoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Donor Name", "Network", "Current Organ Availabilty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(donorInfoJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 800, 170));

        donorTblButton.setBackground(new java.awt.Color(153, 204, 255));
        donorTblButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        donorTblButton.setText("Find Match");
        donorTblButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        donorTblButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donorTblButtonActionPerformed(evt);
            }
        });
        add(donorTblButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 260, -1));

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("Inform About Match");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 260, -1));

        jButton2.setBackground(new java.awt.Color(153, 204, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("PieChart");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 260, -1));

        jButton4.setBackground(new java.awt.Color(153, 204, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setText("<< Back");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void donorTblButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donorTblButtonActionPerformed
        int selectedRow = recipientInfoJTable.getSelectedRow();
        
        if(selectedRow >= 0){
            recipientEmail = (Recipient) recipientInfoJTable.getValueAt(selectedRow, 0);
           String organ = (String) recipientInfoJTable.getValueAt(selectedRow, 2);
           String city = (String) recipientInfoJTable.getValueAt(selectedRow, 1);
           populateDonorTable(organ, city);    
        }else{

            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_donorTblButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = donorInfoJTable.getSelectedRow();

        if (selectedRow >= 0) {
            donorEmail = (Donor) donorInfoJTable.getValueAt(selectedRow, 0);
            sendEmail(donorEmail.getEmailAdd());
            sendEmail(recipientEmail.getEmailAdd());
            JOptionPane.showMessageDialog(null, "Organ match information is sent successfully via email.");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int number1 = this.donorInfoJTable.getRowCount();
        int number2 = this.recipientInfoJTable.getRowCount();

        Frame frame = new Frame();

        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        pieDataSet.setValue("Total Donor", number1);
        pieDataSet.setValue("Total Recipient by Severity", number2);
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataSet, true, true, true);

        ChartPanel cp = new ChartPanel(chart);
        frame.add(cp);

        frame.pack();
        frame.setVisible(true);
        cp.setSize(600, 600);
        cp.setVisible(true);
   


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        ManageOrganMatchJPanel manageCitiesJPanel = new ManageOrganMatchJPanel(rightPanel, system);
        rightPanel.add("manageCitiesJPanel", manageCitiesJPanel);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable donorInfoJTable;
    private javax.swing.JButton donorTblButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipientInfoJTable;
    // End of variables declaration//GEN-END:variables


    private void populateDonorTable(String organ, String city) {
        
        DefaultTableModel model = (DefaultTableModel) donorInfoJTable.getModel();

        //HashMap<String, Donor> donorList = new HashMap<String, Donor>();
        List<Donor> donorList = new ArrayList<Donor>();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if(enterprise instanceof HospitalEnterprise){
                    for (Organization or : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (or.getName().equalsIgnoreCase("Visitor Organization")) {
                            for (Donor donor : or.getDonorDirectory().getDonorList()) {
                                for (String part : donor.getOrgans()) {
                                    if (part.equalsIgnoreCase(organ)) {
                                        // donorList.put(network.getName(), donor);
                                        donor.setNetwork(network.getName());
                                        donorList.add(donor);

                                    }
                                }
                            }
                        }

                   }
                }
            }

        }
        
        Map<Double, Donor> cityDistMap = findDistanceBetweenCities(donorList, city);
        
        for(Donor obj : cityDistMap.values()){
            Object[] row = new Object[3];
            row[0] = obj;
            row[1] = obj.getNetwork();
            row[2] = obj.getIsOrganAvaiNow();

            model.addRow(row);
        }
    }

    private void populateRecipientTable() {

        DefaultTableModel model = (DefaultTableModel) recipientInfoJTable.getModel();

        model.setRowCount(0);

        for (Recipient recipient : recipientList) {
            Object[] row = new Object[4];
            row[0] = recipient;
            row[1] = recipient.getNetwork();
            row[2] = recipient.getOrgan();
            row[3] = recipient.getPriority();

            model.addRow(row);
        }

    }

    private Map<Double, Donor> findDistanceBetweenCities(List<Donor> donorList, String source) {
        
        Map<Double, Donor> cityDistMap = new TreeMap<Double, Donor>();
        
        for(Donor donor : donorList){
            double distance = getDistance(source, donor.getNetwork());
            cityDistMap.put(distance, donor);
        }
        return cityDistMap;
    }
    
        //to find distance between cities
        public static double getDistance(String fromAddress, String toAddres) {
            Map from = getGeoCodes(fromAddress);
            Map to = getGeoCodes(toAddres);
            return distance((Double) from.get("lat"), (Double) from.get("lng"), (Double) to.get("lat"), (Double) to.get("lng"), "K");

        }
    
        public static Map getGeoCodes(String address) {
           try {
               String geoCodeUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=";
               String key = "&key=AIzaSyBiz8PYrcTF4KFwOEpOANYPcgxZUDz3_kU";
               StringBuilder result = new StringBuilder();
               URL url = new URL(geoCodeUrl + address + key);
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("GET");
               BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               String line;
               while ((line = rd.readLine()) != null) {
                   result.append(line);
               }
               rd.close();
               Map resultMap = new ObjectMapper().readValue(result.toString(), Map.class);
               return (Map) ((Map) ((Map) ((List) resultMap.get("results")).get(0)).get("geometry")).get("location");
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           }
           return null;
       }
     
        public static double distance(double lat1, double lon1, double lat2, double lon2, String sr) {
           double theta = lon1 - lon2;
           double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
           dist = Math.acos(dist);
           dist = rad2deg(dist);
           dist = dist * 60 * 1.1515;
           if (sr.equals("K")) {
               dist = dist * 1.609344;
           } else if (sr.equals("N")) {
               dist = dist * 0.8684;
           }
           return (dist);
       }

       public static double deg2rad(double deg) {
           return (deg * Math.PI / 180.0);
       }

       public static double rad2deg(double rad) {
           return (rad * 180.0 / Math.PI);
       }

        private void sendEmail(String emailAdd) {
            final String to = emailAdd;
            boolean sessionDebug=false;
            String from = "sidjonas12345@gmail.com"; 
            String host = "smtp.gmail.com";
            String user="sidjonas12345@gmail.com";
            String pass = "Smart@1995";
            Properties properties = System.getProperties();  
            properties.setProperty("mail.smtp.host", host); properties.put("mail.smtp.starttls.required", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host",host);  
            properties.put("mail.smtp.port", "587");  
            properties.put("mail.smtp.auth", "true");  
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
            Session session;
            session = Session.getDefaultInstance(properties,  null);
            session.setDebug(sessionDebug);
            try{
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(from));  
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            InternetAddress address;
            address = new InternetAddress(to);
            message.setSubject("Did you know?");  
            message.setText("We have paired "+ donorEmail.getEmailAdd()+ " with " + recipientEmail.getEmailAdd()+ " for organ transplant.");  
            Transport transport = session.getTransport("smtp");
            transport.connect(host,user,pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            //JOptionPane.showMessageDialog(null, "Please check your email for further details!");
            }
            
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
}
