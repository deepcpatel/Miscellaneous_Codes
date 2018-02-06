# BEGIN C000H
	   MVI A,81
	   OUT 13

LOOP:	   IN 12
	   ADD A
	   ADD A
	   ADD A
	   ADD A
	   OUT 12
	   JMP LOOP
	   HLT
