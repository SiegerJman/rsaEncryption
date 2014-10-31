//Justin Reed
//10/27/14
//CSE 270M

import java.util.Scanner;

public class Crypto {
	public static void main(String [ ] args)
	{
		long p = 0;
		long q = 0;
		long n = 0;
		long phi = 0;
		long e=0;
		long d = 0;
		
		String wordToEncrypt;
		String decryptedWord;
		
		int[] plainText;
		int[] encrypted;
		int[] decrypted;
	
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Part 1 - RSA KEY GENERATION");
		System.out.println("Enter 2 prime numbers, and I will help you generate public and private");
		System.out.println("RSA keys.");
		System.out.println("Enter prime p: ");
		p = scan.nextLong();
		while(!isPrime(p)){
			System.out.println("Enter a Prime number:");
			p = scan.nextLong();
		}
		System.out.println("Enter prime q: ");
		q = scan.nextInt();
		while(!isPrime(q)){
			System.out.println("Enter a Prime number:");
			q = scan.nextLong();
		}
		System.out.println("Thank you. Keep these primes secret.");
		n= p*q;
		System.out.println("n = pq = " + n + " (share this value)");
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
		
		try{
		d = (int)inverse((long)e,(long)phi);
		} catch (IllegalStateException x)
		{
			System.out.println("There is no inverse for these 2 numbers: IllegalStateException");
		}
		
		System.out.println("The inverse of " + e + ", mod " + phi + " is " + d);
		System.out.println("PUBLIC KEY: e, n: " + e + ", " + n);
		System.out.println("PRIVATE KEY: d, n: " + d + ", " + n);
	
		//PART 2
		
		System.out.println("Part 2 - RSA ENCRYPTION USING PUBLIC KEY");
		System.out.println("KEYS HAVE BEEN GENEERATED, Let's encrypt a message.");
		System.out.println("Enter an uppercase word that you would like to encrypt: ");
		wordToEncrypt = scan.next();
		plainText = convertToArray(wordToEncrypt);
		//CONVERT STRING TO INT ARRAY AND SET IT TO plainText
		System.out.println("Converted to numbers, your message is: {");
		for(int i =0;i<plainText.length;i++)
		{
			System.out.print(plainText[i] + ", ");
		}
		System.out.println("For each value, compute (value)^" + e + " mod " + n);
		//COMPUTE ENCRYPTED ARRAY HERE FROM PLAINTEXT
		System.out.println("Encrypted, your message is: " /*encrypted goes here*/);
		
		
		System.out.println("Part 3 - RSA DECRYPTION USING THE PRIVTE KEY");
		System.out.println("Now, for each value, compute (value)^ " + d + " mod " + n);
		System.out.println("Decrypted, your message is: " /*decrypted array here*/);
		System.out.println("Converted back to text, your message is: " /*insert decryptedWord here */);
		
		
		
		}
		
		public static int[] convertToArray(String n)
		{
		int[] word = new int[n.length()];
		for(int i = 0;i<n.length();i++)
		{
		word[i] = n.charAt(i)-65;	
		}
		return word;
		}
	
		public static boolean isPrime(long n)
		{
		for(double i =1.0;i<Math.sqrt(n);i++)
			{
				if ((n/i)%1 == 0.0)
					return false;
			}
			return true;
		}
		public long gcd(long a, long m)
		{
			long larger, smaller;
			if(a>m){
				larger = a;
				smaller = m;
			}else{
			larger = m;
			smaller = a;
			}
				
			long remainder=1;
			while(remainder>0)
			{
				remainder =larger%smaller;
				larger = smaller;
				smaller = remainder;
			}
			if(remainder == 0)
				return smaller;
			else
				return -1;
		}
		
		public static long inverse(long a, long m)
		{
			int i = 1;
			boolean dFound = false;
			while(!dFound)
			{
				if (((a*i)%m) == 1)
				{
					dFound = true;
				}else
				i++;
				if(i>m)
					throw IllegalStateException;
			}
			return i;
		}		
}
	
