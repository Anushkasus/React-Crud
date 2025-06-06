import java.util.Scanner;

public class Constructor {
    int id;
    String name;
    Constructor()
    {
        id = 101222;
        name = "Riya";
    }
    Constructor(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Employee Id: " + id);
    }

    public static void main(String[] args) {
        int id;
        String name;
        Scanner sc = new Scanner(System.in);
        Constructor cs = new Constructor();
        cs.display();
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter id: ");
        id = sc.nextInt();
        Constructor cs2  = new Constructor(id, name);
        cs2.display();
    }
}
