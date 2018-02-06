#!/bin/bash

#Created by Deep C. Patel-1401010

date ; who | wc

#1).This Command will print output of date command in first line and then followed by combined output of who | wc
#Output: Mon Aug 22 02:04:20 IST 2016
#        2      10      88


(date;who) | wc

#2).This command will first combine date and who and then it will give to wc command to count the lines, words and characters of date and #who command
#Output: 3      16     117

