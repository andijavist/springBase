package spring.annotation;

import org.springframework.stereotype.Component;

@Component("INTEL")//даем имена процессорам, чтобы явно указывать.к оторый из них внедрять
public class IntelCPU implements CPU {

    @Override
    public String getVendor() {
        return "IntelCPU";
    }
}
