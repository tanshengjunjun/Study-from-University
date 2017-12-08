package banking.domain;

public class Bank {
private static  Customer[] customers=new Customer[5];//undefined
private static int numberOfCustomers=0;

/*The single instance should be a static attribute and should be private.*/
private static Bank bankInstance=new Bank();
public  void instantiateCustomers(int n){
	customers=new Customer[n];
}
/*make the Bank constructor private.*/
private Bank(){	//had been modified
};
public static void addCustomer(String f,String l){
	customers[numberOfCustomers]=new Customer(f,l);
	numberOfCustomers++;
}
public static int getNumOfCustomers(){
	return numberOfCustomers;
}
public  static Customer getCustomer(int index){
	return customers[index];
}
/*Modify the Bank class to create a public static method, called getBank, that returns an instance of the Bank class.*/
public static Bank getBank(){//add getBank method
	return bankInstance;
}

//step6 ADD the sortCustomers and searchCustomers method to the Bank class.
public Customer[] sortCustomers(){//利用冒泡排序法+Customer类中自己implement的compareTo方法对Customer进行排序
    int i, j;  
    Customer temp;
    for (i = 0; i < numberOfCustomers - 1; i++)  
        for (j = 0; j < numberOfCustomers - 1 - i; j++)  
            if (customers[j].compareTo(customers[j+1])<0) {  
                temp = customers[j];  
                customers[j] = customers[j + 1];  
                customers[j + 1] = temp;  
            }
    return customers;
}
public Customer[] searchCustomers(String f,String l){
	Customer[] customerTemp=new Customer[5];
	for(int i=0;i<customers.length;i++)
		if(customers[i].getFirstName()==f&&customers[i].getLastName()==l)
			customerTemp[i]= customers[i];//这里用的空间可能比较大，因为没改i
	return customerTemp;
}
}
