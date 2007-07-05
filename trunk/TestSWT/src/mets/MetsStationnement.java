package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class MetsStationnement extends Composite {

	public MetsStationnement(Composite parent) {
		super(parent, SWT.None);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		setLayout(gridLayout);
		
		new MetsComposite(this, "Club Sandwich");
		new MetsComposite(this, "Poutine");
		new MetsComposite(this, "Steak");
		
		pack();

		//initialize();
	}
}

