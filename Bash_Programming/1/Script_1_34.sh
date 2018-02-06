#!/bin/bash

#Created by Deep C. Patel-1401010

clear

sdir=$( sudo find / -type f -perm -666 -print | tr " " "_" )

for nm in $sdir
do 

	echo $nm

done
