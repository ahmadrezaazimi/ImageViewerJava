package Wrapper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageViewerFrame extends JFrame {
	public ImageViewerFrame() {
		setTitle("Image Viewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//set label
		label = new JLabel();
		add(label);
		
		// set current dir and file
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		// set up Menu Bar 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//set menu items and lists
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(path));
				}
			}
		});
		
		// add exit menu item, 
		JMenuItem exitItem = new JMenuItem("Exit");
		menuBar.add(exitItem);
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
	}
	
	
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;
}
