package firstTest;

public class Main {
    public static void main(String[] args) {
        String s = "s";
        Object ob = s;
        System.out.println(ob);
        s= (String) ob;//приведение типов
        System.out.println(s);



        double x=0, y=2,z;
        z=y/x;
        System.out.println(z);//infinity


        int x1=13,y1=3;
        double z1 = x1/y1;
        System.out.println(z1);

        int x2 = 1;
        while (x2<=10){
            if(x2==5){
                continue;
         //       System.out.println(x2); unreachable statement
         //       ++x;
            }
        }



    }

}
