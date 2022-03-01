package task1;

public class MainForMobile {
    public static void main(String[] args) {

        Mobile mobile = new Mobile("Xiaomi");

        mobile.addModel("Mi 11");
        mobile.models.get(0).addAttribute("RAM", 8);
        mobile.models.get(0).addAttribute("ROM", 256);
        mobile.models.get(0).addAttribute("Accumulator", 4600);
        mobile.models.get(0).addAttribute("NFC");

        mobile.addModel("Mi 8");
        mobile.models.get(1).addAttribute("RAM", 6);
        mobile.models.get(1).addAttribute("ROM", 128);
        mobile.models.get(0).addAttribute("Accumulator", 3400);

        System.out.println(mobile);


    }
}
