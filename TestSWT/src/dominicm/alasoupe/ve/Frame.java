package dominicm.alasoupe.ve;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.GridBagLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.*;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JList stationnement = null;

	private JPanel jPanel = null;

	/**
	 * This is the default constructor
	 */
	public Frame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		
		Shell shell = new Shell(display, SWT.CLOSE | SWT.RESIZE);
		shell.setSize(200, 100);
		shell.setText("test");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getStationnement(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel(), BorderLayout.WEST);

			
		}
		return jContentPane;
	}

	/**
	 * This method initializes stationnement	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getStationnement() {
		if (stationnement == null) {
			stationnement = new JList();
			DefaultListModel model = new DefaultListModel();
			model.addElement("ddd");
			model.addElement("ddd2");
			model.addElement("ddd3");
			stationnement.setModel(model);

		}
		return stationnement;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
		}
		return jPanel;
	}

}
