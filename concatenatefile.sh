#!/bin/bash

#Display a welcome message
echo "Welcome user $LOGNAME"

#Checking if the first file exists
if [ ! -f "$1" ]
then	
	echo "$1 does not exist"
	exit 1;
fi

#Checking if the second file exists
if [ ! -f "$2" ]
then	
	echo "$2 does not exist"
	exit 1;
fi

#Checking if the number are two. If they ae not two then display an error
if [ $# -ne 2 ]
then
	echo "Usage: ./concatenatefile.sh [filename1] [filename2]"
	echo "This program takes in two parameters."
	echo "The first parameter is the name of first file."
	echo "The second parameter is the name of the second file."
	exit 1;
fi

#The command to concatenate the two files
cat $1 $2 > output.txt

#Checking the number of errors. If it is 0 then display a successful message
#If the error is not 0 then display an unsuccessful message.
if [ $? -eq 0 ] 
then
    echo "The files were successfully concatenated! "
else
    echo "The operation was unsuccessful!"
fi
