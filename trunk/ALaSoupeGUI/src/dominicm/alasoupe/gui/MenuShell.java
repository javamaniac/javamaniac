package dominicm.alasoupe.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import dominicm.alasoupe.gui.pojos.Messager;
import dominicm.alasoupe.gui.zones.ZoneDeControle;
import dominicm.alasoupe.gui.zones.ZoneDeStationnement;
import dominicm.alasoupe.gui.zones.ZoneMenuDeLaSemaine;



/**
 * Fenêtre principal du logiciel.
 * Création de la fenêtre avec le logo et le nom du programme.
 * 
 * @author Dominic
 *
 */
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
	
		// Définition de l'icone et du nom de la fenetre
		sShell.setImage(new Image(messager.getDisplay(), "C:/wtools/Aptana/aptana.ico"));
		sShell.setText(" À la soupe!");
	
		// définition de la couleur de fond de la fenetre
		sShell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE));
	

		// composition de la fenetre
		// menu
		new ZoneMenuDeLaSemaine(messager);
		// boutons
		new ZoneDeControle(messager);
		// stationnement
		new ZoneDeStationnement(messager);
	
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
