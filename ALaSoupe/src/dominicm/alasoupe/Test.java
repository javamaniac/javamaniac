package dominicm.alasoupe;

	import javax.swing.text.html.ListView;

import org.eclipse.swt.widgets.*;
	import org.eclipse.swt.graphics.*;
	import org.eclipse.swt.layout.*;
import org.eclipse.swt.*;

	public class Test {

	  public static void centrerSurEcran(Display display, Shell shell) {
	    Rectangle rect = display.getClientArea();
	    Point size = shell.getSize();
	    int x = (rect.width - size.x) / 2;
	    int y = (rect.height - size.y) / 2;
	    shell.setLocation(new Point(x, y));
	  }
	  
	  public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setSize(340, 100);
	    centrerSurEcran(display, shell);

	    shell.setText("Hello world!");
	    
//	    Canvas canvas = new Canvas(shell, SWT.NONE);
//	    canvas.setSize(200,200);
//	    canvas.setLocation(10,10);
//	    Button button = new Button(canvas, SWT.CHECK);
//	    
//	    Label label = new Label(shell, SWT.NONE);
//	    label.setText("Bonjour");
//	    label.setLocation(10, 10);
//	    shell.pack();
//	    shell.open();
	    
	    //Font font = new Font(display, "Arial", 16, SWT.ITALIC);
	    Label label = new Label(shell, SWT.NONE);
	    //label.setFont(font);
	    label.setText("Bonjour");
	    label.setLocation(10, 10);
	    label.pack();
	    shell.setSize(100, 100);
	    
	    // création d'un bouton
	    Button button = new Button(shell, SWT.CHECK);
	    button.setLocation(50, 10);
	    button.setText("bouton");
	    button.pack();
	    
	    ListView listeView = new ListView(shell);
	    listViewer.setContentProvider(null);
//	    new IStructuredContentProvider() {
//	        public Object[] getElements(Object inputElement) {
//	          Vector v = (Vector)inputElement;
//	          return v.toArray();
//	        }
//	        public void dispose() {
//	          System.out.println("Disposing ...");
//	        }
//
//	        public void inputChanged(
//	          Viewer viewer,
//	          Object oldInput,
//	          Object newInput) {
//	          System.out.println("Input changed: old=" + oldInput + ", new=" + newInput);
//	        }
//	      });
//	      

	    shell.open();	    
	    
	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch()) 
    		{
	    		display.sleep();
    		}
	    }
	    
	    display.dispose();	  
	  }
	  

	}

