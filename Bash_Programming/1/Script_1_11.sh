#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Date: `date -I`"
echo "Time:`date "+ %I:%M:%S"`"

if [ `date "+ %p"` = "AM" ]
then

	echo -e "\nGood Morning........."
	
else

	if [ `date '+ %H'` -ge 20 ]
	then

		echo -e "\nGood Night........."
	
	elif [ `date '+ %H'` -ge 17 ]
	then

		echo -e "\nGood Evening........."
		
	elif [ `date '+ %H'` -gt 12 ]
	then

		echo -e "\nGood After Noon........."
	
	fi
	
fi
