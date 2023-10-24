class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        self.num1 =l1
        self.num2 =l2
        arr1=[self.num1.val]
        arr2=[self.num2.val]
        while self.num1.next != None:
            self.num1 = self.num1.next
            arr1.append(self.num1.val)
        while self.num2.next != None:
            self.num2 = self.num2.next
            arr2.append(self.num2.val)
        arr1.reverse()
        arr2.reverse()
        
        n1 = int(''.join(str(s) for s in arr1))
        n2 = int(''.join(str(s) for s in arr2))
        sum = list(map(int,str(n1+n2)))
        Ln = ListNode()
        Ln.val =sum[0]
        Ln.next = None
        if(len(sum)>1):
            for i in sum[1:]:
                Ln2 = ListNode()
                Ln2.val = i
                Ln2.next = Ln
                Ln = Ln2
        return Ln

n = ListNode()
l1 = ListNode(2, ListNode(4, ListNode(3)))
l2 = ListNode(5, ListNode(6, ListNode(4)))
s= Solution()
s.addTwoNumbers(l1,l2)
