import java.util.*;

public class HeapifyMin {

    int[] items;
    int size;

    HeapifyMin(int[] items) {
        this.items = items;
        this.size = items.length; // Initialize size correctly
    }

    public static void main(String[] args) {
        HeapifyMin heap = new HeapifyMin(new int[]{10, 15, 20, 17});
        System.out.println("Heap Before:");
        heap.printHeap();
        heap.push(21);
        System.out.println("Heap After:" );
        heap.printHeap();
    }

    private void printHeap(){
        for(int i=0;i<this.size;i++){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    private void ensureCapacity() {
        if (items.length < size + 1) {
            int[] itemsTemp = new int[2 * items.length];
            for (int i = 0; i < size; i++) {
                itemsTemp[i] = items[i];
            }
            items = itemsTemp;
        }
    }

    public void swap(int index1, int index2) {
        int temp = this.items[index1];
        this.items[index1] = this.items[index2];
        this.items[index2] = temp;
    }

    public void push(int item) {
        ensureCapacity();
        this.items[size] = item;
        size++;
        heapifyUp();
    }

    public int poll() {
        int temp = items[0];
        swap(0, size - 1);
        size--;
        heapifyDown();
        return temp;
    }

    private boolean hasParent(int index) {
        // In a min heap implementation, parent is supposed to be in (index - 1) / 2 position
        int parentIndex = getParentIndex(index);
        if (parentIndex < 0) {
            return false;
        }
        return true;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasRightChildren(int index) {
        // In a min heap implementation, right children are supposed to be in (index * 2) + 1 position
        if (getRightChildIndex(index) >= size) {
            return false;
        }
        return true;
    }

    private int getRightChildIndex(int index){
        int rightChildIndex = (index * 2) + 2;
        return rightChildIndex;
    }

    private boolean hasLeftChildren(int index) {
        // In a min heap implementation, left children are supposed to be in (index * 2) + 1 position
        if (getLeftChildIndex(index) >= size) {
            return false;
        }
        return true;
    }

    private int getLeftChildIndex(int index) {
        int leftChildIndex = (index * 2) + 1;
        return leftChildIndex;
    }

    private void heapifyDown() {
        // Will start from first index so
        int index = 0;
        while (hasLeftChildren(index)) {
            int smallestIndex = getLeftChildIndex(index);
            if (hasRightChildren(index) && items[getRightChildIndex(index)] < items[smallestIndex]) {
                smallestIndex = getRightChildIndex(index);
            }
            if (items[smallestIndex] < items[index]) {
                swap(smallestIndex, index);
                index = smallestIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyUp() {
        // Will start from last index so
        int index = size - 1;
        while (hasParent(index) && items[getParentIndex(index)] > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}