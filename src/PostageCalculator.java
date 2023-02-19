public class PostageCalculator {
    public static double calculatePostage(int originZip, int destinationZip, double weight, double length, double width, double height) {
        if (originZip < 10000 || originZip > 99999 || destinationZip < 10000 || destinationZip > 99999) {
            throw new IllegalArgumentException("Zip codes have to be five digits");
        }
        double oversizeCost = 0;
        double combinedLength = length + width + height;
        if(combinedLength > 36){
            oversizeCost += ((combinedLength - 36) * 0.1);
        }

        double overweightCost = 0;
        if(weight > 40){
            overweightCost += (((weight - 40) * 10) * 0.1);
        }

        double baseCost = 3.75;
        double weightCost = Math.ceil(weight * 10) * 0.05;

        int originCountyCode = originZip / 100;
        int destinationCountyCode = destinationZip / 100;
        double countyCodeDifference = Math.abs(originCountyCode - destinationCountyCode);
        double countyCodeCost = countyCodeDifference / 100;

        double totalCost = baseCost + weightCost + countyCodeCost + oversizeCost + overweightCost;
        return totalCost;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double length, double width, double height) {
        return calculatePostage(origin.getZipCode(), destination.getZipCode(), weight, length, width, height);
    }

    public static double calculatePostage(Package pkg) {
        return calculatePostage(pkg.getOriginAddress(), pkg.getDestAddress(), pkg.getWeight(), pkg.getLength(), pkg.getWidth(), pkg.getHeight());
    }

    // Additional helper method to check if package is valid
    public static boolean isValidPackage(double weight, double length, double width, double height) {
        return weight >= 0.1 && (length >= 2 && width >= 2 && height >= 2) && (length + 2 * (width + height)) <= 108;
    }
}