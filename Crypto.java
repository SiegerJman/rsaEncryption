//Justin Reed
//10/27/14
//CSE 270M

import java.util.Scanner;

public class Crypto {
	public static void main(String [ ] args)
	{
		int p = 0;
		int q = 0;
		int n = 0;
		int phi = 0;
		int e=0;
		int d = 0;
		int i = 1;
		
		String wordToEncrypt;
		String decryptedWord;
		
		int[] plainText;
		int[] encrypted;
		int[] decrypted;
	
		boolean dFound = false;
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Part 1 - RSA KEY GENERATION");
		System.out.println("Enter 2 prime numbers, and I will help you generate public and private");
		System.out.println("RSA keys.");
		System.out.println("Enter prime p: ");
		p = scan.nextInt();
		System.out.println("Enter prime q: ");
		q = scan.nextInt();
		System.out.println("Thank you. Keep these primes secret.");
		n= p*q;
		System.out.println("n = pq = " +n + " (share this value)");
		phi = n-p-q+1;
		System.out.println("there are " + phi + " numbers <= n that are coprime with n");
		//INSERT FIND COPRIMES HERE
		System.out.println("Pick a number e that is between 1<e<"+phi);
		System.out.println("Would you like to see a list of comprimes? (y/n)");
		if(scan.next().equalsIgnoreCase("y"))
			System.out.println("ill put something here eventually");
			//LIST PRIMES HERE
		System.out.println("pick a valid coprime.");
		e = scan.nextInt();
		while(!dFound)
			{
				if (((e*i)%phi) == 1)
				{
					d=i;
					dFound = true;
				}
				i++;
			}
		//System.out.println(d);
		System.out.println("The inverse of " + e + ", mod " + phi + " is " + d);
		System.out.println("PUBLIC KEY: e, n: " + e + ", " + n);
		System.out.println("PRIVATE KEY: d, n: " + d + ", " + n);
		
		//PART 2
		
		System.out.println("Part 2 - RSA ENCRYPTION USING PUBLIC KEY");
		System.out.println("KEYS HAVE BEEN GENEERATED, Let's encrypt a message.");
		System.out.println("Enter an uppercase word that you would like to encrypt: ");
		wordToEncrypt = scan.next();
		//CONVERT STRING TO INT ARRAY AND SET IT TO plainText
		System.out.println("Converted to numbers, your message is: " /*contents of plainText here*/);
		System.out.println("For each value, compute (value)^" + e + " mod " + n);
		//COMPUTE ENCRYPTED ARRAY HERE FORM PLAINTEXT
		System.out.println("Encrypted, your message is: " /*encrypted goes here*/);
		
		
		System.out.println("Part 3 - RSA DECRYPTION USING THE PRIVTE KEY");
		System.out.println("Now, for each value, compute (value)^ " + d + " mod " + n);
		System.out.println("Decrypted, your message is: " /*decrypted array here*/);
		System.out.println("Converted back to text, your message is: " /*insert decryptedWord here */);
		
		
		
		}
		
		
	}

