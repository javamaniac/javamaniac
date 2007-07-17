package mets;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import dominicm.alasoupe.ALaSoupe;
import dominicm.alasoupe.recettes.Recette;

public class Stationnement
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Stationnement.class);
	private Group group1;
	private Text text;
	private Composite stationnement;
	private Messager messager;

	public Stationnement(Messager messager)
	{
		// setLayout(new FillLayout());
		// setLayout(new RowLayout());
		this.messager = messager;
		
		Shell shell = messager.getShell();
		stationnement = new Composite(shell, 0);
		stationnement.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));

		group1 = new Group(stationnement, SWT.SHADOW_IN);
		group1.setText("Stationnement");
		group1.setLayout(new RowLayout(SWT.VERTICAL));

		createBoutonAjoutRecette();

		createListeRecettes(messager);

		group1.pack();
		stationnement.pack();

		// initialize();
	}

	private void createListeRecettes(Messager messager)
	{
		try
		{
			// TODO remplacer getCatalogueDeRecettes().getListRecettes() par
			// selection.getListRecettes()
			List<Recette> recettes = ALaSoupe.getInstance()
					.getCatalogueDeRecettes().getListRecettes();
			for (Recette recette : recettes)
			{
				new MetsStationnement(group1, recette.getNom(), messager);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createBoutonAjoutRecette()
	{
		Button ajoutRecette = new Button(group1, SWT.PUSH);
		ajoutRecette.setText("ajouter des recettes");
		ajoutRecette.addSelectionListener(new SelectionListener()
		{

			public void widgetSelected(SelectionEvent event)
			{
				ouvrirFenetre();
				//ouvrirFenetre2();
			}




			public void widgetDefaultSelected(SelectionEvent event)
			{
				// text.setText("No worries!");
			}
		});
	}
	
	private void ouvrirFenetre()
	{
		
		//final Shell shell = new Shell(Display.getCurrent().getActiveShell(), SWT.APPLICATION_MODAL|SWT.DIALOG_TRIM);

		//Display display = new Display();
		Shell sShell = new Shell(Display.getCurrent().getActiveShell(), SWT.APPLICATION_MODAL|SWT.DIALOG_TRIM);
		sShell.setText("Shell");
		//sShell.setSize(new Point(300, 200));
		sShell.setLayout(new GridLayout());
		//sShell.setLayout(new FillLayout());

		//sShell.setImage(new Image(display, "C:/wtools/Aptana/aptana.ico"));
		sShell.setText(" À la soupe!");

        sShell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_BLUE));
		
        text = new Text(sShell, 0);
		Button b = new Button(sShell, SWT.PUSH);
        b.setText("ajouter");
        b.addSelectionListener(new SelectionListener()
		{

			public void widgetSelected(SelectionEvent event)
			{
				ajoutRecette(text.getText());
			}


			public void widgetDefaultSelected(SelectionEvent event)
			{
				// text.setText("No worries!");
			}
		});
		
		sShell.pack();
		sShell.open();				
	}

	private void ouvrirFenetre2()
	{
		Shell shell = new Shell(Display.getCurrent());
		shell.setLayout(new FormLayout());
		shell.setText("Select Column Data");
//		Composite enfant = new Composite(shell, SWT.NONE); I don't know what it does!

		Label label = new Label(shell, SWT.NONE);
		label.setText("YOUPI");
		FormData formData = new FormData();
		formData.bottom = new FormAttachment(100,0);
		formData.top = new FormAttachment(0,0);
		formData.left = new FormAttachment(0,0);
		formData.right = new FormAttachment(100,0);
		label.setLayoutData(formData);

		shell.pack();
		shell.setLocation(200,200);
		shell.setSize(300,100); 
		shell.open();
	}

	private void ajoutRecette(String text)
	{
		new MetsStationnement(stationnement, text, messager);
		stationnement.pack();
	}



}