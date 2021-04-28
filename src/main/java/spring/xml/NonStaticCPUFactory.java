package spring.xml;

class NonStaticCPUFactory {
//убрали отметку static
//    будет создан непосредственно экземпляр этого класса и мы сможем
//    использовать метод фабрики
    public CPU createCPU(String name){
if ("intelCPU".equalsIgnoreCase(name)){
    return new IntelCPU();
} else  if ("AmdCPU".equalsIgnoreCase(name))
{return new AmdCpu();}
 return () -> "Default CPU";
    }
}
