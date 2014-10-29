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
		System.out.println("Pick a number e that is between 1<e<"+phi);
		e = scan.nextInt();
		while(!dFound)
			{
				if (((e*i)%phi) == 1)
				{
					d=i;
					dFound = true;
				}
			}
		System.out.println(d);
		}
		
		
	}

