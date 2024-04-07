public class Main {

     public static void main(String[] args) {
        LL list = new LL();

     //    list.insertLast(1);
     //    list.insertLast(1);
     //    list.insertLast(1);
     //    list.insertLast(2);
     //    list.insertLast(4);
     //    list.insertLast(4);
     //    list.display();
     //    list.duplicates();
     //    list.display();

     LL first = new LL();
     LL second = new LL();

     first.insertLast(1);
     first.insertLast(3);
     first.insertLast(5);
     first.display();

     second.insertLast(1);
     second.insertLast(2);
     second.insertLast(9);
     second.insertLast(14);
     second.display();

     LL ans = LL.merge(first, second);
     ans.display();


     //    list.insertFirst(3);
     //    list.insertFirst(2);
     //    list.insertFirst(8);
     //    list.insertFirst(17);
     //    list.display();
        

     //    list.insertLast(15);
     //    list.display();
     //  list.insert(100,3);
     //  list.display();
     //  System.out.println(list.deleteFirst());
     //  list.display();
     //  System.out.println(list.deleteLast());
     //  list.display();
     //  System.out.println(list.delete(2));
     //  list.display();
     //  System.out.println(list.find(2));
     //  list.display();
     //  list.insertByRec(88, 2);
     //  list.display();
  

     // DLL list = new DLL();
     //    list.insertFirst(3);
     //    list.insertFirst(2);
     //    list.insertFirst(8);
     //    list.insertFirst(17);
     //    list.display();
     //    list.insertLast(99);
     //    list.display();

     //    list.insert(2, 85);
     //    list.display();

     // CLL list = new CLL();
     // list.insert(23);
     // list.insert(3);
     // list.insert(19);
     // list.insert(73);
     // list.delete(19);
     // list.display();
     }
}