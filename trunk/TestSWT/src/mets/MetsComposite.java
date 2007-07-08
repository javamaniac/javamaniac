package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class MetsComposite extends Composite {

	private Button recette = null;  // @jve:decl-index=0:visual-constraint="17,18"

	public MetsComposite(Composite parent, String nom) {
		super(parent, 0);
		initialize(nom);
	}

	private void initialize(String nom) {
		// setSize(new Point(300, 10));

		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 1;
		setLayout(gridLayout);

		//Button recette = new Button(this, SWT.CHECK);
		//recette.setText(nom);
		
		final Label label = new Label(this, 0);
		label.setText(nom);
		
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
			 	   public void dragSetData(DragSourceEvent event) {
			 	     // Provide the data of the requested type.
			 	     if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
			 	          event.data = label.getText();
			 	     }
			 	   }
			 	   public void dragFinished(DragSourceEvent event) {
			 	     // If a move operation has been performed, remove the
						// data
			 	     // from the source
				     if (event.detail == DND.DROP_MOVE){
				    	 label.setText("f");
				     }
				   }
				});
		
		
		// recette.setSize(300, 10);
		// recette.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
	}


}
