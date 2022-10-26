package entities;

public class Juridico extends TaxPayer{
    private int numberOfEmployees;

    public Juridico(){

    }

    public Juridico(String name, Double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax(){
        double sumTax;
        if(numberOfEmployees <= 10){
            sumTax = super.getAnualIncome() * 0.16;
            return sumTax;
        }
        else{
            sumTax = super.getAnualIncome() * 0.14;
            return sumTax;
        }
    }
}
