import java.util.Arrays;

//Basically custom sorting mtlb apne hisabh se sorting kare

class Student implements Comparable<Student> {
        int rno;
        double perc;
        String name;
        Student(int rno, double perc, String name){
            this.name = name;
            this.rno = rno;
            this.perc = perc;
        }
        public int compareTo(Student s ){
            return this.rno - s.rno; // depend on you app kis chiz ko priority de rhe ho for like sorting, storing etc
        }
    }
    
    public class customComparator {
        public static void print(Student[] s) {
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i].name + " ");
                System.out.print(s[i].rno + " ");
                System.out.println(s[i].perc + " ");
                
            }
            System.out.println();
        }
    public static void main(String[] args) {
        Student[] s = new Student[4];
        s[0] = new Student(76, 89.5, "Raghav");
        s[1] = new Student(88, 78.1, "Prachi");
        s[2] = new Student(13, 95.8, "Amrit");
        s[3] = new Student(83, 50.3, "Himanshu");
        print(s);
        Arrays.sort(s);
        print(s);
    }
}
