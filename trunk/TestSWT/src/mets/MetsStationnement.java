package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class MetsStationnement {

	public MetsStationnement(Composite parent, String recette, Messager messager) {
		
		Composite metsStationnement = new Composite(parent, 0);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		metsStationnement.setLayout(gridLayout);
		
		new MetsComposite(metsStationnement, recette, messager);
		/*new MetsComposite(this, "Poutine");
		new MetsComposite(this, "Steak");*/
		
		metsStationnement.pack();

		//initialize();
	}
}

