package mets;

import org.apache.log4j.Logger;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class Boutons
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Boutons.class);

	protected static final int BACKSPACE = 8;
	protected static final int DELETE = 127;
	private Messager messager;

	public Boutons(Messager messager)
	{
		this.messager = messager;
		Shell shell = messager.getShell();

		Composite boutons = new Composite(shell, 0);
		boutons.setLayout(new FillLayout());

		createBoutonSupprimer(boutons);
		createBoutonAutre(boutons);
		createNbPortion(boutons);

	}

	private void createNbPortion(Composite boutons)
	{
		Label etiquette = new Label(boutons, SWT.NONE);
		etiquette.setText("Nombre de portion : ");

		Text text = new Text(boutons, SWT.NONE);
		text.setText("2");
		messager.setPortionText(text);

		text.addVerifyListener(new VerifyListener()
		{
			public void verifyText(VerifyEvent e)
			{
				
				if (e.keyCode >= 48 && e.keyCode <= 57)
				{
					e.doit = true;
				}
				else if (e.keyCode == BACKSPACE) 
				{
					e.doit = true;
				}
				else if (e.keyCode == DELETE) 
				{
					e.doit = true;
				}
				else
				{
					e.doit = false;
					logger.info("KeyCode = " + e.keyCode + " (" + e.text + ")");
				}
			}
		});
	}

	private void createBoutonAutre(Composite boutons)
	{
		Button autre = new Button(boutons, SWT.PUSH);
		autre.setText("Autre");
	}

	private void createBoutonSupprimer(Composite boutons)
	{
		Button supprimer = new Button(boutons, SWT.PUSH);
		supprimer.setText("Supprimer");
		supprimer.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent event)
			{
				suppressionRepas();
			}

			public void widgetDefaultSelected(SelectionEvent event)
			{
				// text.setText("No worries!");
			}
		});
		messager.setBoutonSupprimer(supprimer);
	}

	private void suppressionRepas()
	{
		List<Table> repass = messager.getRepas();

		// TODO ajouter un message "Voulez-vous supprimer 4 mets?"
		for (Table repas : repass)
		{
			TableItem[] metss = repas.getSelection();
			for (TableItem mets : metss)
			{
				mets.dispose();
			}
		}
	}

}
