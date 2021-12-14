class Location {
    private double longitude;
    private double latitude;
    // ASK GÜNDÜZ!!! Doesn't make sense for the person using this shit to enter these numbers. Like who the fuck knows these.
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}