#!/bin/bash

#Created by Deep C. Patel-1401010

who | sort

#1). "who | sort" command gives output of who command to sort command and then sort command after sorting output of who displays it to #terminal.

who > sort

#2). While "who > sort" command overwrites sort file with output of who command. If sort fle doesn't exists then it first creates it and #then writes output to it
