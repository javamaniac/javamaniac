package pojos;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class Messager
{

	private Display display;
	private Shell shell;
	private List<Table> repas = new ArrayList<Table>();
	private Button supprimer;
	private Text portionText;

	public Messager(Display display)
	{
		this.display = display;
	}

	public Display getDisplay()
	{
		return display;
	}

	public void setDisplay(Display display)
	{
		this.display = display;
	}

	public Shell getShell()
	{
		return shell;
	}

	public void setShell(Shell shell)
	{
		this.shell = shell;
	}

	public void addRepas(Table repasComposite)
	{
		repas.add(repasComposite);
	}

	public List<Table> getRepas()
	{
		return repas;
	}

	public void setBoutonSupprimer(Button supprimer)
	{
		this.supprimer = supprimer;
	}

	public Button getSupprimer()
	{
		return supprimer;
	}

	public void setPortionText(Text text)
	{
		portionText = text;
	}

	public Text getPortionText()
	{
		return portionText;
	}
	

}
