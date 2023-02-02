public class Solution {
    public static void main(String[] args) {
        ListNode nodeC = new ListNode(8);
        nodeC.next = new ListNode(4);
        nodeC.next.next = new ListNode(5);

        ListNode nodeA = new ListNode(4);
        nodeA.next = new ListNode(1);

        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(1);
        nodeB.next.next.next = nodeC;


        nodeA.next.next = nodeC;

        System.out.println(getIntersectionNode(nodeA, nodeB).val);
    }

    private static ListNode getIntersectionNode(ListNode nodeA, ListNode nodeB) {
        ListNode longest = findLongest(nodeA, nodeB);
        ListNode shortest = findShortest(nodeA, nodeB);
        ListNode currentLongest = longest;
        ListNode currentShortest = shortest;

        while (currentLongest != null) {
            while (currentShortest != null) {

                if(currentLongest.hashCode()==currentShortest.hashCode()){
                    return currentLongest;
                }
                currentShortest = currentShortest.next;

            }
            currentShortest = shortest;
            currentLongest = currentLongest.next;
        }
        return null;
    }

    private static ListNode findShortest(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null) {
            countA++;
            currentA = currentA.next;
        }

        while (currentB != null) {
            countB++;
            currentB = currentB.next;
        }
        return countA > countB ? headB : headA;
    }

    private static ListNode findLongest(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null) {
            countA++;
            currentA = currentA.next;
        }

        while (currentB != null) {
            countB++;
            currentB = currentB.next;
        }

        return countA > countB ? headA : headB;
    }

    public static void traversal(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println('\n');
    }
}


