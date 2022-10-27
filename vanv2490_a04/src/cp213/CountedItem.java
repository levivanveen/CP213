package cp213;

/**
 * Stores a item and an occurrence count for that item.
 *
 * @author David Brown
 * @version 2021-11-01
 */
public class CountedItem<T extends Comparable<T>> {

    // Attributes.
    private int count = 0; // item count
    private T item = null; // item

    /**
     * Copy constructor.
     *
     * @param source Another CountedCharacter object.
     */
    public CountedItem(final CountedItem<T> source) {
	this.item = source.item;
	this.count = source.count;
    }

    /**
     * Constructor for key version of object. (item count defaults to 0)
     *
     * @param item The item to be counted.
     */
    public CountedItem(final T item) {
	this.item = item;
    }

    /**
     * Constructor.
     *
     * @param item  The item to be counted.
     * @param count The item count.
     */
    public CountedItem(final T item, final int count) {
	this.item = item;
	this.count = count;
    }

    /**
     * Comparison method.
     *
     * @param target Object to compare against.
     * @return less than 0 if this item comes before target item, greater than 0 if
     *         this item comes after target item, 0 if the values are the same.
     */
    public int compareTo(final CountedItem<T> target) {
	return this.item.compareTo(target.item);
    }

    /**
     * Decrements the item count.
     */
    public void decrementCount() {
	this.count--;
    }

    /**
     * Returns this item count.
     *
     * @return this item count.
     */
    public int getCount() {
	return this.count;
    }

    /**
     * Returns this item.
     *
     * @return this item.
     */
    public T getItem() {
	return this.item;
    }

    /**
     * Increments the item count.
     */
    public void incrementCount() {
	this.count++;
    }

    /**
     * Sets the item count.
     *
     * @param count the new item count.
     */
    public void setCount(final int count) {
	this.count = count;
	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "{" + this.item + ": " + this.count + "}";
    }

}
