#include <iostream>

struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = new ListNode();
        ListNode* cur = head;
        int carry = 0;
        while (l1 || l2)
        {
            int sum = 0;
            int num = 0;
            int value1 = l1?l1->val:0;
            int value2 = l2?l2->val:0;
            sum = carry + value1 + value2;
            carry = sum / 10;            
            num = sum % 10;

            cur->next = new ListNode(num);
            cur = cur->next;

            if (l1)
            {
                l1 = l1->next;
            }
            if (l2)
            {
                l2 = l2->next;
            }
        }
        if (carry > 0)
        {
            cur->next = new ListNode(carry);
            cur = cur->next;
        }
        
        return head->next;
    }
};

int main(int argc, const char** argv) {
    std::cout << "" << std::endl;
    return 0;
}