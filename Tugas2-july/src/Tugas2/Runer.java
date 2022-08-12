package Tugas2;

import java.util.Scanner;

public class Runer {

	public static void main(String[] args) throws Exception {
		Implementer implementer = new Implementer();
		
		double input1 = 0;
		double input2 = 0;
		int operator = 1;

		boolean keluar = false;

		while (keluar == false) {
			boolean checkOperator = false;
			while(checkOperator == false) {
				String errorMessageOperator = "";
				try {
					info();
					Scanner op = new Scanner(System.in);  
					System.out.print("Pilih operator: ");
					operator = op.nextInt(); 
				}catch (Exception e1) {
					errorMessageOperator = e1.toString();
					System.out.print("\nERROR, MASUKAN OPERATOR!\n\n");
				}
				if(errorMessageOperator.isEmpty()) {
					checkOperator = true;
				}else {
					checkOperator = false;
				}
			}
			if((operator < 6) && (operator > 0)){
				boolean checkInput = false;
				while(checkInput == false) {
					String errorMessageInput = "";
					try {
						Scanner input = new Scanner(System.in);  
						System.out.print("Masukan nilai 1 yang akan dihitung  : ");
						input1 = input.nextDouble();
						System.out.print("Masukan nilai 2 yang akan dihitung  : ");
						input2 = input.nextDouble();
					}catch (Exception e1) {
						errorMessageInput = e1.toString();
						System.out.print("\nERROR, MASUKAN ANGKA!\n\n");
					}
					if(errorMessageInput.isEmpty()) {
						checkInput = true;
					}else {
						checkInput = false;
					}
				}

				switch (operator) {
					case 1:
						implementer.penjumlahan(input1, input2);
						break;
					case 2:
						implementer.pengurangan(input1, input2);
						break;
					case 3:
						implementer.pembagian(input1, input2);
						break;
					case 4:
						implementer.perkalian(input1, input2);
						break;
					case 5:
						implementer.modulus(input1, input2);
						break;
					default:
						break;
				}
			}else{
				keluar=true;
				exit();
			}
		}
	}

	static void info(){
		System.out.println("\n*****************************************");
		System.out.println("Pilih operator: (+, -, /, *, %, ^) ");
		System.out.println("Press 1. Penjumlahan");
		System.out.println("Press 2. Pengurangan");
		System.out.println("Press 3. Pembagian");
		System.out.println("Press 4. Perkalian");
		System.out.println("Press 5. Modulus");
		System.out.println("Press 6. Keluar");
		System.out.println("*****************************************");
	}

	
	static void exit(){
		System.out.println("\n*****************************************");
		System.out.println("$ Terima kasih telah mencobanya :) ");
		System.out.println("*****************************************");
		System.exit(0);
	}
}
