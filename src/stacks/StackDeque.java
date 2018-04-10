package stacks;

public class StackDeque {
    Deque deque;

    StackDeque(int s) {
        deque = new Deque(s);
    }

    public void push(long j) {
        if(!deque.isFull())
        deque.insertRight(j);
    }

    public long pop() {
        if(!deque.isEmpty())
            return deque.removeRight();
        else
            return -1;
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
class AppStackDeque {
    public static void main(String args[]) {
        StackDeque stackDeque = new StackDeque(3);
        stackDeque.push(34);
        stackDeque.push(334);
        stackDeque.push(33);
        stackDeque.push(32);
        stackDeque.pop();
        stackDeque.push(324);
        stackDeque.push(333333);
        stackDeque.push(9999999);
        stackDeque.pop();
    }
}
