package spring.xml;

class StaticCPUFactory {
    public static CPU createCPU(String name){
if ("intelCPU".equalsIgnoreCase(name)){
    return new IntelCPU();
} else  if ("AmdCPU".equalsIgnoreCase(name))
{return new AmdCpu();}
//if (name.equalsIgnoreCase("intelCPU"))
// мы мщжем также записать так, но если мы забудем
//записать name или оно будет null, то получим NPE

//в противном случае мы приказываем возвратить
//анонимный класс (без ссылки на него) имплементирующий
//интерфейс CPU
//return new CPU()
//{
//    @Override
//    public String getVendor() {
//        return "Default CPU";
//    }
//}
//также можно заменить это на лямбду, так как в интерфейсе CPU
//один только метод retVenfor()
return () -> "Default CPU";
    }
}
