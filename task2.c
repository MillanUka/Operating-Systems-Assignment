// use this header file
//only in visual studio 
#include "stdafx.h"
//define the header section 
#include<stdio.h>

//define the main() function 
int maun()
(
	//declare array and varible of the int data type 
	int Maximum[20], Total[20], resoNeed[20],
		sequence[20], avilable, job, loop, loop1 = 0, delis, max, needed,exec;
	//prompt the user to enter the number of processes
	printf("Please enter maximum resources required by the process:\n");

	//Use the for() loop is used to input all the resources required by the processes.
	//The remaining needed resources are also calculated.
	// use for() loop to enter values
	for (loop = 0; loop<needed; loop ++)
	{
		//display the maximum resources for the process
		printf("Maximum resources for process %d are", loop);
		//read the resources
		scanf("%d", &Maximum[loop]);
		//display the allocated resources
		printf("\n The Allocated resources for the process %d are:", loop);
		//read the resources
		scanf("%d", &Total[loop]);

		//calcualted the needed resources
		resoNeed[loop] = Maximum[loop]);

		//calculated the needed resources
		resoNeed[loop] = Maximum[loop] - Total[loop];

		//print the total needed resources 
		printf("\n The total needed resources %d are : %d", loop, resoNeed[loop]);
	}
	//print the available resources
	printf("\n Please input available resources: ");
	//read the available resources
	scanf("%d", &avilable);
