package main.modelo;

public class QuinzeOuVinteCincoPorCento extends RegraDeCalculo{
    @Override
    protected double porcentagemBase() {
        return 0.85;
    }
    @Override
    protected double porcentagemAcimaDoLimite() {
        return 0.75;
    }
    @Override
    protected int limite() {
        return 2500;
    }
}
