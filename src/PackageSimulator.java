import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<>();
    }

    public void generatePackages(int numPackages) {
        for (int i = 0; i < numPackages; i++) {
            int originZip = generateZipCode();
            int destZip = generateZipCode();
            while (destZip == originZip){
                destZip = generateZipCode();
            }
            Address origin = generateAddress(originZip);
            Address destination = generateAddress(destZip);
            double weight = generateWeight();
            double length = generateLength();
            double width = generateWidth();
            double height = generateHeight();
            Package pkg = new Package(origin, destination, weight, length, height, width);
            packages.add(pkg);
        }
    }

    private int generateZipCode() {
        String zip = "";
        for (int i = 0; i < 5; i++) {
            zip += (Math.random() * 10);
        }
        return Integer.parseInt(zip);
    }

    private Address generateAddress(int zip) {
        return new Address("123", "Random Street", "City", "State", generateZipCode());
    }

    private double generateWeight() {
        double minWeight = 0.1;
        double maxWeight = 50.0;
        return minWeight + Math.random() * (maxWeight - minWeight);
    }

    private double generateLength() {
        double minLength = 2.0;
        double maxLength = 72.0;
        return minLength + Math.random() * (maxLength - minLength);
    }

    private double generateHeight() {
        double minHeight = 2.0;
        double maxHeight = 36.0;
        return minHeight + Math.random() * (maxHeight - minHeight);
    }
    private double generateWidth() {
        double minWidth = 2.0;
        double maxWidth = 36.0;
        return minWidth + Math.random() * (maxWidth - minWidth);
    }

    public double generateTotalCost() {
        double totalCost = 0;
        for (Package pkg : packages) {
            totalCost += PostageCalculator.calculatePostage(pkg);
        }
        return Math.round(totalCost * 100.0) / 100.0;
    }


    public String getSimulationInfo() {
        String info = "Randomly generated packages info:\n";
        for (int i = 0; i < packages.size(); i++) {
            info += "Package " + (i+1) + ": ________________________________________\n";
            info += "Origin address: " + packages.get(i).getOriginAddress() + "\n";
            info += "Destination address: " + packages.get(i).getDestAddress() + "\n";
            info += "Weight: " + packages.get(i).getWeight() + " pounds\n";
            info += "Height: " + packages.get(i).getHeight() + " inches\n";
            info += "Length: " + packages.get(i).getLength() + " inches\n";
            info += "Width: " + packages.get(i).getWidth() + " inches\n";
            info += "Cost: " + PostageCalculator.calculatePostage(packages.get(i)) + "\n";
        }
        info += ("________________________________________\n");
        info += ("Total Cost of all packages: " + generateTotalCost());
        return info;
    }
    public void resetSimulation() {
        packages.clear();
    }

}