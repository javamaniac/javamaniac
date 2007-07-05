package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class MetsComposite extends Composite {

	private Button recette = null;  //  @jve:decl-index=0:visual-constraint="17,18"

	public MetsComposite(Composite parent, String nom) {
		super(parent, 0);
		initialize(nom);
	}

	private void initialize(String nom) {
		//setSize(new Point(300, 10));

		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 1;
		setLayout(gridLayout);

		Button recette = new Button(this, SWT.CHECK);
		recette.setText(nom);
		//recette.setSize(300, 10);
		//recette.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
	}


}
