#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter File Path"
read path

wrd=$( cat $path | tr -c [:alpha:] "\n" | tr -d " " | sort | uniq -c | sort -r | head -10 )

echo -e "$wrd"
