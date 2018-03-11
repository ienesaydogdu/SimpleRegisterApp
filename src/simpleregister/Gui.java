package simpleregister;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.InputMethodListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.InputMethodEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private JTextField tfTc;
	private JTextField tfAdi;
	private JTextField tfSoyadi;
	private JTextField tfMail;
	private JLabel lblSoyadi;
	private JLabel lblEposta;
	private JLabel lblTelefon;
	boolean bkimlik,badi,bsoyadi,bmail,btelefon;
	int butonKontrol =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize()  {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 473, 710);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 468, 710);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tfTc = new JTextField();
		tfTc.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				regexKontrol();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				regexKontrol();				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			void regexKontrol() {
				String kimlik = tfTc.getText();
				if (kimlik.matches("[0-9]{11}")==true) {
					bkimlik = true;
					tfTc.setBorder(BorderFactory.createLineBorder(Color.green,3));
					
				}
				else {
					bkimlik = false;
					tfTc.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}
			}
			
		});
		tfTc.setBounds(150, 150, 236, 39);
		panel.add(tfTc);
		tfTc.setColumns(10);
		
		tfAdi = new JTextField();
		tfAdi.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			void regexKontrol() {
				String isim = tfAdi.getText();
				if (isim.matches("[a-zA-Z ]{3,20}")==true) {
					tfAdi.setBorder(BorderFactory.createLineBorder(Color.green,3));
					badi = true;
					
				}
				else {
					badi = false;
					tfAdi.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}
			}
		});
		tfAdi.setColumns(10);
		tfAdi.setBounds(150, 203, 236, 39);
		panel.add(tfAdi);
		
		tfSoyadi = new JTextField();
		tfSoyadi.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				regexKontrol();	
			}
			
			void regexKontrol() {
				String soyisim = tfSoyadi.getText();
				if (soyisim.matches("[a-zA-Z ]{3,20}")==true) {
					tfSoyadi.setBorder(BorderFactory.createLineBorder(Color.green,3));
					bsoyadi = true;
					
				}
				else {
					tfSoyadi.setBorder(BorderFactory.createLineBorder(Color.red,3));
					bsoyadi = false;
				}
			}
		});
		tfSoyadi.setColumns(10);
		tfSoyadi.setBounds(150, 254, 236, 39);
		panel.add(tfSoyadi);
		
		tfMail = new JTextField();
		tfMail.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				regexKontrol();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				regexKontrol();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				regexKontrol();
			}
			
			void regexKontrol() {
				String mail = tfMail.getText();
				if (mail.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
						+ "\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\."
						+ ")+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]"
						+ "[0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c"
						+ "\\x0e-\\x7f])+)\\])")==true) {
					tfMail.setBorder(BorderFactory.createLineBorder(Color.green,3));
					bmail = true;
					
				}
				else {
					tfMail.setBorder(BorderFactory.createLineBorder(Color.red,3));
					bmail = false;
				}
			}
		});
		tfMail.setColumns(10);
		tfMail.setBounds(150, 306, 236, 39);
		panel.add(tfMail);
		
		JButton btnTamamla = new JButton("Tamamla");
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            JOptionPane.showMessageDialog(new JFrame(), "Kayýt baþarýyla oluþturuldu.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnTamamla.setBackground(Color.YELLOW);
		btnTamamla.setBorder(null);
		btnTamamla.setBounds(150, 454, 180, 55);
		panel.add(btnTamamla);
		
		JLabel lblTc = new JLabel("TC Kimlik:");
		lblTc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTc.setBounds(46, 153, 90, 33);
		panel.add(lblTc);
		
		JLabel lblAdi = new JLabel("\u0130sim:");
		lblAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdi.setBounds(46, 206, 90, 33);
		panel.add(lblAdi);
		
		lblSoyadi = new JLabel("Soyisim:");
		lblSoyadi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyadi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSoyadi.setBounds(46, 257, 90, 33);
		panel.add(lblSoyadi);
		
		lblEposta = new JLabel("E-Posta:");
		lblEposta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEposta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEposta.setBounds(46, 309, 90, 33);
		panel.add(lblEposta);
		
		lblTelefon = new JLabel("Cep Tel. :");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTelefon.setBounds(46, 359, 90, 33);
		panel.add(lblTelefon);
		
		JFormattedTextField tfTelefon = new JFormattedTextField();
		tfTelefon.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				regexKontrol();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				regexKontrol();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				regexKontrol();
			}
			void regexKontrol() {
				String telefon = tfTelefon.getText();
				if (telefon.matches("[0-9]{10}")==true) {
					tfTelefon.setBorder(BorderFactory.createLineBorder(Color.green,3));
					btelefon = true;
					
				}
				else {
					tfTelefon.setBorder(BorderFactory.createLineBorder(Color.red,3));
					btelefon = false;
				}
			}
		});
		tfTelefon.setDisabledTextColor(Color.RED);
		tfTelefon.setBounds(150, 353, 236, 39);
		
		panel.add(tfTelefon);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBorder(null);
		lblBackground.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBackground.setIcon(new ImageIcon(Gui.class.getResource("/simpleregister/automataregex.png")));
		lblBackground.setBackground(Color.LIGHT_GRAY);
		lblBackground.setBounds(36, 28, 416, 575);
		panel.add(lblBackground);
		
		Thread thread = new Thread() {

			@Override
			public void run() {
				while(true) {
				
					System.out.println("Thread içindeyim:"+bkimlik+" "+badi+" "+bsoyadi+" "+bmail+" "+btelefon);//SORULACAK!!! bu satýrý kapatýnca buton aktif olmuyor!
					if (bkimlik == true && badi==true && bsoyadi == true && bmail == true && btelefon ==true ) {
						btnTamamla.setEnabled(true);
					}
					else {
						btnTamamla.setEnabled(false);
					}
				}
			}
			  
			};
			thread.start();
		
	}
}
