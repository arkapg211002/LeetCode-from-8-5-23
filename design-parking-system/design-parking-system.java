class ParkingSystem {
    public int bigCount, mediumCount, smallCount; 
    public ParkingSystem(int big, int medium, int small) 
    {
        this.bigCount = big;
        this.mediumCount = medium;
        this.smallCount = small;
    }
    public boolean addCar(int carType)
    {
        if(carType == 1)
        { 
            if(bigCount==0) return false; 
            else bigCount--; 
        }
        else if(carType == 2)
        {
            if(mediumCount==0) return false;
            else mediumCount--;
        }
        else if(carType == 3)
        {
            if(smallCount==0) return false;
            else smallCount--;
        }
        return true;
    }
}