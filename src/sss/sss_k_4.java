package sss;

import java.io.*;
import java.nio.file.*;

public class sss_k_4 {

	public static void main(String args[]) {
		long systart = System.currentTimeMillis();
		System.out.println("Shamir's secret sharing!");

		try {
			String location = "C:/Users/bhavs/eclipse-workspace/HW_3/src/image.bmp";
			File fimg = new File(location);
			byte[] bitimg = Files.readAllBytes(fimg.toPath());

			int[] share = new int[bitimg.length];
			byte[] share1 = new byte[bitimg.length];
			int k = 0;
			int bmp_h = 54;
			boolean check = k < bitimg.length;

			// Share 1

			if (check) {

				do {
					if (k < bmp_h) {
						share1[k] = (byte) bitimg[k];
					} else {
						share[k] = (((bitimg[k]) + (10 * 1) + (10 * 1) + (10 * 1)) % 251); // for x = 1, a1=a2=a3=10
						share1[k] = (byte) share[k];
					}
					k++;
				} while (k < bitimg.length);
			}

			System.out.println("Generated Share1 successfully!");
			Path save1 = Paths.get("C:/Users/bhavs/eclipse-workspace/HW_3/src/k=4/share1_out.bmp");
			Files.write(save1, share1);

			// Share 2
			k = 0;
			byte[] share2 = new byte[bitimg.length];

			if (check) {

				do {
					if (k < bmp_h) {
						share2[k] = (byte) bitimg[k];
					} else {
						share[k] = ((bitimg[k]) + (10 * 2) + (10 * (2 * 2) + (10 * (2 * 2 * 2))) % 251); // for x = 2,
																											// a1=a2=a3=10
						share2[k] = (byte) share[k];
					}
					k++;
				} while (k < bitimg.length);
			}

			System.out.println("Generated Share2 successfully!");
			Path save2 = Paths.get("C:/Users/bhavs/eclipse-workspace/HW_3/src/k=4/share2_out.bmp");
			Files.write(save2, share2);

			// Share 3
			k = 0;
			byte[] share3 = new byte[bitimg.length];

			if (check) {

				do {
					if (k < bmp_h) {
						share3[k] = (byte) bitimg[k];
					} else {
						share[k] = (((bitimg[k]) + (10 * 3) + (10 * (3 * 3)) + (10 * (3 * 3 * 3))) % 251); // for x = 3,
																											// a1=a2=a3=10
						share3[k] = (byte) share[k];
					}
					k++;
				} while (k < bitimg.length);
			}

			System.out.println("Generated Share3 successfully!");
			Path save3 = Paths.get("C:/Users/bhavs/eclipse-workspace/HW_3/src/k=4/share3_out.bmp");
			Files.write(save3, share3);

			// Share 4
			k = 0;
			byte[] share4 = new byte[bitimg.length];

			if (check) {

				do {
					if (k < bmp_h) {
						share4[k] = (byte) bitimg[k];
					} else {
						share[k] = (((bitimg[k]) + (10 * 4) + (10 * (4 * 4)) + (10 * (4 * 4 * 4))) % 251); // for x = 4,
																											// a1=a2=a3=10
						share4[k] = (byte) share[k];
					}
					k++;
				} while (k < bitimg.length);
			}

			System.out.println("Generated Share4 successfully!");
			Path save4 = Paths.get("C:/Users/bhavs/eclipse-workspace/HW_3/src/k=4/share4_out.bmp");
			Files.write(save4, share4);

			// Share 5
			k = 0;
			byte[] share5 = new byte[bitimg.length];

			if (check) {

				do {
					if (k < bmp_h) {
						share5[k] = (byte) bitimg[k];
					} else {
						share[k] = (((bitimg[k]) + (10 * 5) + (10 * (5 * 5)) + (10 * (5 * 5 * 5))) % 251); // for x = 5,
																											// a1=a2=a3=10
						share5[k] = (byte) share[k];
					}
					k++;
				} while (k < bitimg.length);
			}

			System.out.println("Generated Share5 successfully!");
			Path save5 = Paths.get("C:/Users/bhavs/eclipse-workspace/HW_3/src/k=4/share5_out.bmp");
			Files.write(save5, share5);

			k = 0;
			int[] x1 = new int[share1.length];
			int[] x2 = new int[share2.length];
			int[] x3 = new int[share3.length];
			int[] x4 = new int[share4.length];
			byte[] final_img = new byte[bitimg.length];
			int rec = 0;

			if (check) {

				do {
					x1[k] = share1[k];
					x2[k] = share2[k];
					x3[k] = share3[k];
					x4[k] = share4[k];
					if (k < bmp_h) {
						final_img[k] = bitimg[k];
					}
					rec = ((x1[k] * 4) + (x2[k] * (-6)) + (x3[k] * 4) + (x4[k] * (-1))) % 251;
					final_img[k] = (byte) rec;
					k++;
				} while (k < share1.length);

			}

			System.out.println("Image reconstructed successfully!");
			Path save6 = Paths.get("C:/Users/bhavs/eclipse-workspace/HW_3/src/k=4/final_img_out.bmp");
			Files.write(save6, bitimg);

			long sysstop = System.currentTimeMillis();
			long total = sysstop - systart;
			System.out.println("\nRunning time of the code for the value of k = 4 is: " + total + "ms");

		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
