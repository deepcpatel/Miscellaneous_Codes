#!/bin/bash

clear
echo "Enter File Name(with extension):"
read filename
cat > $filename

gedit $filename
