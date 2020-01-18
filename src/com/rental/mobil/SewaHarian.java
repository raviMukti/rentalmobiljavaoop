
package com.rental.mobil;


public class SewaHarian extends Sewa{
    
    protected int hari;
    protected double harga;
    protected double total = 0;
    
    
    //Inheritance and Polimorfism dari Sewa
    @Override
    public void hitungSewa() {
        total = hari*harga;
    }
    
}
