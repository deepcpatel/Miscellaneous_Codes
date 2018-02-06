#!/bin/bash

#Created by Deep C. Patel-1401010

clear

sdir=$( find / -type d | tr " " "_" )

for nm in $sdir
do 

	echo $nm

done
