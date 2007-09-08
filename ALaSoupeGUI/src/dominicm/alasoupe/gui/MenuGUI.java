package dominicm.alasoupe.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import pojos.Messager;

/**
 * Programme principal en mode graphique.
 * Ce programme appel MenuShell.
 * @author Dominic
 */
public class MenuGUI
{

	private Shell sShell = null; // @jve:decl-index=0:

	/**
	 * This method initializes sShell
	 */
	public MenuGUI()
	{
		Display display = new Display();
		
		Messager messager = new Messager(display);
		
		new MenuShell(messager);
	}

	public static void main(String args[])
	{
		new MenuGUI();
		
	}

}
