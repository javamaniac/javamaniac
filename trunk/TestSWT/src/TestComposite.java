import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.SashForm;

public class TestComposite extends Composite {

	private SashForm sashForm = null;  //  @jve:decl-index=0:visual-constraint="44,30"

	public TestComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setSize(new Point(300, 200));
		setLayout(new GridLayout());
	}


}
