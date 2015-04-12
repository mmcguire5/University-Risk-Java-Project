package project;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.eclipse.wb.swing.FocusTraversalOnArray;


/**
 * The main JPanel of the game.
 * Added on the main window of the game in Driver
 */
	public class GameBoard extends JPanel{
	
	//INSTANT VARIABLES DECLARAION. 
	private ArrayList<Button> _buttonList;
	private Button _musicButton, _theatreButton,_danceButton,_vaButton,
				   _bioButton,_chemButton, _phyButton, _mathButton,
				   _historyButton,_lingButton,_literButton,_reliButton,
				   _compButton,_electriButton,_mechButton,_civilButton,
				   _busButton,_familyButton,_crimButton,_ImmiButton,
				   _anesthButton,_otoButton,_pathButton,_pediaButton;
	private PlayersSetUpPopUpWindow _window;
	private JLabel _turnNameLabel, _stepLB,_schoolNumberLB,_studentNumberLB,_departmentNumberLB,_colorLB,
				   _stringColorLB;
	private JButton _btnNext, btnElect;
	private GameState _gameState;
	private ArrayList<JLabel> _labelList;

	/**
	* Create Button()s for each Departments and add them on GameBoard.
	*@author xingdita, norbertl
	*/
	public GameBoard(){

		
		setBackground(Color.WHITE);
		
		//Create Panels for Schools
		JPanel artPanel = new JPanel();
		artPanel.setBounds(374, 107, 250, 220);JPanel sciencePanel = new JPanel();
		sciencePanel.setBounds(29, 0, 250, 220);
		JPanel humanPanel = new JPanel();
		humanPanel.setBounds(29, 450, 250, 220);JPanel engPanel = new JPanel();
		engPanel.setBounds(374, 339, 250, 220);
		JPanel lawPanel = new JPanel();
		lawPanel.setBounds(709, 450, 250, 220);JPanel mediPanel = new JPanel();
		mediPanel.setBounds(699, 0, 260, 220);
		_theatreButton = new Button("Theatre",Color.YELLOW);
		_theatreButton.setBounds(0, 110, 125, 110);
		_mechButton = new Button("Mechanical",Color.CYAN);
		_mechButton.setBounds(125, 0, 125, 110);
		
		_busButton = new Button("Business",Color.RED);
		_busButton.setBounds(0, 0, 125, 110);
		_crimButton = new Button("Criminal",Color.RED);
		_crimButton.setBounds(125, 0, 125, 110);
		_ImmiButton = new Button("Immigration",Color.RED);
		_ImmiButton.setBounds(0, 110, 125, 110);
		setLayout(null);
		
		//Add schoolPanels onto GameBoard.
		this.add(artPanel);this.add(sciencePanel);
		this.add(humanPanel);
		this.add(engPanel);this.add(lawPanel);this.add(mediPanel);
artPanel.setLayout(null);
artPanel.add(_theatreButton);
_theatreButton.setLayout(new GridLayout(1, 0, 0, 0));
_vaButton = new Button("Visual Arts",Color.YELLOW);
_vaButton.setBounds(125, 110, 125, 110);
artPanel.add(_vaButton);
_vaButton.setLayout(new GridLayout(1, 0, 0, 0));


//Create Buttons
_musicButton = new Button("Music",Color.YELLOW);
_musicButton.setBounds(0, 0, 125, 110);
artPanel.add(_musicButton);
_musicButton.setLayout(new GridLayout(1, 0, 0, 0));
_danceButton = new Button("Dance",Color.YELLOW);
_danceButton.setBounds(125, 0, 125, 110);
artPanel.add(_danceButton);
_danceButton.setLayout(new GridLayout(1, 0, 0, 0));
humanPanel.setLayout(null);
_reliButton = new Button("Religion",Color.BLUE);
_reliButton.setBounds(0, 0, 125, 110);
humanPanel.add(_reliButton);
_reliButton.setLayout(new GridLayout(1, 0, 0, 0));
_literButton = new Button("Literature",Color.BLUE);
_literButton.setBounds(0, 110, 125, 110);
humanPanel.add(_literButton);
_literButton.setLayout(new GridLayout(1, 0, 0, 0));

_historyButton = new Button("History",Color.BLUE);
_historyButton.setBounds(125, 110, 125, 110);
humanPanel.add(_historyButton);
_historyButton.setLayout(new GridLayout(1, 0, 0, 0));
_lingButton = new Button("Linguistics",Color.BLUE);
_lingButton.setBounds(125, 0, 125, 110);
humanPanel.add(_lingButton);
_lingButton.setLayout(new GridLayout(1, 0, 0, 0));engPanel.setLayout(null);
engPanel.add(_mechButton);
_mechButton.setLayout(new GridLayout(1, 0, 0, 0));
_civilButton = new Button("Civil",Color.CYAN);
_civilButton.setBounds(125, 110, 125, 110);
engPanel.add(_civilButton);
_civilButton.setLayout(new GridLayout(1, 0, 0, 0));
_electriButton = new Button("Electrical",Color.CYAN);
_electriButton.setBounds(0, 0, 125, 110);
engPanel.add(_electriButton);
_electriButton.setLayout(new GridLayout(1, 0, 0, 0));

_compButton = new Button("Computer",Color.CYAN);
_compButton.setBounds(0, 110, 125, 110);
engPanel.add(_compButton);
_compButton.setLayout(new GridLayout(1, 0, 0, 0));
		lawPanel.setLayout(null);
		lawPanel.add(_busButton);
		_busButton.setLayout(new GridLayout(1, 0, 0, 0));lawPanel.add(_crimButton);
_crimButton.setLayout(new GridLayout(1, 0, 0, 0));lawPanel.add(_ImmiButton);
_ImmiButton.setLayout(new GridLayout(1, 0, 0, 0));
_familyButton = new Button("Family",Color.RED);
_familyButton.setBounds(125, 110, 125, 110);
lawPanel.add(_familyButton);
_familyButton.setLayout(new GridLayout(1, 0, 0, 0));
mediPanel.setLayout(null);
_pathButton = new Button("Pathology",Color.GRAY);
_pathButton.setBounds(125, 110, 135, 110);
mediPanel.add(_pathButton);
_pathButton.setLayout(new GridLayout(1, 0, 0, 0));
_pediaButton = new Button("Pediatrics",Color.GRAY);
_pediaButton.setBounds(0,110,125,110);
mediPanel.add(_pediaButton);
_pediaButton.setLayout(new GridLayout(1,0,0,0));

_anesthButton = new Button("Anesthesia",Color.GRAY);
_anesthButton.setBounds(0, 0, 125, 110);
mediPanel.add(_anesthButton);
_anesthButton.setLayout(new GridLayout(1, 0, 0, 0));
_otoButton = new Button("Otolaryngology",Color.GRAY);
_otoButton.setBounds(125, 0, 135, 110);
mediPanel.add(_otoButton);
_otoButton.setLayout(new GridLayout(1, 0, 0, 0));
sciencePanel.setLayout(null);
_phyButton = new Button("Physics",Color.GREEN);
_phyButton.setBounds(125, 110, 125, 110);
sciencePanel.add(_phyButton);
_phyButton.setLayout(new GridLayout(1, 0, 0, 0));
_chemButton = new Button("Chemistry",Color.GREEN);
_chemButton.setBounds(125, 0, 125, 110);
sciencePanel.add(_chemButton);
_chemButton.setLayout(new GridLayout(1, 0, 0, 0));
_phyButton.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{_mathButton}));
_bioButton = new Button("Biology",Color.GREEN);
_bioButton.setBounds(0, 0, 125, 110);
sciencePanel.add(_bioButton);
_bioButton.setLayout(new GridLayout(1, 0, 0, 0));
_mathButton = new Button("Mathmetics",Color.GREEN);
_mathButton.setBounds(0, 110, 125, 110);
sciencePanel.add(_mathButton);
_mathButton.setLayout(new GridLayout(1, 0, 0, 0));
JSeparator separator = new JSeparator();
separator.setForeground(Color.RED);
separator.setBounds(278, 131, 102, 18);
add(separator);
JSeparator separator_1 = new JSeparator();
separator_1.setForeground(Color.RED);
separator_1.setBounds(278, 469, 102, 18);
add(separator_1);
JSeparator separator_2 = new JSeparator();
separator_2.setForeground(Color.RED);
separator_2.setOrientation(SwingConstants.VERTICAL);
separator_2.setBounds(80, 215, 48, 240);
add(separator_2);
JSeparator separator_3 = new JSeparator();
separator_3.setForeground(Color.RED);
separator_3.setOrientation(SwingConstants.VERTICAL);
separator_3.setBounds(563, 309, 22, 33);
add(separator_3);
JSeparator separator_4 = new JSeparator();
separator_4.setOrientation(SwingConstants.VERTICAL);
separator_4.setForeground(Color.RED);
separator_4.setBounds(887, 197, 48, 269);
add(separator_4);
JSeparator separator_5 = new JSeparator();
separator_5.setForeground(Color.RED);
separator_5.setBounds(617, 469, 102, 18);
add(separator_5);
JSeparator separator_6 = new JSeparator();
separator_6.setForeground(Color.RED);
separator_6.setBounds(265, 21, 454, 18);
add(separator_6);
	
	JLabel lblSciences = new JLabel("Sciences");
	lblSciences.setHorizontalAlignment(SwingConstants.CENTER);
	lblSciences.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
	lblSciences.setBounds(106, 221, 119, 33);
	add(lblSciences);
	
	JLabel lblNewLabel = new JLabel("Humanities");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
	lblNewLabel.setBounds(98, 412, 152, 33);
	add(lblNewLabel);
	
	JLabel lblArts = new JLabel("Arts");
	lblArts.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
	lblArts.setHorizontalAlignment(SwingConstants.CENTER);
	lblArts.setBounds(450, 73, 97, 33);
	add(lblArts);
	
	JLabel lblEngineering = new JLabel("Engineering");
	lblEngineering.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
	lblEngineering.setHorizontalAlignment(SwingConstants.CENTER);
	lblEngineering.setBounds(410, 560, 187, 33);
	add(lblEngineering);
	
	JLabel lblLaw = new JLabel("Law");
	lblLaw.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
	lblLaw.setHorizontalAlignment(SwingConstants.CENTER);
	lblLaw.setBounds(805, 416, 61, 24);
	add(lblLaw);
	
	JLabel lblMedicine = new JLabel("Medicine");
	lblMedicine.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
	lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
	lblMedicine.setBounds(769, 224, 119, 24);
	add(lblMedicine);
	
		//****************************************************** Turn Side Bar ************************************************************************
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(969, 21, 295, 316);
	add(panel_1);
	panel_1.setLayout(null);
	
	JLabel lblNewLabel_6 = new JLabel("TURN:");
	lblNewLabel_6.setBounds(0, 0, 283, 30);
	panel_1.add(lblNewLabel_6);
	lblNewLabel_6.setForeground(Color.RED);
	lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 31));
	lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	
	_turnNameLabel = new JLabel();
	_turnNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
	_turnNameLabel.setText("");
	_turnNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	_turnNameLabel.setBounds(0, 30, 283, 30);
	panel_1.add(_turnNameLabel);
	
	JLabel lblSchools = new JLabel("Schools:");
	lblSchools.setForeground(Color.BLUE);
	lblSchools.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblSchools.setBounds(0, 181, 72, 30);
	panel_1.add(lblSchools);
	
	JLabel lblDepartments = new JLabel("Departments:");
	lblDepartments.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblDepartments.setForeground(Color.BLUE);
	lblDepartments.setBounds(0, 141, 96, 29);
	panel_1.add(lblDepartments);
	
	JLabel lblNewLabel_7 = new JLabel("Students:");
	lblNewLabel_7.setForeground(Color.BLUE);
	lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel_7.setBounds(0, 104, 72, 14);
	panel_1.add(lblNewLabel_7);
	
	_btnNext = new JButton("Next");
	_btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
	_btnNext.setBounds(109, 275, 81, 30);
	panel_1.add(_btnNext);
	setNextButtonVisible(false);
	
	////////////////////////////// Button Next ActionListener ////////////////////////
	_btnNext.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			btnNextClicked();
		
		}
	}); 
	///////////////////////////////////////////////////////////////////////////////////
	
	JLabel lblStep = new JLabel("Step:");
	lblStep.setForeground(Color.MAGENTA);
	lblStep.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblStep.setBounds(0, 222, 62, 37);
	panel_1.add(lblStep);
	
	_studentNumberLB = new JLabel("0");
	_studentNumberLB.setFont(new Font("Tahoma", Font.PLAIN, 18));
	_studentNumberLB.setHorizontalAlignment(SwingConstants.LEFT);
	_studentNumberLB.setBounds(134, 99, 46, 23);
	panel_1.add(_studentNumberLB);
	
	_departmentNumberLB = new JLabel("0");
	_departmentNumberLB.setFont(new Font("Tahoma", Font.PLAIN, 18));
	_departmentNumberLB.setHorizontalAlignment(SwingConstants.LEFT);
	_departmentNumberLB.setBounds(134, 143, 46, 23);
	panel_1.add(_departmentNumberLB);
	
	_schoolNumberLB = new JLabel("0");
	_schoolNumberLB.setFont(new Font("Tahoma", Font.PLAIN, 18));
	_schoolNumberLB.setHorizontalAlignment(SwingConstants.LEFT);
	_schoolNumberLB.setBounds(134, 188, 46, 14);
	panel_1.add(_schoolNumberLB);
	
	_stepLB = new JLabel();
	_stepLB.setFont(new Font("Tahoma", Font.PLAIN, 21));
	_stepLB.setBounds(72, 222, 211, 37);
	panel_1.add(_stepLB);
	
	JLabel lblNewLabel_8 = new JLabel("Color:");
	lblNewLabel_8.setForeground(Color.BLUE);
	lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel_8.setBounds(0, 71, 58, 14);
	panel_1.add(lblNewLabel_8);
	
	_stringColorLB = new JLabel();
	_stringColorLB.setBackground(Color.LIGHT_GRAY);
	_stringColorLB.setHorizontalAlignment(SwingConstants.CENTER);
	_stringColorLB.setFont(new Font("Tahoma", Font.PLAIN, 15));
	_stringColorLB.setForeground(Color.BLACK);
	_stringColorLB.setBounds(55, 66, 125, 22);
	panel_1.add(_stringColorLB);
	
	_colorLB = new JLabel("");
	_colorLB.setOpaque(true);
	_colorLB.setBounds(184, 63, 89, 25);
	panel_1.add(_colorLB);
	
	btnElect = new JButton("Elect");
	btnElect.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			AttackWindow attack_window = new AttackWindow();
		}
	});
	btnElect.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnElect.setBounds(194, 231, 89, 23);
	panel_1.add(btnElect);
	setElectionButttonInvisible(false);
	
	JPanel panel = new JPanel();
	panel.setBounds(969, 391, 295, 360);
	add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel_2 = new JLabel("Biology");
	lblNewLabel_2.setForeground(Color.RED);
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setBounds(10, 11, 54, 25);
	panel.add(lblNewLabel_2);
	
	JLabel label_001 = new JLabel("0");
	label_001.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_001.setHorizontalAlignment(SwingConstants.CENTER);
	label_001.setBounds(10, 38, 54, 25);
	panel.add(label_001);
	
	
	JLabel lblMusic = new JLabel("Music");
	lblMusic.setForeground(Color.RED);
	lblMusic.setHorizontalAlignment(SwingConstants.CENTER);
	lblMusic.setBounds(10, 74, 54, 25);
	panel.add(lblMusic);
	
	JLabel lblAnesthesia = new JLabel("Anesthesia");
	lblAnesthesia.setForeground(Color.RED);
	lblAnesthesia.setHorizontalAlignment(SwingConstants.CENTER);
	lblAnesthesia.setBounds(10, 132, 54, 25);
	panel.add(lblAnesthesia);
	
	JLabel lblReligion = new JLabel("Religion");
	lblReligion.setForeground(Color.RED);
	lblReligion.setHorizontalAlignment(SwingConstants.CENTER);
	lblReligion.setBounds(10, 184, 54, 25);
	panel.add(lblReligion);
	
	JLabel lblElectrical = new JLabel("Electrical");
	lblElectrical.setForeground(Color.RED);
	lblElectrical.setHorizontalAlignment(SwingConstants.CENTER);
	lblElectrical.setBounds(10, 244, 54, 25);
	panel.add(lblElectrical);
	
	JLabel lblBusiness = new JLabel("Business");
	lblBusiness.setForeground(Color.RED);
	lblBusiness.setHorizontalAlignment(SwingConstants.CENTER);
	lblBusiness.setBounds(10, 301, 54, 25);
	panel.add(lblBusiness);
	
	JLabel lblChemistry = new JLabel("Chemistry");
	lblChemistry.setForeground(Color.RED);
	lblChemistry.setHorizontalAlignment(SwingConstants.CENTER);
	lblChemistry.setBounds(74, 11, 54, 25);
	panel.add(lblChemistry);
	
	JLabel label_002 = new JLabel("0");
	label_002.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_002.setHorizontalAlignment(SwingConstants.CENTER);
	label_002.setBounds(74, 38, 54, 25);
	panel.add(label_002);
	
	JLabel lblDance = new JLabel("Dance");
	lblDance.setForeground(Color.RED);
	lblDance.setHorizontalAlignment(SwingConstants.CENTER);
	lblDance.setBounds(74, 74, 54, 25);
	panel.add(lblDance);
	
	JLabel lblOtolaryngology = new JLabel("Otolaryngology");
	lblOtolaryngology.setForeground(Color.RED);
	lblOtolaryngology.setHorizontalAlignment(SwingConstants.CENTER);
	lblOtolaryngology.setBounds(76, 132, 54, 25);
	panel.add(lblOtolaryngology);
	
	JLabel lblLinguistic = new JLabel("linguistic");
	lblLinguistic.setForeground(Color.RED);
	lblLinguistic.setHorizontalAlignment(SwingConstants.CENTER);
	lblLinguistic.setBounds(75, 184, 54, 25);
	panel.add(lblLinguistic);
	
	JLabel lblMechanical = new JLabel("Mechanical");
	lblMechanical.setForeground(Color.RED);
	lblMechanical.setHorizontalAlignment(SwingConstants.CENTER);
	lblMechanical.setBounds(75, 244, 54, 25);
	panel.add(lblMechanical);
	
	JLabel lblCriminal = new JLabel("Criminal");
	lblCriminal.setForeground(Color.RED);
	lblCriminal.setHorizontalAlignment(SwingConstants.CENTER);
	lblCriminal.setBounds(74, 301, 54, 25);
	panel.add(lblCriminal);
	
	JLabel lblMath = new JLabel("Math");
	lblMath.setForeground(Color.RED);
	lblMath.setHorizontalAlignment(SwingConstants.CENTER);
	lblMath.setBounds(150, 11, 54, 25);
	panel.add(lblMath);
	
	JLabel label_003 = new JLabel("0");
	label_003.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_003.setHorizontalAlignment(SwingConstants.CENTER);
	label_003.setBounds(150, 38, 54, 25);
	panel.add(label_003);
	
	JLabel lblTheatre = new JLabel("Theatre");
	lblTheatre.setForeground(Color.RED);
	lblTheatre.setHorizontalAlignment(SwingConstants.CENTER);
	lblTheatre.setBounds(150, 74, 54, 25);
	panel.add(lblTheatre);
	
	JLabel lblPediatrics = new JLabel("Pediatrics");
	lblPediatrics.setForeground(Color.RED);
	lblPediatrics.setHorizontalAlignment(SwingConstants.CENTER);
	lblPediatrics.setBounds(150, 132, 54, 25);
	panel.add(lblPediatrics);
	
	JLabel lblLiterature = new JLabel("Literature");
	lblLiterature.setForeground(Color.RED);
	lblLiterature.setHorizontalAlignment(SwingConstants.CENTER);
	lblLiterature.setBounds(150, 184, 54, 25);
	panel.add(lblLiterature);
	
	JLabel lblComputer = new JLabel("Computer");
	lblComputer.setForeground(Color.RED);
	lblComputer.setHorizontalAlignment(SwingConstants.CENTER);
	lblComputer.setBounds(150, 244, 54, 25);
	panel.add(lblComputer);
	
	JLabel lblImmigration = new JLabel("Immigration");
	lblImmigration.setForeground(Color.RED);
	lblImmigration.setHorizontalAlignment(SwingConstants.CENTER);
	lblImmigration.setBounds(142, 301, 64, 25);
	panel.add(lblImmigration);
	
	JLabel lblPhysics = new JLabel("Physics");
	lblPhysics.setForeground(Color.RED);
	lblPhysics.setHorizontalAlignment(SwingConstants.CENTER);
	lblPhysics.setBounds(214, 11, 54, 25);
	panel.add(lblPhysics);
	
	JLabel label_004 = new JLabel("0");
	label_004.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_004.setHorizontalAlignment(SwingConstants.CENTER);
	label_004.setBounds(214, 38, 54, 25);
	panel.add(label_004);
	
	JLabel lblVisualArts = new JLabel("Visual Arts");
	lblVisualArts.setForeground(Color.RED);
	lblVisualArts.setHorizontalAlignment(SwingConstants.CENTER);
	lblVisualArts.setBounds(214, 74, 54, 25);
	panel.add(lblVisualArts);
	
	JLabel lblPathology = new JLabel("Pathology");
	lblPathology.setForeground(Color.RED);
	lblPathology.setHorizontalAlignment(SwingConstants.CENTER);
	lblPathology.setBounds(222, 132, 54, 25);
	panel.add(lblPathology);
	
	JLabel lblHistory = new JLabel("History");
	lblHistory.setForeground(Color.RED);
	lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
	lblHistory.setBounds(222, 184, 54, 25);
	panel.add(lblHistory);
	
	JLabel lblCivil = new JLabel("Civil");
	lblCivil.setForeground(Color.RED);
	lblCivil.setHorizontalAlignment(SwingConstants.CENTER);
	lblCivil.setBounds(222, 244, 54, 25);
	panel.add(lblCivil);
	
	JLabel lblFamily = new JLabel("Family");
	lblFamily.setForeground(Color.RED);
	lblFamily.setHorizontalAlignment(SwingConstants.CENTER);
	lblFamily.setBounds(214, 301, 54, 25);
	panel.add(lblFamily);
	
	JLabel label_005 = new JLabel("0");
	label_005.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_005.setHorizontalAlignment(SwingConstants.CENTER);
	label_005.setBounds(18, 103, 46, 14);
	panel.add(label_005);
	
	JLabel label_006 = new JLabel("0");
	label_006.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_006.setHorizontalAlignment(SwingConstants.CENTER);
	label_006.setBounds(82, 103, 46, 14);
	panel.add(label_006);
	
	JLabel label_007 = new JLabel("0");
	label_007.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_007.setHorizontalAlignment(SwingConstants.CENTER);
	label_007.setBounds(158, 103, 46, 14);
	panel.add(label_007);
	
	JLabel label_008 = new JLabel("0");
	label_008.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_008.setHorizontalAlignment(SwingConstants.CENTER);
	label_008.setBounds(222, 103, 46, 14);
	panel.add(label_008);
	
	JLabel label_009 = new JLabel("0");
	label_009.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_009.setHorizontalAlignment(SwingConstants.CENTER);
	label_009.setBounds(18, 159, 46, 14);
	panel.add(label_009);
	
	JLabel label_010 = new JLabel("0");
	label_010.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_010.setHorizontalAlignment(SwingConstants.CENTER);
	label_010.setBounds(82, 159, 46, 14);
	panel.add(label_010);
	
	JLabel label_011 = new JLabel("0");
	label_011.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_011.setHorizontalAlignment(SwingConstants.CENTER);
	label_011.setBounds(158, 159, 46, 14);
	panel.add(label_011);
	
	JLabel label_012 = new JLabel("0");
	label_012.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_012.setHorizontalAlignment(SwingConstants.CENTER);
	label_012.setBounds(222, 159, 46, 14);
	panel.add(label_012);
	
	JLabel label_013 = new JLabel("0");
	label_013.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_013.setHorizontalAlignment(SwingConstants.CENTER);
	label_013.setBounds(18, 209, 46, 14);
	panel.add(label_013);
	
	JLabel label_014 = new JLabel("0");
	label_014.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_014.setHorizontalAlignment(SwingConstants.CENTER);
	label_014.setBounds(82, 209, 46, 14);
	panel.add(label_014);
	
	JLabel label_015 = new JLabel("0");
	label_015.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_015.setHorizontalAlignment(SwingConstants.CENTER);
	label_015.setBounds(158, 209, 46, 14);
	panel.add(label_015);
	
	JLabel label_016 = new JLabel("0");
	label_016.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_016.setHorizontalAlignment(SwingConstants.CENTER);
	label_016.setBounds(222, 209, 46, 14);
	panel.add(label_016);
	
	JLabel label_017 = new JLabel("0");
	label_017.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_017.setHorizontalAlignment(SwingConstants.CENTER);
	label_017.setBounds(20, 280, 46, 14);
	panel.add(label_017);
	
	JLabel label_018 = new JLabel("0");
	label_018.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_018.setHorizontalAlignment(SwingConstants.CENTER);
	label_018.setBounds(84, 280, 46, 14);
	panel.add(label_018);
	
	JLabel label_019 = new JLabel("0");
	label_019.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_019.setHorizontalAlignment(SwingConstants.CENTER);
	label_019.setBounds(160, 280, 46, 14);
	panel.add(label_019);
	
	JLabel label_020 = new JLabel("0");
	label_020.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_020.setHorizontalAlignment(SwingConstants.CENTER);
	label_020.setBounds(224, 280, 46, 14);
	panel.add(label_020);
	
	JLabel label_021 = new JLabel("0");
	label_021.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_021.setHorizontalAlignment(SwingConstants.CENTER);
	label_021.setBounds(20, 327, 46, 14);
	panel.add(label_021);
	
	JLabel label_022 = new JLabel("0");
	label_022.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_022.setHorizontalAlignment(SwingConstants.CENTER);
	label_022.setBounds(84, 327, 46, 14);
	panel.add(label_022);
	
	JLabel label_023 = new JLabel("0");
	label_023.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_023.setHorizontalAlignment(SwingConstants.CENTER);
	label_023.setBounds(160, 327, 46, 14);
	panel.add(label_023);
	
	JLabel label_024 = new JLabel("0");
	label_024.setFont(new Font("Tahoma", Font.PLAIN, 15));
	label_024.setHorizontalAlignment(SwingConstants.CENTER);
	label_024.setBounds(224, 327, 46, 14);
	panel.add(label_024);
	setCheckButttonInvisible(false);
	setButtonList();
	
	
	
	
	
				//Create LabelList!!
	_labelList = new ArrayList<JLabel>();
	_labelList.add(label_001);_labelList.add(label_002);_labelList.add(label_003);_labelList.add(label_004);
	_labelList.add(label_005);_labelList.add(label_006);_labelList.add(label_007);_labelList.add(label_008);
	_labelList.add(label_009);_labelList.add(label_010);_labelList.add(label_011);_labelList.add(label_012);
	_labelList.add(label_013);_labelList.add(label_014);_labelList.add(label_015);_labelList.add(label_016);
	_labelList.add(label_017);_labelList.add(label_018);_labelList.add(label_019);_labelList.add(label_020);
	_labelList.add(label_021);_labelList.add(label_022);_labelList.add(label_023);_labelList.add(label_024);
	
	}
	
	
	




	//******************************************************************* Private Methodes ***********************************************************************
	/**
	 * Adds correct buttons to the list of buttons
	 * @author xingdita
	 */
	
	
	
	private void setButtonList(){
		_buttonList = new ArrayList<Button>();
		_buttonList.add(_bioButton);_buttonList.add(_chemButton);_buttonList.add(_mathButton);_buttonList.add(_phyButton);
		_buttonList.add(_musicButton);_buttonList.add(_danceButton);_buttonList.add(_theatreButton);_buttonList.add(_vaButton);
		_buttonList.add(_anesthButton);_buttonList.add(_otoButton);_buttonList.add(_pediaButton);_buttonList.add(_pathButton);
		_buttonList.add(_reliButton);_buttonList.add(_lingButton);_buttonList.add(_literButton);_buttonList.add(_historyButton);
		_buttonList.add(_electriButton);_buttonList.add(_mechButton);_buttonList.add(_compButton);_buttonList.add(_civilButton);
		_buttonList.add(_busButton);_buttonList.add(_crimButton);_buttonList.add(_ImmiButton);_buttonList.add(_familyButton);
	}
	
	private void btnNextClicked(){
		_gameState = Driver.getGameState();
		int step = _gameState.getStepInteger();
		if(step !=3){
			if(step==1){
				int newStudents = Driver.getGameState().getNumberOfNewStudents();
				Driver.getGameState().getTurnPlayer().addUnsignedStudent(newStudents);
				
					_gameState.toNextStep();
				
			}
			if(step==2){
				_gameState.toNextStep();
				this.setElectionButttonInvisible(true);
				this.setCheckButttonInvisible(true);
			}	
			this.setStep(_gameState.getStepString());
		}else{
			this.setElectionButttonInvisible(false);
			this.setCheckButttonInvisible(false);
			_gameState.toFirstStep();
			this.setStep(_gameState.getStepString());
			
				//change turn here;
			if(_gameState.getTurn()!=_gameState.getNumberOfPlayers()){
				_gameState.toNextTurn();
				Driver.getGameBoard().setMiniMap();
			}else{
				_gameState.toNextRound();
				Driver.getGameBoard().setMiniMap();
			}
			

		}
	}
	
//********************************************************************* Public Methods *******************************************************************
	
	/**
	 * Sets the name of the person who's turn it is to be displayed on the game board
	 * @param name
	 * @author xingdita
	 */
	public void setTurnName(String name){
		_turnNameLabel.setText(name);
	}
	
	/**
	 * Sets the step label on the game board
	 * @param s the String to be dislayed
	 * @author xingdita
	 */
	public void setStep(String s){
		_stepLB.setText(s);
	}
	
	/**
	 * Gets the pop up window where players are specified
	 * @param popupwindow
	 * @author xingdita
	 */
	public void getWindow(PlayersSetUpPopUpWindow popupwindow) {
		
		_window =popupwindow;
	}
	
	/**
	 * Sets the color displayed at each turn depending on who's turn it is
	 * @param stringColor the String representing the color to be displayed
	 * @author xingdita
	 */
	public void setTurnStringColor(String stringColor) {
		_stringColorLB.setText(stringColor);
		
	}
	
	/**
	 * 
	 * @param c
	 * @author xingdita
	 */
	public void setTurnColor(Color c) {
		_colorLB.setBackground(c);
	}
	
	/**
	 * Sets the number of students the player has when it is their turn to be displayed on the board
	 * @param i the int number of students that are loyal to the player who's turn it is
	 * @author xingdita
	 */
	public void setTurnStudentNumber(int i) {
		_studentNumberLB.setText(Integer.toString(i));
		
	}
	
	/**
	 * Sets the number of departments chaired by the player who's turn it is to be displayed to the board
	 * @param i the int number of departments chaired by the player who's turn it is
	 * @author xingdita
	 */
	public void setTurnDepartmentNumber(int i) {
		_departmentNumberLB.setText(Integer.toString(i));
	}
	
	/**
	 * Sets the number of departments that the person who's turn it is is dean of; to be displayed on board
	 * @param i the int number of schools that they person who's turn it is is dean of
	 * @author xingdita
	 */
	public void setTurnSchoolNumber(int i) {
		
		_schoolNumberLB.setText(Integer.toString(i));
		
	}
	
	/**
	 * @param i
	 * @return
	 * @author xingdita
	 */
	public Button getButton(int i){
		return _buttonList.get(i);
	}
	public void setElectionButttonInvisible(boolean b){
		btnElect.setVisible(b);
		btnElect.setEnabled(b);
	}
	
	public void setCheckButttonInvisible(boolean b) {
		
	}



	public void setNextButtonVisible(boolean b) {
		_btnNext.setEnabled(b);
		_btnNext.setVisible(b);
		
	}
	
	public  ArrayList<JLabel> getLabelList(){
		return  _labelList;
	}







	public void setMiniMap() {
		_gameState = Driver.getGameState();
		
		for(int i =0; i<24;i++){
			Department d = _gameState.getDepartmentList().get(i);
			this.getLabelList().get(i).setText(Integer.toString(d.getStudentNumberOf(_gameState.getTurnPlayer())));
		}
		
	}



////////////////////////////////////////////////////////////////////////////////////////////////


		//TRANSFER STUDENTS
	public void transferStudents(Department OriDpt, Department newDpt,int studentNumber) {
		Player p = Driver.getGameState().getTurnPlayer();
		if(p.isChairOf(OriDpt) && p.isChairOf(newDpt)){
				//Add students to newDpt
			newDpt.getButton().addStudents(studentNumber);
			newDpt.addStudentThatBelongsTo(p, studentNumber);
				//Decrease students in OriDpt
			OriDpt.getButton().decreaseStudents(studentNumber);
			OriDpt.decreaseStudentThatBelongsTo(p, studentNumber);
		}else if(p.isChairOf(OriDpt) && newDpt.getChair()==null){
				//Decrease students in OriDpt
			OriDpt.getButton().decreaseStudents(studentNumber);
			OriDpt.decreaseStudentThatBelongsTo(p, studentNumber);
				//Add students to newDpt
			newDpt.setChair(p);
			newDpt.addStudentThatBelongsTo(p, studentNumber);
			newDpt.getButton().addStudents(studentNumber);
			
			p.setDepartment(newDpt);
		}
		else if(p.isChairOf(OriDpt) && newDpt.getChair()!=p){
				//Decrease students in OriDpt
			OriDpt.getButton().decreaseStudents(studentNumber);
			OriDpt.decreaseStudentThatBelongsTo(p, studentNumber);
				//Add students to newDpt
			newDpt.addStudentThatBelongsTo(p, studentNumber);
		}
		else if(OriDpt.getChair()!=p && p.isChairOf(newDpt)){
				//Add students to newDpt
			newDpt.getButton().addStudents(studentNumber);
			newDpt.addStudentThatBelongsTo(p, studentNumber);
				//Decrease students in OriDpt
			OriDpt.decreaseStudentThatBelongsTo(p, studentNumber);
		}
		else if(OriDpt.getChair()!=p && newDpt.getChair()!=p){
				//Add students to newDpt
			newDpt.addStudentThatBelongsTo(p, studentNumber);
				//Decrease students in OriDpt
			OriDpt.decreaseStudentThatBelongsTo(p, studentNumber);
		}
		else if(OriDpt.getChair()!=p && newDpt.getChair()!=null){
				//Add students to newDpt
			newDpt.setChair(p);
			newDpt.getButton().addStudents(studentNumber);
			newDpt.addStudentThatBelongsTo(p, studentNumber);
			p.setDepartment(newDpt);
				//Decrease students in OriDpt
			OriDpt.decreaseStudentThatBelongsTo(p, studentNumber);
		}
		this.setMiniMap();
			//Display department number;
		Driver.getGameBoard().setTurnDepartmentNumber(p.getDepartmentNumber());
			//Display school number;
		if(newDpt.getSchool()==OriDpt.getSchool()){
			if(newDpt.getSchool().checkSchoolHasDean()){
				p.setSchool(newDpt.getSchool());
				Driver.getGameBoard().setTurnSchoolNumber(p.getSchoolNumber());
			}
			//CHECK WIN OR NOT.
		}
	}


}
