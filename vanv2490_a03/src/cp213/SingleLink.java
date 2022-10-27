package cp213;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The abstract base class for singly-linked data structures. Provides
 * attributes and implementations for getLength, peek, isEmpty, append,
 * moveFrontToRear, moveFrontToFront, and iterator methods.
 *
 * @author David Brown
 * @version 2021-09-24
 * @param <T> data type for structure.
 */
public abstract class SingleLink<T> implements Iterable<T> {

    /**
     * Creates an Iterator for the outer class. An iterator allows a program to walk
     * through the values in a data structure by using the hasNext and next methods.
     * Typical code:
     *
     * <pre>
    Iterator&lt;T&gt; iter = dataStructure.iterator();

    while(iter.hasNext()){
        T data = iter.next();
        ...
    }
     * </pre>
     *
     * It also allows the user of the enhanced for loop:
     *
     * <pre>
    for(T data : dataStructure){
        ...
    }
     * </pre>
     *
     * (Replace T with a concrete class such as String or Integer.)
     */
    private class SingleLinkIterator implements Iterator<T> {
	/**
	 * current is initialized to beginning of linked structure.
	 */
	private SingleNode<T> current = SingleLink.this.front;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
	    return this.current != null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {
	    T result = null;

	    if (this.current == null) {
		throw new NoSuchElementException();
	    } else {
		result = this.current.getData();
		this.current = this.current.getNext();
	    }
	    return result;
	}
    }

    /**
     * First node of linked structure.
     */
    protected SingleNode<T> front = null;
    /**
     * Number of values currently stored in linked structure.
     */
    protected int length = 0;
    /**
     * Last node of linked structure.
     */
    protected SingleNode<T> rear = null;

    /**
     * Protected helper method to append the entire source to the rear of this.
     * source becomes empty. O(1) operation - must not use loops. source must
     * contain at least one node, or the method throws an AssertionError.
     *
     * @param source the nodes to append to the end of this.
     */
    protected void append(final SingleLink<T> source) {
	assert source.front != null : "Cannot append an empty source";

	// Update this.
	if (this.front == null) {
	    // this is empty.
	    this.front = source.front;
	} else {
	    // Add source to rear of this.
	    this.rear.setNext(source.front);
	}
	this.rear = source.rear;
	this.length += source.length;
	// Empty source.
	source.front = null;
	source.rear = null;
	source.length = 0;
	return;
    }

    /**
     * Protected helper method to move the front node of source to the front of
     * this. All front, rear, and length attributes are appropriately updated in
     * both SingleLink objects. O(1) operation - must not use loops. source must
     * contain at least one node, or the method throws an AssertionError.
     *
     * @param source The SingleLink to extract the front node from.
     */
    protected void moveFrontToFront(final SingleLink<T> source) {
	assert source.front != null : "Cannot move nodes from an empty source";

	final SingleNode<T> node = source.front;
	// Update source.
	source.length--;
	source.front = source.front.getNext();

	if (source.front == null) {
	    // Clean up source if empty.
	    source.rear = null;
	}
	node.setNext(this.front);

	// Update this.
	if (this.rear == null) {
	    this.rear = node;
	}
	this.front = node;
	this.length++;
	return;
    }

    /**
     * Protected helper method to move the front node of source to the rear of this.
     * All front, rear, and length attributes are appropriately updated in both
     * SingleLink objects. O(1) operation - must not use loops. source must contain
     * at least one node, or the method throws an AssertionError.
     *
     * @param source The SingleLink to extract the front node from.
     */
    protected void moveFrontToRear(final SingleLink<T> source) {
	assert source.front != null : "Cannot move nodes from an empty source";

	final SingleNode<T> node = source.front;
	// Update source.
	source.length--;
	source.front = source.front.getNext();

	if (source.front == null) {
	    // Clean up source if empty.
	    source.rear = null;
	}
	node.setNext(null);

	// Update this.
	if (this.rear == null) {
	    this.front = node;
	} else {
	    this.rear.setNext(node);
	}
	this.rear = node;
	this.length++;
	return;
    }

    /**
     * Returns the current number of values in the linked structure.
     *
     * @return the value of length.
     */
    public final int getLength() {
	return this.length;
    }

    /**
     * Determines whether the linked data structure is empty or not.
     *
     * @return true if data structure is empty, false otherwise.
     */
    public final boolean isEmpty() {
	return this.front == null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public final Iterator<T> iterator() {
	return new SingleLinkIterator();
    }

    /**
     * Returns a reference to the first value of the linked structure without
     * removing that value from the structure.
     *
     * @return The value in the front of the structure.
     */
    public final T peek() {
	return this.front.getData();
    }
}
