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


    private int generateZipCode(){
        int[][] zipRanges = {
                {35004, 36925},
                {99501, 99950},
                {85001, 86556},
                {71601, 72959},
                {90001, 96162},
                {80001, 81658},
                {6001, 6928},
                {19701, 19980},
                {32003, 34997},
                {30002, 39901},
                {96701, 96898},
                {83201, 83877},
                {60001, 62999},
                {46001, 47997},
                {50001, 52809},
                {66002, 67954},
                {40003, 42788},
                {70001, 71497},
                {3901, 4992},
                {20588, 21930},
                {1001, 5544},
                {48001, 49971},
                {55001, 56763},
                {38601, 39776},
                {63001, 65899},
                {59001, 59937},
                {68001, 69367},
                {88901, 89883},
                {3031, 3897},
                {7001, 8989},
                {87001, 88439},
                {501, 14925},
                {27006, 28909},
                {58001, 58856},
                {43001, 45999},
                {73001, 74966},
                {97001, 97920},
                {15001, 19640},
                {2801, 2940},
                {29001, 29945},
                {57001, 57799},
                {37010, 38589},
                {73301, 88595},
                {84001, 84791},
                {5001, 5907},
                {20101, 24658},
                {98001, 99403},
                {24701, 26886},
                {53001, 54990},
                {82001, 83414}
        };
        int stateIndex = (int) (Math.random() * zipRanges.length);
        int[] stateRange = zipRanges[stateIndex];
        int randomZipCode = (int) (Math.random() * (stateRange[1] - stateRange[0] + 1)) + stateRange[0];
        String formattedStr = String.format("%05d", randomZipCode);
        return Integer.parseInt(formattedStr);
    }

    private Address generateAddress(int zip) {
        String formattedStr = String.format("%05d", zip);
        return new Address("123", "Random Street", "City", "State", formattedStr);
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