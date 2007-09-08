package composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import pojos.Messager;

import dominicm.alasoupe.ALaSoupe;

public class RepasComposite {

	private Composite parent;
	private Composite repasComposite;
	private Messager messager;

	public RepasComposite(Composite parent, Messager messager) {
		this.parent = parent;
		this.messager = messager;
		
		repasComposite = new Composite(parent, SWT.NONE);
		// repasComposite doit remplir l'espace du parent
/*		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		repasComposite.setLayoutData(gridData);
*/
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		
		// tous les enfants de repasComposite doivent remplir l'espace
		repasComposite.setLayout(gridLayout);
		
		


//		group1 = new Group(repasComposite, SWT.SHADOW_IN|SWT.TOP);
//		group1.setSize(100, 400);
//		//group1.setText("Repas");
//	    group1.setLayout(new RowLayout(SWT.VERTICAL));

	    
		repasComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_CYAN));
		

		tableRepas(repasComposite);

		
	    

		try {
			ALaSoupe aLaSoupe = ALaSoupe.getInstance();
//			Menu menu = aLaSoupe.getMenu();	  
//			Repas repas = menu.getRepas(ALaSoupe.stringToDate("2007-07-01"));
//			List<Mets> listeMets =  repas.getListMets();
//			for (Mets mets : listeMets) {
//				new MetsComposite(group1, mets);
//			}
		} catch (Exception e) {
			// TODO 5 géré l'erreur
			e.printStackTrace();
		}
	    //Repas repas = new RepasImpl();
	    
	    
	    //addBouton();
		
        repasComposite.pack();
        

	}

//	private void addBouton()
//	{
//		Button b = new Button(repasComposite, SWT.PUSH);
//	    b.setText("+");
//		b.setEnabled(true);
//		GridData g = new GridData();
//		g.heightHint = 14;
//		g.widthHint = 14;
//		b.setLayoutData(g);
//
//        b.addSelectionListener(
//        		new SelectionListener() 
//        		{
//		            public void widgetSelected(SelectionEvent event) {
//		              //text.setText("No problem");
//		            	System.out.println("hit ");
//		        	    System.out.println(repasComposite.getChildren().length);
//		            	addItem("patate frite");
//		        	    System.out.println(repasComposite.getChildren().length);
//
//		            }
//		
//					public void widgetDefaultSelected(SelectionEvent event) {
//		              //text.setText("No worries!");
//		            }
//		         }
//        		);
//	}
//
//    private void addItem(String nom) {
//    	new MetsComposite(repasComposite, nom, messager);
//    	repasComposite.redraw();
//    	repasComposite.pack();
//		parent.redraw();
//		parent.pack();
//	}

	private void tableRepas(Composite parent)
	{
		// Enable a table as a Drop Target
		final Table tableRepas = new Table(parent, SWT.BORDER|SWT.MULTI);
		//initTable(dropTable);
		
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = gridData.FILL;
		gridData.verticalAlignment = gridData.FILL;
		tableRepas.setLayoutData(gridData);

		messager.addRepas(tableRepas);

		// Allow data to be copied or moved to the drop target
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(tableRepas, operations);

		// Receive data in Text or File format
		final TextTransfer textTransfer = TextTransfer.getInstance();
		//final FileTransfer fileTransfer = FileTransfer.getInstance();
		//Transfer[]types = new Transfer[] { fileTransfer, textTransfer };
		Transfer[]types = new Transfer[] { textTransfer };
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener()
		{
			public void dragEnter(DropTargetEvent event)
			{/*
				if (event.detail == DND.DROP_DEFAULT)
				{
					if ((event.operations & DND.DROP_COPY) != 0)
					{
						event.detail = DND.DROP_COPY;
					}
					else
					{
						event.detail = DND.DROP_NONE;
					}
				}
				// will accept text but prefer to have files dropped
				for (int i = 0; i < event.dataTypes.length; i++)
				{
					if (fileTransfer.isSupportedType(event.dataTypes[i]))
					{
						event.currentDataType = event.dataTypes[i];
						// files should only be copied
						if (event.detail != DND.DROP_COPY)
						{
							event.detail = DND.DROP_NONE;
						}
						break;
					}
				}*/
			}

			public void dragOver(DropTargetEvent event)
			{
				System.out.print(".");
				/*
				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
				if (textTransfer.isSupportedType(event.currentDataType))
				{
					// NOTE: on unsupported platforms this will return null
					Object o = textTransfer.nativeToJava(event.currentDataType);
					String t = (String) o;
					if (t != null)
						System.out.println(t);
				}*/
			}

			public void dragOperationChanged(DropTargetEvent event)
			{/*
				if (event.detail == DND.DROP_DEFAULT)
				{
					if ((event.operations & DND.DROP_COPY) != 0)
					{
						event.detail = DND.DROP_COPY;
					}
					else
					{
						event.detail = DND.DROP_NONE;
					}
				}
				// allow text to be moved but files should only be copied
				if (fileTransfer.isSupportedType(event.currentDataType))
				{
					if (event.detail != DND.DROP_COPY)
					{
						event.detail = DND.DROP_NONE;
					}
				}*/
			}

			public void dragLeave(DropTargetEvent event)
			{
			}

			public void dropAccept(DropTargetEvent event)
			{
				// avant un drop
			}

			//
			public void drop(DropTargetEvent event)
			{
	 	          System.out.println(event.data + "!!!!");

				/*
				if (textTransfer.isSupportedType(event.currentDataType))
				{
					Recette recette = (Recette) event.data;
					String text = recette.getNom();
					TableItem item = new TableItem(tableRepas, SWT.NONE);
					String portion = messager.getPortionText().getText();
					//List
					//item.setData(data)
					item.setText(text + " (" + portion + ")");
					// FIXME fait planter lorsqu'on drop un control quand il y a déjà un control draggable à cet endroit.
					//addDraggable(item);
					
				}*/
				/*
				if (fileTransfer.isSupportedType(event.currentDataType))
				{
					String[] files = (String[]) event.data;
					for (int i = 0; i < files.length; i++)
					{
						TableItem item = new TableItem(tableRepas, SWT.NONE);
						item.setText(files[i]);
					}
				}*/
			}

//			private void addDraggable(final TableItem label)
//			//private void addDragable(final Label label)
//			{
//				Table table = label.getParent();
//				
//				// Allow data to be copied or moved from the drag source
//				int operations = DND.DROP_NONE; //DND.DROP_MOVE | DND.DROP_COPY;
//				DragSource source = new DragSource(table, operations);
//				
//				// Provide data in Text format
//				Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
//				source.setTransfer(types);
//				
//				source.addDragListener(new DragSourceListener() {
//					 	   public void dragStart(DragSourceEvent event) {
//					 	      // Only start the drag if there is actually text in the
//					 	      // label - this text will be what is dropped on the
//								// target.
//					 	      if (label.getText().length() == 0) {
//					 	          event.doit = false;
//					 	      }
//					 	   }
//					 	   public void dragSetData(DragSourceEvent event) {
//					 	     // Provide the data of the requested type.
//					 	     if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
//					 	          event.data = label.getText();
//					 	     }
//					 	   }
//					 	   public void dragFinished(DragSourceEvent event) {
//					 	     // If a move operation has been performed, remove the
//								// data
//					 	     // from the source
//						     if (event.detail == DND.DROP_MOVE){
//						    	 label.setText("f");
//						     }
//						   }
//						});
//			}

			
		});
	}

	
	private void initTable(final Table dropTable)
	{
		for (int i = 0; i < 10; i++)
		{
			TableItem item = new TableItem(dropTable, SWT.NONE);
			item.setText("item" + i);
		}
	}

}
