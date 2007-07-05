package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class LabelMenuComposite {

	public LabelMenuComposite(Composite parent, String nom) {
		//super(parent, style);
		
		Label l = new Label(parent, SWT.NONE);
		l.setText(nom);
		//pack();
		
		//initialize(nom);
	}

	private void initialize(String nom) {
		//setSize(new Point(300, 200));

		
		//setLayout(new GridLayout());
		//setLayout(new FillLayout());
		//setLayout(new RowLayout());

	}


}
