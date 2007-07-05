package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;

public class MenuShell {

	private Shell sShell = null;  //  @jve:decl-index=0:

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		Display display = new Display();
		sShell = new Shell(display);
		sShell.setText("Shell");
		//sShell.setSize(new Point(300, 200));
		sShell.setLayout(new GridLayout());
		//sShell.setLayout(new FillLayout());

		sShell.setImage(new Image(display, "C:/wtools/Aptana/aptana.ico"));
		sShell.setText(" À la soupe!");

        sShell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE));
		

		
		new MenuComposite(sShell, 0);
		new Stationnement(sShell, 0);
		
		sShell.pack();
		
//		Button b = new Button(sShell, SWT.CHECK);
//		b.setText("test");
//		b.pack();
	}

}
