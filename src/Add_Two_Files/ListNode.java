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

//Suggest
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



    public static void main(String[] args) {
        ListNode m1 = new ListNode(5);
//        ListNode m2 = new ListNode(4);
//        ListNode m3 = new ListNode(3);

        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(6);
//        ListNode n3 = new ListNode(4);
//        m1.next = m2;
//        m2.next = m3;
//        n1.next = n2;
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
        String s1 = "";
        String s2 = "";
        while (l1 != null) {
            s1 = s1 + l1.val;
            l1 = l1.next;

        }

        while (l2 != null) {
            s2 = s2 + l2.val;
            l2 = l2.next;
        }

        int a=s1.length();
        int b=s2.length();
        //??????????????????????????
        int length=a;
        if (a > b) {
            for (int i = 0; i < a - b; i++) {
                s2 = s2 + "0";
            }
        } else {
            length=b;
            for (int i = 0; i < b - a; i++) {
                s1 = s1 + "0";
            }
        }

//        System.out.println(s1);
//        System.out.println(s2);
//        return null;

        String s="";
        boolean jinwei = false;
        for(int i=0; i< length;i++)
        {
            int m=s1.charAt(i)-48;
            int n=s2.charAt(i)-48;

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
            s=s+"1";
        }

        System.out.println(s);


       char [] answer=s.toCharArray();

       ListNode result = new ListNode(answer[0]-48);

        if(answer.length==1)
        {
            return result;
        }

        ListNode pointer = result;

       for(int i=1; i<answer.length;i++)
       {


            ListNode next = new ListNode(0);
            pointer.next = next;
            next.val = answer[i]-48;
            pointer = pointer.next;

       }

       return result;
    }
}

