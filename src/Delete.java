import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Delete {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Delete() throws ClassNotFoundException, SQLException {
		initialize();
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Class.forName("com.mysql.cj.jdbc.Driver");


        String oracleURL = "jdbc:mysql://localhost/football?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


        Connection conn =  DriverManager.getConnection(oracleURL, "root", "xabiander");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);

		JMenu mnShowData = new JMenu("Show data");
		menuBar.add(mnShowData);

		JMenuItem mntmPlayers = new JMenuItem("Players");
		mntmPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(1);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmPlayers);

		JMenuItem mntmTeams = new JMenuItem("Teams");
		mntmTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(2);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmTeams);

		JMenuItem mntmMatches = new JMenuItem("Matches");
		mntmMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(3);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmMatches);

		JMenu mnAddData = new JMenu("Add data");
		menuBar.add(mnAddData);

		JMenuItem mntmPlayers_1 = new JMenuItem("Players");
		mntmPlayers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddPlayer player = new AddPlayer();
					player.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnAddData.add(mntmPlayers_1);

		JMenuItem mntmTeams_1 = new JMenuItem("Teams");
		mntmTeams_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddTeam team = new AddTeam();
					team.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});

		mnAddData.add(mntmTeams_1);

		JMenuItem mntmMatches_1 = new JMenuItem("Matches");
		mntmMatches_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddMatch match = new AddMatch();
					match.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnAddData.add(mntmMatches_1);

		JMenu mnDeleteData = new JMenu("Delete data");
		menuBar.add(mnDeleteData);

		JMenuItem mntmNewMenuItem = new JMenuItem("Delete player");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete del = new Delete(1);
					del.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnDeleteData.add(mntmNewMenuItem);

		JMenuItem mntmDeleteTeam = new JMenuItem("Delete team");
		mntmDeleteTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete del = new Delete(2);
					del.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnDeleteData.add(mntmDeleteTeam);

		JMenuItem mntmDeleteMatch = new JMenuItem("Delete match");
		mntmDeleteMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete del = new Delete(3);
					del.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnDeleteData.add(mntmDeleteMatch);
		JMenu mnModifyData = new JMenu("Modify data");
		menuBar.add(mnModifyData);

		JMenuItem mntmPlayers_2 = new JMenuItem("Players");
		mntmPlayers_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyPlayer player = new ModifyPlayer();
					player.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmPlayers_2);

		JMenuItem mntmTeams_2 = new JMenuItem("Teams");
		mntmTeams_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyTeam team = new ModifyTeam();
					team.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmTeams_2);

		JMenuItem mntmMatches_2 = new JMenuItem("Matches");
		mntmMatches_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyFootballMatch match = new ModifyFootballMatch();
					match.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmMatches_2);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Delete(int option) throws ClassNotFoundException, SQLException {
		initialize();
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		

		Class.forName("com.mysql.cj.jdbc.Driver");


        String oracleURL = "jdbc:mysql://localhost/football?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


        Connection conn =  DriverManager.getConnection(oracleURL, "root", "xabiander");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);

		JMenu mnShowData = new JMenu("Show data");
		menuBar.add(mnShowData);

		JMenuItem mntmPlayers = new JMenuItem("Players");
		mntmPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(1);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmPlayers);

		JMenuItem mntmTeams = new JMenuItem("Teams");
		mntmTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(2);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmTeams);

		JMenuItem mntmMatches = new JMenuItem("Matches");
		mntmMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Football show = new Football(3);
					show.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnShowData.add(mntmMatches);

		JMenu mnAddData = new JMenu("Add data");
		menuBar.add(mnAddData);

		JMenuItem mntmPlayers_1 = new JMenuItem("Players");
		mntmPlayers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddPlayer player = new AddPlayer();
					player.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnAddData.add(mntmPlayers_1);

		JMenuItem mntmTeams_1 = new JMenuItem("Teams");
		mntmTeams_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddTeam team = new AddTeam();
					team.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});

		mnAddData.add(mntmTeams_1);

		JMenuItem mntmMatches_1 = new JMenuItem("Matches");
		mntmMatches_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddMatch match = new AddMatch();
					match.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnAddData.add(mntmMatches_1);

		JMenu mnDeleteData = new JMenu("Delete data");
		menuBar.add(mnDeleteData);

		JMenuItem mntmNewMenuItem = new JMenuItem("Delete player");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete del = new Delete(1);
					del.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnDeleteData.add(mntmNewMenuItem);

		JMenuItem mntmDeleteTeam = new JMenuItem("Delete team");
		mntmDeleteTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete del = new Delete(2);
					del.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnDeleteData.add(mntmDeleteTeam);

		JMenuItem mntmDeleteMatch = new JMenuItem("Delete match");
		mntmDeleteMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete del = new Delete(3);
					del.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnDeleteData.add(mntmDeleteMatch);
		JMenu mnModifyData = new JMenu("Modify data");
		menuBar.add(mnModifyData);

		JMenuItem mntmPlayers_2 = new JMenuItem("Players");
		mntmPlayers_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyPlayer player = new ModifyPlayer();
					player.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmPlayers_2);

		JMenuItem mntmTeams_2 = new JMenuItem("Teams");
		mntmTeams_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyTeam team = new ModifyTeam();
					team.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmTeams_2);

		JMenuItem mntmMatches_2 = new JMenuItem("Matches");
		mntmMatches_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ModifyFootballMatch match = new ModifyFootballMatch();
					match.getFrame().setVisible(true);
					frame.dispose();

				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		mnModifyData.add(mntmMatches_2);

		if (option == 1) {

			JLabel lblNameOfThe = new JLabel("Name of the player");
			lblNameOfThe.setBounds(37, 92, 113, 14);
			contentPane.add(lblNameOfThe);

			textField = new JTextField();
			textField.setBounds(172, 89, 153, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PreparedStatement pst;
					try {
						pst = conn.prepareStatement("delete from players where name=?;");
						
						pst.setString(1, textField.getText());
						
			
						pst.executeUpdate();
						
						Football show = new Football(1);
						show.getFrame().setVisible(true);
						frame.dispose();
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				}
			});
			btnDelete.setBounds(168, 148, 89, 23);
			contentPane.add(btnDelete);
		} else if (option == 2) {
			JLabel lblNameOfThe_1 = new JLabel("Name of the team");
			lblNameOfThe_1.setBounds(37, 92, 113, 14);
			contentPane.add(lblNameOfThe_1);

			textField_1 = new JTextField();
			textField_1.setBounds(181, 89, 177, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			JButton btnDelete_1 = new JButton("Delete");
			btnDelete_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PreparedStatement pst2;
					try {
						pst2 = conn.prepareStatement("delete from teams where team_name=?;");
						
						pst2.setString(1, textField_1.getText());
						
			
						pst2.executeUpdate();
						
						Football show = new Football(2);
						show.getFrame().setVisible(true);
						frame.dispose();
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnDelete_1.setBounds(149, 162, 89, 23);
			contentPane.add(btnDelete_1);
		} else if (option == 3) {

			JLabel lblLocalTeam = new JLabel("Local Team");
			lblLocalTeam.setBounds(43, 58, 108, 14);
			contentPane.add(lblLocalTeam);

			textField_2 = new JTextField();
			textField_2.setBounds(162, 55, 149, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			JLabel lblVisitorTeam = new JLabel("Visitor Team");
			lblVisitorTeam.setBounds(43, 99, 108, 14);
			contentPane.add(lblVisitorTeam);

			textField_3 = new JTextField();
			textField_3.setBounds(162, 96, 149, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			JButton btnDelete_2 = new JButton("Delete");
			btnDelete_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PreparedStatement pst3;
					try {
						pst3 = conn.prepareStatement("delete from matches where local_team=? and visitor_team=?;");
						
						pst3.setString(1, textField_2.getText());
						pst3.setString(2, textField_3.getText());
						
			
						pst3.executeUpdate();
						
						Football show = new Football(3);
						show.getFrame().setVisible(true);
						frame.dispose();
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			btnDelete_2.setBounds(164, 171, 89, 23);
			contentPane.add(btnDelete_2);

		}
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return this.frame;
	}
}
