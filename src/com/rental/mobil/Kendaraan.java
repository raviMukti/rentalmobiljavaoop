
package com.rental.mobil;

//Outer Class
public class Kendaraan {
    //Inner Class
    static class Mobil{
        private String tipe;
        private String nama;
        private String warna;
        private int kursi;
        private String platNomor;
        private String statusSewa;

        //Default Constructor
        public Mobil() {
            super();
        }
        
        //Setter and Getter
        public String getTipe() {
            return tipe;
        }

        public void setTipe(String tipe) {
            this.tipe = tipe;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getWarna() {
            return warna;
        }

        public void setWarna(String warna) {
            this.warna = warna;
        }

        public int getKursi() {
            return kursi;
        }

        public void setKursi(int kursi) {
            this.kursi = kursi;
        }

        public String getPlatNomor() {
            return platNomor;
        }

        public void setPlatNomor(String platNomor) {
            this.platNomor = platNomor;
        }

        public String getStatusSewa() {
            return statusSewa;
        }

        public void setStatusSewa(String statusSewa) {
            this.statusSewa = statusSewa;
        }
        
    }  
}
