package dominicm.alasoupe.gui;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import dominicm.alasoupe.recettes.Recette;

public class MetsComposite {

	private Button recette = null;  // @jve:decl-index=0:visual-constraint="17,18"

	public MetsComposite(Composite parent, Recette recette, Messager messager) {
		
		// setSize(new Point(300, 10));

		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 1;
		parent.setLayout(gridLayout);

		//Button recette = new Button(this, SWT.CHECK);
		//recette.setText(nom);
		
		final Label label = new Label(parent, 0);
		label.setText(recette.getNom());
		
		addDragable(label);
		
		
		// recette.setSize(300, 10);
		// recette.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
	}

	private void addDragable(final Label label)
	{
		// Allow data to be copied or moved from the drag source
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		DragSource source = new DragSource(label, operations);
		
		// Provide data in Text format
		Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
		source.setTransfer(types);
		
		source.addDragListener(new DragSourceListener() {
			
				
			 	   public void dragStart(DragSourceEvent event) {
			 	      // Only start the drag if there is actually text in the
			 	      // label - this text will be what is dropped on the
						// target.
			 	      if (label.getText().length() == 0) {
			 	          event.doit = false;
			 	      }
			 	   }
			 	   
			 	   // information à transférer
			 	   public void dragSetData(DragSourceEvent event) {
			 	     // Provide the data of the requested type.
			 	     if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
			 	          event.data = label.getText();
			 	     }
			 	   }
			 	   
			 	   // 
			 	   public void dragFinished(DragSourceEvent event) {
			 	     // If a move operation has been performed, remove the data from the source
				     /*if (event.detail == DND.DROP_MOVE){
				    	 // changement de l'etiquette draggé
				    	 label.setText("-" + label.getText());
				    	 label.pack();
				     }*/
				   }
				});
	}


}
