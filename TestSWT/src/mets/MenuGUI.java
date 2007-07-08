package mets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class MenuGUI
{

	private Shell sShell = null; // @jve:decl-index=0:

	/**
	 * This method initializes sShell
	 */
	private void createSShell()
	{
		Display display = new Display();
		sShell = new Shell(display);
		sShell.setText("Shell");
		// sShell.setSize(new Point(300, 200));
		sShell.setLayout(new GridLayout());
		// sShell.setLayout(new FillLayout());

		sShell.setImage(new Image(display, "C:/wtools/Aptana/aptana.ico"));
		sShell.setText(" � la soupe!");

		sShell.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_DARK_BLUE));

		dropTarget(sShell);

		new MenuComposite(sShell, 0);
		//new Stationnement(sShell, 0);

		sShell.pack();

		// Button b = new Button(sShell, SWT.CHECK);
		// b.setText("test");
		// b.pack();
	}

	private void dropTarget(Shell shell)
	{
		// Enable a table as a Drop Target
		final Table dropTable = new Table(shell, SWT.BORDER);
		for (int i = 0; i < 10; i++)
		{
			//TableItem item = new TableItem(dropTable, SWT.NONE);
			//item.setText("item" + i);
		}

		// Allow data to be copied or moved to the drop target
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(dropTable, operations);

		// Receive data in Text or File format
		final TextTransfer textTransfer = TextTransfer.getInstance();
		final FileTransfer fileTransfer = FileTransfer.getInstance();
		Transfer[]types = new Transfer[]
		{ fileTransfer, textTransfer };
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener()
		{
			public void dragEnter(DropTargetEvent event)
			{
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
				}
			}

			public void dragOver(DropTargetEvent event)
			{
				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
				if (textTransfer.isSupportedType(event.currentDataType))
				{
					// NOTE: on unsupported platforms this will return null
					Object o = textTransfer.nativeToJava(event.currentDataType);
					String t = (String) o;
					if (t != null)
						System.out.println(t);
				}
			}

			public void dragOperationChanged(DropTargetEvent event)
			{
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
				}
			}

			public void dragLeave(DropTargetEvent event)
			{
			}

			public void dropAccept(DropTargetEvent event)
			{
			}

			public void drop(DropTargetEvent event)
			{
				if (textTransfer.isSupportedType(event.currentDataType))
				{
					String text = (String) event.data;
					TableItem item = new TableItem(dropTable, SWT.NONE);
					item.setText(text);
				}
				if (fileTransfer.isSupportedType(event.currentDataType))
				{
					String[] files = (String[]) event.data;
					for (int i = 0; i < files.length; i++)
					{
						TableItem item = new TableItem(dropTable, SWT.NONE);
						item.setText(files[i]);
					}
				}
			}
		});
	}

}
