package case1;

import java.util.Scanner;
public class Code {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of transaction array :");

		int n = sc.nextInt();    //size of array

		int arr[] = new int[n];
		System.out.println("Enter the values of the array:");
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();   //array input
		}
		System.out.println("Enter the total number of targets needs to be achieved :");
		int target = sc.nextInt();    //Number of targets


		while(target > 0)               
		{
			boolean flag = false;
			int sum =0;
			int temp =0;
			System.out.println("Enter the value of target:");   //value of target
			int value = sc.nextInt();
			for(int j=0;j<n;j++)
			{
				sum+=arr[j];        //summation of array elements

				if(sum >= value)
				{
					flag = true;
					temp = j+1;
					break;
				}
			}
			if(flag == false)
				System.out.println("Given Target is not achieved");

			else
				System.out.println("Target achieved after " + temp + "  transactions");
		}
		target--;

	}


}


