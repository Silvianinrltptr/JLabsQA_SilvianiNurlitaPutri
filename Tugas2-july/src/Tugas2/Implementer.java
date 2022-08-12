package Tugas2;

public class Implementer implements Interface{

	@Override
	public void penjumlahan(double bil1, double bil2) {
		double hasil = bil1+bil2;
		System.out.println("\n");
		System.out.println(bil1 + " + "+bil2);
		System.out.println("Hasil Penjumlahan = " +  hasil);
	}

	@Override
	public void pengurangan(double bil1, double bil2) {
		double hasil = bil1-bil2;
		System.out.println("\n");
		System.out.println(bil1 + " - "+bil2);
		System.out.println("Hasil Pengurangan = " + hasil);
	}

	@Override
	public void perkalian(double bil1, double bil2) {
		double hasil = bil1*bil2;
		System.out.println("\n");
		System.out.println(bil1 + " * "+bil2);
		System.out.println("Hasil Perkalian = " +hasil);
	}

	@Override
	public void pembagian(double bil1, double bil2) {
		double hasil = bil1/bil2;
		System.out.println("\n");
		System.out.println(bil1 + " / "+bil2);
		System.out.println("Hasil Pembagian = " +hasil);
	}

	@Override
	public void modulus(double bil1, double bil2) {
		double hasil = bil1/bil2;
		System.out.println("\n");
		System.out.println(bil1 + " % "+bil2);
		System.out.println("Hasil Modulus = " +hasil);
	}
}
