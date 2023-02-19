public class Package {
    private Address originAddress;
    private Address destAddress;
    private double weight;
    private double length;
    private double height;
    private double width;

    public Package(Address originAddress, Address destAddress, double weight, double length, double height, double width) {
        if (weight < 0.1) {
            throw new IllegalArgumentException("Package weight cannot be less than 0.1 pound.");
        }
        if (length < 2 || height < 2 || width < 2) {
            throw new IllegalArgumentException("Package dimensions cannot be less than 2 inches on each side.");
        }
        this.originAddress = originAddress;
        this.destAddress = destAddress;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    // accessor methods for all fields
    public Address getOriginAddress() {
        return originAddress;
    }

    public Address getDestAddress() {
        return destAddress;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}