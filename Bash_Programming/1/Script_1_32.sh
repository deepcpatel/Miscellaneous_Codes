#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter the .c/.h file Path:"
read path

stringInt="int"
stringFloat="float"
stringChar="char"
stringDouble="double"
stringLong="long"
stringshort="short"

grep -w $stringInt $path >> temp
grep -w $stringFloat $path >> temp
grep -w $stringChar $path >> temp
grep -w $stringDouble $path >> temp
grep -w $stringLong $path >> temp
grep -w $stringshort $path >> temp

( grep -v "(" "temp" | tr " " "\n" | tr ";=*,"  "\n" | tr "\t" "\n" ) > temp1

sed -i '/^\s*$/d' "temp1"
sed -i 's/int//g' "temp1"
sed -i 's/char//g' "temp1"
sed -i 's/float//g' "temp1"
sed -i 's/double//g' "temp1"
sed -i 's/long//g' "temp1"
sed -i 's/short//g' "temp1"
sed -i 's/final//g' "temp1"
sed -i 's/static//g' "temp1"
sed -i 's/const//g' "temp1"
sed -i '/^\s*$/d' "temp1"

echo -e "\nVariable in c file.\n"

while read line
do
	
	var=$( echo $line | cut -c1-1 )

	if ! echo $var | egrep -q '^[0-9]+$';
	then
		echo $line
	fi

done < temp1
