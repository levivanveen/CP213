package cp213;

import java.awt.Font;
import java.math.RoundingMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores a HashMap of MenuItem objects and the quantity of each MenuItem
 * ordered. Each MenuItem may appear only once in the HashMap.
 *
 * @author Levi Van Veen
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2021-11-01
 */
public class Order implements Printable {

    /**
     * The current tax rate on menu items.
     */
    public static final BigDecimal TAX_RATE = new BigDecimal(0.13);
    private Map<MenuItem, Integer> items = new HashMap<MenuItem, Integer>();

    /**
     * Update the quantity of a particular MenuItem in an order.
     *
     * @param item     The MenuItem to purchase - the HashMap key.
     * @param quantity The number of the MenuItem to purchase - the HashMap value.
     */
    public void add(MenuItem item, int quantity) {
    	int number = 0;
    	if (this.items.containsKey(item))
    		 number = this.items.get(item);
    	
    	this.items.put(item, quantity + number);
    }

    /**
     * Calculates the total value of all MenuItems and their quantities in the
     * HashMap.
     *
     * @return the total price for the MenuItems ordered.
     */
    public BigDecimal getSubTotal() {
    BigDecimal subTotal = new BigDecimal ((double) 0);
    
	for (Map.Entry<MenuItem, Integer> entry : this.items.entrySet()) {
		MenuItem item = entry.getKey();
		Integer value = entry.getValue();
		
		BigDecimal price = item.getPrice();		
		price = price.multiply(new BigDecimal ((double)value));
		subTotal = subTotal.add(price);
	}
	return subTotal;
    }

    /**
     * Calculates and returns the total taxes to apply to the subtotal of all
     * MenuItems in the order. Tax rate is TAX_RATE.
     *
     * @return total taxes on all MenuItems
     */
    public BigDecimal getTaxes() {
    	BigDecimal taxes = new BigDecimal ((double) 0);
    	taxes = taxes.add(getSubTotal().multiply(TAX_RATE));
	return taxes;
    }

    /**
     * Calculates and returns the total price of all MenuItems order, including tax.
     *
     * @return total price
     */
    public BigDecimal getTotal() {
	return getSubTotal().add(getTaxes());
    }

    /**
     * Returns a String version of a receipt for all the MenuItems in the order.
     */
    @Override
    public String toString() {
    	String receipt = "";
    	for (Map.Entry<MenuItem, Integer> entry : this.items.entrySet()) {
    		MenuItem item = entry.getKey();
    		Integer value = entry.getValue();
    		BigDecimal cost = item.getPrice().multiply(new BigDecimal ((double) value));
    		
    		receipt = receipt + String.format("%-13s %d @ $%,6.2f = $%,6.2f\n", item.getName(), value, item.getPrice(), cost);
    	}
//    	receipt = receipt + "\nSubtotal:                    $" + 
//    	String.format("%,6.2f", getSubTotal().setScale(2, RoundingMode.HALF_EVEN)) + "\n";
//    	
//    	receipt = receipt + "Taxes:                       $" + 
//    	String.format("%,6.2f", getTaxes().setScale(2, RoundingMode.HALF_EVEN)) + "\n";
//    	
//    	receipt = receipt + "Total:                       $" + 
//    	String.format("%,6.2f", getTotal().setScale(2, RoundingMode.HALF_EVEN)) + "\n";
    	receipt = receipt + "\nSubtotal:                   $" + String.format("%,6.2f", this.getSubTotal()) + "\n";
    	    	
    	receipt = receipt + "Taxes:                      $" + String.format("%,6.2f", this.getTaxes()) + "\n";
    	    	
    	receipt = receipt + "Total:                      $" + String.format("%,6.2f", this.getTotal()) + "\n";
    	
	return receipt;
    }

    /**
     * Replaces the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added. If quantity is 0
     * or negative, the MenuItem is removed from the Order.
     *
     * @param item The MenuItem to update
     * @param quantity The quantity to apply to item
     */
    public void update(MenuItem item, int quantity) {
    	if (quantity <= 0) {
    		this.items.remove(item);
    	}
    	else
    		this.items.put(item, quantity);
    }

    /*
     * Implements the Printable interface print method. Prints lines to a Graphics2D
     * object using the drawString method. Prints the current contents of the Order.
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	int result = PAGE_EXISTS;

	if (pageIndex == 0) {
	    Graphics2D g2d = (Graphics2D) graphics;
	    g2d.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

	    String receipt = this.toString();
	    
	    int y = 100;
	    for (String line : receipt.split("\n")) {
	    	g2d.drawString(line, 100, y);
	    	y = y + 24;
	    }

	} else {
	    result = NO_SUCH_PAGE;
	}
	return result;
    }
}