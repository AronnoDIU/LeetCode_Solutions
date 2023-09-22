package Easy_Problems;

public class ReverseLinkedList_206 {
    ListNodeReversed head;

    ListNodeReversed reverseList(ListNodeReversed head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNodeReversed previousNode = head;
        ListNodeReversed currentNode = head.next;

        while (currentNode != null) {
            ListNodeReversed nextNode = currentNode.next;
            currentNode.next = previousNode;

            // Update the Nodes
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = previousNode;

        return head;
    }

    // Adding Last Node
    // Add - last Integer data
    public void addLast(int val) {
        ListNodeReversed listNode = new ListNodeReversed(val);

        if (head == null) {
            head = listNode;
            return;
        }

        ListNodeReversed currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = listNode;  // Assign as a last Node
    }

    // Print GenericNode
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ListNodeReversed currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList_206 reverseLinkedList =
                new ReverseLinkedList_206();

        reverseLinkedList.addLast(1);
        reverseLinkedList.addLast(2);
        reverseLinkedList.addLast(3);
        reverseLinkedList.addLast(4);
        reverseLinkedList.printList();

        reverseLinkedList.head =
                reverseLinkedList.reverseList(reverseLinkedList.head);
        reverseLinkedList.printList();
    }
}

// Definition for singly-linked list.
class ListNodeReversed {
    int val;
    ListNodeReversed next;

    ListNodeReversed(int val) {
        this.val = val;
    }
}
