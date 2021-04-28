package spring.javaconfig;

public class AmdCpu implements CPU {
    @Override
    public String getVendor() {
        return "AmdCPU";
    }
}
