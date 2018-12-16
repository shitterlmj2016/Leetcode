import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.SplittableRandom;
import java.util.Stack;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
//        ListNode m3 = new ListNode(3);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(6);
//        ListNode n3 = new ListNode(4);
       m1.next = m2;
//        m2.next = m3;
        n1.next = n2;
//        n2.next = n3;

        solution s = new solution();
        ListNode node = s.addTwoNumbers(m1, n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack l1Stack = new Stack<Integer>();
        Stack l2Stack = new Stack<Integer>();
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;

        }

        while(l2!=null)
        {l2Stack.push(l2.val);
            l2 = l2.next;
        }


        int length=l1Stack.size();
        if (l2Stack.size()>length)
            length = l2Stack.size();

        String s="";
        boolean jinwei = false;
        for(int i=0; i< length;i++)
        {
            int m=0,n=0;
            if (l1Stack.size()!=0) {
                m = (int)l1Stack.pop();
            }
            if (l2Stack.size()!=0) {
                n = (int)l2Stack.pop();
            }

            int j=m+n;

            if(jinwei)
            {
                j++;
            }

            jinwei=false;

            if(j>9)
            {
                j=j%10;
                jinwei=true;
            }
            System.out.println(j);
            s=s+j;
        }

        if (jinwei)
        {
            s="1"+s;
        }

        System.out.println(s);


       char [] answer=s.toCharArray();

       ListNode result = new ListNode(answer[answer.length-1]-48);

        if(answer.length==1)
        {
            return result;
        }

        ListNode pointer = result;

       for(int i=1; i<answer.length;i++)
       {


            ListNode next = new ListNode(0);
            pointer.next = next;
            next.val = answer[answer.length-1-i]-48;
            pointer = pointer.next;

       }

       return result;
    }
}
