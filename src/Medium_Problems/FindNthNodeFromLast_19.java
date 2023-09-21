package Medium_Problems;

public class FindNthNodeFromLast_19 {
    ListNode head;

    ListNode Solution(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        // find Size
        int size = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }

        int indexToSearch = size - n;
        ListNode previousNode = head;
        int index = 1;
        while (index < indexToSearch) {
            previousNode = previousNode.next;
            index++;
        }
        previousNode.next = previousNode.next.next;

        return head;
    }

    // Add - last String data
    public void addLast(int val) {
        ListNode addLastNode = new ListNode(val);

        if (head == null) {
            head = addLastNode;
            return;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = addLastNode;  // Assign as a last Node
    }

    // Print GenericNode
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ListNode currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        FindNthNodeFromLast_19 findNthNode =
                new FindNthNodeFromLast_19();
        int n = 3; // Find & Remove the Nth Node

        findNthNode.addLast(1);
        findNthNode.addLast(2);
        findNthNode.addLast(3);
        findNthNode.addLast(4);
        findNthNode.addLast(5);

        findNthNode.printList();

        findNthNode.head = findNthNode.Solution(findNthNode.head, n);

        findNthNode.printList();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/*Expected Output:

1 -> 2 -> 3 -> 4 -> 5 -> null
1 -> 2 -> 4 -> 5 -> null

* */