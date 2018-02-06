#!/bin/bash

#Created by Deep C. Patel-1401010

ls > temp

echo "Contents of temp file after ls > temp: `cat temp`"

#1).Command creates temp file if it not exists and copies output of $ls command to it


wc temp > temp
echo "Contents of temp file after wc temp > temp: `cat temp`"

#2).This command coverwrites output of "$wc temp" in temp file. The OUtput consists of no of lines in temp, no of words in temp, no of 
#characters in temp file
