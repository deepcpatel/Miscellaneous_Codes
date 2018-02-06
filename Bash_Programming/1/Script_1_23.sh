#!/bin/bash

#Created by Deep C. Patel-1401010

clear
echo -e "Enter Name of User:\c"
read name
echo -e "No of times User Logged In:\c"
expr `last $name | wc -l` - 2
