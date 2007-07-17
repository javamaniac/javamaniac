package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MenuShell
{
	
	public MenuShell(Messager messager)
	{
		Shell sShell = new Shell(messager.getDisplay());
		messager.setShell(sShell);
		sShell.setText("Shell");
		GridLayout gridLayout = new GridLayout();
		// sShell.setSize(new Point(300, 200));
		sShell.setLayout(gridLayout);
	
		sShell.setImage(new Image(messager.getDisplay(), "C:/wtools/Aptana/aptana.ico"));
		sShell.setText(" À la soupe!");
	
		sShell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE));
	

		new MenuComposite(messager);
		new Boutons(messager);
		new Stationnement(messager);
	
		sShell.pack();


		
		sShell.open();
		Display display = messager.getDisplay();
		while (!sShell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		
	
		// Button b = new Button(sShell, SWT.CHECK);
		// b.setText("test");
		// b.pack();
	}
	

}
