import java.util.Scanner;

public class PackageRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice = 0;
        while ((!(choice == 4))) {
            System.out.println("________________________________________");
            System.out.println("What would you like to do?");
            System.out.println("1. Calculate cost of one package");
            System.out.println("2. Stimulate packages");
            System.out.println("3. How package costs are calculated");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            choice = s.nextInt();
            if (choice == 1) {
                System.out.println("________________________________________");
                System.out.print("Enter the zip code of the origin package: ");
                int zipCode = s.nextInt();
                System.out.print("Enter the zip code of the destination package: ");
                int zipCode2 = s.nextInt();
                System.out.print("Enter the weight of the package: ");
                double weight = s.nextDouble();
                System.out.print("Enter the height of the package: ");
                double height = s.nextDouble();
                System.out.print("Enter the length of the package: ");
                double length = s.nextDouble();
                System.out.print("Enter the width of the package: ");
                double width = s.nextDouble();
                PostageCalculator.calculatePostage(zipCode, zipCode2, weight, length, width, height);
                System.out.print("Cost: " + PostageCalculator.calculatePostage(zipCode, zipCode2, weight, length, width, height));
                System.out.println();
            }
            if (choice == 2) {
                PackageSimulator simulator = new PackageSimulator();
                System.out.println("________________________________________");
                System.out.print("How may packages would you like to simulate? ");
                int choice2 = s.nextInt();
                simulator.generatePackages(choice2);
                System.out.println(simulator.getSimulationInfo());
                simulator.resetSimulation();
            }
            if(choice == 3){
                System.out.println("________________________________________");
                System.out.println("Shipping Cost Calculation Breakdown: ");
                System.out.println("Base cost: $3.75");
                System.out.println("Weight cost: 5 cents per tenth of a pound");
                System.out.println("County code difference cost: difference in county codes divided by 100");
                System.out.println("Oversize cost: 10 cents per inch for packages that exceed 36 inches in combined length");
                System.out.println("Overweight cost: 10 cents per tenth of a pound over the 40 pound limit");
                System.out.println();
                System.out.println("To calculate the total shipping cost of a package, we add up all of these costs: ");
                System.out.println("Total Cost = Base Cost + Weight Cost + County Code Difference Cost + Oversize Cost + Overweight Cost");
            }
        }
        System.exit(0);
    }
}
