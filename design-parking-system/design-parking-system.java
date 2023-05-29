class ParkingSystem {
    private int bigCount; //keeps track of big cars
    private int mediumCount; //keeps track of medium cars
    private int smallCount; //keeps track of small cars
    public ParkingSystem(int big, int medium, int small) {//constructor
        //setting values
        this.bigCount = big;
        this.mediumCount = medium;
        this.smallCount = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){ //checks for car type
            if(bigCount==0) return false; //if maximum capacity reached, returns false
            else {
                bigCount--; //otherwise it decreases available space by 1 and returns true
            }
        }
        else if(carType == 2){
            if(mediumCount==0) return false;
            else {
                mediumCount--;
            }
        }
        else if(carType == 3){
            if(smallCount==0) return false;
            else {
                smallCount--;
        }
        }
        return true;
    }
}