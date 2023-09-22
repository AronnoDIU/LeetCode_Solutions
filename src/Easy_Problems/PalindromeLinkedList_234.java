package Easy_Problems;

public class PalindromeLinkedList_234 {
    ListNode head;

    // Reversed LinkedList
    ListNode reversedRecursive(ListNode head) {
        if (head == null || head.next == null) {    //Corner Point
            return head;
        }

        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = next;
        }

        return previousNode;
    }

    // Find Middle Node
    ListNode findMiddle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reversedRecursive(middle.next);

        ListNode firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    // Adding Last Node
    // Add - last Integer data
    public void addLast(int val) {
        ListNode listNode = new ListNode(val);

        if (head == null) {
            head = listNode;
            return;
        }

        ListNode currentNode = head;
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

        ListNode currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PalindromeLinkedList_234 isPalindromic =
                new PalindromeLinkedList_234();

        isPalindromic.addLast(1);
        isPalindromic.addLast(2);
        isPalindromic.addLast(2);
        isPalindromic.addLast(1);
        isPalindromic.printList();

        System.out.println("Is this list Palindromic? "
                + isPalindromic.isPalindrome(isPalindromic.head));
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

1 -> 2 -> 2 -> 1 -> null
Is this list Palindromic? true

* */