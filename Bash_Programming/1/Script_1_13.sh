#!/bin/bash

#Created by Deep C. Patel-1401010

#Tree Command of Windows

clear

echo "Enter the Directory:"
read path

ls -laR $path | grep ":$" | sed -e 's/:$//' -e 's/[^-][^\/]*\//--/g' -e 's/^/   /'  -e 's/-/|/'
