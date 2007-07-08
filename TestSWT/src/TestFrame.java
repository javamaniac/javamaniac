import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class TestFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private Button checkBox = null;  //  @jve:decl-index=0:visual-constraint="425,170"

	/**
	 * This is the default constructor
	 */
	public TestFrame() {
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
		}
		return jContentPane;
	}

	/**
	 * This method initializes checkBox	
	 * 	
	 * @return org.eclipse.swt.widgets.Button	
	 */    
	private Button getCheckBox() {
		if (checkBox == null) {
			checkBox = new Button({parentComposite}, SWT.CHECK);
		}
		return checkBox;
	}

}
