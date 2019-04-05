import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ModifyFootballMatch {

	private JFrame frame;
	private JTextField textFieldNewLocalTeam;
	private JTextField textFieldNewLocalGoals;
	private JTextField textFieldNewVisitorTeam;
	private JTextField textFieldVisitorTeam;
	private JTextField textFieldNewVisitorGoals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFootballMatch window = new ModifyFootballMatch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ModifyFootballMatch() throws ClassNotFoundException, SQLException {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		Class.forName("com.mysql.cj.jdbc.Driver");

		String oracleURL = "jdbc:mysql://localhost/football?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		Connection conn = DriverManager.getConnection(oracleURL, "root", "xabiander");

		JLabel lblLocalTeam = new JLabel("Local team");
		lblLocalTeam.setBounds(10, 53, 73, 14);
		contentPane.add(lblLocalTeam);

		JTextField textFieldLocalTeam = new JTextField();
		textFieldLocalTeam.setBounds(93, 50, 97, 20);
		contentPane.add(textFieldLocalTeam);
		textFieldLocalTeam.setColumns(10);

		JLabel lblVisitorTeam = new JLabel("Visitor team");
		lblVisitorTeam.setBounds(213, 53, 86, 14);
		contentPane.add(lblVisitorTeam);

		textFieldVisitorTeam = new JTextField();
		textFieldVisitorTeam.setBounds(310, 50, 102, 20);
		contentPane.add(textFieldVisitorTeam);
		textFieldVisitorTeam.setColumns(10);

		JLabel lblNotFound = new JLabel("Not found");
		lblNotFound.setBounds(337, 92, 97, 14);
		lblNotFound.setVisible(false);
		contentPane.add(lblNotFound);

		JLabel lblNewLocalTeam = new JLabel("New local team");
		lblNewLocalTeam.setBounds(10, 92, 86, 14);
		lblNewLocalTeam.setVisible(false);
		contentPane.add(lblNewLocalTeam);

		textFieldNewLocalTeam = new JTextField();
		textFieldNewLocalTeam.setBounds(93, 89, 86, 20);
		textFieldNewLocalTeam.setVisible(false);
		contentPane.add(textFieldNewLocalTeam);
		textFieldNewLocalTeam.setColumns(10);

		JLabel lblNewLocalGoals = new JLabel("New local goals");
		lblNewLocalGoals.setBounds(213, 92, 86, 14);
		lblNewLocalGoals.setVisible(false);
		contentPane.add(lblNewLocalGoals);

		textFieldNewLocalGoals = new JTextField();
		textFieldNewLocalGoals.setBounds(310, 92, 86, 20);
		textFieldNewLocalGoals.setVisible(false);
		contentPane.add(textFieldNewLocalGoals);
		textFieldNewLocalGoals.setColumns(10);

		JLabel lblNewVisitorTeam = new JLabel("New visitor team");
		lblNewVisitorTeam.setVisible(false);
		lblNewVisitorTeam.setBounds(10, 150, 86, 14);
		contentPane.add(lblNewVisitorTeam);

		textFieldNewVisitorTeam = new JTextField();
		textFieldNewVisitorTeam.setBounds(93, 147, 86, 20);
		textFieldNewVisitorTeam.setVisible(false);
		contentPane.add(textFieldNewVisitorTeam);
		textFieldNewVisitorTeam.setColumns(10);

		JLabel lblNewVisitorGoals = new JLabel("New visitor goals");
		lblNewVisitorGoals.setVisible(false);
		lblNewVisitorGoals.setBounds(202, 150, 97, 14);
		contentPane.add(lblNewVisitorGoals);

		textFieldNewVisitorGoals = new JTextField();
		textFieldNewVisitorGoals.setVisible(false);
		textFieldNewVisitorGoals.setBounds(310, 147, 102, 20);
		contentPane.add(textFieldNewVisitorGoals);
		textFieldNewVisitorGoals.setColumns(10);

		JButton btnModify = new JButton("Modify");
		btnModify.setVisible(false);
		btnModify.setBounds(157, 203, 89, 23);
		contentPane.add(btnModify);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNotFound.setVisible(false);
				lblNewLocalTeam.setVisible(false);
				lblNewLocalGoals.setVisible(false);
				lblNewVisitorTeam.setVisible(false);
				lblNewVisitorTeam.setVisible(false);
				textFieldNewLocalTeam.setVisible(false);
				textFieldNewLocalGoals.setVisible(false);
				textFieldNewVisitorTeam.setVisible(false);
				textFieldNewVisitorGoals.setVisible(false);
				btnModify.setVisible(false);
				PreparedStatement pst;
				try {
					pst = conn.prepareStatement("select * from matches where local_team=? and visitor_team=?;");

					pst.setString(1, textFieldLocalTeam.getText());
					pst.setString(2, textFieldVisitorTeam.getText());
					ResultSet result = pst.executeQuery();

					if (result.next()) {
						lblNewLocalTeam.setVisible(true);
						lblNewVisitorTeam.setVisible(true);
						lblNewLocalGoals.setVisible(true);
						lblNewVisitorGoals.setVisible(true);
						textFieldNewLocalTeam.setVisible(true);
						textFieldNewVisitorTeam.setVisible(true);
						textFieldNewLocalGoals.setVisible(true);
						textFieldNewVisitorGoals.setVisible(true);
						btnModify.setVisible(true);
						textFieldNewLocalTeam.setText(result.getString(2));
						textFieldNewVisitorTeam.setText(result.getString(4));
						textFieldNewLocalGoals.setText(result.getString(3));
						textFieldNewVisitorGoals.setText(result.getString(5));
						;
						lblLocalTeam.setVisible(false);
						textFieldLocalTeam.setVisible(false);
						lblVisitorTeam.setVisible(false);
						textFieldVisitorTeam.setVisible(false);
						btnSearch.setVisible(false);
					} else {
						lblNotFound.setVisible(true);
					}

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pst2;
				try {
					pst2 = conn.prepareStatement("update matches set local_team=?,local_goals=?,visitor_team=?,visitor_goals=? where local_team=? and visitor_team=?;");

					pst2.setString(1, textFieldNewLocalTeam.getText());
					pst2.setString(2, textFieldNewLocalGoals.getText());
					pst2.setString(3,textFieldNewVisitorTeam.getText());
					pst2.setString(4, textFieldNewVisitorGoals.getText());
					pst2.setString(5, textFieldLocalTeam.getText());
					pst2.setString(6, textFieldVisitorTeam.getText());

					pst2.executeUpdate();

					Football show = new Football(3);
					show.getFrame().setVisible(true);
					frame.dispose();
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(165, 88, 117, 23);
		contentPane.add(btnSearch);

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
}
