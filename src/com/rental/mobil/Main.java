package com.rental.mobil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    // Let's Rock
    public static void main(String[] args) throws TransaksiException{
        //Instansiasi SewaHarian
        SewaHarian sewaHarian = new SewaHarian();
        SewaBulanan sewaBulanan = new SewaBulanan();
        Scanner back = new Scanner(System.in);
        Scanner inputMenu = new Scanner(System.in);
        Scanner inputNamaKonsumen = new Scanner(System.in);
        Scanner inputJenis = new Scanner(System.in);
        Scanner inputDurasi = new Scanner(System.in);
        Scanner inputMobil = new Scanner(System.in);
        List<String> transaksi = new ArrayList<>();
        String namaKonsumen;
        int pilihMobil;
        int pilihanMenu;
        int pilihanJenis;
        int inputBack;
        int durasi;
        List<Kendaraan.Mobil> daftarMobil = new ArrayList<>();
        //Instansiasi Class Mobil ke mobil1
        Kendaraan.Mobil mobil1 = new Kendaraan.Mobil();
        //Instansiasi Class Mobil ke mobil2
        Kendaraan.Mobil mobil2 = new Kendaraan.Mobil();
        //Instansiasi Class Mobil ke mobil3
        Kendaraan.Mobil mobil3 = new Kendaraan.Mobil();

        //Set object mobil1
        mobil1.setTipe("Sedan");
        mobil1.setNama("Vios");
        mobil1.setWarna("Silver");
        mobil1.setKursi(4);
        mobil1.setPlatNomor("B 6423 JKL");
        mobil1.setStatusSewa("READY");

        //Set object mobil2
        mobil2.setTipe("SUV");
        mobil2.setNama("Mobilio");
        mobil2.setWarna("Hitam");
        mobil2.setKursi(6);
        mobil2.setPlatNomor("D 7823 HGY");
        mobil2.setStatusSewa("NOT READY");

        //Set object mobil3
        mobil3.setTipe("Double SUV");
        mobil3.setNama("Fortuner");
        mobil3.setWarna("Putih");
        mobil3.setKursi(8);
        mobil3.setPlatNomor("D 5673 KKK");
        mobil3.setStatusSewa("READY");

        daftarMobil.add(0, mobil1);
        daftarMobil.add(1, mobil2);
        daftarMobil.add(2, mobil3);
        
        // 1. Tampilkan List Menu
        // - Menu Daftar Kendaraan Sewa
        // - Menu Sewa
        do {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                            ************RENTAL MOBIL*************                         ");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("SILAKAN PILIH MENU DENGAN INPUT 1/2 ATAU 0 UNTUK EXIT");
            System.out.println("1. TAMPILKAN DAFTAR KENDARAAN");
            System.out.println("2. SEWA KENDARAAN\n");
            System.out.println("-------------------------------- MASUKAN PILIHAN ANDA ------------------------------------");
            pilihanMenu = inputMenu.nextInt();
            if (pilihanMenu == 1){
                //Print the list objects in tabular format.
               System.out.println("------------------------------------------------------------------------------------------");
                System.out.printf("%10s %20s %20s %15s", "NAMA MOBIL", "JUMLAH KURSI", "WARNA MOBIL", "STATUS");
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------");
                for(Kendaraan.Mobil m : daftarMobil){
                    System.out.format("%10s %20s %20s %15s", m.getNama(), m.getKursi(), m.getWarna(), m.getStatusSewa());
                    System.out.println();
                }
                System.out.println("------------------------------------------------------------------------------------------");
            }if(pilihanMenu == 2){
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("SILAKAN MASUKAN NAMA : ");
                namaKonsumen = inputNamaKonsumen.nextLine();
                transaksi.add(namaKonsumen);
                //Print the list objects in tabular format.
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.printf("%5s %10s %20s %20s %15s", "NO", "NAMA MOBIL", "JUMLAH KURSI", "WARNA MOBIL", "STATUS");
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------");
                for (Kendaraan.Mobil m : daftarMobil) {
                int index = daftarMobil.indexOf(m)+1;
                System.out.format("%5s %10s %20s %20s %15s", index, m.getNama(), m.getKursi(), m.getWarna(), m.getStatusSewa());
                System.out.println();
                }
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("PILIH MOBIL (PILIH NO MOBIL) : ");
                System.out.println("-------------------------------- MASUKAN PILIHAN ANDA ------------------------------------");
                pilihMobil = inputMobil.nextInt();
                if(pilihMobil == 1){
                    transaksi.add(mobil1.getNama());
                    transaksi.add(mobil1.getStatusSewa());
                }if(pilihMobil == 2){
                    transaksi.add(mobil2.getNama());
                    transaksi.add(mobil2.getStatusSewa());
                }if(pilihMobil == 3){
                    transaksi.add(mobil3.getNama());
                    transaksi.add(mobil3.getStatusSewa());
                }
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("PILIH JENIS SEWA : ");
                System.out.println("1. SEWA HARIAN");
                System.out.println("2. SEWA BULANAN");
                System.out.println("------------------------------------------------------------------------------------------");
                pilihanJenis = inputJenis.nextInt();
                if(pilihanJenis == 1){
                    transaksi.add("HARIAN");
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("1 HARI SEWA = Rp. 250.000 ");
                    System.out.println("MASUKAN (HARI) DURASI SEWA : ");
                    durasi = inputDurasi.nextInt();
                    sewaHarian.hari = durasi;
                    transaksi.add(String.valueOf(durasi));
                    sewaHarian.harga = 250000;
                    sewaHarian.hitungSewa();
                    transaksi.add(String.valueOf(sewaHarian.harga));
                    System.out.println("HARAP TUNGGU TRANSAKSI SEDANG DI PROSES");
                    if(transaksi.get(2).equals("NOT READY")){
                        throw new TransaksiException("MOBIL SEDANG DISEWA TRANSAKSI TIDAK BISA DILAKUKAN");
                    }else{
                        transaksi.add(String.valueOf(sewaHarian.total));
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        System.out.printf("%15s %15s %15s %15s %15s %10s %10s", "NAMA", "NAMA MOBIL", "STATUS","JENIS SEWA", "DURASI", "HARGA", "TOTAL");
                        System.out.println();
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        System.out.printf("%15s %15s %15s %15s %15s %10s %10s", transaksi.get(0), transaksi.get(1),
                                transaksi.get(2), transaksi.get(3), transaksi.get(4), transaksi.get(5),
                                transaksi.get(6));
                        System.out.println();
                    }
                    
                }if(pilihanJenis == 2){
                    transaksi.add("BULANAN");
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("1 BULAN SEWA = Rp. 5.000.000 ");
                    System.out.println("MASUKAN (BULAN) DURASI SEWA : ");
                    durasi = inputDurasi.nextInt();
                    sewaBulanan.bulan = durasi;
                    transaksi.add(String.valueOf(durasi));
                    sewaBulanan.harga = 5000000;
                    sewaBulanan.hitungSewa();
                    transaksi.add(String.valueOf(sewaBulanan.harga));
                    System.out.println("HARAP TUNGGU TRANSAKSI SEDANG DI PROSES");
                    if(transaksi.get(2).equals("NOT READY")){
                        throw new TransaksiException("MOBIL SEDANG DISEWA TRANSAKSI TIDAK BISA DILAKUKAN");
                    }else{
                        transaksi.add(String.valueOf(sewaBulanan.total));
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        System.out.printf("%15s %15s %15s %15s %15s %10s %10s", "NAMA", "NAMA MOBIL", "STATUS","JENIS SEWA", "DURASI", "HARGA", "TOTAL");
                        System.out.println();
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        System.out.printf("%15s %15s %15s %15s %15s %10s %10s", transaksi.get(0), transaksi.get(1),
                                transaksi.get(2), transaksi.get(3), transaksi.get(4), transaksi.get(5),
                                transaksi.get(6));
                        System.out.println();
                    }
                }
            }if(pilihanMenu == 0){
               System.out.println("APLIKASI BERAKHIR");
               System.exit(0);
            }
            System.out.println("KEMBALI KE HALAMAN UTAMA? (1/0)");
            inputBack =  back.nextInt();
        }while (inputBack != 0);
        System.out.println("APLIKASI BERAKHIR");
    }
}
    

