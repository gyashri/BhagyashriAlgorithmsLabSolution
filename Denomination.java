package case2;

import java.util.Scanner;
public class Denomination {
	public static void merge(int arr[], int beg, int mid, int end)  
	{  

		int l = mid - beg + 1;  
		int r = end - mid;  

		int LeftArray[] = new int [l];  
		int RightArray[] = new int [r];  

		for (int i=0; i<l; ++i) { 
			LeftArray[i] = arr[beg + i];  
		}
		for (int j=0; j<r; ++j) {  
			RightArray[j] = arr[mid + 1+ j];  
		}

		int i = 0, j = 0;  
		int k = beg;  
		while ((i<l) && (j<r))  
		{  
			if (LeftArray[i] <= RightArray[j])  
			{  
				arr[k] = LeftArray[i];  
				i++;
				k++;
			}  
			else  
			{  
				arr[k] = RightArray[j];  
				j++; 
				k++;  
			}  
			
		}  
		while (i<l)  
		{  
			arr[k] = LeftArray[i];  
			i++;  
			k++;  
		}  

		while (j<r)  
		{  
			arr[k] = RightArray[j];  
			j++;  
			k++;  
		}  
	}  

	public static void mergeSort(int arr[], int beg, int end)  
	{  
		if (beg<end)  
		{  
			int mid = (beg+end)/2;  
			mergeSort(arr, beg, mid);  
			mergeSort(arr , mid+1, end);  
			merge(arr, beg, mid, end);  
		}  
	}

	public static void display(int arr[])
	{
		for(int i=arr.length; i>=0; i--)
		{
			System.out.println(arr[i] + "");
		}
	}
	public static void main(String [] args) throws Exception
	{
		System.out.println("Enter the size of currency denominations :");
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		int[] value= new int[n];
		System.out.println("Enter the currency denominations value :");
		for(int i=0; i<n;i++)
		{
			value [i] =sc.nextInt();
		}

		mergeSort(value, 0, n-1);

        System.out.println("Enter the amount you want to pay : ");
        int payAmount = sc.nextInt();
        System.out.println("Your payment approach in order to give min no of notes will be :");
        int q = 0;
        int r = 0;
        int[] Currencyvalue = new int[n];
        for (int i = n -1; i >= 0; i--) {
            if (value[i] <= payAmount) {
                q = payAmount / value[i];
                payAmount = payAmount % value[i];
                Currencyvalue[i] = q;
            }
        }
        if (payAmount >= 0) {
            for (int i = n - 1; i >= 0; i--) {
                if (Currencyvalue[i] != 0) {
                    System.out.println(value[i] + ":" + Currencyvalue[i]);
            }
            }
        } else {
            System.out.println("Amount is not Payable");
        }
       sc.close();

}
}