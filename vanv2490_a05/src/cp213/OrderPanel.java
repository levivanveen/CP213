package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterJob;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;


/**
 * The GUI for the Order class.
 *
 * @author Levi Van Veen
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2021-11-01
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
    private class PrintListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
	    final PrinterJob printJob = PrinterJob.getPrinterJob();
	    printJob.setPrintable(order);

	    if (printJob.printDialog()) {
		try {
		    printJob.print();
		} catch (final Exception printException) {
		    System.err.println(printException);
		}
	    }
	}
    }

    /**
     * Implements a FocusListener on a JTextField. Accepts only positive integers,
     * all other values are reset to 0. Adds a new MenuItem to the Order with the
     * new quantity, updates an existing MenuItem in the Order with the new
     * quantity, or removes the MenuItem from the Order if the resulting quantity is
     * 0.
     */
    private class QuantityListener implements FocusListener {

    	private int index = -1;
    	private String original = "";
    
    	
		@Override
		public void focusGained(final FocusEvent evt) {
			JTextField text = (JTextField) evt.getSource();
			this.index = items.indexOf(text);
			this.original = text.getText();
			text.setText("");
		}
	
		@Override
		public void focusLost(final FocusEvent evt) {
	
			JTextField text = (JTextField) evt.getSource();
			String entered = text.getText();
			int input = 0;
			
			if (entered.isBlank()) {
				text.setText(original);
			}
			else {
				try {
					input = Integer.parseInt(entered);
				}
				catch (NumberFormatException e) {
					System.out.println("Not a Number");
				}
				MenuItem food = menu.getItem(index);
				if (input > 0) {
					order.update(food, input);
				}
				else {
					input = 0;
					order.update(food, input);
					text.setText("0");
				}
				System.out.println("Item: " + food + "		Quantity:" + input);
				subtotalLabel.setText(String.format("$%,.2f", order.getSubTotal()));
				totalLabel.setText(String.format("$%,.2f", order.getTotal()));
				taxLabel.setText(String.format("$%,.2f", order.getTaxes()));
			}
		}
    }

    // Attributes
    private Menu menu = null;
    private final Order order = new Order();
    private final JButton printButton = new JButton("Print");
    private final JLabel subtotalLabel = new JLabel("$0.00");
    private final JLabel taxLabel = new JLabel("$0.00");
    private final JLabel totalLabel = new JLabel("$0.00");
	private List<JTextField> items = new ArrayList<JTextField>();    
	

    /**
     * Displays the menu in a GUI.
     *
     * @param menu The menu to display.
     */
    public OrderPanel(final Menu menu) {
	this.menu = menu;
	this.layoutView();
	}

    /**
     * Uses the GridLayout to place the labels and buttons.
     */
    private void layoutView() {
	this.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
	// Number of rows of GridLayout must be updated to accommodate all MenuItems,
	// totals, and Print button
	int size = menu.size();
	
	this.setLayout(new GridLayout(size + 5, 3));
	JPanel[][] panelHolder = new JPanel[size + 5][3];
	
	for(int m = 0; m < size + 5; m++) {
		for(int n = 0; n < 3; n++) {
			if (n == 0 && m > 0) {
				panelHolder[m][n] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			}
			else if (n == 2 && m > 0){
				panelHolder[m][n] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			}
			else if (n == 1 && m > 0) {
				panelHolder[m][n] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			}
			else {
				panelHolder[m][n] = new JPanel();
			}

		    this.add(panelHolder[m][n]);
		    if (m == 0) {
		    	panelHolder[m][n].setBorder(BorderFactory.createBevelBorder(0));
		    	panelHolder[m][n].setBackground(Color.YELLOW);
		    }
		}
	}
	JLabel item = new JLabel("Item");
	JLabel prices = new JLabel("Price");
	JLabel quantity = new JLabel("Quantity");
	

	
	panelHolder[0][0].add(item);
	panelHolder[0][1].add(prices);
	panelHolder[0][2].add(quantity);
	
	for (int i = 1; i <= size; i++) {
		panelHolder[i][0].add(new JLabel(menu.getItem(i - 1).getName()));
		
		String price = String.format("$%,.2f", menu.getItem(i - 1).getPrice());	
		panelHolder[i][1].add(new JLabel(price));
	
		JTextField text = new JTextField("0", 5);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.addFocusListener(new QuantityListener());

		items.add(text);

		panelHolder[i][2].add(text);
	}
	
	panelHolder[size + 1][0].add(new JLabel ("Subtotal:"));
	panelHolder[size + 2][0].add(new JLabel ("Tax:"));
	panelHolder[size + 3][0].add(new JLabel ("Total:"));
	panelHolder[size + 1][2].add(subtotalLabel);
	panelHolder[size + 2][2].add(taxLabel);
	panelHolder[size + 3][2].add(totalLabel);
	

	// Register listeners here


	// Register the PrinterListener with the print button.
	this.printButton.addActionListener(new PrintListener());
	panelHolder[size + 4][1].add(this.printButton);
	return;
    }
}