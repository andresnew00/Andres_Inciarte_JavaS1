public class IceCreamPOS {

    int Coldness;
    int Creamness;
    String Flavor;
    String Size;
    String DayOfWeek;

    public IceCreamPOS(int coldness, int creamness, String flavor, String size, String dayOfWeek) {
        Coldness = coldness;
        Creamness = creamness;
        Flavor = flavor;
        Size = size;
        DayOfWeek = dayOfWeek;
    }

    public int getColdness() {
        return Coldness;
    }

    public void setColdness(int coldness) {
        Coldness = coldness;
    }

    public int getCreamness() {
        return Creamness;
    }

    public void setCreamness(int creamness) {
        Creamness = creamness;
    }

    public String getFlavor() {
        return Flavor;
    }

    public void setFlavor(String flavor) {
        Flavor = flavor;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public void IsSaleDay(String Size, String DayOfWeek){

        if(DayOfWeek == "Monday" && Size == "Large"){
            System.out.println("Its Large Icecream Monday SALEEE!!");
        } else {
            System.out.println("Regular price day");
        }

    }

    public void CreateBestIcream(int coldness, int creamness){

        if (coldness > creamness) {
            System.out.println("Adding more creamness to the icecream...");
            creamness++;
        } else if (creamness == coldness) {
            System.out.println("Perfect balance");
        }
    }
}
