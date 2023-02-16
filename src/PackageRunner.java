public class PackageRunner {
    public static void main(String[] args) {
        Address a = new Address("1313","Mockingbird Lane", "Springfield","MO",65123);
        System.out.println(a);

        Address a2 = new Address(a);
        System.out.println(a2);

        Address a3 = new Address("1313 Mockingbird Lane, Springfield, MO 65123");
        System.out.println(a3);
    }
}
