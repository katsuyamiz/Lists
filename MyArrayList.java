package collections.list;

import java.util.*;

// "generic" type <E> : Element
public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // <? extends E> -> any type that extends E
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            // grow (increases by 50%)
            elementData = grow(size + 1);
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    /*
    The maximum size of array to allocate.
    Attempts to allocate larger arrays "may" result in OutOfMemoryOrder
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * @param minCapacity the desired minimum capacity
     * @return
     */
    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity <= minCapacity) {
            if (minCapacity < 0 || minCapacity > MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("integer overflow");
            }
            return minCapacity;
        }
        return (newCapacity <= MAX_ARRAY_SIZE) ? newCapacity : Integer.MAX_VALUE;
    }

    @Override
    public boolean remove(Object o) {
        // TODO
        for (int i = 0; i < elementData.length; i++){
            if(elementData[i] == o){
                for(int j = i; j < elementData.length - 1; j++){
                    elementData[j] = elementData[j+1];
                }
                break;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO
        for(int i = 0; i < elementData.length; i ++){
            if(elementData[i] == c){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO
        boolean result = false;
        for (E e : c) {
            result |= add(e);
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO
        boolean changed = false;
        List<E> toAdd = new ArrayList<>();
        for (E e: c){
            if (contains(e)){
                continue;
            }
            add(e);
            toAdd.add(e);
            changed = true;
        }
        if(changed){
            addAll(index, toAdd);
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO
        boolean flag = true;
        for (Object obj: c){
            flag &= remove(obj);

        }        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO
        if (c == null){
            throw  new NullPointerException("collection is null");
        }
        Iterator itr = iterator();
        boolean found = false;
        while(itr.hasNext()){
            if(!c.contains(itr.next())){
                itr.remove();
                found = true;
            }
        }
        return found;
    }

    @Override
    public void clear() {
        // TODO
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        // TODO
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        add(element);

        for (int i = size - 1; i > index; i ++){
            elementData[i] = elementData[i - 1];
        }
   elementData[index] = element;
    }

    @Override
    public E remove(int index) {
        // TODO
        E element = get(index);
        for (int i = index; i <size-1; i ++){
            elementData[i] = elementData[i + 1];
        }
        size++;

        return element;
    }

    @Override
    public int indexOf(Object o) {
        // TODO
        for (int i = 0; i < size; i ++){
            if (o.equals(elementData[i])){
                return i;

            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO
        for (int i = size - 1; i >= 0; i ++){
            if(o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex){
            throw  new IndexOutOfBoundsException();
        }
         //E[] copy = Arrays.copyOfRange(elementData,fromIndex,toIndex);
        return null;//Arrays.asList(copy);
    }

}

