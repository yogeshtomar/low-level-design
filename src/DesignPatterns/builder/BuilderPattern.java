package DesignPatterns.builder;

class Computer {
    private String cpuName;
    private String ramName;
    private String storage;

    public String getCPUName() {return this.cpuName;}
    public String getRAMName() {return this.ramName;}
    public String getStorage() {return this.storage;}

    public Computer setRAMName(String ramName) {
        this.ramName = ramName;
        return this;
    }
    
    public Computer setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public Computer setCPUName(String cpuName) {
        this.cpuName = cpuName;
        return this;
    }
    
    public void displayInformation() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpuName);
        System.out.println("RAM: " + ramName);
        System.out.println("Storage: " + storage);
    }
}

interface Builder {
    Builder buildCPU(String cpu);
    Builder buildRAM(String ram);
    Builder buildStorage(String storage);
    Computer getResult();
}

class GamingComputerBuilder implements Builder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public Builder buildCPU(String cpuName) {
        computer.setCPUName(cpuName);
        return this;
    }

    @Override
    public Builder buildRAM(String ram) {
        computer.setRAMName(ram);
        return this;
    }

    @Override
    public Builder buildStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    @Override
    public Computer getResult() {
        return computer;   
    }
}

class ComputerDirector {
    public void construct(Builder builder) {
        String cpu = "Intel Core i9 15th Gen 8 core cpu";
        String ram = "16GB DDR4";
        String storage = "1TB SSD";
        builder.buildCPU(cpu)
            .buildRAM(ram)
            .buildStorage(storage);
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        
        GamingComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();

        director.construct(gamingComputerBuilder);    
        Computer gamingComputer = gamingComputerBuilder.getResult();
        gamingComputer.displayInformation();
    }
    
}
