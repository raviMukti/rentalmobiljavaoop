
package com.rental.mobil;


public class SewaBulanan extends Sewa{
    
    protected int bulan;
    protected double harga;
    protected double total;
    
    //Inheritance and Polimorfism
    @Override
    public void hitungSewa() {
        total = bulan*harga;
    }
    
}
