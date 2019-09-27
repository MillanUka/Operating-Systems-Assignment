#!/bin/bash

echo "Welcome user $LOGNAME"

if [ ! -f "$1" ]
then	
	echo "$1 does not exist"
	exit 1;
fi

if [ ! -f "$2" ]
then	
	echo "$2 does not exist"
	exit 1;
fi

if [ $# -ne 2 ]
then
	echo "Usage: ./concatenatefile.sh [filename1] [filenam2]"
	echo "This program takes in two parameters."
	echo "The first parameter is the name of first file."
	echo "The second parameter is the name of the second file."
fi

cat $1 $2 > output.txt

if [ $? -eq 0 ]; then
    echo "The files were successfully concatenated! "
else
    echo "The operation was unsuccessful!"
fi
