package org.example;

public class RollProviderStub extends RollProvider {

    private int number;
    
    public RollProviderStub(int number) {
        this.number = number;
    }

    @Override
    public Integer getRoll() {
        return this.number;
    }

}
