package spring.annotation;

import org.springframework.stereotype.Component;
@Component
@MyCpu
public class AmdCpu implements CPU {
    @Override
    public String getVendor() {
        return "AmdCPU";
    }
}
