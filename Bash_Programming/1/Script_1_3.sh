#!/bin/bash

#Created By:-Deep C. Patel, 1401010

clear

echo "Enter the File Name (With Extension)"
read v1

echo -e "Path:\n"

find "/home/ramkabir/Documents/" -type f -name $v1
